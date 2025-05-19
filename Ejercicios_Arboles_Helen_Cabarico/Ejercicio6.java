
package ejercicio6;

public class Ejercicio6 {

    // Clase Nodo del Árbol
    static class Nodo {
        char valor;
        Nodo izquierdo, derecho;

        Nodo(char valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    // Método para calcular la altura del árbol con recorrido postorden
    public static int altura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }

        int alturaIzquierda = altura(nodo.izquierdo);
        int alturaDerecha = altura(nodo.derecho);

        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    public static void main(String[] args) {
        // Árbol:
        //     M
        //    /
        //   N
        //  / \
        // O   P
        //        \
        //         Q

        Nodo raiz = new Nodo('M');
        raiz.izquierdo = new Nodo('N');
        raiz.izquierdo.izquierdo = new Nodo('O');
        raiz.izquierdo.derecho = new Nodo('P');
        raiz.izquierdo.derecho.derecho = new Nodo('Q');

        int alturaArbol = altura(raiz);
        System.out.println("Altura = " + alturaArbol);
    }
}

