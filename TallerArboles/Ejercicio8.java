package TallerArboles;

public class Ejercicio8 {
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    public class BusquedaPreorden {

        public static boolean buscarPreorden(Nodo nodo, int key) {
            if (nodo == null) return false;

            // Preorden: Nodo -> Izquierdo -> Derecho
            if (nodo.valor == key) return true;

            // Buscar en subárbol izquierdo o derecho
            return buscarPreorden(nodo.izquierdo, key) || buscarPreorden(nodo.derecho, key);
        }

        public static void main(String[] args) {
            // Construcción del árbol
            Nodo raiz = new Nodo(20);
            raiz.izquierdo = new Nodo(10);
            raiz.izquierdo.izquierdo = new Nodo(5);
            raiz.izquierdo.derecho = new Nodo(15);
            raiz.derecho = new Nodo(30);

            int key1 = 15;
            int key2 = 25;

            System.out.println("Buscando key=" + key1 + ": " +
                (buscarPreorden(raiz, key1) ? "Encontrado" : "No encontrado"));

            System.out.println("Buscando key=" + key2 + ": " +
                (buscarPreorden(raiz, key2) ? "Encontrado" : "No encontrado"));
        }
    }
}
