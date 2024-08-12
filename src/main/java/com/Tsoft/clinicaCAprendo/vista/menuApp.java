package main.java.com.Tsoft.clinicaCAprendo.vista;

import main.java.com.Tsoft.clinicaCAprendo.controlador.pacienteControlador;
import main.java.com.Tsoft.clinicaCAprendo.modelador.pacienteClinico;

public class menuApp {
    public static void main(String[] args) {
        pacienteClinico paciente = new pacienteClinico("17417954-9", "Esteban Caceres", 34, "M");
        pacienteControlador menu = new pacienteControlador(paciente);
        menu.mostrarMenu();
    }
}
