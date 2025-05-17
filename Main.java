import java.util.ArrayList;

/* ---------- Clase Nodo: nodo genérico para el árbol binario --------- */
class Nodo<V> {

    private V value;           // Valor almacenado en el nodo
    private Nodo<V> izq;       // Nodo hijo izquierdo
    private Nodo<V> der;       // Nodo hijo derecho

    // Constructor inicializando el valor y nodos hijo
    public Nodo(V value, Nodo<V> izq, Nodo<V> der) {
        super();
        this.value = value;
        this.izq = izq;
        this.der = der;
    }

    // Getter y setter para el valor
    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    // Getter y setter para hijo izquierdo
    public Nodo<V> getIzq() {
        return izq;
    }

    public void setIzq(Nodo<V> izq) {
        this.izq = izq;
    }

    // Getter y setter para hijo derecho
    public Nodo<V> getDer() {
        return der;
    }

    public void setDer(Nodo<V> der) {
        this.der = der;
    }
}

/* ---------- Clase ArbolBinarioBusqueda: implementación de ABB --------- */
class ArbolBinarioBusqueda {

    private Nodo<Integer> raiz = null;            // Raíz del árbol
    private int numeroElementos = 0;               // Conteo de elementos en el árbol
    private int numeroBusquedas = 0;                // Cantidad de búsquedas realizadas
    private int numeroIteracionesTotal = 0;         // Total de iteraciones en búsquedas
    private int numeroIteracionesUltimaBusqueda = 0;// Iteraciones en la última búsqueda

    // Constructor vacío
    public ArbolBinarioBusqueda() {
    }

    /* ------------------------------------------------------------
     * Método insertarElemento:
     * Inserta un valor en el ABB manteniendo la propiedad del árbol.
     * ------------------------------------------------------------ */
    public void insertarElemento(Integer value) {
        Nodo<Integer> nuevoNodo = new Nodo<>(value, null, null);

        if (raiz == null) {
            raiz = nuevoNodo;
            System.out.println("Inserto la raiz");
        } else {
            Nodo<Integer> aux = raiz;

            while (aux != null) {
                if (value > aux.getValue()) {
                    if (aux.getDer() == null) {
                        System.out.println(value + " Lo insertamos a la derecha de: " + aux.getValue());
                        aux.setDer(nuevoNodo);
                        aux = null;
                    } else {
                        aux = aux.getDer();
                    }
                } else {
                    if (aux.getIzq() == null) {
                        System.out.println(value + " Lo insertamos a la izquierda de: " + aux.getValue());
                        aux.setIzq(nuevoNodo);
                        aux = null;
                    } else {
                        aux = aux.getIzq();
                    }
                }
            }
        }

        numeroElementos++;
    }

    /* ------------------------------------------------------------
     * Método privado insertarNodo:
     * Inserta un nodo ya existente en el ABB, respetando el orden.
     * ------------------------------------------------------------ */
    private void insertarNodo(Nodo<Integer> nodo) {
        if (raiz == null) {
            raiz = nodo;
            System.out.println("Inserto la raiz");
        } else {
            Nodo<Integer> aux = raiz;

            while (aux != null) {
                if (nodo.getValue() > aux.getValue()) {
                    if (aux.getDer() == null) {
                        System.out.println(nodo.getValue() + " Lo insertamos a la derecha de: " + aux.getValue());
                        aux.setDer(nodo);
                        aux = null;
                    } else {
                        aux = aux.getDer();
                    }
                } else {
                    if (aux.getIzq() == null) {
                        System.out.println(nodo.getValue() + " Lo insertamos a la izquierda de: " + aux.getValue());
                        aux.setIzq(nodo);
                        aux = null;
                    } else {
                        aux = aux.getIzq();
                    }
                }
            }
        }
    }

    /* ------------------------------------------------------------
     * Método buscarElemento:
     * Busca un valor en el ABB y devuelve el valor si existe.
     * ------------------------------------------------------------ */
    public Integer buscarElemento(Integer value) {
        Nodo<Integer> aux = raiz;
        Nodo<Integer> resultado = null;
        numeroIteracionesUltimaBusqueda = 0;

        while (aux != null) {
            if (aux.getValue().equals(value)) {
                resultado = aux;
                aux = null;
            } else if (value > aux.getValue()) {
                aux = aux.getDer();
            } else {
                aux = aux.getIzq();
            }
            numeroIteracionesUltimaBusqueda++;
        }

        numeroIteracionesTotal += numeroIteracionesUltimaBusqueda;
        numeroBusquedas++;

        return (resultado != null) ? resultado.getValue() : null;
    }

    /* ------------------------------------------------------------
     * Método eliminarElemento:
     * Elimina un valor del ABB si existe y reordena el árbol.
     * ------------------------------------------------------------ */
    public boolean eliminarElemento(Integer value) {
        if (raiz == null) {
            return false; // Árbol vacío
        }

        // Caso especial: El nodo a eliminar es la raíz
        if (raiz.getValue().equals(value)) {
            Nodo<Integer> nodoAEliminar = raiz;

            if (raiz.getDer() != null) {
                raiz = raiz.getDer();
                if (nodoAEliminar.getIzq() != null) {
                    insertarNodo(nodoAEliminar.getIzq());
                }
            } else if (raiz.getIzq() != null) {
                raiz = raiz.getIzq();
                if (nodoAEliminar.getDer() != null) {
                    insertarNodo(nodoAEliminar.getDer());
                }
            } else {
                raiz = null;
            }

            numeroElementos--;
            return true;
        }

        // Búsqueda del nodo a eliminar y su padre
        Nodo<Integer> padre = null;
        Nodo<Integer> actual = raiz;

        while (actual != null && !actual.getValue().equals(value)) {
            padre = actual;
            if (value > actual.getValue()) {
                actual = actual.getDer();
            } else {
                actual = actual.getIzq();
            }
        }

        if (actual == null) {
            return false; // No encontrado el nodo
        }

        // Nodo a eliminar es hijo izquierdo del padre
        if (padre.getIzq() != null && padre.getIzq().getValue().equals(value)) {
            if (actual.getIzq() != null) {
                padre.setIzq(actual.getIzq());
                if (actual.getDer() != null) {
                    insertarNodo(actual.getDer());
                }
            } else if (actual.getDer() != null) {
                padre.setIzq(actual.getDer());
            } else {
                padre.setIzq(null);
            }
        }
        // Nodo a eliminar es hijo derecho del padre
        else if (padre.getDer() != null && padre.getDer().getValue().equals(value)) {
            if (actual.getDer() != null) {
                padre.setDer(actual.getDer());
                if (actual.getIzq() != null) {
                    insertarNodo(actual.getIzq());
                }
            } else if (actual.getIzq() != null) {
                padre.setDer(actual.getIzq());
            } else {
                padre.setDer(null);
            }
        }

        numeroElementos--;
        return true;
    }

    public int size() {
        return this.numeroElementos;
    }

    public int getNumeroIteracionesUltimaBusqueda() {
        return this.numeroIteracionesUltimaBusqueda;
    }

    public int getNumeroIteracionesMedioEnBusquedas() {
        if (numeroBusquedas == 0) {
            return 0;
        }
        return (int) Math.ceil(numeroIteracionesTotal / (double) numeroBusquedas);
    }

    public ArrayList<Integer> obtenerElementosOrdenadosAscendentemente() {
        ArrayList<Integer> elementosOrdenados = new ArrayList<>();
        recorrerAscendente(raiz, elementosOrdenados);
        return elementosOrdenados;
    }

    private void recorrerAscendente(Nodo<Integer> nodo, ArrayList<Integer> elementos) {
        if (nodo != null) {
            recorrerAscendente(nodo.getIzq(), elementos);
            elementos.add(nodo.getValue());
            recorrerAscendente(nodo.getDer(), elementos);
        }
    }

    public ArrayList<Integer> obtenerElementosOrdenadosDescendentemente() {
        ArrayList<Integer> elementosOrdenados = new ArrayList<>();
        recorrerDescendente(raiz, elementosOrdenados);
        return elementosOrdenados;
    }

    private void recorrerDescendente(Nodo<Integer> nodo, ArrayList<Integer> elementos) {
        if (nodo != null) {
            recorrerDescendente(nodo.getDer(), elementos);
            elementos.add(nodo.getValue());
            recorrerDescendente(nodo.getIzq(), elementos);
        }
    }
}

/* ---------- Clase Main para prueba y demostración --------- */
public class Main {
    public static void main(String[] args) {
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        // Insertar elementos
        arbol.insertarElemento(50);
        arbol.insertarElemento(30);
        arbol.insertarElemento(70);
        arbol.insertarElemento(20);
        arbol.insertarElemento(40);
        arbol.insertarElemento(60);
        arbol.insertarElemento(80);

        System.out.println("\nElementos ordenados ascendentemente:");
        System.out.println(arbol.obtenerElementosOrdenadosAscendentemente());

        System.out.println("\nElementos ordenados descendentemente:");
        System.out.println(arbol.obtenerElementosOrdenadosDescendentemente());

        // Buscar elementos
        int buscar = 40;
        Integer encontrado = arbol.buscarElemento(buscar);
        if (encontrado != null) {
            System.out.println("\nElemento " + buscar + " encontrado en el árbol.");
        } else {
            System.out.println("\nElemento " + buscar + " NO encontrado en el árbol.");
        }

        // Eliminar elemento
        int eliminar = 70;
        boolean eliminado = arbol.eliminarElemento(eliminar);
        System.out.println("\nElemento " + eliminar + (eliminado ? " eliminado del árbol." : " no encontrado."));

        System.out.println("\nElementos ordenados ascendentemente después de eliminación:");
        System.out.println(arbol.obtenerElementosOrdenadosAscendentemente());

        System.out.println("\nTamaño actual del árbol:");
        System.out.println(arbol.size());

        System.out.println("\nNúmero de iteraciones en última búsqueda:");
        System.out.println(arbol.getNumeroIteracionesUltimaBusqueda());

        System.out.println("\nPromedio de iteraciones en búsquedas:");
        System.out.println(arbol.getNumeroIteracionesMedioEnBusquedas());
    }
}

