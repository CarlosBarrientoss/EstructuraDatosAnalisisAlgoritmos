class Ejercicio8 {

    static class Node {
        int value;
        Node left, right;
        Node(int v) { value = v; }
    }

    static boolean found = false;

    static void preOrderSearch(Node root, int key) {
        if (root == null) return;
        if (root.value == key) {
            found = true;
            return;
        }
        preOrderSearch(root.left, key);
        preOrderSearch(root.right, key);
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);

        int key1 = 15;
        preOrderSearch(root, key1);
        System.out.println("¿" + key1 + " encontrado? " + (found ? "Sí" : "No"));

        found = false;
        int key2 = 25;
        preOrderSearch(root, key2);
        System.out.println("¿" + key2 + " encontrado? " + (found ? "Sí" : "No"));
    }
}
