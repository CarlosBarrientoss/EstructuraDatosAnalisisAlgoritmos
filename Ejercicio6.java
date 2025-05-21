
public class Ejercicio6 {

    static class Nodo {
        char valor;
        Nodo izquierda, derecha;

        Nodo(char valor) {
            this.valor = valor;
            izquierda = derecha = null;
        }
    }

    public static int calcularAltura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }

        int alturaIzquierda = calcularAltura(nodo.izquierda);
        int alturaDerecha = calcularAltura(nodo.derecha);

        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    public static void main(String[] args) {
        Nodo raiz = new Nodo('M');
        raiz.izquierda = new Nodo('N');
        raiz.izquierda.izquierda = new Nodo('O');
        raiz.izquierda.derecha = new Nodo('P');
        raiz.izquierda.derecha.derecha = new Nodo('Q');

        int altura = calcularAltura(raiz);
        System.out.println("Altura = " + altura);
    }
}

