/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbol_binario;

/**
 *
 * @author GM104-2
 */
public class Ejercicio3 {

    static class Nodo {
        char valor;
        Nodo izquierdo, derecho;

        Nodo(char valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    Nodo raiz;

    void postorden(Nodo nodo) {
        if (nodo == null) return;

        postorden(nodo.izquierdo);
        postorden(nodo.derecho);
        System.out.print(nodo.valor + " ");
    }

    public static void main(String[] args) {
        Ejercicio3 arbol = new Ejercicio3();
        arbol.raiz = new Nodo('A');
        arbol.raiz.izquierdo = new Nodo('B');
        arbol.raiz.izquierdo.izquierdo = new Nodo('D');
        arbol.raiz.derecho = new Nodo('C');
        arbol.raiz.derecho.izquierdo = new Nodo('E');
        arbol.raiz.derecho.derecho = new Nodo('F');

        System.out.println("Recorrido postorden:");
        arbol.postorden(arbol.raiz); 
    }
}
