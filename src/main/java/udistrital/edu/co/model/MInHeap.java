/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.edu.co.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acurr
 */
class MinHeap {
    private List<Paciente> arbol;

    public MinHeap() {
        arbol = new ArrayList<>();
    }

    // Fórmulas de índices en el arreglo
    private int indicePadre(int i) { return (i - 1) / 2; }
    private int indiceHijoIzquierdo(int i) { return (2 * i) + 1; }
    private int indiceHijoDerecho(int i) { return (2 * i) + 2; }

    public void insertar(Paciente paciente) {
        // 1. Insertar al final del árbol (arreglo)
        arbol.add(paciente);
        // 2. Reorganizar hacia arriba (Sift-up / Burbujeo)
        siftUp(arbol.size() - 1);
    }

    public Paciente extraerMinimo() {
        if (arbol.isEmpty()) {
            return null;
        }
        if (arbol.size() == 1) {
            return arbol.remove(0);
        }

        // 1. Guardamos la raíz (el paciente más crítico)
        Paciente raiz = arbol.get(0);
        // 2. Movemos el último elemento del árbol a la raíz
        arbol.set(0, arbol.remove(arbol.size() - 1));
        // 3. Reorganizamos hacia abajo (Sift-down / Hundimiento)
        siftDown(0);

        return raiz;
    }

    private void siftUp(int i) {
        // Mientras no estemos en la raíz y el nodo actual sea "menor" (más prioritario) que su padre
        while (i > 0 && arbol.get(i).compareTo(arbol.get(indicePadre(i))) < 0) {
            intercambiar(i, indicePadre(i));
            i = indicePadre(i); // Subimos al nivel del padre
        }
    }

    private void siftDown(int i) {
        int indiceMasPequeño = i;
        int izq = indiceHijoIzquierdo(i);
        int der = indiceHijoDerecho(i);

        // Comprobamos si el hijo izquierdo existe y es más prioritario que el actual
        if (izq < arbol.size() && arbol.get(izq).compareTo(arbol.get(indiceMasPequeño)) < 0) {
            indiceMasPequeño = izq;
        }

        // Comprobamos si el hijo derecho existe y es más prioritario que el menor encontrado
        if (der < arbol.size() && arbol.get(der).compareTo(arbol.get(indiceMasPequeño)) < 0) {
            indiceMasPequeño = der;
        }

        // Si el más pequeño no es el nodo actual, intercambiamos y seguimos bajando
        if (indiceMasPequeño != i) {
            intercambiar(i, indiceMasPequeño);
            siftDown(indiceMasPequeño); // Llamada recursiva
        }
    }

    private void intercambiar(int i, int j) {
        Paciente temp = arbol.get(i);
        arbol.set(i, arbol.get(j));
        arbol.set(j, temp);
    }

    public List<Paciente> obtenerElementos() {
        return new ArrayList<>(arbol);
    }
}
