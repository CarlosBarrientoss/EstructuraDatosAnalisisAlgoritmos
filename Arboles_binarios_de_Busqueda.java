/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arboles_binarios_de_busqueda;

import arboles_binarios_de_busqueda.Nodo.ArbolBinarioBusqueda;

/**
 *
 * @author GM-104-2
 */
public class Arboles_binarios_de_Busqueda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        arbol.insertarElemento(50);
        arbol.insertarElemento(30);
        arbol.insertarElemento(70);
        arbol.insertarElemento(20);
        arbol.insertarElemento(40);
        arbol.insertarElemento(60);
        arbol.insertarElemento(80);

        System.out.println("Árbol en orden:");
        arbol.inOrden();

        System.out.println("Buscar 40: " + arbol.buscarElemento(40)); // true
        System.out.println("Buscar 90: " + arbol.buscarElemento(90)); // false

        System.out.println("Tamaño del árbol: " + arbol.size());

        arbol.eliminarElemento(70);

        System.out.println("Árbol después de eliminar 70:");
        arbol.inOrden();
        System.out.println("Tamaño del árbol: " + arbol.size());
    }
    
}
