/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arboles;

/**
 *
 * @author andre
 */
public class Ejercicio4 {

    static class Node {
        int value;
        Node left, right;

        Node(int v) {
            value = v;
        }
    }

    // Implementación de cola simple para BFS
    static class SimpleQueue {
        Node[] elements;
        int front, rear, size;

        SimpleQueue(int capacity) {
            elements = new Node[capacity];
            front = 0;
            rear = 0;
            size = 0;
        }

        void enqueue(Node node) {
            if (size == elements.length) return; // Cola llena
            elements[rear] = node;
            rear = (rear + 1) % elements.length;
            size++;
        }

        Node dequeue() {
            if (isEmpty()) return null;
            Node node = elements[front];
            front = (front + 1) % elements.length;
            size--;
            return node;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    // Recorrido por niveles (BFS) sin usar librerías
    static void bfs(Node root) {
        if (root == null) return;

        SimpleQueue queue = new SimpleQueue(100); // tamaño fijo suficiente
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node current = queue.dequeue();
            System.out.print(current.value + " ");

            if (current.left != null) queue.enqueue(current.left);
            if (current.right != null) queue.enqueue(current.right);
        }
    }

    public static void main(String[] args) {
        // Construcción del árbol del ejercicio (imagen)
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        // Recorrido por niveles (esperado: 1 2 3 4 5 6)
        bfs(root);
    }
}
