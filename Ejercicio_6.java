/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerArbolesBinarios;
/**
 * Ejercicio 6: Calcular la altura de un árbol binario usando Postorden.
 *
 * Se recorre el árbol recursivamente para obtener la altura de cada subárbol,
 * y la altura del árbol es el máximo entre la altura del subárbol izquierdo
 * y el derecho, más uno.
 */
public class Ejercicio_6 {

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
     * Calcula la altura del árbol.
     *
     * @param root raíz del subárbol actual.
     * @return Altura del subárbol (número de niveles).
     */
    private static int calculateHeight(Node root) {
        // Caso base: árbol vacío tiene altura 0
        if (root == null) {
            return 0;
        }
        // Calcular altura de subárbol izquierdo
        int leftHeight = calculateHeight(root.left);
        // Calcular altura de subárbol derecho
        int rightHeight = calculateHeight(root.right);
        // Altura del árbol = mayor altura de los subárboles + 1 (nivel actual)
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        // Construcción del árbol de ejemplo (altura esperada = 4):
        //       M
        //      /
        //     N
        //    / \
        //   O   P
        //          \
        //           Q
        Node root = new Node('M');
        root.left = new Node('N');
        root.left.left = new Node('O');
        root.left.right = new Node('P');
        root.left.right.right = new Node('Q');

        // Calcular y mostrar la altura
        int height = calculateHeight(root);
        System.out.println("Altura = " + height);
    }
}
