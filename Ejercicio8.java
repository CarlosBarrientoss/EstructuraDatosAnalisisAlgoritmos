class NodoBusqueda {
    int valor;
    NodoBusqueda izq, der;

    NodoBusqueda(int valor) {
        this.valor = valor;
        izq = der = null;
    }
}

public class Ejercicio8{

    static boolean buscarPreorden(NodoBusqueda nodo, int key) {
        if (nodo == null) return false;
        if (nodo.valor == key) return true;
        return buscarPreorden(nodo.izq, key) || buscarPreorden(nodo.der, key);
    }

    public static void main(String[] args) {
        NodoBusqueda raiz = new NodoBusqueda(20);
        raiz.izq = new NodoBusqueda(10);
        raiz.der = new NodoBusqueda(30);
        raiz.izq.izq = new NodoBusqueda(5);
        raiz.izq.der = new NodoBusqueda(15);

        boolean encontrado15 = buscarPreorden(raiz, 15);
        boolean encontrado25 = buscarPreorden(raiz, 25);

        System.out.println("Encontrado para key=15: " + encontrado15); // true
        System.out.println("Encontrado para key=25: " + encontrado25); // false
    }
}
