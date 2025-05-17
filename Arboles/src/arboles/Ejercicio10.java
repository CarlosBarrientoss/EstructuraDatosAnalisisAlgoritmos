/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arboles;

/**
 *
 * @author andre
 */
public class Ejercicio10 {
    static class Node {
        int value;
        Node left, right;
        Node(int v) { value = v; }
    }

    static void espejo(Node root) {
        if (root == null) return;
        espejo(root.left);
        espejo(root.right);
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    static void inorden(Node root) {
        if (root == null) return;
        inorden(root.left);
        System.out.print(root.value + " ");
        inorden(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(9);
        root.left = new Node(6);
        root.right = new Node(12);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.right = new Node(15);

        espejo(root);
        inorden(root);  // Esperado: 15 12 9 7 6 3
    }
}
