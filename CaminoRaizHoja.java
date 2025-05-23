/*ejercicio 9*/
import java.util.*;

public class CaminoRaizHoja {

    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    public static boolean encontrarCamino(Nodo nodo, int destino, List<Integer> camino) {
        if (nodo == null) return false;

        camino.add(nodo.valor);

        if (nodo.valor == destino)
            return true;

        if (encontrarCamino(nodo.izquierdo, destino, camino) ||
            encontrarCamino(nodo.derecho, destino, camino))
            return true;

        camino.remove(camino.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        /*
            Árbol:
                  1
                 / \
                2   3
                   / \
                  4   5
        */

        Nodo raiz = new Nodo(1);
        raiz.izquierdo = new Nodo(2);
        raiz.derecho = new Nodo(3);
        raiz.derecho.izquierdo = new Nodo(4);
        raiz.derecho.derecho = new Nodo(5);

        int destino = 4;
        List<Integer> camino = new ArrayList<>();

        if (encontrarCamino(raiz, destino, camino)) {
            System.out.print("Camino a " + destino + ": ");
            for (int val : camino) {
                System.out.print(val + " ");
            }
            System.out.println();
        } else {
            System.out.println("No se encontró el nodo " + destino);
        }
    }
}
