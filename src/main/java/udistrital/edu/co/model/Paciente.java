/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.edu.co.model;

/**
 *
 * @author acurr
 */
public class Paciente implements Comparable<Paciente> {
    private String idPaciente;
    private String nombre;
    private int nivelTriage;
    private long timestamp;  

    public Paciente(String idPaciente, String nombre, int nivelTriage) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.nivelTriage = nivelTriage;
        this.timestamp = System.nanoTime(); // Marca de tiempo precisa
    }

   
    public String getIdPaciente() { return idPaciente; }
    public String getNombre() { return nombre; }
    public int getNivelTriage() { return nivelTriage; }

    /**
     * Este método define la prioridad dentro del Heap (PriorityQueue).
     * Java extrae primero el elemento que sea considerado "menor".
     */
    @Override
    public int compareTo(Paciente otro) {
        if (this.nivelTriage != otro.nivelTriage) {
            // Nivel 1 (Rojo) es "menor" numéricamente que Nivel 2 (Naranja),
            // por lo tanto, PriorityQueue lo pondrá en la raíz.
            return Integer.compare(this.nivelTriage, otro.nivelTriage);
        }
        // Si tienen la misma gravedad, va primero el que llegó antes (menor timestamp)
        return Long.compare(this.timestamp, otro.timestamp);
    }
}
