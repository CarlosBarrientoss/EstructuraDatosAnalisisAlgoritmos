/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.arboles;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio9 {
    static class Node {
        int value;
        Node left, right;
        Node(int v) { value = v; }
    }

    static boolean printPathToLeaf(Node root, int target, List<Integer> path) {
        if (root == null) return false;
        path.add(root.value);

        if (root.left == null && root.right == null && root.value == target) {
            System.out.print("Camino a " + target + ": ");
            for (int val : path) {
                System.out.print(val + " ");
            }
            System.out.println();
            return true;
        }

        if (printPathToLeaf(root.left, target, path) || printPathToLeaf(root.right, target, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        List<Integer> path = new ArrayList<>();
        printPathToLeaf(root, 4, path);  // Salida esperada: Camino a 4: 1 3 4
    }
}