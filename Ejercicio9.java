/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios_aaa;

/**
 *
 * @author GM104-2
 */
public class Ejercicio9 {

    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    Nodo raiz;

    boolean imprimirCamino(Nodo nodo, int destino, String camino) {
        if (nodo == null) return false;

        camino += nodo.valor + " ";

        if (nodo.valor == destino) {
            System.out.println("Camino a " + destino + ": " + camino);
            return true;
        }

        boolean encontradoIzq = imprimirCamino(nodo.izquierdo, destino, camino);
        boolean encontradoDer = imprimirCamino(nodo.derecho, destino, camino);

        return encontradoIzq || encontradoDer;
    }

    public static void main(String[] args) {
        Ejercicio9 arbol = new Ejercicio9();
        arbol.raiz = new Nodo(1);
        arbol.raiz.izquierdo = new Nodo(2);
        arbol.raiz.derecho = new Nodo(3);
        arbol.raiz.derecho.izquierdo = new Nodo(4);
        arbol.raiz.derecho.derecho = new Nodo(5);

        int destino = 4;
        boolean encontrado = arbol.imprimirCamino(arbol.raiz, destino, "");

        if (!encontrado) {
            System.out.println("El nodo " + destino + " no fue encontrado.");
        }
    }
}
