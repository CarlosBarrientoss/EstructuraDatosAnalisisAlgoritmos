/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arboles;

/**
 *
 * @author andre
 */
public class Ejercicio9 {
    static class Node {
        int value;
        Node left, right;
        Node(int v) { value = v; }
    }

    static boolean imprimirCamino(Node root, int target) {
        if (root == null) return false;
        System.out.print(root.value + " ");
        if (root.value == target) return true;

        if (imprimirCamino(root.left, target) || imprimirCamino(root.right, target))
            return true;

        System.out.print("\b\b"); // Elimina valor si no está en el camino
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        int target = 4;
        System.out.print("Camino a " + target + ": ");
        imprimirCamino(root, target);  // Esperado: 1 3 4
    }
}

