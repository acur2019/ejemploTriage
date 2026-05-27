/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.edu.co.controller;
import udistrital.edu.co.model.Paciente;
import udistrital.edu.co.model.TriageModel;
import udistrital.edu.co.view.TriageView;


/**
 *
 * @author acurr
 */
class TriageController {
    private TriageModel model;
    private TriageView view;

    public TriageController(TriageModel model, TriageView view) {
        this.model = model;
        this.view = view;
    }

    public void ejecutar() {
        int opcion;
        do {
            opcion = view.mostrarMenu();
            switch (opcion) {
                case 1:
                    Paciente nuevo = view.pedirDatosPaciente();
                    if (nuevo.getNivelTriage() >= 1 && nuevo.getNivelTriage() <= 5) {
                        model.agregarPaciente(nuevo);
                        view.mostrarMensaje("Paciente insertado en el Heap Personalizado exitosamente.");
                    } else {
                        view.mostrarMensaje("Error: El nivel de triage debe ser estrictamente entre 1 y 5.");
                    }
                    break;
                case 2:
                    Paciente atendido = model.extraerSiguientePaciente();
                    view.mostrarPacienteAtendido(atendido);
                    break;
                case 3:
                    view.mostrarCola(model.obtenerColaOrdenada());
                    break;
                case 4:
                    view.mostrarMensaje("Cerrando el sistema de Triage... ¡Hasta luego!");
                    break;
                default:
                    view.mostrarMensaje("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }
}
