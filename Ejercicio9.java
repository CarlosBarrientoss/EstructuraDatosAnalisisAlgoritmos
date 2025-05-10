class Ejercicio9 {

    static class Node {
        int value;
        Node left, right;
        Node(int v) { value = v; }
    }

    static boolean printPath(Node root, int target) {
        if (root == null) return false;

        if (root.value == target || printPath(root.left, target) || printPath(root.right, target)) {
            System.out.print(root.value + " ");
            return true;
        }

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
        printPath(root, target);
        System.out.println(); // Esperado: 1 3 4
    }
}
