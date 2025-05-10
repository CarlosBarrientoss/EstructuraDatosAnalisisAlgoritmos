/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerArbolesBinarios;
/**
 * Ejercicio 2: Recorrido en Inorden de un árbol binario.
 *
 * Se recorre primero recursivamente el subárbol izquierdo,
 * luego la raíz y después el subárbol derecho.
 */
public class Ejercicio_2 {
    /**
     * Clase interna que representa un nodo de un árbol binario.
     */
    private static class Node {
        int value;
        Node left;
        Node right;

        /**
         * Construye un nodo con el valor dado.
         *
         * @param value El valor a almacenar en el nodo.
         */
        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Recorre el árbol en inorden (Left-Root-Right) e imprime cada valor.
     *
     * @param root Raíz del subárbol actual.
     */
    private static void inOrderTraversal(Node root) {
        // Caso base: si el nodo es nulo, no realizar nada
        if (root == null) {
            return;
        }
        // Recorrer subárbol izquierdo
        inOrderTraversal(root.left);
        // Visitar la raíz
        System.out.print(root.value + " ");
        // Recorrer subárbol derecho
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        // Construcción del árbol de ejemplo:
        //       8
        //      / \
        //     3   10
        //      \    \
        //       6    14

        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.right = new Node(6);
        root.right.right = new Node(14);

        // Mostrar el recorrido en inorden
        System.out.print("Recorrido en Inorden: ");
        inOrderTraversal(root);
        System.out.println();  // Salto de línea al finalizar
    }
}