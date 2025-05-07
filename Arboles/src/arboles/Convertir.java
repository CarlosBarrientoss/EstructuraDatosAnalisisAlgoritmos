package arboles;

/**
 *
 * @author duvan
 */
public class Convertir {

    // Clase Nodo estática
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
        }
    }

    // Clase Espejo estática
    static class Espejo {

        // Método para convertir el árbol en su espejo
        Nodo convertir(Nodo raiz) {
            if (raiz == null) return null;
            Nodo izq = convertir(raiz.izquierdo);
            Nodo der = convertir(raiz.derecho);
            raiz.izquierdo = der;
            raiz.derecho = izq;
            return raiz;
        }

        // Recorrido en inorden para imprimir el árbol
        void inorden(Nodo raiz) {
            if (raiz != null) {
                inorden(raiz.izquierdo);
                System.out.print(raiz.valor + " ");
                inorden(raiz.derecho);
            }
        }

        public static void main(String[] args) {
            // Crear árbol original
            Nodo raiz = new Nodo(9);
            raiz.izquierdo = new Nodo(6);
            raiz.derecho = new Nodo(12);
            raiz.izquierdo.izquierdo = new Nodo(3);
            raiz.izquierdo.derecho = new Nodo(7);
            raiz.derecho.derecho = new Nodo(15);

            // Convertir a espejo
            Espejo e = new Espejo();
            e.convertir(raiz);

            // Imprimir el árbol espejado en inorden
            e.inorden(raiz);  // Salida espejada esperada
        }
    }
}

