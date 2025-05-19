
package ejercicio9;

import java.util.*;

public class Ejercicio9 {

    // Clase Nodo del Árbol
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    // Método para imprimir el camino desde la raíz hasta un nodo hoja específico
    public static boolean imprimirCamino(Nodo nodo, int destino, List<Integer> camino) {
        if (nodo == null) return false;

        camino.add(nodo.valor); // Añadir el nodo actual al camino

        // Si se encuentra el nodo destino
        if (nodo.valor == destino) return true;

        // Buscar en los subárboles izquierdo y derecho
        if (imprimirCamino(nodo.izquierdo, destino, camino) || imprimirCamino(nodo.derecho, destino, camino)) {
            return true;
        }

        // Si no se encontró en ninguna rama, eliminar el nodo actual del camino
        camino.remove(camino.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        // Árbol:
        //       1
        //      / \
        //     2   3
        //        / \
        //       4   5

        Nodo raiz = new Nodo(1);
        raiz.izquierdo = new Nodo(2);
        raiz.derecho = new Nodo(3);
        raiz.derecho.izquierdo = new Nodo(4);
        raiz.derecho.derecho = new Nodo(5);

        int destino = 4;
        List<Integer> camino = new ArrayList<>();

        if (imprimirCamino(raiz, destino, camino)) {
            System.out.print("Camino a " + destino + ": ");
            for (int val : camino) {
                System.out.print(val + " ");
            }
        } else {
            System.out.println("Nodo " + destino + " no encontrado en el árbol.");
        }
    }
}
