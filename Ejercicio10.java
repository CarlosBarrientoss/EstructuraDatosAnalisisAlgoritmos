/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.arboles;

/**
 *
 * @author Usuario
 */
class Ejercicio10 {
    static class Node {
        int value;
        Node left, right;
        Node(int v) { value = v; }
    }

    static void mirrorPostOrder(Node root) {
        if (root == null) return;
        mirrorPostOrder(root.left);
        mirrorPostOrder(root.right);
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(9);
        root.left = new Node(6);
        root.right = new Node(12);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.right = new Node(15);

        mirrorPostOrder(root);

        System.out.print("Salida espejada Inorden: ");
        inOrder(root);  
    }
}
