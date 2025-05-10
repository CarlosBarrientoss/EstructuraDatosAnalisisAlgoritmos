/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tallerArbolesBinarios;
/**
 * Ejercicio 1: Recorrido en Preorden de un árbol binario.
 *
 * Se recorre primero la raíz, luego recursivamente el subárbol izquierdo
 * y después el subárbol derecho.
 */
public class Ejercicio_1 {
    /**
     * Nodo de un árbol binario.
     */
    private static class Node {
        int value;
        Node left;
        Node right;

        /**
         * Crea un nodo con el valor dado.
         * @param value Valor que almacena el nodo.
         */
        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Recorre el árbol en preorden (Root-Left-Right) e imprime cada valor.
     * @param root Raíz del subárbol actual.
     */
    private static void preOrderTraversal(Node root) {
        // Caso base: si el nodo es nulo, no hacer nada
        if (root == null) {
            return;
        }
        // Visitar la raíz
        System.out.print(root.value + " ");
        // Recorrer subárbol izquierdo
        preOrderTraversal(root.left);
        // Recorrer subárbol derecho
        preOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        // Construcción del árbol de ejemplo:
        //         10
        //        /  \
        //       5    15
        //      / \   / \
        //     2   7 12 20

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(20);

        // Realizar y mostrar el recorrido en preorden
        System.out.print("Recorrido en Preorden: ");
        preOrderTraversal(root);
        System.out.println();  // Salto de línea al terminar
    }
    
}
