class Nodo {
    int valor;
    Nodo izquierdo, derecho;

    Nodo(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

public class ContarHojasPreorden {

    public static int contarHojas(Nodo nodo) {
        if (nodo == null)
            return 0;

        if (nodo.izquierdo == null && nodo.derecho == null) {
            System.out.println("Hoja encontrada: " + nodo.valor);
            return 1;
        }

        return contarHojas(nodo.izquierdo) + contarHojas(nodo.derecho);
    }

    public static void main(String[] args) {
 
        Nodo raiz = new Nodo(7);
        raiz.izquierdo = new Nodo(4);
        raiz.derecho = new Nodo(9);
        raiz.izquierdo.izquierdo = new Nodo(2);
        raiz.derecho.izquierdo = new Nodo(8);
        raiz.derecho.derecho = new Nodo(11);

        int totalHojas = contarHojas(raiz);
        System.out.println("N.º de hojas = " + totalHojas); 
    }
}
