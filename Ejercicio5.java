class Nodo {
    int valor;
    Nodo izquierdo, derecho;

    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}

public class Ejercicio5 {
    Nodo raiz;

    public Ejercicio5() {
        this.raiz = null;
    }

    public int contarHojas(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.izquierdo == null && nodo.derecho == null) {
            return 1;
        }
        return contarHojas(nodo.izquierdo) + contarHojas(nodo.derecho);
    }

    public static void main(String[] args) {
        Ejercicio5 arbol = new Ejercicio5();

        arbol.raiz = new Nodo(7);
        arbol.raiz.izquierdo = new Nodo(4);
        arbol.raiz.derecho = new Nodo(9);
        arbol.raiz.izquierdo.izquierdo = new Nodo(2);
        arbol.raiz.derecho.izquierdo = new Nodo(8);
        arbol.raiz.derecho.derecho = new Nodo(11);

        int numeroHojas = arbol.contarHojas(arbol.raiz);
        System.out.println("N.º de hojas = " + numeroHojas);
    }
}
