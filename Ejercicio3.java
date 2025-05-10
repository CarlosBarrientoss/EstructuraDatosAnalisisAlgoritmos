class Ejercicio3 {
    static class Node {
        char value;
        Node left, right;
        Node(char v) { value = v; }
    }

    static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

    public static void main(String[] args) {
        Node root = new Node('A');
        root.left = new Node('B');
        root.right = new Node('C');
        root.left.left = new Node('D');
        root.right.left = new Node('E');
        root.right.right = new Node('F');

        postOrder(root);  // Salida: D B E F C A
    }
}
