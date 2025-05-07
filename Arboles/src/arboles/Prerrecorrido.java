
package arboles;

/**
 *
 * @author duvan
 */
public class Prerrecorrido {

    
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    // Clase interna con método main para Preorden
    public static class Preorden {
        void recorrer(Nodo raiz) {
            if (raiz != null) {
                System.out.print(raiz.valor + " ");
                recorrer(raiz.izquierdo);
                recorrer(raiz.derecho);
            }
        }

        public static void main(String[] args) {
            Nodo raiz = new Nodo(10);
            raiz.izquierdo = new Nodo(5);
            raiz.derecho = new Nodo(15);
            raiz.izquierdo.izquierdo = new Nodo(2);
            raiz.izquierdo.derecho = new Nodo(7);
            raiz.derecho.izquierdo = new Nodo(12);
            raiz.derecho.derecho = new Nodo(20);

            new Preorden().recorrer(raiz);
        }
    }
}

