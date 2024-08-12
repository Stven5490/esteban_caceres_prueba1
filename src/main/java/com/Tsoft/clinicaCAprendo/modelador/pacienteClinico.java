package main.java.com.Tsoft.clinicaCAprendo.modelador;

import java.util.Random;

public class pacienteClinico {
   private String Rut;
   private String Nombre;
   private int Edad;
   private String sexo; //F => Femenino - M => Masculino
    private  double[] pesoMensual;

    public pacienteClinico(String rut, String nombre, int edad, String sexo) {
        Rut = rut;
        Nombre = nombre;
        Edad = edad;
        this.sexo = sexo;
        //this.pesoMensual = pesoMensual;
        this.pesoMensual = randomPesoMensual();
    }

    public String getRut() {
        return Rut;
    }

    public void setRut(String rut) {
        Rut = rut;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double[] getPesoMensual() {
        return pesoMensual;
    }

    public void setPesoMensual(double[] pesoMensual) {
        this.pesoMensual = pesoMensual;
    }

    private double[] randomPesoMensual() {
        Random random = new Random();
        double[] pesos = new  double[12];
        for (int i = 0; i < 12; i++) {
            pesos[i] = random.nextDouble(181) + 70;
        }
        return pesos;
    }
    public double menorPesoMensual() {
        double menorPeso = pesoMensual[0];
        double mesMenorPeso = 0;
        for (int i = 1; i < pesoMensual.length; i++) {
            if (pesoMensual[i] < menorPeso) {
                menorPeso = pesoMensual[i];
                mesMenorPeso = i;
            }
        }
        return mesMenorPeso + 1;
    }
    public double indiceMasaCorporal(int mes){
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mes invalido");
        }
        double peso = pesoMensual[mes - 1];
        double estatura = 1.75;
        return peso / (estatura * estatura);
    }
    public Integer[] menosDeXKilos(int pesoComparacion) {
        int count = 0;
        for (double peso : pesoMensual) {
            if (peso < pesoComparacion){
                count++;
            }
        }
        if (count == 0) {
            return null;
        }
        Integer[] mesesMenosDeX = new Integer[count];
        int index = 0;
        for (int i = 0; i < pesoMensual.length; i++) {
            if (pesoMensual[i] < pesoComparacion) {
                mesesMenosDeX[index++] = i + 1;
            }
        }
        return mesesMenosDeX;
    }
    public String pesoMesX(int mes, double estatura) {
        double imc = indiceMasaCorporal(mes);
        if (imc >= 28) {
            return "Obeso";
        } else if (imc >= 20) {
            return "Sobrepeso";
        } else if (imc >= 15) {
            return "Normal";
        } else {
            return "Bajo peso";
        }
    }
}
