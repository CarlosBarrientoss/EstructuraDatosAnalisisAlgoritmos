class Ejercicio1 {
    
    static class Node {
        int value;
        Node left, right;
        Node(int v) { value = v; }
    }

    static void preOrder(Node root) {
        
        if (root == null) return;
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        // Construcción del árbol
        
        Node root = new Node(10);
        
        root.left = new Node(5);
        root.right = new Node(15);
        
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        
        root.right.left = new Node(12);
        root.right.right = new Node(20);

        // Recorrido preorden
        preOrder(root);  // Salida: 10 5 2 7 15 12 20
    }
}
