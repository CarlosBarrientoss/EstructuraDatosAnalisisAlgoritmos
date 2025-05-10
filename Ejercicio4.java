/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbol_binario;

/**
 *
 * @author GM104-2
 */
public class Ejercicio4{

    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    static class Cola {
        Nodo[] elementos;
        int frente, fin, tamaño;

        Cola(int capacidad) {
            elementos = new Nodo[capacidad];
            frente = fin = 0;
            tamaño = 0;
        }

        void encolar(Nodo nodo) {
            if (tamaño == elementos.length) return; 
            elementos[fin] = nodo;
            fin = (fin + 1) % elementos.length;
            tamaño++;
        }

        Nodo desencolar() {
            if (estaVacia()) return null;
            Nodo nodo = elementos[frente];
            frente = (frente + 1) % elementos.length;
            tamaño--;
            return nodo;
        }

        boolean estaVacia() {
            return tamaño == 0;
        }
    }

    Nodo raiz;

    void recorridoPorNiveles(Nodo nodo) {
        if (nodo == null) return;

        Cola cola = new Cola(100);
        cola.encolar(nodo);

        while (!cola.estaVacia()) {
            Nodo actual = cola.desencolar();
            System.out.print(actual.valor + " ");

            if (actual.izquierdo != null) cola.encolar(actual.izquierdo);
            if (actual.derecho != null) cola.encolar(actual.derecho);
        }
    }

    public static void main(String[] args) {
        Ejercicio4 arbol = new Ejercicio4();
        arbol.raiz = new Nodo(1);
        arbol.raiz.izquierdo = new Nodo(2);
        arbol.raiz.derecho = new Nodo(3);
        arbol.raiz.izquierdo.izquierdo = new Nodo(4);
        arbol.raiz.izquierdo.derecho = new Nodo(5);
        arbol.raiz.derecho.derecho = new Nodo(6);

        System.out.println("Recorrido por niveles sin LinkedList:");
        arbol.recorridoPorNiveles(arbol.raiz);
    }
}
