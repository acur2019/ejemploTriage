/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.edu.co.controller;

import udistrital.edu.co.model.TriageModel;
import udistrital.edu.co.view.TriageView;

/**
 *
 * @author acurr
 */
public class SistemaTriage {
    public static void main(String[] args) {
        TriageModel modelo = new TriageModel();
        TriageView vista = new TriageView();
        TriageController controlador = new TriageController(modelo, vista);
        
        controlador.ejecutar();
    }
}
