package arboles;

/**
 *
 * @author duvan
 */
public class Posorden {

    // Clase NodoChar estática
    static class NodoChar {
        char valor;
        NodoChar izquierdo, derecho;

        NodoChar(char valor) {
            this.valor = valor;
        }
    }

    // Clase Postorden estática para poder ser usada en el main
    static class Postorden {
        void recorrer(NodoChar raiz) {
            if (raiz != null) {
                recorrer(raiz.izquierdo);
                recorrer(raiz.derecho);
                System.out.print(raiz.valor + " ");
            }
        }
    }

    public static void main(String[] args) {
        NodoChar raiz = new NodoChar('A');
        raiz.izquierdo = new NodoChar('B');
        raiz.derecho = new NodoChar('C');
        raiz.izquierdo.izquierdo = new NodoChar('D');
        raiz.derecho.izquierdo = new NodoChar('E');
        raiz.derecho.derecho = new NodoChar('F');

        Postorden p = new Postorden();
        p.recorrer(raiz);
    }
}

