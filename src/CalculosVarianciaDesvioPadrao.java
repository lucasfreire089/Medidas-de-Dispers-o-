import java.util.Arrays;
import java.util.Scanner;

public class CalculosVarianciaDesvioPadrao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de dados:");
        int quantidadeNumeros = scanner.nextInt();

        double[] numeros = new double[quantidadeNumeros];

        System.out.println("Digite os dados:");
        for (int i = 0; i < quantidadeNumeros; i++) {
            numeros[i] = scanner.nextDouble();
        }

        CalculosVarianciaDesvioPadrao calculos = new CalculosVarianciaDesvioPadrao();
        calculos.ordenarNumeros(numeros);
        calculos.executarCalculos(numeros);

        scanner.close();
    }

    private void ordenarNumeros(double[] numeros) {
        Arrays.sort(numeros);
        System.out.println("Os números ordenados são: " + Arrays.toString(numeros));
    }

    public void executarCalculos(double[] numeros) {
      
        // Calcular e imprimir a média
        double media = calcularMedia(numeros);
        System.out.println("A média é: " + media);

        // Calcular e imprimir a mediana
        double mediana = calcularMediana(numeros);
        System.out.println("A mediana é: " + mediana);

        // Calcular e imprimir a variancia, desvio padrão e coeficiente de variação
        double resultadoVariancia = calcularVariancia(numeros, media);
        double desvioPadrao = Math.sqrt(resultadoVariancia);
        double coeficienteVariacao = (desvioPadrao / media) * 100;
        System.out.println("A variancia é: " + resultadoVariancia);
        System.out.println("O desvio padrão é: " + desvioPadrao);
        System.out.println("O coeficiente de variação é: " + coeficienteVariacao + "%");


        // Calcular e imprimir os quartis
        double primeiroQuartil = calcularQuartil(numeros, 0.25);
        double terceiroQuartil = calcularQuartil(numeros, 0.75);
        System.out.println("O primeiro quartil é: " + primeiroQuartil);
        System.out.println("O terceiro quartil é: " + terceiroQuartil);
    }

    private double calcularMedia(double[] numeros) {
        double somaTotal = 0;
        for (int i = 0; i < numeros.length; i++) {
            somaTotal += numeros[i];
        }
        return somaTotal / numeros.length;
    }

    private double calcularVariancia(double[] numeros, double media) {
        double somaNumeros = 0.0;
        for (int i = 0; i < numeros.length; i++) {
            somaNumeros += Math.pow(numeros[i] - media, 2);
        }
        return somaNumeros / (numeros.length - 1);
    }

    private double calcularMediana(double[] numeros) {
        int meio = numeros.length / 2;
        if (numeros.length % 2 == 0) {
            // Média dos dois valores do meio se o conjunto tem um número par de elementos
            return (numeros[meio - 1] + numeros[meio]) / 2.0;
        } else {
            // Valor do meio se o conjunto tem um número ímpar de elementos
            return numeros[meio];
        }
    }

    private double calcularQuartil(double[] numeros, double percentil) {
        double indice = (numeros.length) * percentil;
        if (indice % 1 == 0 || indice % 2 == 0) {
            return (numeros[(int) indice - 1] + numeros[(int) indice]) / 2;
        } else {
            return numeros[(int) indice];
        }
    }
}
