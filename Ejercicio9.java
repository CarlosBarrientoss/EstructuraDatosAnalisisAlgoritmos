import java.util.ArrayList;
import java.util.List;

public class Ejercicio9 {

static class Nodo {
    int valor;
    Nodo izquierdo, derecho;

    public Nodo(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

static public class CaminoArbol {

    public static boolean buscarCamino(Nodo raiz, int objetivo, List<Integer> camino) {
        if (raiz == null) {
            return false;
        }
        camino.add(raiz.valor);

        if (raiz.valor == objetivo) {
            return true;
        }

        if (buscarCamino(raiz.izquierdo, objetivo, camino) || buscarCamino(raiz.derecho, objetivo, camino)) {
            return true;
        }

        camino.remove(camino.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        
        Nodo raiz = new Nodo(1);
        raiz.izquierdo = new Nodo(2);
        raiz.derecho = new Nodo(3);
        raiz.derecho.izquierdo = new Nodo(4);
        raiz.derecho.derecho = new Nodo(5);

        List<Integer> camino = new ArrayList<>();

        int objetivo = 4;
        if (buscarCamino(raiz, objetivo, camino)) {
            System.out.print("Camino a " + objetivo + ": ");
            for (int val : camino) {
                System.out.print(val + " ");
            }
        } else {
            System.out.println("Nodo no encontrado en el árbol.");
        }
    }
}

}
