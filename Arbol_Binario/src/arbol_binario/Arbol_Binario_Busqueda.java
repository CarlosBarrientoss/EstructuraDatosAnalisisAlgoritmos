/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbol_binario;

/**
 *
 * @author duvan
 */
class Nodo {
    int valor;
    Nodo izquierdo, derecho;

    public Nodo(int item) {
        valor = item;
        izquierdo = derecho = null;
    }
}

public class Arbol_Binario_Busqueda {

    Nodo raiz;

    public Arbol_Binario_Busqueda() {
        raiz = null;
    }

    // Insertar un valor
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo raiz, int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
            return raiz;
        }

        if (valor < raiz.valor)
            raiz.izquierdo = insertarRec(raiz.izquierdo, valor);
        else if (valor > raiz.valor)
            raiz.derecho = insertarRec(raiz.derecho, valor);

        return raiz;
    }

    // Buscar un valor
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(Nodo raiz, int valor) {
        if (raiz == null)
            return false;
        if (raiz.valor == valor)
            return true;

        return valor < raiz.valor
            ? buscarRec(raiz.izquierdo, valor)
            : buscarRec(raiz.derecho, valor);
    }

    // Eliminar un valor
    public void eliminar(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private Nodo eliminarRec(Nodo raiz, int valor) {
        if (raiz == null)
            return raiz;

        if (valor < raiz.valor)
            raiz.izquierdo = eliminarRec(raiz.izquierdo, valor);
        else if (valor > raiz.valor)
            raiz.derecho = eliminarRec(raiz.derecho, valor);
        else {
            if (raiz.izquierdo == null)
                return raiz.derecho;
            else if (raiz.derecho == null)
                return raiz.izquierdo;

            raiz.valor = minValor(raiz.derecho);
            raiz.derecho = eliminarRec(raiz.derecho, raiz.valor);
        }
        return raiz;
    }

    private int minValor(Nodo raiz) {
        int min = raiz.valor;
        while (raiz.izquierdo != null) {
            min = raiz.izquierdo.valor;
            raiz = raiz.izquierdo;
        }
        return min;
    }

    // Recorridos
    public void inorden() {
        inordenRec(raiz);
        System.out.println();
    }

    private void inordenRec(Nodo raiz) {
        if (raiz != null) {
            inordenRec(raiz.izquierdo);
            System.out.print(raiz.valor + " ");
            inordenRec(raiz.derecho);
        }
    }

    public void preorden() {
        preordenRec(raiz);
        System.out.println();
    }

    private void preordenRec(Nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.valor + " ");
            preordenRec(raiz.izquierdo);
            preordenRec(raiz.derecho);
        }
    }

    public void postorden() {
        postordenRec(raiz);
        System.out.println();
    }

    private void postordenRec(Nodo raiz) {
        if (raiz != null) {
            postordenRec(raiz.izquierdo);
            postordenRec(raiz.derecho);
            System.out.print(raiz.valor + " ");
        }
    }

    // Método main para probar el árbol
    public static void main(String[] args) {
        Arbol_Binario_Busqueda arbol = new Arbol_Binario_Busqueda();

        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(70);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Recorrido inorden:");
        arbol.inorden();

        System.out.println("\nRecorrido preorden:");
        arbol.preorden();

        System.out.println("\nRecorrido postorden:");
        arbol.postorden();

        System.out.println("\nBuscar 40: " + arbol.buscar(40));
        System.out.println("Buscar 90: " + arbol.buscar(90));

        System.out.println("\nEliminar 20");
        arbol.eliminar(20);
        arbol.inorden();

        System.out.println("\nEliminar 30");
        arbol.eliminar(30);
        arbol.inorden();

        System.out.println("\nEliminar 50");
        arbol.eliminar(50);
        arbol.inorden();
    }
}

