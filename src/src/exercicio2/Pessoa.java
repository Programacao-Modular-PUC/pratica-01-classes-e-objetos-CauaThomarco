package exercicio2;
/*
*
* @author cthomarco
 */
import java.util.Scanner;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;
    private double altura;
    private double peso;
    private double imc;

    public Pessoa() {}

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public double getImc() { return imc; }

    public void calculaIMC() {
        this.imc = getPeso() / Math.pow(getAltura(), 2);
    }

    public String informaObesidade() {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc <= 24.9) {
            return "Peso normal";
        } else if (imc <= 29.9) {
            return "Sobrepeso";
        } else if (imc <= 34.9) {
            return "Obesidade grau 1";
        } else if (imc <= 39.9) {
            return "Obesidade grau 2";
        } else {
            return "Obesidade grau 3";
        }
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();

        System.out.print("Nome: ");
        pessoa.setNome(leitor.next());

        System.out.print("Sobrenome: ");
        pessoa.setSobrenome(leitor.next());

        System.out.print("Idade: ");
        pessoa.setIdade(leitor.nextInt());

        System.out.print("Altura (m): ");
        pessoa.setAltura(leitor.nextDouble());

        System.out.print("Peso (kg): ");
        pessoa.setPeso(leitor.nextDouble());

        pessoa.calculaIMC();

        System.out.printf("%nIMC de %s %s: %.2f%n", pessoa.getNome(), pessoa.getSobrenome(), pessoa.getImc());
        System.out.println("Classificação: " + pessoa.informaObesidade());

        leitor.close();
    }
}