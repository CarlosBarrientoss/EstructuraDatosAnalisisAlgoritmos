/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.arboles;

public class Ejercicio7 {
    static class Node {
        int value;
        Node left, right;
        Node(int v) { value = v; }
    }

    static int totalSum = 0;

    static void inOrderSum(Node root) {
        if (root == null) return;
        inOrderSum(root.left);
        totalSum += root.value;
        inOrderSum(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.right = new Node(9);

        inOrderSum(root);  // Suma usando recorrido inorden
        System.out.println("Suma total = " + totalSum);  // Salida esperada: 29
    }
}