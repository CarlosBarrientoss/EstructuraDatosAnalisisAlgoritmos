package ejercicio7;

public class Ejercicio7 {

    // Clase Nodo del Árbol
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    // Método para sumar todos los nodos (Inorden)
    public static int sumaInorden(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }

        // Recorrido inorden: izquierda - nodo - derecha
        int sumaIzquierda = sumaInorden(nodo.izquierdo);
        int sumaActual = nodo.valor;
        int sumaDerecha = sumaInorden(nodo.derecho);

        return sumaIzquierda + sumaActual + sumaDerecha;
    }

    public static void main(String[] args) {
        // Árbol:
        //       5
        //      / \
        //     3   7
        //    / \    \
        //   1   4    9

        Nodo raiz = new Nodo(5);
        raiz.izquierdo = new Nodo(3);
        raiz.derecho = new Nodo(7);
        raiz.izquierdo.izquierdo = new Nodo(1);
        raiz.izquierdo.derecho = new Nodo(4);
        raiz.derecho.derecho = new Nodo(9);

        int sumaTotal = sumaInorden(raiz);
        System.out.println("Suma total = " + sumaTotal);
    }
}
