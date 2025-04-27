package imc;

import java.util.Locale;
import javax.swing.JOptionPane;

/**
 * Linha responsável pelo cálculo e classificação do IMC.
 */
public class ImcApp {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try {
            // Solicitação do peso e da altura ao usuário
            String pesoInput = JOptionPane.showInputDialog(null, "Digite seu peso (kg):");
            double peso = parseInput(pesoInput);

            String alturaInput = JOptionPane.showInputDialog(null, "Digite sua altura (m):");
            double altura = parseInput(alturaInput);

            // Calcula o IMC e classifica
            double imc = ImcCalculator.calcularImc(peso, altura);
            String classificacao = ImcCalculator.classificarImc(imc);

            // Mostra o IMC e sua classificação
            String mensagem = String.format("Seu IMC é: %.2f\nClassificação: %s", imc, classificacao);
            JOptionPane.showMessageDialog(null, mensagem);

        } catch (IllegalArgumentException e) {
            // Exibição de mensagem de erro caso o usuário insira dados inválidos
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     * Converte a entrada do usuário para um número decimal, considerando a vírgula.
     * 
     * @param input A entrada como String.
     * 
     * @return O valor convertido para double.
     * 
     * @throws IllegalArgumentException Se a entrada não for um número válido.
     */
    private static double parseInput(String input) {
        try {
            // Realiza a substituição da vírgula por ponto para garantir a compatibilidade
            // na conversão para double.
            String normalizedInput = input.replace(",", ".");
            return Double.parseDouble(normalizedInput);
        } catch (NumberFormatException e) {
            // Dispara uma exceção se o valor inserido for inválido.
            throw new IllegalArgumentException("Entrada inválida. Use apenas números.");
        }
    }
}
