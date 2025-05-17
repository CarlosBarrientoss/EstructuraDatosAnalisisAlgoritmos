class NodoEspejo {
    int valor;
    NodoEspejo izq, der;

    NodoEspejo(int valor) {
        this.valor = valor;
        izq = der = null;
    }
}

public class Ejercicio10 {

    static void espejo(NodoEspejo nodo) {
        if (nodo == null) return;
        espejo(nodo.izq);
        espejo(nodo.der);
        NodoEspejo temp = nodo.izq;
        nodo.izq = nodo.der;
        nodo.der = temp;
    }

    static void inorden(NodoEspejo nodo) {
        if (nodo == null) return;
        inorden(nodo.izq);
        System.out.print(nodo.valor + " ");
        inorden(nodo.der);
    }

    public static void main(String[] args) {
        NodoEspejo raiz = new NodoEspejo(9);
        raiz.izq = new NodoEspejo(6);
        raiz.der = new NodoEspejo(12);
        raiz.izq.izq = new NodoEspejo(3);
        raiz.izq.der = new NodoEspejo(7);
        raiz.der.izq = new NodoEspejo(15);

        espejo(raiz);

        System.out.print("Inorden espejo: ");
        inorden(raiz); // Salida esperada: 15 12 9 7 6 3
    }
}
