/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

class NodoChar {
    char valor;
    NodoChar izquierdo, derecho;

    NodoChar(char valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

public class Ejercicio3 {
    static void postorden(NodoChar nodo) {
        if (nodo != null) {
            postorden(nodo.izquierdo);
            postorden(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }
    
    public static void main(String[] args) {
        NodoChar raiz = new NodoChar('A');
        raiz.izquierdo = new NodoChar('B');
        raiz.derecho = new NodoChar('C');
        raiz.izquierdo.izquierdo = new NodoChar('D');
        raiz.izquierdo.derecho = new NodoChar('E');
        raiz.derecho.derecho = new NodoChar('F');

        System.out.print("Recorrido Postorden: ");
        postorden(raiz); // Salida esperada: D B E F C A
    }
}
