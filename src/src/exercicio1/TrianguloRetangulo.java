package exercicio1;

/*
*
* @author cthomarco
 */

import java.util.Scanner;

public class TrianguloRetangulo {
    private double h;
    private double c1;
    private double c2;

    public TrianguloRetangulo(double c1, double c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public double calculaHipotenusa() {
        this.h = Math.sqrt(Math.pow(c1, 2) + Math.pow(c2, 2));
        return this.h;
    }

    public double calculaArea() {
        return (c1 * c2) / 2;
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o valor do cateto c1: ");
        double c1 = leitor.nextDouble();

        System.out.print("Digite o valor do cateto c2: ");
        double c2 = leitor.nextDouble();

        TrianguloRetangulo triangulo = new TrianguloRetangulo(c1, c2);

        System.out.printf("Hipotenusa: %.2f%n", triangulo.calculaHipotenusa());
        System.out.printf("Área do triângulo: %.2f", triangulo.calculaArea());

        leitor.close();
    }
}