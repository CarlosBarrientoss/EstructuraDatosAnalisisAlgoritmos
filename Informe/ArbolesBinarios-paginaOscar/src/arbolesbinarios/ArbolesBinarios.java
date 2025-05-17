/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolesbinarios;

import java.util.Scanner;

/**
 *
 * @author andre
 */
public class ArbolesBinarios {

    // Clase Nodo para ABB
    static class Nodo {
        int valor;
        Nodo izquierda, derecha;

        public Nodo(int valor) {
            this.valor = valor;
            izquierda = derecha = null;
        }
    }

    // Clase Nodo para AVL
    static class NodoAVL {
        int valor, altura;
        NodoAVL izquierda, derecha;

        NodoAVL(int valor) {
            this.valor = valor;
            this.altura = 1;
        }
    }

    // Operaciones para ABB
    static class ABB {
        Nodo raiz;

        void insertar(int valor) {
            raiz = insertarRec(raiz, valor);
        }

        Nodo insertarRec(Nodo raiz, int valor) {
            if (raiz == null) {
                return new Nodo(valor);
            }
            if (valor < raiz.valor) {
                raiz.izquierda = insertarRec(raiz.izquierda, valor);
            } else if (valor > raiz.valor) {
                raiz.derecha = insertarRec(raiz.derecha, valor);
            }
            return raiz;
        }

        void inOrder() {
            inOrderRec(raiz);
            System.out.println();
        }

        void inOrderRec(Nodo raiz) {
            if (raiz != null) {
                inOrderRec(raiz.izquierda);
                System.out.print(raiz.valor + " ");
                inOrderRec(raiz.derecha);
            }
        }
    }

    // Operaciones para AVL
    static class AVL {
        NodoAVL raiz;

        int altura(NodoAVL nodo) {
            return (nodo == null) ? 0 : nodo.altura;
        }

        int max(int a, int b) {
            return (a > b) ? a : b;
        }

        NodoAVL rotacionDerecha(NodoAVL y) {
            NodoAVL x = y.izquierda;
            NodoAVL T2 = x.derecha;

            x.derecha = y;
            y.izquierda = T2;

            y.altura = max(altura(y.izquierda), altura(y.derecha)) + 1;
            x.altura = max(altura(x.izquierda), altura(x.derecha)) + 1;

            return x;
        }

        NodoAVL insertar(NodoAVL nodo, int valor) {
            if (nodo == null) {
                return new NodoAVL(valor);
            }

            if (valor < nodo.valor) {
                nodo.izquierda = insertar(nodo.izquierda, valor);
            } else if (valor > nodo.valor) {
                nodo.derecha = insertar(nodo.derecha, valor);
            } else {
                return nodo;
            }

            nodo.altura = 1 + max(altura(nodo.izquierda), altura(nodo.derecha));

            int balance = altura(nodo.izquierda) - altura(nodo.derecha);

            if (balance > 1 && valor < nodo.izquierda.valor) {
                return rotacionDerecha(nodo);
            }

            // Aquí irían otros casos de rotación (izquierda-derecha, etc.)

            return nodo;
        }

        void inOrder() {
            inOrderRec(raiz);
            System.out.println();
        }

        void inOrderRec(NodoAVL raiz) {
            if (raiz != null) {
                inOrderRec(raiz.izquierda);
                System.out.print(raiz.valor + " ");
                inOrderRec(raiz.derecha);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ABB arbolABB = new ABB();
        AVL arbolAVL = new AVL();

        while (true) {
            System.out.println("\nMenu Arboles Binarios:");
            System.out.println("1. Insertar en ABB");
            System.out.println("2. Mostrar in-order ABB");
            System.out.println("3. Insertar en AVL");
            System.out.println("4. Mostrar in-order AVL");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese valor a insertar en ABB: ");
                    int valorABB = scanner.nextInt();
                    arbolABB.insertar(valorABB);
                    break;
                case 2:
                    System.out.print("Recorrido In-Order ABB: ");
                    arbolABB.inOrder();
                    break;
                case 3:
                    System.out.print("Ingrese valor a insertar en AVL: ");
                    int valorAVL = scanner.nextInt();
                    arbolAVL.raiz = arbolAVL.insertar(arbolAVL.raiz, valorAVL);
                    break;
                case 4:
                    System.out.print("Recorrido In-Order AVL: ");
                    arbolAVL.inOrder();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }
}