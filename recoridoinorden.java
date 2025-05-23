//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Nodo {
    int valor;
    Nodo izquierda, derecha;

    public Nodo(int valor) {
        this.valor = valor;
        izquierda = derecha = null;
    }
}

public class RecorridoInorden {

    public static void inorden(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        inorden(nodo.izquierda);
        System.out.print(nodo.valor + " ");
        inorden(nodo.derecha);
    }

    public static void main(String[] args) {
        Nodo raiz = new Nodo(8);
        raiz.izquierda = new Nodo(3);
        raiz.derecha = new Nodo(10);
        raiz.izquierda.derecha = new Nodo(6);
        raiz.derecha.derecha = new Nodo(14);

        inorden(raiz); // Salida esperada: 3 6 8 10 14
    }
}