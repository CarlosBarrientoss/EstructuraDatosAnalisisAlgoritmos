package arboles;

/**
 *
 * @author duvan
 */
public class Altura {

    // Clase Nodo estática, adaptada para trabajar con char
    static class Nodo {
        char valor;
        Nodo izquierdo, derecho;

        Nodo(char valor) {
            this.valor = valor;
        }
    }

    // Clase AlturaArbol estática para poder ser usada en el main
    static class AlturaArbol {
        int altura(Nodo raiz) {
            if (raiz == null) return 0;
            int izq = altura(raiz.izquierdo);
            int der = altura(raiz.derecho);
            return Math.max(izq, der) + 1;
        }

        public static void main(String[] args) {
            Nodo raiz = new Nodo('M');
            raiz.izquierdo = new Nodo('N');
            raiz.izquierdo.izquierdo = new Nodo('O');
            raiz.izquierdo.derecho = new Nodo('P');
            raiz.izquierdo.derecho.derecho = new Nodo('Q');

            System.out.println("Altura = " + new AlturaArbol().altura(raiz));
        }
    }
}

