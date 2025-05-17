/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

/**
 *
 * @author usuario
 */
import java.util.*;

class Nodo {
    int valor;
    Nodo izquierdo, derecho;

    Nodo(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

public class ArbolBinario {
    Nodo raiz;

    // 1. Preorden
    public void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preorden(nodo.izquierdo);
            preorden(nodo.derecho);
        }
    }

    // 2. Inorden
    public void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecho);
        }
    }

    // 3. Postorden
    public void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.izquierdo);
            postorden(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }

    // 4. Por niveles
    public void recorridoPorNiveles(Nodo raiz) {
        if (raiz == null) return;
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            System.out.print(actual.valor + " ");
            if (actual.izquierdo != null) cola.add(actual.izquierdo);
            if (actual.derecho != null) cola.add(actual.derecho);
        }
    }

    // 5. Contar hojas
    public int contarHojas(Nodo nodo) {
        if (nodo == null) return 0;
        if (nodo.izquierdo == null && nodo.derecho == null) return 1;
        return contarHojas(nodo.izquierdo) + contarHojas(nodo.derecho);
    }

    // 6. Altura
    public int altura(Nodo nodo) {
        if (nodo == null) return 0;
        return 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
    }

    // 7. Suma de todos los nodos
    public int sumaTotal(Nodo nodo) {
        if (nodo == null) return 0;
        return nodo.valor + sumaTotal(nodo.izquierdo) + sumaTotal(nodo.derecho);
    }

    // 8. Búsqueda
    public boolean buscar(Nodo nodo, int clave) {
        if (nodo == null) return false;
        if (nodo.valor == clave) return true;
        return buscar(nodo.izquierdo, clave) || buscar(nodo.derecho, clave);
    }

    // 9. Camino a hoja
    public boolean imprimirCamino(Nodo nodo, int hoja, List<Integer> camino) {
        if (nodo == null) return false;
        camino.add(nodo.valor);
        if (nodo.valor == hoja) return true;
        if (imprimirCamino(nodo.izquierdo, hoja, camino) || imprimirCamino(nodo.derecho, hoja, camino))
            return true;
        camino.remove(camino.size() - 1);
        return false;
    }

    // 10. Árbol espejo
    public void espejo(Nodo nodo) {
        if (nodo != null) {
            espejo(nodo.izquierdo);
            espejo(nodo.derecho);
            Nodo temp = nodo.izquierdo;
            nodo.izquierdo = nodo.derecho;
            nodo.derecho = temp;
        }
    }
}
public class Ejercicios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
         ArbolBinario arbol = new ArbolBinario();

        // Ejercicio 1 - Preorden
        Nodo pre = new Nodo(10);
        pre.izquierdo = new Nodo(5);
        pre.derecho = new Nodo(15);
        pre.izquierdo.izquierdo = new Nodo(2);
        pre.izquierdo.derecho = new Nodo(7);
        pre.derecho.izquierdo = new Nodo(12);
        pre.derecho.derecho = new Nodo(20);
        System.out.print("1. Preorden: ");
        arbol.preorden(pre);
        System.out.println();

        // Ejercicio 2 - Inorden
        Nodo in = new Nodo(8);
        in.izquierdo = new Nodo(3);
        in.izquierdo.derecho = new Nodo(6);
        in.derecho = new Nodo(10);
        in.derecho.derecho = new Nodo(14);
        System.out.print("2. Inorden: ");
        arbol.inorden(in);
        System.out.println();

        // Ejercicio 3 - Postorden (usando letras como int ASCII)
        Nodo post = new Nodo('A');
        post.izquierdo = new Nodo('B');
        post.izquierdo.izquierdo = new Nodo('D');
        post.derecho = new Nodo('C');
        post.derecho.izquierdo = new Nodo('E');
        post.derecho.derecho = new Nodo('F');
        System.out.print("3. Postorden: ");
        arbol.postorden(post);
        System.out.println();

        // Ejercicio 4 - BFS
        Nodo bfs = new Nodo(1);
        bfs.izquierdo = new Nodo(2);
        bfs.derecho = new Nodo(3);
        bfs.izquierdo.izquierdo = new Nodo(4);
        bfs.izquierdo.derecho = new Nodo(5);
        bfs.derecho.derecho = new Nodo(6);
        System.out.print("4. Por niveles: ");
        arbol.recorridoPorNiveles(bfs);
        System.out.println();

        // Ejercicio 5 - Contar hojas
        Nodo hoja = new Nodo(7);
        hoja.izquierdo = new Nodo(4);
        hoja.izquierdo.izquierdo = new Nodo(2);
        hoja.derecho = new Nodo(9);
        hoja.derecho.izquierdo = new Nodo(8);
        hoja.derecho.derecho = new Nodo(11);
        int hojas = arbol.contarHojas(hoja);
        System.out.println("5. N.º de hojas: " + hojas);

        // Ejercicio 6 - Altura
        Nodo alt = new Nodo('M');
        alt.izquierdo = new Nodo('N');
        alt.izquierdo.izquierdo = new Nodo('O');
        alt.izquierdo.derecho = new Nodo('P');
        alt.izquierdo.derecho.derecho = new Nodo('Q');
        int altura = arbol.altura(alt);
        System.out.println("6. Altura: " + altura);

        // Ejercicio 7 - Suma
        Nodo suma = new Nodo(5);
        suma.izquierdo = new Nodo(3);
        suma.izquierdo.izquierdo = new Nodo(1);
        suma.izquierdo.derecho = new Nodo(4);
        suma.derecho = new Nodo(7);
        suma.derecho.derecho = new Nodo(9);
        int total = arbol.sumaTotal(suma);
        System.out.println("7. Suma total: " + total);

        // Ejercicio 8 - Búsqueda
        Nodo busq = new Nodo(20);
        busq.izquierdo = new Nodo(10);
        busq.izquierdo.izquierdo = new Nodo(5);
        busq.izquierdo.derecho = new Nodo(15);
        busq.derecho = new Nodo(30);
        boolean encontrado15 = arbol.buscar(busq, 15);
        boolean encontrado25 = arbol.buscar(busq, 25);
        System.out.println("8. Buscar 15: " + (encontrado15 ? "Encontrado" : "No encontrado"));
        System.out.println("   Buscar 25: " + (encontrado25 ? "Encontrado" : "No encontrado"));

        // Ejercicio 9 - Camino a hoja
        Nodo camino = new Nodo(1);
        camino.izquierdo = new Nodo(2);
        camino.derecho = new Nodo(3);
        camino.derecho.izquierdo = new Nodo(4);
        camino.derecho.derecho = new Nodo(5);
        List<Integer> ruta = new ArrayList<>();
        arbol.imprimirCamino(camino, 4, ruta);
        System.out.print("9. Camino a 4: ");
        for (int val : ruta) System.out.print(val + " ");
        System.out.println();

        // Ejercicio 10 - Árbol espejo
        Nodo espejo = new Nodo(9);
        espejo.izquierdo = new Nodo(6);
        espejo.derecho = new Nodo(12);
        espejo.izquierdo.izquierdo = new Nodo(3);
        espejo.izquierdo.derecho = new Nodo(7);
        espejo.derecho.derecho = new Nodo(15);
        arbol.espejo(espejo);
        System.out.print("10. Árbol espejo (Inorden): ");
        arbol.inorden(espejo);
        System.out.println();
    }
    
}
