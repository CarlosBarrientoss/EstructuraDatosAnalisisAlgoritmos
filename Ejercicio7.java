class Ejercicio7 {

    static class Node {
        int value;
        Node left, right;
        Node(int v) { value = v; }
    }

    static int sum = 0;

    static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        sum += root.value;
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.right = new Node(9);

        inOrder(root);
        System.out.println("Suma total = " + sum); // Esperado: 29
    }
}
