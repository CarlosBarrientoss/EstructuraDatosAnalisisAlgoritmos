
import java.util.*;

class Nodo {
    String valor;
    List<Nodo> hijos;

    public Nodo(String valor) {
        this.valor = valor;
        this.hijos = new ArrayList<>();
    }

    public void agregarHijo(Nodo hijo) {
        hijos.add(hijo);
    }
}

class Arbol {
    Nodo raiz;

    public Arbol() {
        this.raiz = construirArbol();
    }

    private Nodo construirArbol() {
        Nodo H = new Nodo("H");
        Nodo I = new Nodo("I");
        Nodo J = new Nodo("J");
        Nodo K = new Nodo("K");
        Nodo L = new Nodo("L");
        Nodo M = new Nodo("M");
        Nodo N = new Nodo("N");
        Nodo O = new Nodo("O");

        Nodo D = new Nodo("D");
        D.agregarHijo(H);
        D.agregarHijo(I);

        Nodo E = new Nodo("E");
        E.agregarHijo(J);
        E.agregarHijo(K);

        Nodo F = new Nodo("F");
        F.agregarHijo(L);
        F.agregarHijo(M);

        Nodo G = new Nodo("G");
        G.agregarHijo(N);
        G.agregarHijo(O);

        Nodo B = new Nodo("B");
        B.agregarHijo(D);
        B.agregarHijo(E);

        Nodo C = new Nodo("C");
        C.agregarHijo(F);
        C.agregarHijo(G);

        Nodo A = new Nodo("A");
        A.agregarHijo(B);
        A.agregarHijo(C);

        return A;
    }

    public void preOrden() {
        System.out.print("Recorrido en Preorden: ");
        recorrerPreOrden(raiz);
        System.out.println();
    }

    private void recorrerPreOrden(Nodo nodo) {
        if (nodo == null) return;
        System.out.print(nodo.valor + " ");
        for (Nodo hijo : nodo.hijos) {
            recorrerPreOrden(hijo);
        }
    }

    public void postOrden() {
        System.out.print("Recorrido en Postorden: ");
        recorrerPostOrden(raiz);
        System.out.println();
    }

    private void recorrerPostOrden(Nodo nodo) {
        if (nodo == null) return;
        for (Nodo hijo : nodo.hijos) {
            recorrerPostOrden(hijo);
        }
        System.out.print(nodo.valor + " ");
    }

    public void inOrden() {
        System.out.print("Recorrido en Inorden: ");
        recorrerInOrden(raiz);
        System.out.println();
    }

    private void recorrerInOrden(Nodo nodo) {
        if (nodo == null) return;
        int n = nodo.hijos.size();
        for (int i = 0; i < n / 2; i++) {
            recorrerInOrden(nodo.hijos.get(i));
        }
        System.out.print(nodo.valor + " ");
        for (int i = n / 2; i < n; i++) {
            recorrerInOrden(nodo.hijos.get(i));
        }
    }

    public void amplitud() {
        System.out.print("Recorrido en Amplitud: ");
        if (raiz == null) return;
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            System.out.print(actual.valor + " ");
            cola.addAll(actual.hijos);
        }
        System.out.println();
    }
}

public class AB {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        arbol.preOrden();
        arbol.inOrden();
        arbol.postOrden();
        arbol.amplitud();
    }
}
