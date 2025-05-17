/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arboles;

/**
 *
 * @author andre
 */
public class Ejercicio7 {
    static class Node {
        int value;
        Node left, right;
        Node(int v) { value = v; }
    }

    static int suma(Node root) {
        if (root == null) return 0;
        return suma(root.left) + root.value + suma(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.right = new Node(9);

        int total = suma(root);
        System.out.println("Suma total = " + total);  // Esperado: 29
    }
}

