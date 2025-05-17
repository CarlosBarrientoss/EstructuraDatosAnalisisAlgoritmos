/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios_aaa;

/**
 *
 * @author GM104-2
 */
public class Ejercicio8 {

    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    Nodo raiz;

    boolean buscar(Nodo nodo, int clave) {
        if (nodo == null) return false;

        if (nodo.valor == clave) return true;

        return buscar(nodo.izquierdo, clave) || buscar(nodo.derecho, clave);
    }

    public static void main(String[] args) {
        Ejercicio8 arbol = new Ejercicio8();
        arbol.raiz = new Nodo(20);
        arbol.raiz.izquierdo = new Nodo(10);
        arbol.raiz.izquierdo.izquierdo = new Nodo(5);
        arbol.raiz.izquierdo.derecho = new Nodo(15);
        arbol.raiz.derecho = new Nodo(30);

        int clave1 = 15;
        int clave2 = 25;

        System.out.println("¿Clave " + clave1 + " encontrada?: " + (arbol.buscar(arbol.raiz, clave1) ? "Sí" : "No"));
        System.out.println("¿Clave " + clave2 + " encontrada?: " + (arbol.buscar(arbol.raiz, clave2) ? "Sí" : "No"));
    }
}
