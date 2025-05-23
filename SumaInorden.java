/*ejercicio 7*/
class Nodo {
    int valor;
    Nodo izquierdo, derecho;

    Nodo(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

public class SumaInorden {

    public static int sumaInorden(Nodo nodo) {
        if (nodo == null)
            return 0;

        // Suma izquierda + nodo actual + derecha (inorden)
        return sumaInorden(nodo.izquierdo) + nodo.valor + sumaInorden(nodo.derecho);
    }

    public static void main(String[] args) {
        /*
            Árbol:
                   5
                 /   \
                3     7
               / \     \
              1   4     9
        */

        Nodo raiz = new Nodo(5);
        raiz.izquierdo = new Nodo(3);
        raiz.derecho = new Nodo(7);
        raiz.izquierdo.izquierdo = new Nodo(1);
        raiz.izquierdo.derecho = new Nodo(4);
        raiz.derecho.derecho = new Nodo(9);

        int suma = sumaInorden(raiz);
        System.out.println("Suma total = " + suma);  // Salida esperada: 29
    }
}
