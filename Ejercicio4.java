import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio4 {

    static class Nodo {
        int valor;
        Nodo izquierda, derecha;

        public Nodo(int valor) {
            this.valor = valor;
            izquierda = derecha = null;
        }
    }

    public static void recorridoPorNiveles(Nodo raiz) {
        if (raiz == null) return;

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            System.out.print(actual.valor + " ");

            if (actual.izquierda != null) {
                cola.add(actual.izquierda);
            }
            if (actual.derecha != null) {
                cola.add(actual.derecha);
            }
        }
    }

    public static void main(String[] args) {
        Nodo raiz = new Nodo(1);
        raiz.izquierda = new Nodo(2);
        raiz.derecha = new Nodo(3);
        raiz.izquierda.izquierda = new Nodo(4);
        raiz.izquierda.derecha = new Nodo(5);
        raiz.derecha.derecha = new Nodo(6);

        recorridoPorNiveles(raiz);
    }
}

