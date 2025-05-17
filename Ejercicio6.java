/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios_aaa;

/**
 *
 * @author GM104-2
 */
public class Ejercicio6 {

    static class Nodo {
        char valor;
        Nodo izquierdo, derecho;

        Nodo(char valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    Nodo raiz;

    int altura(Nodo nodo) {
        if (nodo == null) return 0;

        int alturaIzq = altura(nodo.izquierdo);
        int alturaDer = altura(nodo.derecho);

        return 1 + Math.max(alturaIzq, alturaDer);
    }

    public static void main(String[] args) {
        Ejercicio6 arbol = new Ejercicio6();
        arbol.raiz = new Nodo('M');
        arbol.raiz.izquierdo = new Nodo('N');
        arbol.raiz.izquierdo.izquierdo = new Nodo('O');
        arbol.raiz.izquierdo.derecho = new Nodo('P');
        arbol.raiz.izquierdo.derecho.derecho = new Nodo('Q');

        int altura = arbol.altura(arbol.raiz);
        System.out.println("Altura del árbol: " + altura);
    }
}
