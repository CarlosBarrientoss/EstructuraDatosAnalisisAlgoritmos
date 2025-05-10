class Ejercicio5 {

    static class Node {
        int value;
        Node left, right;
        Node(int v) { value = v; }
    }

    static int countLeaves(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(4);
        root.right = new Node(9);
        root.left.left = new Node(2);
        root.right.left = new Node(8);
        root.right.right = new Node(11);

        int leaves = countLeaves(root);
        System.out.println("N.º de hojas = " + leaves);  // Esperado: 3
    }
}
