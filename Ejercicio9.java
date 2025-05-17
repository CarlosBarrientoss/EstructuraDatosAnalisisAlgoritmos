class NodoCamino {
    int valor;
    NodoCamino izq, der;

    NodoCamino(int valor) {
        this.valor = valor;
        izq = der = null;
    }
}

public class Ejercicio9{

    static boolean imprimirCamino(NodoCamino nodo, int hoja) {
        if (nodo == null) return false;
        System.out.print(nodo.valor + " ");
        if (nodo.valor == hoja) return true;
        if (imprimirCamino(nodo.izq, hoja) || imprimirCamino(nodo.der, hoja)) return true;
        return false;
    }

    public static void main(String[] args) {
        NodoCamino raiz = new NodoCamino(1);
        raiz.izq = new NodoCamino(2);
        raiz.izq.izq = new NodoCamino(3);
        raiz.izq.izq.izq = new NodoCamino(4);
        raiz.izq.izq.izq.izq = new NodoCamino(5);

        System.out.print("Camino a 4: ");
        imprimirCamino(raiz, 4); // Salida esperada: 1 2 3 4
    }
}
