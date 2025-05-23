/*ejercicio 6*/
class NodoChar {
    char valor;
    NodoChar izquierdo, derecho;

    NodoChar(char valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

public class AlturaPostorden {

    public static int calcularAltura(NodoChar nodo) {
        if (nodo == null)
            return 0;

        int alturaIzq = calcularAltura(nodo.izquierdo);
        int alturaDer = calcularAltura(nodo.derecho);

        return Math.max(alturaIzq, alturaDer) + 1;
    }

    public static void main(String[] args) {
        /*
            Árbol:
                   M
                  /
                 N
                / \
               O   P
                     \
                      Q
        */

        NodoChar raiz = new NodoChar('M');
        raiz.izquierdo = new NodoChar('N');
        raiz.izquierdo.izquierdo = new NodoChar('O');
        raiz.izquierdo.derecho = new NodoChar('P');
        raiz.izquierdo.derecho.derecho = new NodoChar('Q');

        int altura = calcularAltura(raiz);
        System.out.println("Altura = " + altura);  // Salida esperada: 4
    }
}
