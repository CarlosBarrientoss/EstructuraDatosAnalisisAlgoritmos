/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolesbinario;

/**
 *
 * @author andre
 */
public class ArbolesBinario {

    public static void main(String[] args) {
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        // Insertando valores según el ejemplo
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(70);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Recorrido Inorden:");
        arbol.inorden(); // 20 30 40 50 60 70 80
        System.out.println("\nRecorrido Preorden:");
        arbol.preorden(); // 50 30 20 40 70 60 80
        System.out.println("\nRecorrido Postorden:");
        arbol.postorden(); // 20 40 30 60 80 70 50

        System.out.println("\n\nBúsqueda de valores:");
        System.out.println("¿Existe 40? " + arbol.buscar(40)); // true
        System.out.println("¿Existe 90? " + arbol.buscar(90)); // false

        System.out.println("\nValor mínimo: " + arbol.valorMinimo()); // 20
        System.out.println("Valor máximo: " + arbol.valorMaximo()); // 80
    }
}

// Clase del Árbol Binario de Búsqueda
class ArbolBinarioBusqueda {

    // Clase Nodo
    class Nodo {
        int valor;
        Nodo izquierda, derecha;

        public Nodo(int item) {
            valor = item;
            izquierda = derecha = null;
        }
    }

    Nodo raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    Nodo insertarRec(Nodo raiz, int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
            return raiz;
        }

        if (valor < raiz.valor)
            raiz.izquierda = insertarRec(raiz.izquierda, valor);
        else if (valor > raiz.valor)
            raiz.derecha = insertarRec(raiz.derecha, valor);

        return raiz;
    }

    boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    boolean buscarRec(Nodo raiz, int valor) {
        if (raiz == null)
            return false;
        if (raiz.valor == valor)
            return true;
        return valor < raiz.valor
                ? buscarRec(raiz.izquierda, valor)
                : buscarRec(raiz.derecha, valor);
    }

    void inorden() {
        inordenRec(raiz);
    }

    void inordenRec(Nodo raiz) {
        if (raiz != null) {
            inordenRec(raiz.izquierda);
            System.out.print(raiz.valor + " ");
            inordenRec(raiz.derecha);
        }
    }

    void preorden() {
        preordenRec(raiz);
    }

    void preordenRec(Nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.valor + " ");
            preordenRec(raiz.izquierda);
            preordenRec(raiz.derecha);
        }
    }

    void postorden() {
        postordenRec(raiz);
    }

    void postordenRec(Nodo raiz) {
        if (raiz != null) {
            postordenRec(raiz.izquierda);
            postordenRec(raiz.derecha);
            System.out.print(raiz.valor + " ");
        }
    }

    int valorMinimo() {
        return valorMinimoRec(raiz);
    }

    int valorMinimoRec(Nodo raiz) {
        if (raiz.izquierda == null)
            return raiz.valor;
        return valorMinimoRec(raiz.izquierda);
    }

    int valorMaximo() {
        return valorMaximoRec(raiz);
    }

    int valorMaximoRec(Nodo raiz) {
        if (raiz.derecha == null)
            return raiz.valor;
        return valorMaximoRec(raiz.derecha);
    }
}
