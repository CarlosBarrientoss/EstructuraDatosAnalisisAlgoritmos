
package arboles;

/**
 *
 * @author duvan
 */
public class RecorridoInorden {

    // Clase Nodo estática y accesible
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    // Clase Inorden como estática para poder usarla en el main
    static class Inorden {
        void recorrer(Nodo raiz) {
            if (raiz != null) {
                recorrer(raiz.izquierdo);
                System.out.print(raiz.valor + " ");
                recorrer(raiz.derecho);
            }
        }
    }

    public static void main(String[] args) {
        Nodo raiz = new Nodo(8);
        raiz.izquierdo = new Nodo(3);
        raiz.izquierdo.derecho = new Nodo(6);
        raiz.derecho = new Nodo(10);
        raiz.derecho.derecho = new Nodo(14);

        Inorden in = new Inorden();
        in.recorrer(raiz);
    }
}

