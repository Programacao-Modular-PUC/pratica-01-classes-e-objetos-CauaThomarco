package parte2;

/*
 * @author cthomarco
 */
import java.util.Scanner;
import java.util.Calendar;

class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() { return dia; }
    public void setDia(int dia) { this.dia = dia; }

    public int getMes() { return mes; }
    public void setMes(int mes) { this.mes = mes; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }
}

public class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;
    private double altura;
    private double peso;
    private double imc;
    private Data dataNascimento;

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

    public Data getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(Data dataNascimento) { this.dataNascimento = dataNascimento; }

    public void calculaIMC() {
        this.imc = getPeso() / Math.pow(getAltura(), 2);
    }

    public int calculaIdade(Data dataNasc) {
        Calendar hoje = Calendar.getInstance();
        int anoAtual = hoje.get(Calendar.YEAR);
        int mesAtual = hoje.get(Calendar.MONTH) + 1;
        int diaAtual = hoje.get(Calendar.DAY_OF_MONTH);

        int idade = anoAtual - dataNasc.getAno();

        if (mesAtual < dataNasc.getMes() ||
                (mesAtual == dataNasc.getMes() && diaAtual < dataNasc.getDia())) {
            idade--;
        }
        return idade;
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
        Pessoa[] pessoas = new Pessoa[10];
        int total = 0;

        for (int i = 0; i < 10; i++) {
            pessoas[i] = new Pessoa();

            System.out.println("\n--- Cadastro " + (i + 1) + " ---");
            if (i > 0) {
                System.out.println("(Digite o mesmo nome+sobrenome do cadastro anterior para encerrar)");
            }

            System.out.print("Nome: ");
            pessoas[i].setNome(leitor.nextLine().trim());

            System.out.print("Sobrenome: ");
            pessoas[i].setSobrenome(leitor.nextLine().trim());

            // Verifica condição de parada ANTES de pedir os demais dados
            if (i > 0) {
                String nomeAtual    = pessoas[i].getNome() + pessoas[i].getSobrenome();
                String nomeAnterior = pessoas[i - 1].getNome() + pessoas[i - 1].getSobrenome();
                if (nomeAtual.equalsIgnoreCase(nomeAnterior)) {
                    break;
                }
            }

            System.out.print("Data de nascimento (dd/mm/aaaa): ");
            String dataStr = leitor.nextLine().trim();
            String[] partes = dataStr.split("/");
            Data dataNasc = new Data(
                    Integer.parseInt(partes[0]),
                    Integer.parseInt(partes[1]),
                    Integer.parseInt(partes[2])
            );
            pessoas[i].setDataNascimento(dataNasc);
            pessoas[i].setIdade(pessoas[i].calculaIdade(dataNasc));

            System.out.print("Altura (m): ");
            pessoas[i].setAltura(Double.parseDouble(leitor.nextLine().trim().replace(",", ".")));

            System.out.print("Peso (kg): ");
            pessoas[i].setPeso(Double.parseDouble(leitor.nextLine().trim().replace(",", ".")));

            pessoas[i].calculaIMC();
            total++;
        }

        System.out.println("\n========== DADOS CADASTRADOS ==========");
        for (int i = 0; i < total; i++) {
            Pessoa p = pessoas[i];
            System.out.println("\nCadastro " + (i + 1) + ":");
            System.out.println("Nome completo: " + p.getNome() + " " + p.getSobrenome());
            System.out.println("Nome de referência: " + p.getSobrenome() + ", " + p.getNome().toUpperCase());
            System.out.println("Idade: " + p.getIdade());
            System.out.printf("Peso: %.1f%n", p.getPeso());
            System.out.printf("Altura: %.2f%n", p.getAltura());
            System.out.printf("IMC: %.2f%n", p.getImc());
            System.out.println("Classificação: " + p.informaObesidade());
        }

        leitor.close();
    }
}