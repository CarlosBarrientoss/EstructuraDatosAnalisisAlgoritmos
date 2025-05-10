package TallerArboles;

public class Ejercicio7 {
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    public class SumaNodosInorden {

        public static int sumaInorden(Nodo nodo) {
            if (nodo == null) return 0;

            // Inorden: Izquierdo -> Nodo -> Derecho
            int sumaIzquierda = sumaInorden(nodo.izquierdo);
            int sumaActual = nodo.valor;
            int sumaDerecha = sumaInorden(nodo.derecho);

            return sumaIzquierda + sumaActual + sumaDerecha;
        }

        public static void main(String[] args) {
            // Construcción del árbol
            Nodo raiz = new Nodo(5);
            raiz.izquierdo = new Nodo(3);
            raiz.izquierdo.izquierdo = new Nodo(1);
            raiz.izquierdo.derecho = new Nodo(4);
            raiz.derecho = new Nodo(7);
            raiz.derecho.derecho = new Nodo(9);

            int sumaTotal = sumaInorden(raiz);
            System.out.println("Suma total = " + sumaTotal);  // Salida esperada: 29
        }
    }
}
