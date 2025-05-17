/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerArbolesBinarios;

import java.util.ArrayList;
 
public class ArbolBinarioBusquedaGenerico<V extends Comparable<V>> {
    
    public class NodoGenerico<V> {
 
    private V value;
    private NodoGenerico<V> izq;
    private NodoGenerico<V> der;
     
    public NodoGenerico(V value, NodoGenerico<V> izq, NodoGenerico<V> der) {
        super();
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
    
        public class Producto extends Comparable<Producto>{
        private int id;
        private String nombre;

        public Producto(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public boolean equals(Object p2) {
            Producto producto2 = (Producto)p2;
            if (this.getId() == producto2.getId() && this.getNombre().equals(producto2.getNombre())) {
                return true;
            }else {
                return false;
            }
        }

        @Override
        int compare(Producto value) {
            if (this.id > value.getId()) {
                return 1;
            }else if (this.id < value.getId()) {
                return -1;
            }else {
                //Si son iguales
                return 0;
            }
        }

        @Override
        public String toString() {
            return "Producto [id=" + id + ", nombre=" + nombre + "]";
        }
    }
    
    NodoGenerico<V> raiz = null;
    private int numeroElementos = 0;
    private int numeroBusquedas = 0;
    private int numeroIteracionesTotal = 0;
    private int numeroIteracionesUltimaBusqueda = 0;
 
    public ArbolBinarioBusquedaGenerico() {
 
    }
 
    public void insertarElemento(V value) {
        NodoGenerico<V> nuevoNodo = new NodoGenerico<V>(value, null, null);
 
        if (raiz == null) {
            raiz = nuevoNodo;
            System.out.println("Inserto la raiz");
        } else {
            // Necesitamos encontrar en que posición debemos insertar el nodo
            NodoGenerico<V> aux = raiz;
 
            while (aux != null) {
                // Comprobamos si tenemos que insertarlo ya
                // Comprobamos si nodo hoja
                if (aux.getDer() == null && aux.getIzq() == null) {
                    if (value.compare(aux.getValue()) == 1) {
                        // Derecha
                        System.out.println(value + " Lo insertamos a la derecha de: " + aux.getValue());
                        aux.setDer(nuevoNodo);
                        aux = null;
                    } else {
                        // Izquierda
                        System.out.println(value + " Lo insertamos a la izquierda de: " + aux.getValue());
                        aux.setIzq(nuevoNodo);
                        aux = null;
                    }
                } else if (value.compare(aux.getValue()) == 1 && aux.getDer() == null) {
                    // Lo insertamos a la derecha
                    System.out.println(value + " Lo insertamos a la derecha de: " + aux.getValue());
                    aux.setDer(nuevoNodo);
                    aux = null;
                } else if (value.compare(aux.getValue()) == -1 && aux.getIzq() == null) {
                    // Lo insertamos a la izquierda
                    System.out.println(value + " Lo insertamos a la izquierda de: " + aux.getValue());
                    aux.setIzq(nuevoNodo);
                    aux = null;
                } else {
                    // Pasamos de nodo
                    if (value.compare(aux.getValue()) == 1) {
                        aux = aux.getDer();
                    } else {
                        aux = aux.getIzq();
                    }
                }
 
            }
 
        }
 
        // Incrementamos el número de elementos en 1
        numeroElementos++;
    }
 
    public V buscarElemento(V value) {
        NodoGenerico<V> aux = raiz;
        NodoGenerico<V> resultado = null;
        numeroIteracionesUltimaBusqueda = 0;
 
        while (aux != null) {
            // Comprobamos si es el valor
            if (value.compare(aux.getValue()) == 0) {
                // Hemos encontrado el elemento
                resultado = aux;
                aux = null;
            } else if (aux.getDer() == null && aux.getIzq() == null) {
                // Si hemos llegado a un nodo hoja el elemento no está en el ABB
                // El elemento no está
                aux = null;
            } else if (value.compare(aux.getValue()) == 1 && aux.getDer() != null) {
                // Si el valor es mayor y tenemos nodo a la derecha, vamos a la derecha
                aux = aux.getDer();
            } else if (value.compare(aux.getValue()) == -1 && aux.getIzq() != null) {
                // Si el valor es menos y tenemos nodo a la izquierda, vamos a la izquierda
                aux = aux.getIzq();
            } else {
                // Si el nodo es mayor y no tenemos nodo a la derecha o es menor y no tenemos
                // nodo a la izquierda
                // El elemento no está
                aux = null;
            }
 
            numeroIteracionesUltimaBusqueda++;
        }
 
        numeroIteracionesTotal += numeroIteracionesUltimaBusqueda;
        numeroBusquedas++;
 
        if (resultado != null) {
            return resultado.getValue();
        }else {
            return null;
        }
    }
 
    public boolean eliminarElemento(V value) {
        boolean resultado = false;
        NodoGenerico<V> aux = raiz;
 
        while (aux != null) {
            // Si es la raiz
            if (aux.getValue().compare(value) == 0) {
                NodoGenerico<V> nodoAEliminar = aux;
 
                if (aux.getDer() != null) {
                    raiz = aux.getDer();
                    if (nodoAEliminar.getIzq() != null) {
                        insertarNodo(nodoAEliminar.getIzq());
                        nodoAEliminar.setIzq(null);
                        nodoAEliminar.setDer(null);
                    }
                } else if (aux.getIzq() != null) {
                    raiz = aux.getIzq();
                    if (nodoAEliminar.getDer() != null) {
                        insertarNodo(nodoAEliminar.getDer());
                        nodoAEliminar.setIzq(null);
                        nodoAEliminar.setDer(null);
                    }
                } else {
                    raiz = null;
                }
 
                resultado = true;
                aux = null;
            } else if (aux.getIzq() != null && aux.getIzq().getValue().compare(value) == 0) {
                NodoGenerico<V> nodoAEliminar = aux.getIzq();
                // Si el valor está a la izquierda del nodo que estamos recorriendo
                // Miramos si tenemos izquierda en el nodo a eliminar
 
                if (aux.getIzq().getIzq() != null) {
                    // Tenemos Nodo a la izquierda
                    // Apuntamos el nodo que estamos recorriendo al siguiente del nodo a eliminar
                    aux.setIzq(aux.getIzq().getIzq());
                    // Reposicionamos sus hijos
                    if (nodoAEliminar.getDer() != null) {
                        insertarNodo(nodoAEliminar.getDer());
                    }
                    nodoAEliminar.setDer(null);
                    nodoAEliminar.setIzq(null);
                    resultado = true;
                    aux = null;
                } else {
                    // No tenemos nodo a la izquierda del elemento a eliminar
                    // Miramos si es nodo hoja
 
                    if (aux.getIzq() == null && aux.getDer() == null) {
                        aux.setIzq(null);
                    } else {
                        aux.setIzq(null);
                        if (nodoAEliminar.getDer() != null) {
                            insertarNodo(nodoAEliminar.getDer());
                        }
                    }
 
                    resultado = true;
                    aux = null;
                }
 
            } else if (aux.getDer() != null && aux.getDer().getValue().compare(value) == 0) {
                NodoGenerico<V> nodoAEliminar = aux.getDer();
                // Si el valor está a la derecha del nodo que estamos recorriendo
                // Miramos si tenemos derecha en el nodo a eliminar
 
                if (aux.getDer().getDer() != null) {
                    // Tenemos Nodo a la izquierda
                    // Apuntamos el nodo que estamos recorriendo al siguiente del nodo a eliminar
                    aux.setDer(aux.getDer().getDer());
                    // Reposicionamos sus hijos
                    if (nodoAEliminar.getIzq() != null) {
                        insertarNodo(nodoAEliminar.getIzq());
                    }
                    nodoAEliminar.setDer(null);
                    nodoAEliminar.setIzq(null);
                    resultado = true;
                    aux = null;
                } else {
                    // No tenemos nodo a la izquierda del elemento a eliminar
                    // Miramos si es nodo hoja
 
                    if (aux.getIzq().getIzq() == null && aux.getDer().getDer() == null) {
                        aux.setDer(null);
                    } else {
                        aux.setDer(null);
                        if (nodoAEliminar.getIzq() != null) {
                            insertarNodo(nodoAEliminar.getIzq());
                        }
 
                    }
 
                    resultado = true;
                    aux = null;
                }
            } else {
                if (value.compare(aux.getValue()) == 1) {
                    aux = aux.getDer();
                } else {
                    aux = aux.getIzq();
                }
            }
        }
 
        // En caso de borrar el nodo disminuimos la cantidad de nodos en 1
        if (resultado) {
            numeroElementos--;
        }
 
        return resultado;
 
    }
 
    private void insertarNodo(NodoGenerico<V> nodo) {
        if (raiz == null) {
            raiz = nodo;
            System.out.println("Inserto la raiz");
        } else {
            // Necesitamos encontrar en que posición debemos insertar el nodo
            NodoGenerico<V> aux = raiz;
 
            while (aux != null) {
                // Comprobamos si tenemos que insertarlo ya
                // Comprobamos si nodo hoja
                if (aux.getDer() == null && aux.getIzq() == null) {
                    if (nodo.getValue().compare(aux.getValue()) == 1) {
                        // Derecha
                        System.out.println(nodo.getValue() + " Lo insertamos a la derecha de: " + aux.getValue());
                        aux.setDer(nodo);
                        aux = null;
                    } else {
                        // Izquierda
                        System.out.println(nodo.getValue() + " Lo insertamos a la izquierda de: " + aux.getValue());
                        aux.setIzq(nodo);
                        aux = null;
                    }
                } else if (nodo.getValue().compare(aux.getValue()) == 1 && aux.getDer() == null) {
                    // Lo insertamos a la derecha
                    System.out.println(nodo.getValue() + " Lo insertamos a la derecha de: " + aux.getValue());
                    aux.setDer(nodo);
                    aux = null;
                } else if (nodo.getValue().compare(aux.getValue()) == -1 && aux.getIzq() == null) {
                    // Lo insertamos a la izquierda
                    System.out.println(nodo.getValue() + " Lo insertamos a la izquierda de: " + aux.getValue());
                    aux.setIzq(nodo);
                    aux = null;
                } else {
                    // Pasamos de nodo
                    if (nodo.getValue().compare(aux.getValue()) == 1) {
                        aux = aux.getDer();
                    } else {
                        aux = aux.getIzq();
                    }
                }
 
            }
        }
    }
 
    public int size() {
        return this.numeroElementos;
    }
 
    public int getNumeroIteracionesMedioEnBusquedas() {
        return (int) Math.ceil(numeroIteracionesTotal / (double) this.numeroBusquedas);
    }
 
    public int getNumeroIteracionesUltimaBusqueda() {
        return this.numeroIteracionesUltimaBusqueda;
    }
 
    public ArrayList<V> obtenerElementosOrdenadosAscendentemente() {
        ArrayList<V> elementosOrdenados = new ArrayList<>();
        recorrerAscendente(raiz, elementosOrdenados);
        return elementosOrdenados;
    }
 
    public ArrayList<V> obtenerElementosOrdenadosDescendentemente() {
        ArrayList<V> elementosOrdenados = new ArrayList<>();
        recorrerDescendente(raiz, elementosOrdenados);
        return elementosOrdenados;
    }
 
    private void recorrerAscendente(NodoGenerico<V> nodo, ArrayList<V> elementos) {
        if (nodo != null) {
            if (nodo.getIzq() == null && nodo.getDer() == null) {
                elementos.add(nodo.getValue());
            } else {
                recorrerAscendente(nodo.getIzq(), elementos);
                elementos.add(nodo.getValue());
                recorrerAscendente(nodo.getDer(), elementos);
            }
        }
 
    }
 
    private void recorrerDescendente(NodoGenerico<V> nodo, ArrayList<V> elementos) {
        if (nodo != null) {
            if (nodo.getIzq() == null && nodo.getDer() == null) {
                elementos.add(nodo.getValue());
            } else {
                recorrerDescendente(nodo.getDer(), elementos);
                elementos.add(nodo.getValue());
                recorrerDescendente(nodo.getIzq(), elementos);
            }
        }
 
    }
    
    public static void main(String[] args) {
 
    //Creamos el Arbol binario de Busqueda
    ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();
     
    //Insertamos nos nodos
    abb.insertarElemento(15);
    abb.insertarElemento(9);
    abb.insertarElemento(20);
    abb.insertarElemento(6);
    abb.insertarElemento(14);
    abb.insertarElemento(13);
    abb.insertarElemento(17);
    abb.insertarElemento(64);
    abb.insertarElemento(72);
    abb.insertarElemento(26);
 
    //Imprimimos el número de elementos que tenemos:
    System.out.println("Número de elementos: " + abb.size());
     
    //Obtenemos los números ordenados ascendentemente
    ArrayList<Integer> numerosOrdenadosAscedentemente = abb.obtenerElementosOrdenadosAscendentemente();
    System.out.print("Lista de números ordenados ascendentemente: [ ");
     
    for (Integer numero: numerosOrdenadosAscedentemente) {
        System.out.print(numero + " ");
    }
    System.out.print("]\n");
     
    //Obtenemos los números ordenados descendentemente
    ArrayList<Integer> numerosOrdenadosDescedentemente = abb.obtenerElementosOrdenadosDescendentemente();
    System.out.print("Lista de números ordenados descendentemente: [ ");
     
    for (Integer numero: numerosOrdenadosDescedentemente) {
        System.out.print(numero + " ");
    }
    System.out.print("]\n");
     
    //Realizamos diferentes búsquedas
    if (abb.buscarElemento(20) != null) {
        System.out.println("Elemento encontrado");
    }else {
        System.out.println("Elemento no encontrado");
    }
     
    if (abb.buscarElemento(72) != null) {
        System.out.println("Elemento encontrado");
    }else {
        System.out.println("Elemento no encontrado");
    }
     
    if (abb.buscarElemento(56) != null) {
        System.out.println("Elemento encontrado");
    }else {
        System.out.println("Elemento no encontrado");
    }
     
    if (abb.buscarElemento(6) != null) {
        System.out.println("Elemento encontrado");
    }else {
        System.out.println("Elemento no encontrado");
    }
     
    if (abb.buscarElemento(9) != null) {
        System.out.println("Elemento encontrado");
    }else {
        System.out.println("Elemento no encontrado");
    }
     
    //imprimimos estadisticas
    System.out.println("Numero de iteraciones en la última búsqueda: " + abb.getNumeroIteracionesUltimaBusqueda());
    System.out.println("Numero de iteraciones medio en las búsquedas: " + abb.getNumeroIteracionesMedioEnBusquedas());
 
    //Eliminamos nodos
    //Eliminamos la raiz
    abb.eliminarElemento(15);
    //Eliminamos nodos
    abb.eliminarElemento(13);
    abb.eliminarElemento(14);
    abb.eliminarElemento(64);
     
    //Buscamos los elementos eliminado
    if (abb.buscarElemento(15) != null) {
        System.out.println("Elemento encontrado");
    }else {
        System.out.println("Elemento no encontrado");
    }
     
    if (abb.buscarElemento(13) != null) {
        System.out.println("Elemento encontrado");
    }else {
        System.out.println("Elemento no encontrado");
    }
     
    if (abb.buscarElemento(14) != null) {
        System.out.println("Elemento encontrado");
    }else {
        System.out.println("Elemento no encontrado");
    }
     
    if (abb.buscarElemento(64) != null) {
        System.out.println("Elemento encontrado");
    }else {
        System.out.println("Elemento no encontrado");
    }
     
    //Obtenemos los números ordenados ascendentemente
    numerosOrdenadosAscedentemente = abb.obtenerElementosOrdenadosAscendentemente();
    System.out.print("Lista de números ordenados ascendentemente: [ ");
     
    for (Integer numero: numerosOrdenadosAscedentemente) {
        System.out.print(numero + " ");
    }
    System.out.print("]\n");
     
    //Obtenemos los números ordenados descendentemente
    numerosOrdenadosDescedentemente = abb.obtenerElementosOrdenadosDescendentemente();
    System.out.print("Lista de números ordenados descendentemente: [ ");
     
    for (Integer numero: numerosOrdenadosDescedentemente) {
        System.out.print(numero + " ");
    }
    System.out.print("]\n");
     
    //Imprimimos el número de elementos que tenemos:
    System.out.println("Número de elementos: " + abb.size());
}
 
}
