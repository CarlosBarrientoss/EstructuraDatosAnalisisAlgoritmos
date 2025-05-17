import java.util.LinkedList;
import java.util.Queue;

class Nodo {
    String valor;
    Nodo izquierdo;
    Nodo derecho;

    Nodo(String valor) {
        this.valor = valor;
    }
}

public class AB {

    public static void main(String[] args) {
        // Crear nodos
        Nodo A = new Nodo("A");
        Nodo B = new Nodo("B");
        Nodo C = new Nodo("C");
        Nodo D = new Nodo("D");
        Nodo E = new Nodo("E");
        Nodo F = new Nodo("F");
        Nodo G = new Nodo("G");
        Nodo H = new Nodo("H");
        Nodo I = new Nodo("I");
        Nodo J = new Nodo("J");
        Nodo K = new Nodo("K");
        Nodo L = new Nodo("L");
        Nodo M = new Nodo("M");
        Nodo N = new Nodo("N");
        Nodo O = new Nodo("O");

        // Estructura del árbol binario
        A.izquierdo = B;
        A.derecho = C;

        B.izquierdo = D;
        B.derecho = E;

        C.izquierdo = F;
        C.derecho = G;

        D.izquierdo = H;
        D.derecho = I;

        E.izquierdo = J;
        E.derecho = K;

        F.izquierdo = L;
        F.derecho = M;

        G.izquierdo = N;
        G.derecho = O;

        //  RECORRIDO EN PREORDEN
        System.out.print("Recorrido en Preorden: ");
        preOrden(A);
        System.out.println();

        //  RECORRIDO EN INORDEN
        System.out.print("Recorrido en Inorden: ");
        inOrden(A);
        System.out.println();

        //  RECORRIDO EN POSTORDEN
        System.out.print("Recorrido en Postorden: ");
        postOrden(A);
        System.out.println();

        //  RECORRIDO POR NIVELES (AMPLITUD)
        System.out.print("Recorrido por Niveles (Búsqueda en amplitud): ");
        porNiveles(A);
        System.out.println();
    }

    // MÉTODO DE RECORRIDO EN PREORDEN
    public static void preOrden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preOrden(nodo.izquierdo);
            preOrden(nodo.derecho);
        }
    }

    // MÉTODO DE RECORRIDO EN INORDEN
    public static void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inOrden(nodo.derecho);
        }
    }

    // MÉTODO DE RECORRIDO EN POSTORDEN
    public static void postOrden(Nodo nodo) {
        if (nodo != null) {
            postOrden(nodo.izquierdo);
            postOrden(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }

    // MÉTODO DE RECORRIDO POR NIVELES (AMPLITUD)
    public static void porNiveles(Nodo raiz) {
        if (raiz == null) return;

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            System.out.print(actual.valor + " ");
            if (actual.izquierdo != null) cola.add(actual.izquierdo);
            if (actual.derecho != null) cola.add(actual.derecho);
        }
    }
}

