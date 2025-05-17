/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arboles;

/**
 *
 * @author andre
 */
public class Ejercicio6 {
    static class Node {
        char value;
        Node left, right;
        Node(char v) { value = v; }
    }

    static int altura(Node root) {
        if (root == null) return 0;
        int izq = altura(root.left);
        int der = altura(root.right);
        return 1 + Math.max(izq, der);
    }

    public static void main(String[] args) {
        Node root = new Node('M');
        root.left = new Node('N');
        root.left.left = new Node('O');
        root.left.right = new Node('P');
        root.left.right.right = new Node('Q');

        int h = altura(root);
        System.out.println("Altura = " + h);  // Esperado: 4
    }
}
