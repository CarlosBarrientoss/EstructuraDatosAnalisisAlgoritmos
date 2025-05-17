/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerArbolesBinarios;
/**
 * https://www.oscarblancarteblog.com/2014/08/22/estructura-de-datos-arboles/
 * implementado con clase main completamente funcional
 */
import java.util.Queue;
import java.util.LinkedList;

// Clase AB con recorridos y búsqueda por amplitud
public class AB {
    
    // Clase NodoArbol según Blancarte (2014)
    public class NodoArbol {
        public char value;
        public NodoArbol hijo1, hijo2;

        public NodoArbol(char value) {
            this.value = value;
            this.hijo1 = null;
            this.hijo2 = null;
        }
    }
    private NodoArbol raiz;

    public AB() {
        this.raiz = null;
    }

    // Inserta un nodo (para facilitar el main de prueba)
    public void insertar(char value) {
        raiz = insertarRec(raiz, value);
    }

    private NodoArbol insertarRec(NodoArbol nodo, char value) {
        if (nodo == null) {
            return new NodoArbol(value);
        }
        // ejemplo simple: siempre a la izquierda si menor, a la derecha si mayor o igual
        if (value < nodo.value) {
            nodo.hijo1 = insertarRec(nodo.hijo1, value);
        } else {
            nodo.hijo2 = insertarRec(nodo.hijo2, value);
        }
        return nodo;
    }

    // Recorrido preorden
    public void preorden(NodoArbol nodo){
        if (nodo == null)
            return;
        System.out.println("Node Value -> " + nodo.value);
        preorden(nodo.hijo1);
        preorden(nodo.hijo2);
    }

    // Recorrido inorden
    public void inorden(NodoArbol nodo){
        if (nodo == null)
            return;
        inorden(nodo.hijo1);
        System.out.println("Node Value -> " + nodo.value);
        inorden(nodo.hijo2);
    }

    // Recorrido posorden
    public void posorden(NodoArbol nodo){
        if (nodo == null)
            return;
        posorden(nodo.hijo1);
        posorden(nodo.hijo2);
        System.out.println("Node Value -> " + nodo.value);
    }

    // Búsqueda en amplitud (BFS) usando LinkedList como Queue :contentReference[oaicite:0]{index=0}
    public boolean busquedaAnchura(char c){
        if (raiz == null) return false;

        Queue<NodoArbol> colaAuxiliar = new LinkedList<>();  // LinkedList implementa Queue :contentReference[oaicite:1]{index=1}
        colaAuxiliar.add(raiz);

        while (!colaAuxiliar.isEmpty()) {
            NodoArbol nodo = colaAuxiliar.poll();              // poll() devuelve null si está vacía :contentReference[oaicite:2]{index=2}
            System.out.println("Node Value -> " + nodo.value);
            if (nodo.value == c) {
                return true;
            }
            // sólo encolar hijos no nulos para evitar NullPointerException
            if (nodo.hijo1 != null) {
                colaAuxiliar.add(nodo.hijo1);
            }
            if (nodo.hijo2 != null) {
                colaAuxiliar.add(nodo.hijo2);
            }
        }
        return false;
    }

    // Getters para la raíz
    public NodoArbol getRaiz() {
        return this.raiz;
    }
    
    // Clase Main para demostrar todos los métodos
    
        public static void main(String[] args) {
            AB arbol = new AB();

            // Construcción de un árbol de ejemplo:      
            //         'M'
            //        /   \
            //      'C'   'R'
            //      / \     \
            //    'A' 'E'   'Z'
            arbol.insertar('M');
            arbol.insertar('C');
            arbol.insertar('R');
            arbol.insertar('A');
            arbol.insertar('E');
            arbol.insertar('Z');

            System.out.println("=== Recorrido Preorden ===");
            arbol.preorden(arbol.getRaiz());

            System.out.println("\n=== Recorrido Inorden ===");
            arbol.inorden(arbol.getRaiz());

            System.out.println("\n=== Recorrido Posorden ===");
            arbol.posorden(arbol.getRaiz());

            System.out.println("\n=== Busqueda por Amplitud buscando 'E' ===");
            boolean encontrado = arbol.busquedaAnchura('E');
            System.out.println("Valor 'E' encontrado? " + encontrado);
        }
    
}



