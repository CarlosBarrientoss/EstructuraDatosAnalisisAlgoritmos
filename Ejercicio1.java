/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbol_binario;

/**
 *
 * @author GM104-2
 */
public class Ejercicio1 {

    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    Nodo raiz;

    void preorden(Nodo nodo) {
        if (nodo == null) return;

        System.out.print(nodo.valor + " ");
        preorden(nodo.izquierdo);
        preorden(nodo.derecho);
    }

    public static void main(String[] args) {
        Ejercicio1 arbol = new Ejercicio1();
        arbol.raiz = new Nodo(10);
        arbol.raiz.izquierdo = new Nodo(5);
        arbol.raiz.derecho = new Nodo(15);
        arbol.raiz.izquierdo.izquierdo = new Nodo(2);
        arbol.raiz.izquierdo.derecho = new Nodo(7);
        arbol.raiz.derecho.izquierdo = new Nodo(12);
        arbol.raiz.derecho.derecho = new Nodo(20);

        System.out.println("Recorrido en preorden:");
        arbol.preorden(arbol.raiz); // Salida esperada: 10 5 2 7 15 12 20
    }
}
