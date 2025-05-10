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

public class Ejercicio2 {
    static void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecho);
        }
    }
    
    public static void main(String[] args) {
        Nodo raiz = new Nodo(8);
        raiz.izquierdo = new Nodo(3);
        raiz.derecho = new Nodo(10);
        raiz.izquierdo.derecho = new Nodo(6);
        raiz.derecho.derecho = new Nodo(14);

        System.out.print("Recorrido Inorden: ");
        inorden(raiz); // Salida esperada: 3 6 8 10 14
    }
}
