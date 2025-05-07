
package arboles;

/**
 *
 * @author duvan
 */
public class Busqueda {

    // Clase Nodo estática
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
        }
    }

    // Clase Buscar estática para poder usarla en el main
    static class Buscar {
        boolean buscar(Nodo raiz, int key) {
            if (raiz == null) return false;
            if (raiz.valor == key) return true;
            return buscar(raiz.izquierdo, key) || buscar(raiz.derecho, key);
        }

        public static void main(String[] args) {
            Nodo raiz = new Nodo(20);
            raiz.izquierdo = new Nodo(10);
            raiz.derecho = new Nodo(30);
            raiz.izquierdo.izquierdo = new Nodo(5);
            raiz.izquierdo.derecho = new Nodo(15);

            // Instanciamos Buscar como una clase estática para poder usarla directamente en el main
            Buscar b = new Buscar();
            System.out.println("Encontrado para key=15: " + b.buscar(raiz, 15));
            System.out.println("Encontrado para key=25: " + b.buscar(raiz, 25));
        }
    }
}

