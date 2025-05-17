import java.util.ArrayList;

/********************************************
 * Clase NodoABB Genérica (antes Nodo)
 ********************************************/
class NodoABB<V> {
    private V value;
    private NodoABB<V> izq;
    private NodoABB<V> der;

    public NodoABB(V value, NodoABB<V> izq, NodoABB<V> der) {
        this.value = value;
        this.izq = izq;
        this.der = der;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public NodoABB<V> getIzq() {
        return izq;
    }

    public void setIzq(NodoABB<V> izq) {
        this.izq = izq;
    }

    public NodoABB<V> getDer() {
        return der;
    }

    public void setDer(NodoABB<V> der) {
        this.der = der;
    }
}

/********************************************
 * Clase ArbolBinarioBusqueda con Integer
 ********************************************/
class ArbolBinarioBusqueda {
    NodoABB<Integer> raiz = null;
    private int numeroElementos = 0;
    private int numeroBusquedas = 0;
    private int numeroIteracionesTotal = 0;
    private int numeroIteracionesUltimaBusqueda = 0;

    public ArbolBinarioBusqueda() {}

    // Inserta un nuevo valor en el árbol
    public void insertarElemento(Integer value) {
        NodoABB<Integer> nuevoNodo = new NodoABB<>(value, null, null);

        if (raiz == null) {
            raiz = nuevoNodo;
            System.out.println("Inserto la raiz");
        } else {
            NodoABB<Integer> aux = raiz;
            while (aux != null) {
                if (value > aux.getValue()) {
                    if (aux.getDer() == null) {
                        aux.setDer(nuevoNodo);
                        System.out.println(value + " Lo insertamos a la derecha de: " + aux.getValue());
                        aux = null;
                    } else {
                        aux = aux.getDer();
                    }
                } else {
                    if (aux.getIzq() == null) {
                        aux.setIzq(nuevoNodo);
                        System.out.println(value + " Lo insertamos a la izquierda de: " + aux.getValue());
                        aux = null;
                    } else {
                        aux = aux.getIzq();
                    }
                }
            }
        }
        numeroElementos++;
    }

    // Busca un valor en el árbol y devuelve el valor si existe
    public Integer buscarElemento(Integer value) {
        NodoABB<Integer> aux = raiz;
        NodoABB<Integer> resultado = null;
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

        return resultado != null ? resultado.getValue() : null;
    }

    // Elimina un elemento del árbol
    public boolean eliminarElemento(Integer value) {
        boolean resultado = false;
        NodoABB<Integer> aux = raiz;
        NodoABB<Integer> padre = null;
        boolean esIzq = false;

        while (aux != null && !aux.getValue().equals(value)) {
            padre = aux;
            if (value.compareTo(aux.getValue()) < 0) {
                aux = aux.getIzq();
                esIzq = true;
            } else {
                aux = aux.getDer();
                esIzq = false;
            }
        }

        if (aux == null) {
            return false; // No encontrado
        }

        // Caso 1: Nodo hoja
        if (aux.getIzq() == null && aux.getDer() == null) {
            if (aux == raiz) {
                raiz = null;
            } else if (esIzq) {
                padre.setIzq(null);
            } else {
                padre.setDer(null);
            }
        }
        // Caso 2: Nodo con un hijo izquierdo
        else if (aux.getDer() == null) {
            if (aux == raiz) {
                raiz = aux.getIzq();
            } else if (esIzq) {
                padre.setIzq(aux.getIzq());
            } else {
                padre.setDer(aux.getIzq());
            }
        }
        // Caso 3: Nodo con un hijo derecho
        else if (aux.getIzq() == null) {
            if (aux == raiz) {
                raiz = aux.getDer();
            } else if (esIzq) {
                padre.setIzq(aux.getDer());
            } else {
                padre.setDer(aux.getDer());
            }
        }
        // Caso 4: Nodo con dos hijos
        else {
            NodoABB<Integer> sucesor = obtenerSucesor(aux);
            if (aux == raiz) {
                raiz = sucesor;
            } else if (esIzq) {
                padre.setIzq(sucesor);
            } else {
                padre.setDer(sucesor);
            }
            sucesor.setIzq(aux.getIzq());
        }
        numeroElementos--;
        resultado = true;
        return resultado;
    }

    // Método auxiliar para obtener sucesor de un nodo (el mínimo de la subrama derecha)
    private NodoABB<Integer> obtenerSucesor(NodoABB<Integer> nodo) {
        NodoABB<Integer> padreSucesor = nodo;
        NodoABB<Integer> sucesor = nodo;
        NodoABB<Integer> aux = nodo.getDer();

        while (aux != null) {
            padreSucesor = sucesor;
            sucesor = aux;
            aux = aux.getIzq();
        }

        if (sucesor != nodo.getDer()) {
            padreSucesor.setIzq(sucesor.getDer());
            sucesor.setDer(nodo.getDer());
        }
        return sucesor;
    }

    // Devuelve el tamaño del árbol
    public int size() {
        return this.numeroElementos;
    }

    // Devuelve el número de iteraciones promedio en búsquedas
    public int getNumeroIteracionesMedioEnBusquedas() {
        return (int) Math.ceil(numeroIteracionesTotal / (double) this.numeroBusquedas);
    }

    // Devuelve las iteraciones en la última búsqueda
    public int getNumeroIteracionesUltimaBusqueda() {
        return this.numeroIteracionesUltimaBusqueda;
    }

    // Devuelve la lista ordenada ascendentemente
    public ArrayList<Integer> obtenerElementosOrdenadosAscendentemente() {
        ArrayList<Integer> elementos = new ArrayList<>();
        recorrerAscendente(raiz, elementos);
        return elementos;
    }

    private void recorrerAscendente(NodoABB<Integer> nodo, ArrayList<Integer> elementos) {
        if (nodo != null) {
            recorrerAscendente(nodo.getIzq(), elementos);
            elementos.add(nodo.getValue());
            recorrerAscendente(nodo.getDer(), elementos);
        }
    }

    // Devuelve la lista ordenada descendentemente
    public ArrayList<Integer> obtenerElementosOrdenadosDescendentemente() {
        ArrayList<Integer> elementos = new ArrayList<>();
        recorrerDescendente(raiz, elementos);
        return elementos;
    }

    private void recorrerDescendente(NodoABB<Integer> nodo, ArrayList<Integer> elementos) {
        if (nodo != null) {
            recorrerDescendente(nodo.getDer(), elementos);
            elementos.add(nodo.getValue());
            recorrerDescendente(nodo.getIzq(), elementos);
        }
    }
}


/********************************************
 * Clase Abstracta Comparable Genérica
 ********************************************/
abstract class ComparableGeneric<V> {
    abstract int compare(V elementoAComparar);
}

/********************************************
 * Clase NodoGenerico Genérica
 ********************************************/
class NodoGenerico<V> {
    private V value;
    private NodoGenerico<V> izq;
    private NodoGenerico<V> der;

    public NodoGenerico(V value, NodoGenerico<V> izq, NodoGenerico<V> der) {
        this.value = value;
        this.izq = izq;
        this.der = der;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public NodoGenerico<V> getIzq() {
        return izq;
    }

    public void setIzq(NodoGenerico<V> izq) {
        this.izq = izq;
    }

    public NodoGenerico<V> getDer() {
        return der;
    }

    public void setDer(NodoGenerico<V> der) {
        this.der = der;
    }
}

/********************************************
 * Clase Producto que implementa Comparable<Producto>
 ********************************************/
class Producto implements Comparable<Producto> {
    private int id;
    private String nombre;

    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object p2) {
        if (!(p2 instanceof Producto)) return false;
        Producto producto2 = (Producto) p2;
        return this.getId() == producto2.getId();
    }

    @Override
    public int compareTo(Producto otro) {
        return Integer.compare(this.id, otro.getId());
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + "]";
    }
}

/********************************************
 * Clase ArbolBinarioBusquedaGenerico Genérica
 ********************************************/
class ArbolBinarioBusquedaGenerico<V extends Comparable<V>> {
    NodoGenerico<V> raiz = null;
    private int numeroElementos = 0;
    private int numeroBusquedas = 0;
    private int numeroIteracionesTotal = 0;
    private int numeroIteracionesUltimaBusqueda = 0;

    public ArbolBinarioBusquedaGenerico() {}

    // Inserta elemento genérico que implementa Comparable
    public void insertarElemento(V value) {
        NodoGenerico<V> nuevoNodo = new NodoGenerico<>(value, null, null);

        if (raiz == null) {
            raiz = nuevoNodo;
            System.out.println("Inserto la raiz");
        } else {
            NodoGenerico<V> aux = raiz;

            while (aux != null) {
                if (value.compareTo(aux.getValue()) > 0) {
                    if (aux.getDer() == null) {
                        aux.setDer(nuevoNodo);
                        System.out.println(value + " Lo insertamos a la derecha de: " + aux.getValue());
                        aux = null;
                    } else {
                        aux = aux.getDer();
                    }
                } else {
                    if (aux.getIzq() == null) {
                        aux.setIzq(nuevoNodo);
                        System.out.println(value + " Lo insertamos a la izquierda de: " + aux.getValue());
                        aux = null;
                    } else {
                        aux = aux.getIzq();
                    }
                }
            }
        }
        numeroElementos++;
    }

    // Busca elemento genérico
    public V buscarElemento(V value) {
        NodoGenerico<V> aux = raiz;
        NodoGenerico<V> resultado = null;
        numeroIteracionesUltimaBusqueda = 0;

        while (aux != null) {
            int comparacion = value.compareTo(aux.getValue());
            if (comparacion == 0) {
                resultado = aux;
                aux = null;
            } else if (comparacion > 0) {
                aux = aux.getDer();
            } else {
                aux = aux.getIzq();
            }
            numeroIteracionesUltimaBusqueda++;
        }

        numeroIteracionesTotal += numeroIteracionesUltimaBusqueda;
        numeroBusquedas++;

        return resultado != null ? resultado.getValue() : null;
    }

    // Elimina elemento genérico
    public boolean eliminarElemento(V value) {
        boolean resultado = false;
        NodoGenerico<V> aux = raiz;
        NodoGenerico<V> padre = null;
        boolean esIzq = false;

        while (aux != null && aux.getValue().compareTo(value) != 0) {
            padre = aux;
            if (value.compareTo(aux.getValue()) < 0) {
                aux = aux.getIzq();
                esIzq = true;
            } else {
                aux = aux.getDer();
                esIzq = false;
            }
        }

        if (aux == null) return false; // No encontrado

        // Caso 1: Nodo hoja
        if (aux.getIzq() == null && aux.getDer() == null) {
            if (aux == raiz) {
                raiz = null;
            } else if (esIzq) {
                padre.setIzq(null);
            } else {
                padre.setDer(null);
            }
        }
        // Caso 2: Nodo con hijo izquierdo
        else if (aux.getDer() == null) {
            if (aux == raiz) {
                raiz = aux.getIzq();
            } else if (esIzq) {
                padre.setIzq(aux.getIzq());
            } else {
                padre.setDer(aux.getIzq());
            }
        }
        // Caso 3: Nodo con hijo derecho
        else if (aux.getIzq() == null) {
            if (aux == raiz) {
                raiz = aux.getDer();
            } else if (esIzq) {
                padre.setIzq(aux.getDer());
            } else {
                padre.setDer(aux.getDer());
            }
        }
        // Caso 4: Nodo con dos hijos
        else {
            NodoGenerico<V> sucesor = obtenerSucesor(aux);
            if (aux == raiz) {
                raiz = sucesor;
            } else if (esIzq) {
                padre.setIzq(sucesor);
            } else {
                padre.setDer(sucesor);
            }
            sucesor.setIzq(aux.getIzq());
        }
        numeroElementos--;
        resultado = true;
        return resultado;
    }

    // Obtiene sucesor en el árbol genérico
    private NodoGenerico<V> obtenerSucesor(NodoGenerico<V> nodo) {
        NodoGenerico<V> padreSucesor = nodo;
        NodoGenerico<V> sucesor = nodo;
        NodoGenerico<V> aux = nodo.getDer();

        while (aux != null) {
            padreSucesor = sucesor;
            sucesor = aux;
            aux = aux.getIzq();
        }

        if (sucesor != nodo.getDer()) {
            padreSucesor.setIzq(sucesor.getDer());
            sucesor.setDer(nodo.getDer());
        }
        return sucesor;
    }

    public int size() {
        return this.numeroElementos;
    }

    public int getNumeroIteracionesMedioEnBusquedas() {
        if (numeroBusquedas == 0) return 0;
        return (int) Math.ceil(numeroIteracionesTotal / (double) numeroBusquedas);
    }

    public int getNumeroIteracionesUltimaBusqueda() {
        return this.numeroIteracionesUltimaBusqueda;
    }

    public ArrayList<V> obtenerElementosOrdenadosAscendentemente() {
        ArrayList<V> elementos = new ArrayList<>();
        recorrerAscendente(raiz, elementos);
        return elementos;
    }

    private void recorrerAscendente(NodoGenerico<V> nodo, ArrayList<V> elementos) {
        if (nodo != null) {
            recorrerAscendente(nodo.getIzq(), elementos);
            elementos.add(nodo.getValue());
            recorrerAscendente(nodo.getDer(), elementos);
        }
    }

    public ArrayList<V> obtenerElementosOrdenadosDescendentemente() {
        ArrayList<V> elementos = new ArrayList<>();
        recorrerDescendente(raiz, elementos);
        return elementos;
    }

    private void recorrerDescendente(NodoGenerico<V> nodo, ArrayList<V> elementos) {
        if (nodo != null) {
            recorrerDescendente(nodo.getDer(), elementos);
            elementos.add(nodo.getValue());
            recorrerDescendente(nodo.getIzq(), elementos);
        }
    }
}

/********************************************
 * Clase Principal con método main para pruebas
 ********************************************/
public class ABB {

    public static void main(String[] args) {

        System.out.println("=== Pruebas para ArbolBinarioBusqueda con Integer ===");
        ArbolBinarioBusqueda abbInt = new ArbolBinarioBusqueda();

        abbInt.insertarElemento(15);
        abbInt.insertarElemento(9);
        abbInt.insertarElemento(20);
        abbInt.insertarElemento(6);
        abbInt.insertarElemento(14);
        abbInt.insertarElemento(13);
        abbInt.insertarElemento(17);
        abbInt.insertarElemento(64);
        abbInt.insertarElemento(72);
        abbInt.insertarElemento(26);

        System.out.println("Número de elementos: " + abbInt.size());

        ArrayList<Integer> ascendInt = abbInt.obtenerElementosOrdenadosAscendentemente();
        System.out.print("Elementos en orden ascendente: " + ascendInt + "\n");

        ArrayList<Integer> descendInt = abbInt.obtenerElementosOrdenadosDescendentemente();
        System.out.print("Elementos en orden descendente: " + descendInt + "\n");

        int buscarValor = 20;
        System.out.println("Buscar " + buscarValor + ": " + (abbInt.buscarElemento(buscarValor) != null ? "Encontrado" : "No encontrado"));

        System.out.println("Iteraciones última búsqueda: " + abbInt.getNumeroIteracionesUltimaBusqueda());
        System.out.println("Iteraciones media en búsquedas: " + abbInt.getNumeroIteracionesMedioEnBusquedas());

        abbInt.eliminarElemento(15);
        abbInt.eliminarElemento(13);
        abbInt.eliminarElemento(14);
        abbInt.eliminarElemento(64);

        System.out.println("Número de elementos después de eliminaciones: " + abbInt.size());

        System.out.println("\n=== Pruebas para ArbolBinarioBusquedaGenerico con Producto ===");
        ArbolBinarioBusquedaGenerico<Producto> abbProd = new ArbolBinarioBusquedaGenerico<>();

        Producto p1 = new Producto(15, "Tercas");
        Producto p2 = new Producto(9, "Tercas");
        Producto p3 = new Producto(20, "Tercas");
        Producto p4 = new Producto(6, "Tercas");
        Producto p5 = new Producto(14, "Tercas");
        Producto p6 = new Producto(13, "Tercas");
        Producto p7 = new Producto(17, "Tercas");
        Producto p8 = new Producto(64, "Tercas");
        Producto p9 = new Producto(72, "Tercas");
        Producto p10 = new Producto(26, "Tercas");

        abbProd.insertarElemento(p1);
        abbProd.insertarElemento(p2);
        abbProd.insertarElemento(p3);
        abbProd.insertarElemento(p4);
        abbProd.insertarElemento(p5);
        abbProd.insertarElemento(p6);
        abbProd.insertarElemento(p7);
        abbProd.insertarElemento(p8);
        abbProd.insertarElemento(p9);
        abbProd.insertarElemento(p10);

        System.out.println("Número de elementos: " + abbProd.size());

        ArrayList<Producto> ascProd = abbProd.obtenerElementosOrdenadosAscendentemente();
        System.out.print("Elementos en orden ascendente: " + ascProd + "\n");

        ArrayList<Producto> descProd = abbProd.obtenerElementosOrdenadosDescendentemente();
        System.out.print("Elementos en orden descendente: " + descProd + "\n");

        Producto buscarProd = new Producto(20, "");
        System.out.println("Buscar Producto con id 20: " + (abbProd.buscarElemento(buscarProd) != null ? "Encontrado" : "No encontrado"));

        System.out.println("Iteraciones última búsqueda: " + abbProd.getNumeroIteracionesUltimaBusqueda());
        System.out.println("Iteraciones media en búsquedas: " + abbProd.getNumeroIteracionesMedioEnBusquedas());

        abbProd.eliminarElemento(p1);
        abbProd.eliminarElemento(p6);
        abbProd.eliminarElemento(p5);
        abbProd.eliminarElemento(p8);

        System.out.println("Número de elementos después de eliminaciones: " + abbProd.size());
    }
}

