/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arboles2;


public class ArbolBusqueda {
    // Clase Nodo básica
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        public Nodo(int item) {
            valor = item;
            izquierdo = derecho = null;
        }
    }

    Nodo raiz;

    public ArbolBusqueda() {
        raiz = null;
    }

    // Métodos para ABB
    public void insertarABB(int valor) {
        raiz = insertarABBRec(raiz, valor);
    }

    private Nodo insertarABBRec(Nodo raiz, int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.izquierdo = insertarABBRec(raiz.izquierdo, valor);
        } else if (valor > raiz.valor) {
            raiz.derecho = insertarABBRec(raiz.derecho, valor);
        }

        return raiz;
    }

    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(Nodo raiz, int valor) {
        if (raiz == null) return false;
        if (raiz.valor == valor) return true;
        
        return valor < raiz.valor 
            ? buscarRec(raiz.izquierdo, valor)
            : buscarRec(raiz.derecho, valor);
    }

    public void eliminar(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private Nodo eliminarRec(Nodo raiz, int valor) {
        if (raiz == null) return raiz;

        if (valor < raiz.valor) {
            raiz.izquierdo = eliminarRec(raiz.izquierdo, valor);
        } else if (valor > raiz.valor) {
            raiz.derecho = eliminarRec(raiz.derecho, valor);
        } else {
            // Nodo con un solo hijo o sin hijos
            if (raiz.izquierdo == null) {
                return raiz.derecho;
            } else if (raiz.derecho == null) {
                return raiz.izquierdo;
            }

            // Nodo con dos hijos: obtener el sucesor inorden (mínimo en subárbol derecho)
            raiz.valor = minValor(raiz.derecho);

            // Eliminar el sucesor inorden
            raiz.derecho = eliminarRec(raiz.derecho, raiz.valor);
        }
        return raiz;
    }

    private int minValor(Nodo raiz) {
        int min = raiz.valor;
        while (raiz.izquierdo != null) {
            min = raiz.izquierdo.valor;
            raiz = raiz.izquierdo;
        }
        return min;
    }

    public void recorridoInorden() {
        inordenRec(raiz);
        System.out.println();
    }

    private void inordenRec(Nodo raiz) {
        if (raiz != null) {
            inordenRec(raiz.izquierdo);
            System.out.print(raiz.valor + " ");
            inordenRec(raiz.derecho);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Prueba Árbol Binario de Búsqueda ===");
        ArbolBusqueda arbolABB = new ArbolBusqueda();
        
        // Insertar valores
        arbolABB.insertarABB(50);
        arbolABB.insertarABB(30);
        arbolABB.insertarABB(70);
        arbolABB.insertarABB(20);
        arbolABB.insertarABB(40);
        arbolABB.insertarABB(60);
        arbolABB.insertarABB(80);
        
        // Recorrido inorden (debe mostrar valores ordenados)
        System.out.print("Recorrido inorden: ");
        arbolABB.recorridoInorden();
        
        // Búsquedas
        System.out.println("¿Existe 40? " + arbolABB.buscar(40));
        System.out.println("¿Existe 90? " + arbolABB.buscar(90));
        
        // Eliminación
        System.out.println("\nEliminando el valor 20...");
        arbolABB.eliminar(20);
        System.out.print("Recorrido inorden después de eliminar: ");
        arbolABB.recorridoInorden();
        
        System.out.println("\nEliminando el valor 50 (raíz)...");
        arbolABB.eliminar(50);
        System.out.print("Recorrido inorden después de eliminar raíz: ");
        arbolABB.recorridoInorden();
    }
}