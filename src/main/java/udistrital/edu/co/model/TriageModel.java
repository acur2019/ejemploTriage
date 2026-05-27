/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.edu.co.model;

import java.util.Collections;
import java.util.List;


/**
 *
 * @author acurr
 */
public class TriageModel {
    // PriorityQueue en Java es un Binary Heap balanceado
    private MinHeap heapPacientes;

    public TriageModel() {
        this.heapPacientes = new MinHeap();
    }

    public void agregarPaciente(Paciente paciente) {
        heapPacientes.insertar(paciente);
    }

    public Paciente extraerSiguientePaciente() {
        return heapPacientes.extraerMinimo();
    }

    public List<Paciente> obtenerColaOrdenada() {
        // Obtenemos los elementos de nuestro Heap custom y los ordenamos visualmente
        List<Paciente> listaCopia = heapPacientes.obtenerElementos();
        Collections.sort(listaCopia);
        return listaCopia;
    }
}
