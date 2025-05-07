package arboles;

import java.util.*; // Necesario para importar List y ArrayList

/**
 *
 * @author duvan
 */
public class Imprimir {

    // Clase Nodo estática
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
        }
    }

    // Clase Camino estática para poder ser usada en el main
    static class Camino {
        boolean caminoHasta(Nodo raiz, int objetivo, List<Integer> camino) {
            if (raiz == null) return false;
            camino.add(raiz.valor);
            if (raiz.valor == objetivo) return true;

            if (caminoHasta(raiz.izquierdo, objetivo, camino) || caminoHasta(raiz.derecho, objetivo, camino))
                return true;

            camino.remove(camino.size() - 1);
            return false;
        }

        public static void main(String[] args) {
            Nodo raiz = new Nodo(1);
            raiz.izquierdo = new Nodo(2);
            raiz.derecho = new Nodo(3);
            raiz.derecho.izquierdo = new Nodo(4);
            raiz.derecho.derecho = new Nodo(5);

            List<Integer> camino = new ArrayList<>();
            new Camino().caminoHasta(raiz, 4, camino);
            System.out.println("Camino a 4: " + camino);
        }
    }
}

