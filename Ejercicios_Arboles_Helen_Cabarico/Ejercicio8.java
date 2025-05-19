
package ejercicio8;

public class Ejercicio8 {

    // Clase Nodo del Árbol
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    // Método de búsqueda con recorrido Preorden
    public static boolean buscarPreorden(Nodo nodo, int clave) {
        if (nodo == null) {
            return false;
        }

        // Revisar el nodo actual
        if (nodo.valor == clave) {
            return true;
        }

        // Buscar en subárbol izquierdo y derecho
        return buscarPreorden(nodo.izquierdo, clave) || buscarPreorden(nodo.derecho, clave);
    }

    public static void main(String[] args) {
        // Árbol:
        //       20
        //      /  \
        //    10   30
        //   /  \
        //  5   15

        Nodo raiz = new Nodo(20);
        raiz.izquierdo = new Nodo(10);
        raiz.derecho = new Nodo(30);
        raiz.izquierdo.izquierdo = new Nodo(5);
        raiz.izquierdo.derecho = new Nodo(15);

        int clave1 = 15;
        int clave2 = 25;

        System.out.println("Buscando " + clave1 + ": " + (buscarPreorden(raiz, clave1) ? "Encontrado" : "No encontrado"));
        System.out.println("Buscando " + clave2 + ": " + (buscarPreorden(raiz, clave2) ? "Encontrado" : "No encontrado"));
    }
}
