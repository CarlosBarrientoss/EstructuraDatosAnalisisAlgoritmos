/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arboles;

/**
 *
 * @author andre
 */
public class Ejercicio8 {
    static class Node {
        int value;
        Node left, right;
        Node(int v) { value = v; }
    }

    static boolean buscar(Node root, int key) {
        if (root == null) return false;
        if (root.value == key) return true;
        return buscar(root.left, key) || buscar(root.right, key);
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);

        int key1 = 15;
        int key2 = 25;

        System.out.println("¿Encontrado key=" + key1 + "? " + (buscar(root, key1) ? "Sí" : "No"));
        System.out.println("¿Encontrado key=" + key2 + "? " + (buscar(root, key2) ? "Sí" : "No"));
    }
}

