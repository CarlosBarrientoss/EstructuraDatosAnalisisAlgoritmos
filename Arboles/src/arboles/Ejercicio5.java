/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arboles;

/**
 *
 * @author andre
 */
public class Ejercicio5 {
    static class Node {
        int value;
        Node left, right;
        Node(int v) { value = v; }
    }

    static int contarHojas(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return contarHojas(root.left) + contarHojas(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(4);
        root.right = new Node(9);
        root.left.left = new Node(2);
        root.right.left = new Node(8);
        root.right.right = new Node(11);

        int hojas = contarHojas(root);
        System.out.println("N.º de hojas = " + hojas);  // Esperado: 3
    } 
}
