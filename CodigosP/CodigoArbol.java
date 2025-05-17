package CodigosP;

import java.util.LinkedList;
import java.util.Queue;

public class CodigoArbol {
	
	public void preorden(NodoArbol nodo) {
	    if (nodo == null)
	        return;

	    System.out.print("Nodo Value => " + nodo.value);
	    preorden(nodo.hijo1);
	    preorden(nodo.hijo2);
	}
	
	
	public void posorden(NodoArblon nodo) {
		if (nodo == null)
			return;
		 
		posorden(nodo.hijo1);
		posorden(nodo.hijo2);
		System.out.print("Nodo Value => " + nodo.value);
	}
	
	
	public void inorden(NodoArbol nodo) {
		if(nodo == null)
			return;
		
		inorden(nodo.hijo1);
		System.out.print("Nodo Value => " + nodo.value);
		inorden(nodo.hijo2);
	}
	
	public boolean busquedaAnchura(char c) {
		Queue<NodoArbol> colaAuxiliar = new LinkedList<NodoArbol>();
		colaAxiliar.add(raiz);
		while(ColaAuxiliar.size() != 0) {
			NodoArbol nodo = colaAuxiliar.poll();
			System.out.print("Nodo value =>" + nodo.value);
			if(nodo.value == c) {
				return true;
			}else {
				colaAuxiliar.add(nodo.hijo1);
				colaAuxiliar.add(nodo.hijo2);
			}
		}
		return false;
	}
	

	
	
	
	

}
