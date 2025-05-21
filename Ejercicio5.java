
public class Ejercicio5 {

    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        public Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    public static int contarHojas(Nodo nodo) {
        if (nodo == null)
            return 0;

        if (nodo.izquierdo == null && nodo.derecho == null)
            return 1;

        int hojasIzquierda = contarHojas(nodo.izquierdo);
        int hojasDerecha = contarHojas(nodo.derecho);

        return hojasIzquierda + hojasDerecha;
    }

    public static void main(String[] args) {
        Nodo raiz = new Nodo(7);
        raiz.izquierdo = new Nodo(4);
        raiz.derecho = new Nodo(9);
        raiz.izquierdo.izquierdo = new Nodo(2);
        raiz.derecho.izquierdo = new Nodo(8);
        raiz.derecho.derecho = new Nodo(11);

        int numeroHojas = contarHojas(raiz);
        System.out.println("número de hojas = " + numeroHojas);
    }
}
