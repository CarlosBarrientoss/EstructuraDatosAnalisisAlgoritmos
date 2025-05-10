/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerArbolesBinarios;
/**
 * Ejercicio 4: Recorrido por niveles (BFS) de un árbol binario.
 *
 * Se recorre el árbol nivel por nivel, de izquierda a derecha, utilizando una cola.
 */
import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio_4 {

    /**
     * Representa un nodo de un árbol binario con valor entero y referencias a hijos.
     */
    private static class Node {
        int value;
        Node left;
        Node right;

        /**
         * Constructor que inicializa el nodo con el valor dado.
         *
         * @param value valor entero del nodo
         */
        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Recorre el árbol en nivel (BFS) e imprime cada valor.
     *
     * @param root raíz del árbol sobre la que se aplica el recorrido
     */
    private static void levelOrderTraversal(Node root) {
        // Si el árbol está vacío, no hacer nada
        if (root == null) {
            return;
        }

        // Cola para procesar nodos en orden FIFO
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Mientras haya nodos en la cola
        while (!queue.isEmpty()) {
            Node current = queue.poll();  // Obtener y remover el nodo al frente
            System.out.print(current.value + " ");  // Visitar el nodo

            // Encolar hijo izquierdo si existe
            if (current.left != null) {
                queue.add(current.left);
            }
            // Encolar hijo derecho si existe
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        // Construcción del árbol de ejemplo:
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4  5    6

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        // Mostrar el recorrido por niveles
        System.out.print("Recorrido por niveles (BFS): ");
        levelOrderTraversal(root);
        System.out.println();  // Salto de línea al finalizar
    }
}
