/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerArbolesBinarios;
/**
 * Ejercicio 5: Contar nodos hoja usando recorrido en Preorden.
 *
 * Se recorre el árbol en Preorden (Root-Left-Right) y se cuenta
 * cada nodo que no tiene hijos (hoja).
 */
public class Ejercicio_5 {

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
     * Cuenta la cantidad de nodos hoja en el árbol usando Preorden.
     *
     * @param root Raíz del subárbol actual.
     * @return Número de hojas encontradas.
     */
    private static int countLeafNodes(Node root) {
        // Caso base: árbol vacío no aporta hojas
        if (root == null) {
            return 0;
        }
        // Si es hoja (sin hijos), contamos 1
        if (root.left == null && root.right == null) {
            return 1;
        }
        // En Preorden, se visitan raíz, luego subárbol izquierdo y derecho
        int count = 0;
        // No se suma en la raíz pues no es hoja
        // Recorrer subárbol izquierdo
        count += countLeafNodes(root.left);
        // Recorrer subárbol derecho
        count += countLeafNodes(root.right);
        return count;
    }

    public static void main(String[] args) {
        // Construcción del árbol de ejemplo:
        //         7
        //        /  \
        //       4    9
        //      /    /  \
        //     2    8   11
        Node root = new Node(7);
        root.left = new Node(4);
        root.right = new Node(9);
        root.left.left = new Node(2);
        root.right.left = new Node(8);
        root.right.right = new Node(11);

        // Contar y mostrar el número de hojas
        int numLeaves = countLeafNodes(root);
        System.out.println("No. de hojas = " + numLeaves);
    }
}

