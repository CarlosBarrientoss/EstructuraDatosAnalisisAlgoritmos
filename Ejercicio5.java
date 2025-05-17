/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.arboles;

public class Ejercicio5 {
    static class Node {
        int value;
        Node left, right;
        Node(int v) { value = v; }
    }

    static int leafCount = 0;

    static void countLeavesPreOrder(Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leafCount++;
        }
        countLeavesPreOrder(root.left);
        countLeavesPreOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(4);
        root.right = new Node(9);
        root.left.left = new Node(2);
        root.right.left = new Node(8);
        root.right.right = new Node(11);

        countLeavesPreOrder(root);  // Preorden para contar hojas

        System.out.println("Numero de hojas = " + leafCount);  // Salida esperada: 3
    }
}