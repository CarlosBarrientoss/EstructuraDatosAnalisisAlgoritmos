/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

class Nodo {
    int valor;
    Nodo izquierdo, derecho;

    Nodo(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

public class Ejercicio5 {
    static int contarHojas(Nodo nodo) {
        if (nodo == null) return 0;
        if (nodo.izquierdo == null && nodo.derecho == null) return 1;

        return contarHojas(nodo.izquierdo) + contarHojas(nodo.derecho);
    }

    public static void main(String[] args) {
        Nodo raiz = new Nodo(7);
        raiz.izquierdo = new Nodo(4);
        raiz.derecho = new Nodo(9);
        raiz.izquierdo.izquierdo = new Nodo(2);
        raiz.derecho.izquierdo = new Nodo(8);
        raiz.derecho.derecho = new Nodo(11);

        int hojas = contarHojas(raiz);
        System.out.println("N.º de hojas = " + hojas); // Salida esperada: 3
    }
}
