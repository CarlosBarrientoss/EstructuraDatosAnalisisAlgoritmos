/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

class NodoBusqueda {
    int valor;
    NodoBusqueda izquierdo, derecho;

    NodoBusqueda(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

public class Ejercicio8 {
    static boolean buscar(NodoBusqueda nodo, int clave) {
        if (nodo == null) return false;
        if (nodo.valor == clave) return true;
        return buscar(nodo.izquierdo, clave) || buscar(nodo.derecho, clave);
    }

    public static void main(String[] args) {
        NodoBusqueda raiz = new NodoBusqueda(20);
        raiz.izquierdo = new NodoBusqueda(10);
        raiz.derecho = new NodoBusqueda(30);
        raiz.izquierdo.izquierdo = new NodoBusqueda(5);
        raiz.izquierdo.derecho = new NodoBusqueda(15);

        int clave1 = 15;
        int clave2 = 25;

        System.out.println(buscar(raiz, clave1) ? "Encontrado para key=15" : "No encontrado para key=15");
        System.out.println(buscar(raiz, clave2) ? "Encontrado para key=25" : "No encontrado para key=25");
    }
}
