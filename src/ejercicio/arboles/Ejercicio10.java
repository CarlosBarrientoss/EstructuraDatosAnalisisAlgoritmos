/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.arboles;

public class Ejercicio10 {
    static class Node {
        int value;
        Node left, right;
        Node(int v) { value = v; }
    }

    static void mirrorTree(Node root) {
        if (root == null) return;
        
        // Recursión para intercambiar los hijos
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);  // Llamada recursiva en el hijo izquierdo
        mirrorTree(root.right);  // Llamada recursiva en el hijo derecho
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

        System.out.print("Árbol original Inorden: ");
        inOrder(root);  // Salida esperada: 3 6 7 9 12 15
        System.out.println();

        mirrorTree(root);  // Convertir el árbol en espejo

        System.out.print("Árbol espejado Inorden: ");
        inOrder(root);  // Salida esperada: 15 12 9 7 6 3
    }
}