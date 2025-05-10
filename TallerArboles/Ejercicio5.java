package TallerArboles;

public class Ejercicio5 {
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    public class ContarHojas {

        // Método recursivo para contar hojas en Preorden
        public static int contarHojas(Nodo nodo) {
            if (nodo == null) return 0;

            // Si el nodo no tiene hijos, es una hoja
            if (nodo.izquierdo == null && nodo.derecho == null) {
                return 1;
            }

            // Preorden: Nodo -> Izquierdo -> Derecho
            int hojasIzquierda = contarHojas(nodo.izquierdo);
            int hojasDerecha = contarHojas(nodo.derecho);

            return hojasIzquierda + hojasDerecha;
        }

        public static void main(String[] args) {
            // Construcción del árbol
            Nodo raiz = new Nodo(7);
            raiz.izquierdo = new Nodo(4);
            raiz.izquierdo.izquierdo = new Nodo(2);
            raiz.derecho = new Nodo(9);
            raiz.derecho.izquierdo = new Nodo(8);
            raiz.derecho.derecho = new Nodo(11);

            int totalHojas = contarHojas(raiz);
            System.out.println("N.º de hojas = " + totalHojas);  // Salida esperada: 3
        }
    }
}
