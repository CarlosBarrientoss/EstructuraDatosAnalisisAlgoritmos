/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

class NodoInt {
    int valor;
    NodoInt izquierdo, derecho;

    NodoInt(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

public class Ejercicio7 {
    static int suma = 0;

    static void inorden(NodoInt nodo) {
        if (nodo != null) {
            inorden(nodo.izquierdo);
            suma += nodo.valor;
            inorden(nodo.derecho);
        }
    }

    public static void main(String[] args) {
        NodoInt raiz = new NodoInt(5);
        raiz.izquierdo = new NodoInt(3);
        raiz.derecho = new NodoInt(7);
        raiz.izquierdo.izquierdo = new NodoInt(1);
        raiz.izquierdo.derecho = new NodoInt(4);
        raiz.derecho.derecho = new NodoInt(9);

        inorden(raiz);
        System.out.println("Suma total = " + suma); // Suma total = 29
    }
}
