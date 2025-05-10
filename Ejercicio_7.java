/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerArbolesBinarios;
/**
 * Ejercicio 7: Suma de todos los nodos de un árbol binario usando recorrido Inorden.
 *
 * Se recorre el árbol en Inorden (Left-Root-Right) y se acumula el valor de cada nodo.
 */
public class Ejercicio_7 {

    /**
     * Representa un nodo de un árbol binario.
     */
    private static class Node {
        int value;
        Node left;
        Node right;

        /**
         * Constructor de nodo con valor dado.
         *
         * @param value Valor entero a almacenar
         */
        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Recorre el árbol en Inorden y suma los valores de todos los nodos.
     *
     * @param root Raíz del subárbol actual
     * @return Suma de los valores de los nodos
     */
    private static int sumNodesInOrder(Node root) {
        if (root == null) {
            // Si no hay nodo, aporta 0 a la suma
            return 0;
        }
        // Sumar valores del subárbol izquierdo
        int sum = sumNodesInOrder(root.left);
        // Sumar el valor de la raíz
        sum += root.value;
        // Sumar valores del subárbol derecho
        sum += sumNodesInOrder(root.right);
        return sum;
    }

    /**
     * Método principal: construye el árbol de ejemplo y muestra la suma total.
     *
     * Árbol de ejemplo:
     *       5
     *      / \
     *     3   7
     *    / \   \
     *   1  4    9
     *
     * Salida esperada: Suma total = 29
     */
    public static void main(String[] args) {
        // Construcción del árbol de ejemplo
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.right = new Node(9);

        // Calcular y mostrar la suma de todos los nodos
        int totalSum = sumNodesInOrder(root);
        System.out.println("Suma total = " + totalSum);
    }
}

