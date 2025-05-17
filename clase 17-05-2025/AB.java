/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.wi;

/**
 *
 * @author GM104-2
 */
public class AB {

public void preorden(NodoArbol nodo) {
    if (nodo == null)
        return;

    System.out.print("Nodo Value => " + nodo.value);  // CORREGIDO: 'vvakue' a 'value'
    preorden(nodo.hijo1);  // hijo izquierdo
    preorden(nodo.hijo2);  // hijo derecho ('hojo2' corregido)
}

public void posorden(NodoArbol nodo) {
    if (nodo == null)
        return;

    posorden(nodo.hijo1);
    posorden(nodo.hijo2);
    System.out.print("Nodo value => " + nodo.value);
}

public void inorden(NodoArbol nodo) {
    if (nodo == null)
        return;

    inorden(nodo.hijo1);
    System.out.print("Nodo Value => " + nodo.value);
    inorden(nodo.hijo2);
}

public boolean busquedaAnchura(char c) {
    Queue<NodoArbol> colaAuxiliar = new LinkedList<>();  // corregido 'queue' y 'linkedList'
    colaAuxiliar.add(raiz);

    while (!colaAuxiliar.isEmpty()) {  // corregido 'size() !=' a '!isEmpty()'
        NodoArbol nodo = colaAuxiliar.poll();  // corregido 'pll()' a 'poll()'
        System.out.print("Nodo Value => " + nodo.value);
        if (nodo.value == c) {
            return true;
        } else {
            if (nodo.hijo1 != null) colaAuxiliar.add(nodo.hijo1);
            if (nodo.hijo2 != null) colaAuxiliar.add(nodo.hijo2);
        }
    }
    return false;  // agregado para que compile correctamente
}

}
