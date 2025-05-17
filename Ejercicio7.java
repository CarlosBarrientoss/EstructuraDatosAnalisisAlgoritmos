/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios_aaa;

/**
 *
 * @author GM104-2
 */
public class Ejercicio7 {

    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    Nodo raiz;
    int sumaTotal = 0;

    void sumarNodos(Nodo nodo) {
        if (nodo == null) return;

        sumarNodos(nodo.izquierdo);
        sumaTotal += nodo.valor;
        sumarNodos(nodo.derecho);
    }

    public static void main(String[] args) {
        Ejercicio7 arbol = new Ejercicio7();
        arbol.raiz = new Nodo(5);
        arbol.raiz.izquierdo = new Nodo(3);
        arbol.raiz.izquierdo.izquierdo = new Nodo(1);
        arbol.raiz.izquierdo.derecho = new Nodo(4);
        arbol.raiz.derecho = new Nodo(7);
        arbol.raiz.derecho.derecho = new Nodo(9);

        arbol.sumarNodos(arbol.raiz);
        System.out.println("Suma total de los nodos: " + arbol.sumaTotal); 
    }
}
