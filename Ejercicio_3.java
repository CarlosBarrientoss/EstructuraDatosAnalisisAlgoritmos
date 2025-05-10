/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerArbolesBinarios;
/**
 * Ejercicio 3: Recorrido en Postorden de un árbol binario.
 *
 * Se recorre primero recursivamente el subárbol izquierdo,
 * luego el subárbol derecho y, finalmente, la raíz.
 */
public class Ejercicio_3 {

    /**
     * Nodo de un árbol binario que almacena un carácter y referencias a sus hijos.
     */
    private static class Node {
        char value;
        Node left;
        Node right;

        /**
         * Constructor de nodo.
         *
         * @param value carácter que almacenará el nodo.
         */
        Node(char value) {
            this.value = value;
        }
    }

    /**
     * Recorre el árbol en postorden (Left-Right-Root) e imprime cada valor seguido de un espacio.
     *
     * @param root la raíz del subárbol actual.
     */
    private static void postOrderTraversal(Node root) {
        // Caso base: si el nodo es nulo, no hacer nada
        if (root == null) {
            return;
        }
        // Recorrer subárbol izquierdo
        postOrderTraversal(root.left);
        // Recorrer subárbol derecho
        postOrderTraversal(root.right);
        // Visitar la raíz
        System.out.print(root.value + " ");
    }

    public static void main(String[] args) {
        // Construcción del árbol de ejemplo:
        //         A
        //        / \
        //       B   C
        //      /   / \
        //     D   E   F
        Node root = new Node('A');
        root.left = new Node('B');
        root.right = new Node('C');
        root.left.left = new Node('D');
        root.right.left = new Node('E');
        root.right.right = new Node('F');

        // Mostrar el recorrido en postorden
        System.out.print("Recorrido en Postorden: ");
        postOrderTraversal(root);
        System.out.println(); // Salto de línea al terminar
    }
}

