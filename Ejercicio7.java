
public class Ejercicio7 {
    static public class SumaInorden {

    static class Nodo {
        int valor;
        Nodo izquierda, derecha;

        Nodo(int valor) {
            this.valor = valor;
            izquierda = derecha = null;
        }
    }

    static int sumaInorden(Nodo nodo) {
        if (nodo == null) return 0;

        int sumaIzquierda = sumaInorden(nodo.izquierda);
        int sumaDerecha = sumaInorden(nodo.derecha);
        return sumaIzquierda + nodo.valor + sumaDerecha;
    }

    public static void main(String[] args) {

        Nodo raiz = new Nodo(5);
        raiz.izquierda = new Nodo(3);
        raiz.derecha = new Nodo(7);
        raiz.izquierda.izquierda = new Nodo(1);
        raiz.izquierda.derecha = new Nodo(4);
        raiz.derecha.derecha = new Nodo(9);

        int sumaTotal = sumaInorden(raiz);
        System.out.println("Suma total = " + sumaTotal);
    }
}

}
