/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.edu.co.view;

import java.util.List;
import java.util.Scanner;
import udistrital.edu.co.model.Paciente;

/**
 *
 * @author acurr
 */
public class TriageView {
    private Scanner scanner;

    public TriageView() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n========================================");
        System.out.println("🏥 SISTEMA DE TRIAGE HOSPITALARIO (JAVA) 🏥");
        System.out.println("========================================");
        System.out.println("1.  Ingresar nuevo paciente");
        System.out.println("2.  Llamar siguiente paciente (Extraer Raíz)");
        System.out.println("3.  Ver cola de espera actual");
        System.out.println("4.  Salir");
        System.out.print("\nSeleccione una opción (1-4): ");
        
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, ingrese un número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public Paciente pedirDatosPaciente() {
        scanner.nextLine(); // Limpiar el búfer
        System.out.println("\n--- INGRESO DE PACIENTE ---");
        System.out.print("ID del paciente: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.println("\nNiveles de Triage (Manchester):");
        System.out.println("1: Rojo (Inmediato) | 2: Naranja (Muy Urg.) | 3: Amarillo (Urg.) | 4: Verde (Normal) | 5: Azul (No Urg.)");
        System.out.print("Ingrese el nivel (1-5): ");
        
        int nivel = 5;
        if (scanner.hasNextInt()) {
            nivel = scanner.nextInt();
        }
        return new Paciente(id, nombre, nivel);
    }

    public void mostrarPacienteAtendido(Paciente paciente) {
        System.out.println("\n*********************************************");
        if (paciente != null) {
            System.out.println(" LLAMADO INMEDIATO A CONSULTORIO ");
            System.out.println("Paciente: " + paciente.getNombre() + " (ID: " + paciente.getIdPaciente() + ")");
            System.out.println("Nivel de Urgencia: " + paciente.getNivelTriage() + " -> " + obtenerNombreColor(paciente.getNivelTriage()));
        } else {
            System.out.println("La sala de espera está vacía. No hay pacientes.");
        }
        System.out.println("*********************************************");
    }

    public void mostrarCola(List<Paciente> pacientes) {
        System.out.println("\n--- COLA DE ESPERA (Orden de Prioridad en el Heap) ---");
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes esperando.");
        } else {
            int i = 1;
            for (Paciente p : pacientes) {
                System.out.println(i + ". [Nivel " + p.getNivelTriage() + " - " + obtenerNombreColor(p.getNivelTriage()) + "] " 
                                   + p.getNombre() + " (ID: " + p.getIdPaciente() + ")");
                i++;
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println("\n> " + mensaje);
    }

    private String obtenerNombreColor(int nivel) {
        switch (nivel) {
            case 1: return "Rojo (Crítico)";
            case 2: return "Naranja (Muy Urgente)";
            case 3: return "Amarillo (Urgente)";
            case 4: return "Verde (Estable/Normal)";
            case 5: return "Azul (No Urgente)";
            default: return "Desconocido";
        }
    }
}
