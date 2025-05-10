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

public class Ejercicio6 {
    static int altura(NodoChar nodo) {
        if (nodo == null) return 0;

        int izquierda = altura(nodo.izquierdo);
        int derecha = altura(nodo.derecho);
        return Math.max(izquierda, derecha) + 1;
    }

    public static void main(String[] args) {
        NodoChar raiz = new NodoChar('M');
        raiz.izquierdo = new NodoChar('N');
        raiz.izquierdo.izquierdo = new NodoChar('O');
        raiz.izquierdo.derecho = new NodoChar('P');
        raiz.izquierdo.derecho.derecho = new NodoChar('Q');

        System.out.println("Altura = " + altura(raiz)); // Salida esperada: 4
    }
}
