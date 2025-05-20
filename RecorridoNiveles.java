import java.util.*;

class Nodo {
    int valor;
    Nodo izquierdo, derecho;

    Nodo(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

public class RecorridoNiveles {
    public static void recorridoBFS(Nodo raiz) {
        if (raiz == null) return;

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            System.out.print(actual.valor + " ");

            if (actual.izquierdo != null)
                cola.add(actual.izquierdo);
            if (actual.derecho != null)
                cola.add(actual.derecho);
        }
    }

    public static void main(String[] args) {

        Nodo raiz = new Nodo(1);
        raiz.izquierdo = new Nodo(2);
        raiz.derecho = new Nodo(3);
        raiz.izquierdo.izquierdo = new Nodo(4);
        raiz.izquierdo.derecho = new Nodo(5);
        raiz.derecho.derecho = new Nodo(6);

        System.out.print("Recorrido BFS: ");
        recorridoBFS(raiz);  // Salida esperada: 1 2 3 4 5 6
    }
}
