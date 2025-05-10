class Ejercicio2 {
    static class Node {
        int value;
        Node left, right;
        Node(int v) { value = v; }
    }

    static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        
        Node root = new Node(8);
        
        root.left = new Node(3);
        root.right = new Node(10);
        
        root.left.right = new Node(6);
        root.right.right = new Node(14);

        inOrder(root);  // Salida: 3 6 8 10 14
    }
}
