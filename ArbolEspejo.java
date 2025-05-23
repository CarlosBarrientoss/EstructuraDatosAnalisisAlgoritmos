class Nodo {
    int valor;
    Nodo izquierda, derecha;

    public Nodo(int valor) {
        this.valor = valor;
        izquierda = derecha = null;
    }
}

public class ArbolEspejo {

    // Recorrido postorden para convertir en espejo
    public static void convertirEnEspejo(Nodo nodo) {
        if (nodo == null) return;

        convertirEnEspejo(nodo.izquierda);
        convertirEnEspejo(nodo.derecha);

        // Intercambiar hijos
        Nodo temp = nodo.izquierda;
        nodo.izquierda = nodo.derecha;
        nodo.derecha = temp;
    }

    // Recorrido inorden para mostrar el árbol
    public static void inorden(Nodo nodo) {
        if (nodo == null) return;

        inorden(nodo.izquierda);
        System.out.print(nodo.valor + " ");
        inorden(nodo.derecha);
    }

    public static void main(String[] args) {
        Nodo raiz = new Nodo(9);
        raiz.izquierda = new Nodo(6);
        raiz.derecha = new Nodo(12);
        raiz.izquierda.izquierda = new Nodo(3);
        raiz.izquierda.derecha = new Nodo(7);
        raiz.derecha.derecha = new Nodo(15);

        convertirEnEspejo(raiz);

        inorden(raiz); // Salida esperada: 15 12 9 7 6 3
    }
}
