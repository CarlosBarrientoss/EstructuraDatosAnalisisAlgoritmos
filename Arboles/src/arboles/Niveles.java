package arboles;

import java.util.*; // Importación correcta fuera de la clase

/**
 *
 * @author duvan
 */
public class Niveles {

    // Clase Nodo estática
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
        }
    }

    // Clase BFS estática para poder ser usada en el main
    static class BFS {
        void recorrer(Nodo raiz) {
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

        public static void main(String[] args) {
            Nodo raiz = new Nodo(1);
            raiz.izquierdo = new Nodo(2);
            raiz.derecho = new Nodo(3);
            raiz.izquierdo.izquierdo = new Nodo(4);
            raiz.izquierdo.derecho = new Nodo(5);
            raiz.derecho.derecho = new Nodo(6);

            new BFS().recorrer(raiz);
        }
    }
}
