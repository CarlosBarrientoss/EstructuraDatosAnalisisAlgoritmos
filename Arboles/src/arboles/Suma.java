package arboles;

/**
 *
 * @author duvan
 */
public class Suma {

    // Clase Nodo estática
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
        }
    }

    // Clase SumaNodos estática para poder usarla en el main
    static class SumaNodos {
        int suma(Nodo raiz) {
            if (raiz == null) return 0;
            return suma(raiz.izquierdo) + raiz.valor + suma(raiz.derecho);
        }

        public static void main(String[] args) {
            Nodo raiz = new Nodo(5);
            raiz.izquierdo = new Nodo(3);
            raiz.derecho = new Nodo(7);
            raiz.izquierdo.izquierdo = new Nodo(1);
            raiz.izquierdo.derecho = new Nodo(4);
            raiz.derecho.derecho = new Nodo(9);

            System.out.println("Suma total = " + new SumaNodos().suma(raiz));
        }
    }
}

