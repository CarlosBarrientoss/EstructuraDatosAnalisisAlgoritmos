package TallerArboles;

public class Ejercicio10 {
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    public class ArbolEspejo {

        // Recorrido postorden para convertir a espejo
        public static void convertirEnEspejo(Nodo nodo) {
            if (nodo == null) return;

            // Postorden: Izquierdo → Derecho → Nodo
            convertirEnEspejo(nodo.izquierdo);
            convertirEnEspejo(nodo.derecho);

            // Intercambiar hijos
            Nodo temp = nodo.izquierdo;
            nodo.izquierdo = nodo.derecho;
            nodo.derecho = temp;
        }

        // Inorden para mostrar el árbol
        public static void inorden(Nodo nodo) {
            if (nodo == null) return;

            inorden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecho);
        }

        public static void main(String[] args) {
            // Construcción del árbol
            Nodo raiz = new Nodo(9);
            raiz.izquierdo = new Nodo(6);
            raiz.izquierdo.izquierdo = new Nodo(3);
            raiz.izquierdo.derecho = new Nodo(7);
            raiz.derecho = new Nodo(12);
            raiz.derecho.derecho = new Nodo(15);

            convertirEnEspejo(raiz);

            System.out.print("Inorden del árbol espejo: ");
            inorden(raiz);  // Salida esperada: 15 12 9 7 6 3
        }
    }
}
