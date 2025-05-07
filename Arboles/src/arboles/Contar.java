
package arboles;

/**
 *
 * @author duvan
 */
public class Contar {

    // Clase Nodo estática
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
        }
    }

    // Clase ContarHojas estática para poder usarla en el main
    static class ContarHojas {
        int contar(Nodo raiz) {
            if (raiz == null) return 0;
            if (raiz.izquierdo == null && raiz.derecho == null) return 1;
            return contar(raiz.izquierdo) + contar(raiz.derecho);
        }

        public static void main(String[] args) {
            Nodo raiz = new Nodo(7);
            raiz.izquierdo = new Nodo(4);
            raiz.derecho = new Nodo(9);
            raiz.izquierdo.izquierdo = new Nodo(2);
            raiz.derecho.izquierdo = new Nodo(8);
            raiz.derecho.derecho = new Nodo(11);

            System.out.println("N.º de hojas = " + new ContarHojas().contar(raiz));
        }
    }
}

