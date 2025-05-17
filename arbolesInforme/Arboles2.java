/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arboles2;

public class Arboles2 {
    // Clase Nodo anidada
    static class NodoLleno {
        int valor;
        NodoLleno izquierdo, derecho;

        public NodoLleno(int item) {
            valor = item;
            izquierdo = derecho = null;
        }
    }

    NodoLleno raiz;

    // Método para verificar si el árbol está lleno
    boolean estaLleno(NodoLleno nodo) {
        // Si el árbol está vacío
        if (nodo == null) return true;
        
        // Si es un nodo hoja
        if (nodo.izquierdo == null && nodo.derecho == null) return true;
        
        // Si ambos hijos no son null, verificamos recursivamente
        if (nodo.izquierdo != null && nodo.derecho != null)
            return estaLleno(nodo.izquierdo) && estaLleno(nodo.derecho);
        
        // Si llegamos aquí significa que tiene un solo hijo
        return false;
    }

    public static void main(String[] args) {
        Arboles2 arbol = new Arboles2();
        
        // Construimos el árbol
        arbol.raiz = new NodoLleno(10);
        arbol.raiz.izquierdo = new NodoLleno(20);
        arbol.raiz.derecho = new NodoLleno(30);
        arbol.raiz.izquierdo.izquierdo = new NodoLleno(40);
        arbol.raiz.izquierdo.derecho = new NodoLleno(50);
        
        // Verificamos si está lleno
        if (arbol.estaLleno(arbol.raiz))
            System.out.println("El árbol está lleno");
        else
            System.out.println("El árbol NO está lleno");
    }
}
