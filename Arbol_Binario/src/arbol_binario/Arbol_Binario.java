/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbol_binario;

/**
 *
 * @author duvan
 */
public class Arbol_Binario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== ÁRBOL BINARIO SIMPLE ===");
        ejemploArbolBinario();
        
        System.out.println("\n=== ÁRBOL BINARIO DE BÚSQUEDA ===");
        ejemploArbolBinarioBusqueda();
        
        System.out.println("\n=== ÁRBOL BINARIO CON MÉTODOS ADICIONALES ===");
        ejemploArbolCompleto();
    }
    
    // Clase Nodo para todos los tipos de árbol
    static class Nodo {
        int valor;
        Nodo izquierdo;
        Nodo derecho;

        public Nodo(int valor) {
            this.valor = valor;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    // 1. Ejemplo de árbol binario básico
    public static void ejemploArbolBinario() {
        // Crear nodos
        Nodo raiz = new Nodo(1);
        Nodo izq = new Nodo(2);
        Nodo der = new Nodo(3);
        
        // Conectar nodos
        raiz.izquierdo = izq;
        raiz.derecho = der;
        
        // Agregar más nodos
        izq.izquierdo = new Nodo(4);
        izq.derecho = new Nodo(5);
        
        // Imprimir estructura
        System.out.println("     " + raiz.valor);
        System.out.println("   /   \\");
        System.out.println("  " + raiz.izquierdo.valor + "     " + raiz.derecho.valor);
        System.out.println(" / \\");
        System.out.println(raiz.izquierdo.izquierdo.valor + "   " + raiz.izquierdo.derecho.valor);
    }
    
    // 2. Árbol Binario de Búsqueda (BST)
    static class ArbolBusqueda {
        Nodo raiz;

        public void insertar(int valor) {
            raiz = insertarRec(raiz, valor);
        }

        private Nodo insertarRec(Nodo nodo, int valor) {
            if (nodo == null) {
                return new Nodo(valor);
            }

            if (valor < nodo.valor) {
                nodo.izquierdo = insertarRec(nodo.izquierdo, valor);
            } else if (valor > nodo.valor) {
                nodo.derecho = insertarRec(nodo.derecho, valor);
            }

            return nodo;
        }

        public void inOrden() {
            inOrdenRec(raiz);
            System.out.println();
        }

        private void inOrdenRec(Nodo nodo) {
            if (nodo != null) {
                inOrdenRec(nodo.izquierdo);
                System.out.print(nodo.valor + " ");
                inOrdenRec(nodo.derecho);
            }
        }
    }

    public static void ejemploArbolBinarioBusqueda() {
        ArbolBusqueda arbol = new ArbolBusqueda();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(70);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Recorrido In-Orden del BST:");
        arbol.inOrden();  // Debería imprimir: 20 30 40 50 60 70 80
    }
    
    // 3. Árbol con métodos adicionales
    static class ArbolCompleto {
        Nodo raiz;

        public void insertar(int valor) {
            raiz = insertarRec(raiz, valor);
        }

        private Nodo insertarRec(Nodo nodo, int valor) {
            if (nodo == null) {
                return new Nodo(valor);
            }

            if (valor < nodo.valor) {
                nodo.izquierdo = insertarRec(nodo.izquierdo, valor);
            } else if (valor > nodo.valor) {
                nodo.derecho = insertarRec(nodo.derecho, valor);
            }

            return nodo;
        }

        public boolean buscar(int valor) {
            return buscarRec(raiz, valor);
        }

        private boolean buscarRec(Nodo nodo, int valor) {
            if (nodo == null) {
                return false;
            }

            if (valor == nodo.valor) {
                return true;
            }

            return valor < nodo.valor 
                ? buscarRec(nodo.izquierdo, valor) 
                : buscarRec(nodo.derecho, valor);
        }

        public void preOrden() {
            preOrdenRec(raiz);
            System.out.println();
        }

        private void preOrdenRec(Nodo nodo) {
            if (nodo != null) {
                System.out.print(nodo.valor + " ");
                preOrdenRec(nodo.izquierdo);
                preOrdenRec(nodo.derecho);
            }
        }

        public void postOrden() {
            postOrdenRec(raiz);
            System.out.println();
        }

        private void postOrdenRec(Nodo nodo) {
            if (nodo != null) {
                postOrdenRec(nodo.izquierdo);
                postOrdenRec(nodo.derecho);
                System.out.print(nodo.valor + " ");
            }
        }
    }

    public static void ejemploArbolCompleto() {
        ArbolCompleto arbol = new ArbolCompleto();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(70);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Recorrido Pre-Orden:");
        arbol.preOrden();  // 50 30 20 40 70 60 80
        
        System.out.println("Recorrido Post-Orden:");
        arbol.postOrden();  // 20 40 30 60 80 70 50
        
        System.out.println("Búsqueda de valores:");
        System.out.println("¿Existe 40? " + arbol.buscar(40));  // true
        System.out.println("¿Existe 100? " + arbol.buscar(100));  // false
    }
}