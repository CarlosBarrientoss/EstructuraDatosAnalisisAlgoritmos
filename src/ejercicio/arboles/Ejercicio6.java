/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.arboles;

public class Ejercicio6 {
    static class Node {
        char value;
        Node left, right;
        Node(char v) { value = v; }
    }

    static int height(Node root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node('M');
        root.left = new Node('N');
        root.left.left = new Node('O');
        root.left.right = new Node('P');
        root.left.right.right = new Node('Q');

        int altura = height(root);  // Calculada con recorrido postorden
        System.out.println("Altura = " + altura);  // Salida esperada: 4
    }
}