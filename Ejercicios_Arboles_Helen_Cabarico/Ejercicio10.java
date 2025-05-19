package ejercicio10;

public class Ejercicio10 {

    // Clase Nodo del Árbol
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    // Método para convertir el árbol en espejo usando postorden
    public static void convertirEnEspejo(Nodo nodo) {
        if (nodo == null) return;

        // Primero recorrer los hijos (postorden)
        convertirEnEspejo(nodo.izquierdo);
        convertirEnEspejo(nodo.derecho);

        // Intercambiar los hijos
        Nodo temp = nodo.izquierdo;
        nodo.izquierdo = nodo.derecho;
        nodo.derecho = temp;
    }

    // Método para recorrido inorden
    public static void inorden(Nodo nodo) {
        if (nodo == null) return;
        inorden(nodo.izquierdo);
        System.out.print(nodo.valor + " ");
        inorden(nodo.derecho);
    }

    public static void main(String[] args) {
        // Árbol original:
        //         9
        //        / \
        //       6   12
        //      / \    \
        //     3   7   15

        Nodo raiz = new Nodo(9);
        raiz.izquierdo = new Nodo(6);
        raiz.derecho = new Nodo(12);
        raiz.izquierdo.izquierdo = new Nodo(3);
        raiz.izquierdo.derecho = new Nodo(7);
        raiz.derecho.derecho = new Nodo(15);

        convertirEnEspejo(raiz);

        System.out.print("Árbol espejado (Inorden): ");
        inorden(raiz);
    }
}

