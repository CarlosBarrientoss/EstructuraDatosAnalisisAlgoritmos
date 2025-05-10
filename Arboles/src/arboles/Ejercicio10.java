/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

class NodoEspejo {
    int valor;
    NodoEspejo izquierdo, derecho;

    NodoEspejo(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

public class Ejercicio10 {
    static void convertirEnEspejo(NodoEspejo nodo) {
        if (nodo == null) return;

        convertirEnEspejo(nodo.izquierdo);
        convertirEnEspejo(nodo.derecho);

        NodoEspejo temp = nodo.izquierdo;
        nodo.izquierdo = nodo.derecho;
        nodo.derecho = temp;
    }

    static void inorden(NodoEspejo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecho);
        }
    }

    public static void main(String[] args) {
        NodoEspejo raiz = new NodoEspejo(9);
        raiz.izquierdo = new NodoEspejo(6);
        raiz.derecho = new NodoEspejo(12);
        raiz.izquierdo.izquierdo = new NodoEspejo(3);
        raiz.izquierdo.derecho = new NodoEspejo(7);
        raiz.derecho.derecho = new NodoEspejo(15);

        convertirEnEspejo(raiz);

        System.out.print("Inorden del árbol espejado: ");
        inorden(raiz); // Salida esperada: 15 12 9 7 6 3
    }
}
