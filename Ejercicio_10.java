/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerArbolesBinarios;
/**
 * Ejercicio 10: Convertir un árbol binario en su espejo (swap de hijos) usando Postorden.
 *
 * Se recorre el árbol recursivamente en Postorden y en cada nodo se intercambian
 * los hijos izquierdo y derecho para obtener el árbol espejo.
 * Después se imprime el árbol resultante en Inorden para verificar la transformación.
 *
 * Ejemplo (Árbol original):
 *         9
 *        /  \
 *       6   12
 *      / \    \
 *     3   7   15
 *
 * Salida esperada (Inorden del árbol espejo): 15 12 9 7 6 3
 *
 * Referencia: Descripción del ejercicio
 */
public class Ejercicio_10 {

    /**
     * Nodo de un árbol binario con referencias a hijos.
     */
    private static class Node {
        int value;
        Node left;
        Node right;

        /**
         * Construye un nodo con el valor dado.
         *
         * @param value Valor entero a almacenar en el nodo.
         */
        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Convierte el árbol en su espejo intercambiando los hijos en Postorden.
     *
     * @param root Raíz del subárbol actual.
     */
    private static void mirrorTree(Node root) {
        if (root == null) {
            return;
        }
        // Convertir subárbol izquierdo primero
        mirrorTree(root.left);
        // Convertir subárbol derecho
        mirrorTree(root.right);
        // Intercambiar hijos izquierdo y derecho
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    /**
     * Recorre el árbol en Inorden (Left-Root-Right) e imprime cada valor.
     *
     * @param root Raíz del subárbol actual.
     */
    private static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        // Construcción del árbol de ejemplo
        Node root = new Node(9);
        root.left = new Node(6);
        root.right = new Node(12);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.right = new Node(15);

        // Convertir a espejo
        mirrorTree(root);

        // Mostrar recorrido en Inorden del árbol espejo
        System.out.print("Inorden del arbol espejo: ");
        inOrderTraversal(root);
        System.out.println(); // Salto de línea final
    }
}

