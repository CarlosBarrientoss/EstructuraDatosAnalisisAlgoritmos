class Ejercicio6 {

    static class Node {
        int value;
        Node left, right;
        Node(int v) { value = v; }
    }

    static int height(Node root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(1);
        root.right.right = new Node(10);
        root.right.right.right = new Node(12);

        int h = height(root);
        System.out.println("Altura del árbol = " + h);  // Esperado: 4
    }
}
