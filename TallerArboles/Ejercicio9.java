package TallerArboles;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio9 {
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    public class CaminoRaizHoja {

        public static boolean encontrarCamino(Nodo nodo, int hojaObjetivo, List<Integer> camino) {
            if (nodo == null) return false;

            // Agregamos el nodo actual al camino
            camino.add(nodo.valor);

            // Si es el nodo hoja objetivo, terminamos
            if (nodo.valor == hojaObjetivo &&
                nodo.izquierdo == null && nodo.derecho == null) {
                return true;
            }

            // DFS en subárbol izquierdo y derecho
            if (encontrarCamino(nodo.izquierdo, hojaObjetivo, camino) ||
                encontrarCamino(nodo.derecho, hojaObjetivo, camino)) {
                return true;
            }

            // Si no lo encontramos, quitamos el nodo actual del camino (backtracking)
            camino.remove(camino.size() - 1);
            return false;
        }

        public static void main(String[] args) {
            // Construcción del árbol
            Nodo raiz = new Nodo(1);
            raiz.izquierdo = new Nodo(2);
            raiz.derecho = new Nodo(3);
            raiz.derecho.izquierdo = new Nodo(4);
            raiz.derecho.derecho = new Nodo(5);

            int hojaObjetivo = 4;
            List<Integer> camino = new ArrayList<>();

            if (encontrarCamino(raiz, hojaObjetivo, camino)) {
                System.out.print("Camino a " + hojaObjetivo + ": ");
                for (int val : camino) {
                    System.out.print(val + " ");
                }
            } else {
                System.out.println("No se encontró el nodo hoja " + hojaObjetivo);
            }
        }
    }
}
