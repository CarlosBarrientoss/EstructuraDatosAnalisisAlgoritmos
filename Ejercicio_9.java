/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerArbolesBinarios;
/**
 * Ejercicio 9 (versión práctica): Imprimir el camino desde la raíz hasta un nodo
 * objetivo en un árbol binario sin usar listas ni funciones auxiliares complejas.
 *
 * Estrategia:
 * 1. Añadir punteros "parent" en cada nodo para reconstruir el camino.
 * 2. Realizar un recorrido en profundidad iterativo (stack) para encontrar el nodo target.
 * 3. Una vez encontrado, usar recursión sencilla en el método printPath para imprimir
 *    el camino desde la raíz hasta el nodo siguiendo los punteros parent.
 */
import java.util.Stack;

public class Ejercicio_9 {

    /**
     * Nodo de un árbol binario con puntero al padre.
     */
    private static class Node {
        int value;
        Node left;
        Node right;
        Node parent;  // Puntero al padre para reconstruir el camino

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Recorre el árbol iterativamente con un stack para encontrar el nodo con valor target.
     * @param root  Raíz del árbol donde iniciar la búsqueda
     * @param target Valor a buscar
     * @return Referencia al nodo encontrado, o null si no existe
     */
    private static Node findNode(Node root, int target) {
        if (root == null) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (current.value == target) {
                return current;
            }
            // Push hijos (derecho primero para procesar izquierdo luego)
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return null;
    }

    /**
     * Imprime recursivamente el camino desde la raíz hasta el nodo dado.
     * Aprovecha los punteros "parent" para subir hasta la raíz.
     * @param node Nodo objetivo
     */
    private static void printPath(Node node) {
        if (node == null) {
            return;
        }
        printPath(node.parent);  // Primero imprimir ancestros
        System.out.print(node.value + " ");
    }

    public static void main(String[] args) {
        // Construcción del árbol de ejemplo:
        //      1
        //     / \
        //    2   3
        //       / \
        //      4   5
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.parent = root;
        root.right.parent = root;
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.left.parent = root.right;
        root.right.right.parent = root.right;

        int target = 4;
        Node targetNode = findNode(root, target);
        if (targetNode != null) {
            System.out.print("Camino a " + target + ": ");
            printPath(targetNode);
            System.out.println();
        } else {
            System.out.println("Nodo con valor " + target + " no encontrado.");
        }
    }
}
