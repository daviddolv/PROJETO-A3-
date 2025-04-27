package imc;

public class ImcCalculator {

    public static double calcularImc(double peso, double altura) {
        if (peso <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Peso e altura devem ser maiores que zero.");
        }
        return peso / (altura * altura);
    }

    public static String classificarImc(double imc) {
        if (imc < 16) {
            return "Magreza grave";
        } else if (imc < 17) {
            return "Magreza moderada";
        } else if (imc < 18.5) {
            return "Magreza leve";
        } else if (imc < 25) {
            return "Saudável";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else if (imc < 35) {
            return "Obesidade Grave";
        } else if (imc < 40) {
            return "Obesidade Avançada";
        } else {
            return "Obesidade Extrema";
        }
    }
}
