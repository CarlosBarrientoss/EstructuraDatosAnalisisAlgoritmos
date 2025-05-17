public class BusquedaPreorden {

    // Clase interna para el nodo del árbol
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    // Búsqueda usando recorrido preorden (nodo - izq - der)
    public static boolean buscarPreorden(Nodo nodo, int clave) {
        if (nodo == null)
            return false;

        // Comprobar el nodo actual
        if (nodo.valor == clave)
            return true;

        // Buscar en subárbol izquierdo y derecho
        return buscarPreorden(nodo.izquierdo, clave) || buscarPreorden(nodo.derecho, clave);
    }

    public static void main(String[] args) {
        /*
            Árbol:
                   20
                  /  \
                10    30
               /  \
              5   15
        */

        Nodo raiz = new Nodo(20);
        raiz.izquierdo = new Nodo(10);
        raiz.derecho = new Nodo(30);
        raiz.izquierdo.izquierdo = new Nodo(5);
        raiz.izquierdo.derecho = new Nodo(15);

        int clave1 = 15;
        int clave2 = 25;

        if (buscarPreorden(raiz, clave1)) {
            System.out.println("Encontrado: " + clave1);
        } else {
            System.out.println("No encontrado: " + clave1);
        }

        if (buscarPreorden(raiz, clave2)) {
            System.out.println("Encontrado: " + clave2);
        } else {
            System.out.println("No encontrado: " + clave2);
        }
    }
}
