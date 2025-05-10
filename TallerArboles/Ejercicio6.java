package TallerArboles;

public class Ejercicio6 {
    static class Nodo {
        char valor;
        Nodo izquierdo, derecho;

        Nodo(char valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    public class AlturaArbol {

        public static int calcularAltura(Nodo nodo) {
            if (nodo == null) return 0;

            // Postorden: Izquierdo -> Derecho -> Nodo
            int alturaIzquierda = calcularAltura(nodo.izquierdo);
            int alturaDerecha = calcularAltura(nodo.derecho);

            return 1 + Math.max(alturaIzquierda, alturaDerecha);
        }

        public static void main(String[] args) {
            // Construcción del árbol
            Nodo raiz = new Nodo('M');
            raiz.izquierdo = new Nodo('N');
            raiz.izquierdo.izquierdo = new Nodo('O');
            raiz.izquierdo.derecho = new Nodo('P');
            raiz.izquierdo.derecho.derecho = new Nodo('Q');

            int altura = calcularAltura(raiz);
            System.out.println("Altura = " + altura);  // Salida esperada: 4
        }
    }
}
