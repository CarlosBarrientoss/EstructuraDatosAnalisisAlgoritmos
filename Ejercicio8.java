
public class Ejercicio8 {
    static class Nodo {
    int valor;
    Nodo izquierdo, derecho;

    public Nodo(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

static public class ArbolBusquedaPreorden {

    Nodo raiz;

    public ArbolBusquedaPreorden() {
        raiz = null;
    }

    public boolean buscarPreorden(Nodo nodo, int key) {
        if (nodo == null) {
            return false;
        }
        if (nodo.valor == key) {
            return true;
        }
        if (buscarPreorden(nodo.izquierdo, key)) {
            return true;
        }
        return buscarPreorden(nodo.derecho, key);
    }

    public static void main(String[] args) {
        ArbolBusquedaPreorden arbol = new ArbolBusquedaPreorden();

        arbol.raiz = new Nodo(20);
        arbol.raiz.izquierdo = new Nodo(10);
        arbol.raiz.derecho = new Nodo(30);
        arbol.raiz.izquierdo.izquierdo = new Nodo(5);
        arbol.raiz.izquierdo.derecho = new Nodo(15);

        int[] keys = {15, 25};
        for (int key : keys) {
            if (arbol.buscarPreorden(arbol.raiz, key)) {
                System.out.println("Encontrado para key=" + key);
            } else {
                System.out.println("No encontrado para key=" + key);
            }
        }
    }
}

}
