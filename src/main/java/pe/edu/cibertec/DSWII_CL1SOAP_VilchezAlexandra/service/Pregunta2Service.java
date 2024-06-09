package pe.edu.cibertec.DSWII_CL1SOAP_VilchezAlexandra.service;

import org.springframework.stereotype.Service;

@Service
public class Pregunta2Service {

    public boolean calcularJubilacion(int edad, String sexo) {
        if (!sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("F")) {
            throw new IllegalArgumentException("Sexo inválido. Debe ser 'M' o 'F'.");
        }
        int resultado = sexo.equalsIgnoreCase("M") ? 60 : 54;
        return edad >= resultado;
    }

    private static final double PrecioUnitario = 520.0;
    private static final double Descuento = 0.10;
    public double calcularMatricula(int numMaterias) {
        if (numMaterias < 0) {
            throw new IllegalArgumentException("El número de materias no puede ser negativo.");
        }
        double precio = numMaterias * PrecioUnitario;
        if (numMaterias > 5) {
            precio -= precio * Descuento;
        }
        return precio;
    }

    public int calcularMenor(int... numeros) {
        if (numeros.length == 0) {
            throw new IllegalArgumentException("Debe proporcionar al menos un número.");
        }
        int numMenor = numeros[0];
        for (int num : numeros) {
            if (num < numMenor) {
                numMenor = num;
            }
        }
        return numMenor;
    }

    public double calcularUtilidades(double salario, int tiempo) {
        if (salario < 0 || tiempo < 0) {
            throw new IllegalArgumentException("Los valores ingresados son inválidos. Deben ser mayores o iguales a cero.");
        }
        double utilidades = 0;
        if (tiempo < 1) {
            utilidades = salario * 0.05;
        } else if (tiempo >= 1 && tiempo < 2) {
            utilidades = salario * 0.07;
        } else if (tiempo >= 2 && tiempo < 5) {
            utilidades = salario * 0.10;
        } else if (tiempo >= 5 && tiempo < 10) {
            utilidades = salario * 0.15;
        } else if (tiempo >= 10) {
            utilidades = salario * 0.20;
        }
        return utilidades;
    }

    public int calcularSuma() {
        int suma = 0;
        for (int numero = 9; numero <= 45; numero++) {
            if (esMultiplo(numero, 3) || esMultiplo(numero, 7)) {
                suma += numero;
            }
        }
        return suma;
    }
    private boolean esMultiplo(int numero, int divisor) {
        if (numero < 1 || divisor < 1) {
            System.out.println("Número o divisor inválido. Ambos deben ser mayores o iguales a 1.");
            return false;
        }
        return numero % divisor == 0;
    }
}