package main.java.com.Tsoft.clinicaCAprendo.controlador;

import main.java.com.Tsoft.clinicaCAprendo.modelador.pacienteClinico;

import java.util.Scanner;

public class pacienteControlador {
    private pacienteClinico Paciente;
    private Scanner scanner;

    public pacienteControlador(pacienteClinico paciente) {
        this.Paciente = paciente;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("<====== Menu Clinica ======>");
            System.out.println("<===== Contigo Aprendo =====>");
            System.out.println("1.\tMostrar datos del paciente");
            System.out.println("2.\tMostrar mes con menor peso");
            System.out.println("3.\tMostrar meses con peso menor a X kilos");
            System.out.println("4.\tMostrar condicion de peso en noviembre");
            System.out.println("5.\tSalir");
            System.out.println("Ingrese una opcion");
            opcion = scanner.nextInt();
            scanner.nextLine();
            ejecutarOpcion(opcion);
        } while (opcion != 5);
    }
    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                mostrarDatosPaciente();
                break;
            case 2:
                mostrarMesMenorPeso();
                break;
            case 3:
                mostrarMesesMenosDeXKilos();
                break;
            case 4:
                mostrarCondicionPesoNoviembre();
                break;
            case 5:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.err.println("Opcion invalida. Intente nuevamente");
        }
    }
    private void mostrarDatosPaciente() {
        System.out.println("Datos del paciente: ");
        System.out.println("RUT: " + Paciente.getRut());
        System.out.println("Nombre: " + Paciente.getNombre());
        System.out.println("Edad: " + Paciente.getEdad());
        System.out.println("Sexo: " + (Paciente.getSexo().equals("M") ? "Masculino" : "Femenino"));
    }
    private void mostrarMesMenorPeso() {
        System.out.println("Mes con menor peso: " + Paciente.menorPesoMensual());
    }
    private void mostrarMesesMenosDeXKilos() {
        System.out.println("Ingrese un peso para comprar");
        int pesoComparacion = scanner.nextInt();
        Integer[] mesesMenosDeX = Paciente.menosDeXKilos(pesoComparacion);
        if (mesesMenosDeX != null) {
            System.out.println("Meses con peso menor a " + pesoComparacion + " Kg: ");
            for (int mes : mesesMenosDeX) {
                System.out.println(mes + " ");
            }
            System.out.println();
        } else {
            System.out.println("El paciente nunca peso menos de " + pesoComparacion + "kg en ningun mes");
        }
    }
    private void mostrarCondicionPesoNoviembre() {
        System.out.println("Ingrese la estatura del paciente (en metros)");
        double estatura = scanner.nextDouble();
        String condicionPeso = Paciente.pesoMesX(11, estatura);
        System.out.println("Codigo de peso en noviembre: " + condicionPeso);
    }
}
