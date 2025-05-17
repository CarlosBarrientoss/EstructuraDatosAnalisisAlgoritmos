/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atboles_binarios;

import atboles_binarios.Nodo.ArbolBinario;

/**
 *
 * @author GM-104-2
 */
public class Atboles_Binarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        /*
              1
             / \
            2   3
           / \   \
          4   5   6
        */

        Nodo raiz = new Nodo(1);
        raiz.izquierda = new Nodo(2);
        raiz.derecha = new Nodo(3);
        raiz.izquierda.izquierda = new Nodo(4);
        raiz.izquierda.derecha = new Nodo(5);
        raiz.derecha.derecha = new Nodo(6);

        System.out.print("Recorrido en Preorden: ");
        arbol.preorden(raiz);
        System.out.println();

        System.out.print("Recorrido en Inorden: ");
        arbol.inorden(raiz);
        System.out.println();

        System.out.print("Recorrido en Posorden: ");
        arbol.posorden(raiz);
        System.out.println();

        System.out.print("Recorrido por Amplitud: ");
        arbol.recorridoPorAmplitud(raiz);
        System.out.println();
    }
    
}
