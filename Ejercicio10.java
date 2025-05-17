/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios_aaa;

/**
 *
 * @author GM104-2
 */
public class Ejercicio10 {

    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    Nodo raiz;

    void convertirEnEspejo(Nodo nodo) {
        if (nodo == null) return;

        convertirEnEspejo(nodo.izquierdo);
        convertirEnEspejo(nodo.derecho);

        Nodo temp = nodo.izquierdo;
        nodo.izquierdo = nodo.derecho;
        nodo.derecho = temp;
    }

    void inorden(Nodo nodo) {
        if (nodo == null) return;

        inorden(nodo.izquierdo);
        System.out.print(nodo.valor + " ");
        inorden(nodo.derecho);
    }

    public static void main(String[] args) {
        Ejercicio10 arbol = new Ejercicio10();
        arbol.raiz = new Nodo(9);
        arbol.raiz.izquierdo = new Nodo(6);
        arbol.raiz.izquierdo.izquierdo = new Nodo(3);
        arbol.raiz.izquierdo.derecho = new Nodo(7);
        arbol.raiz.derecho = new Nodo(12);
        arbol.raiz.derecho.derecho = new Nodo(15);

        arbol.convertirEnEspejo(arbol.raiz);

        System.out.println("Inorden del árbol espejado:");
        arbol.inorden(arbol.raiz); 
    }
}
