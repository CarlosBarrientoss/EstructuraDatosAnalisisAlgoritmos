/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.arboles;

public class Ejercicio8 {
    static class Node {
        int value;
        Node left, right;
        Node(int v) { value = v; }
    }

    static boolean searchPreOrder(Node root, int key) {
        if (root == null) return false;
        if (root.value == key) return true;
        return searchPreOrder(root.left, key) || searchPreOrder(root.right, key);
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);

        System.out.println("Encontrado para key=15: " + searchPreOrder(root, 15));  // Salida esperada: true
        System.out.println("Encontrado para key=25: " + searchPreOrder(root, 25));  // Salida esperada: false
    }
}