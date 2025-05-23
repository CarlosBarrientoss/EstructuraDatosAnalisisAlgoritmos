class Nodo {
char valor;
        Nodo izquierda, derecha;

public Nodo(char valor) {
    this.valor = valor;
    izquierda = derecha = null;
}
}

public class RecorridoPostorden {

    public static void postorden(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        postorden(nodo.izquierda);
        postorden(nodo.derecha);
        System.out.print(nodo.valor + " ");
    }

    public static void main(String[] args) {
        Nodo raiz = new Nodo('A');
        raiz.izquierda = new Nodo('B');
        raiz.derecha = new Nodo('C');
        raiz.izquierda.izquierda = new Nodo('D');
        raiz.derecha.izquierda = new Nodo('E');
        raiz.derecha.derecha = new Nodo('F');

        postorden(raiz); // Salida esperada: D B E F C A
    }
}