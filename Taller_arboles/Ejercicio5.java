
package ejercicio5;
public class Ejercicio5 {

    // Clase Nodo del Árbol
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    // Método para contar hojas con recorrido Preorden
    public static int contarHojas(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }

        // Si el nodo no tiene hijos, es hoja
        if (nodo.izquierdo == null && nodo.derecho == null) {
            return 1;
        }

        // Llamadas recursivas a los hijos
        return contarHojas(nodo.izquierdo) + contarHojas(nodo.derecho);
    }

    public static void main(String[] args) {
        // Árbol:
        //       7
        //      / \
        //     4   9
        //    /   / \
        //   2   8  11

        Nodo raiz = new Nodo(7);
        raiz.izquierdo = new Nodo(4);
        raiz.derecho = new Nodo(9);
        raiz.izquierdo.izquierdo = new Nodo(2);
        raiz.derecho.izquierdo = new Nodo(8);
        raiz.derecho.derecho = new Nodo(11);

        int hojas = contarHojas(raiz);
        System.out.println("N.º de hojas = " + hojas);
    }
}
