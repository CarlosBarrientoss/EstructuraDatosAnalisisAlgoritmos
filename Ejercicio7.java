class NodoInt {
    int valor;
    NodoInt izq, der;

    NodoInt(int valor) {
        this.valor = valor;
        izq = der = null;
    }
}

public class Ejercicio7 {

    static int sumaTotal(NodoInt nodo) {
        if (nodo == null) return 0;
        return sumaTotal(nodo.izq) + nodo.valor + sumaTotal(nodo.der);
    }

    public static void main(String[] args) {
        NodoInt raiz = new NodoInt(5);
        raiz.izq = new NodoInt(3);
        raiz.der = new NodoInt(7);
        raiz.izq.izq = new NodoInt(1);
        raiz.izq.der = new NodoInt(4);
        raiz.der.der = new NodoInt(9);

        int suma = sumaTotal(raiz);
        System.out.println("Suma total = " + suma); // Salida esperada: 29
    }
}
