/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbol_binario;

/**
 *
 * @author GM104-2
 */
public class Ejercicio2 {

    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    Nodo raiz;

    // Método para recorrer el árbol en inorden
    void inorden(Nodo nodo) {
        if (nodo == null) return;

        inorden(nodo.izquierdo);
        System.out.print(nodo.valor + " ");
        inorden(nodo.derecho);
    }

    public static void main(String[] args) {
        Ejercicio2 arbol = new Ejercicio2();
        arbol.raiz = new Nodo(8);
        arbol.raiz.izquierdo = new Nodo(3);
        arbol.raiz.izquierdo.derecho = new Nodo(6);
        arbol.raiz.derecho = new Nodo(10);
        arbol.raiz.derecho.derecho = new Nodo(14);

        System.out.println("Recorrido inorden:");
        arbol.inorden(arbol.raiz); 
    }
}

