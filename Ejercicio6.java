class NodoChar {
    char valor;
    NodoChar izq, der;

    NodoChar(char valor) {
        this.valor = valor;
        izq = der = null;
    }
}

public class Ejercicio6{

    static int altura(NodoChar nodo) {
        if (nodo == null) return 0;
        int izq = altura(nodo.izq);
        int der = altura(nodo.der);
        return Math.max(izq, der) + 1;
    }

    public static void main(String[] args) {
        NodoChar raiz = new NodoChar('M');
        raiz.izq = new NodoChar('N');
        raiz.izq.izq = new NodoChar('O');
        raiz.izq.izq.der = new NodoChar('P');
        raiz.izq.izq.der.der = new NodoChar('Q');

        int resultado = altura(raiz);
        System.out.println("Altura = " + resultado); // Salida esperada: Altura = 4
    }
}