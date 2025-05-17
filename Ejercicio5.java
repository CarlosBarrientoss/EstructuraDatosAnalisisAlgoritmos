/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbol_binario;

/**
 *
 * @author GM104-2
 */
public class Ejercicio5 {

    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    Nodo raiz;
    int contadorHojas = 0;

    void contarHojas(Nodo nodo) {
        if (nodo == null) return;

        if (nodo.izquierdo == null && nodo.derecho == null) {
            contadorHojas++;
        }

        contarHojas(nodo.izquierdo);
        contarHojas(nodo.derecho);
    }

    public static void main(String[] args) {
        Ejercicio5 arbol = new Ejercicio5();
        arbol.raiz = new Nodo(7);
        arbol.raiz.izquierdo = new Nodo(4);
        arbol.raiz.izquierdo.izquierdo = new Nodo(2);
        arbol.raiz.derecho = new Nodo(9);
        arbol.raiz.derecho.izquierdo = new Nodo(8);
        arbol.raiz.derecho.derecho = new Nodo(11);

        arbol.contarHojas(arbol.raiz);
        System.out.println("Número de hojas: " + arbol.contadorHojas); // Esperado: 3
    }
}
