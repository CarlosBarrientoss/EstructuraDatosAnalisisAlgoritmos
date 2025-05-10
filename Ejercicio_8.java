/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerArbolesBinarios;
/**
 * Ejercicio 8: Búsqueda de un valor en un árbol binario usando Preorden.
 *
 * Se recorre primero la raíz, luego recursivamente el subárbol izquierdo
 * y después el subárbol derecho, buscando el valor clave.
 */
public class Ejercicio_8 {

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
         * @param value Valor almacenado en el nodo.
         */
        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Busca un valor clave en el árbol usando recorrido en Preorden.
     *
     * @param root Raíz del subárbol actual.
     * @param key  Valor a buscar.
     * @return true si se encuentra el valor; false en caso contrario.
     */
    private static boolean searchPreOrder(Node root, int key) {
        // Caso base: si el nodo es nulo, no encontrado
        if (root == null) {
            return false;
        }
        // Verificar la raíz
        if (root.value == key) {
            return true;
        }
        // Buscar en subárbol izquierdo
        if (searchPreOrder(root.left, key)) {
            return true;
        }
        // Buscar en subárbol derecho
        return searchPreOrder(root.right, key);
    }

    public static void main(String[] args) {
        // Construcción del árbol de ejemplo (Ejercicio 8)
        //       20
        //      /  \
        //     10  30
        //    /  \
        //   5   15

        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);

        // Búsqueda de claves y muestra de resultados
        int[] keysToSearch = {15, 25};
        for (int key : keysToSearch) {
            boolean found = searchPreOrder(root, key);
            if (found) {
                System.out.println("Encontrado para key=" + key);
            } else {
                System.out.println("No encontrado para key=" + key);
            }
        }
    }
}

