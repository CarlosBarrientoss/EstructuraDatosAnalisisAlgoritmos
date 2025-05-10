/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

import java.util.*;

class NodoCamino {
    int valor;
    NodoCamino izquierdo, derecho;

    NodoCamino(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

public class Ejercicio9 {
    static boolean encontrarCamino(NodoCamino nodo, int destino, List<Integer> camino) {
        if (nodo == null) return false;

        camino.add(nodo.valor);
        if (nodo.valor == destino) return true;

        if (encontrarCamino(nodo.izquierdo, destino, camino) || encontrarCamino(nodo.derecho, destino, camino))
            return true;

        camino.remove(camino.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        NodoCamino raiz = new NodoCamino(1);
        raiz.izquierdo = new NodoCamino(2);
        raiz.derecho = new NodoCamino(3);
        raiz.derecho.izquierdo = new NodoCamino(4);
        raiz.derecho.derecho = new NodoCamino(5);

        List<Integer> camino = new ArrayList<>();
        if (encontrarCamino(raiz, 4, camino)) {
            System.out.print("Camino a 4: ");
            for (int val : camino)
                System.out.print(val + " ");
        } else {
            System.out.println("No se encontró el nodo.");
        }
    }
}
