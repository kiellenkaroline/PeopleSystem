package kiellen.tech.com.pessoas;

import kiellen.tech.com.composicao.Cargo;
import kiellen.tech.com.composicao.Profissao;

import java.time.LocalDate;
import java.util.Scanner;

public class Funcionario extends Pessoa {
    private int matricula;
    private Profissao profissao;
    private LocalDate dataAdmissao;
    private double salario;

    public Funcionario() {
        super();
    }

    public Funcionario(String nome, int matricula, Profissao profissao, double salario) {
        this.nome = nome;
        this.matricula = matricula;
        this.profissao = profissao;
        this.salario = salario;
    }

    @Override
    public void cadastrar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do funcionário: ");
        this.setNome(scanner.nextLine());

        System.out.println("Digite a matrícula do funcionário: ");
        this.matricula = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite a profissão do funcionário (ex.: ENGENHEIRO, MEDICO, PROFESSOR): ");
        try {
            this.profissao = Profissao.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Profissão inválida. Certifique-se de usar uma das profissões válidas.");
            return;
        }

        System.out.println("Digite o salário do funcionário: ");
        this.salario = scanner.nextDouble();


    }

    @Override
    public String toString() {
        return "Funcionário {" +
                "Nome='" + getNome() + '\'' +
                ", Matrícula=" + matricula +
                ", Profissão=" + profissao +
                ", Salário=" + salario +
                '}';
    }


    public Profissao getProfissao() {

        return profissao;
    }

    public void setProfissao(Profissao profissao) {

        this.profissao = profissao;
    }

    public double getSalario() {

        return salario;
    }

    public void setSalario(double salario) {

        this.salario = salario;
    }

    public int getMatricula() {

        return matricula;
    }

    public void setMatricula(int matricula) {

        this.matricula = matricula;
    }

    public LocalDate getDataAdmissao() {

        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {

        this.dataAdmissao = dataAdmissao;
    }

    public void reajustarSalario(double percentual) {
        double valorReajuste = salario * (percentual / 100);
        salario += valorReajuste;}

    public void promover(Cargo novoCargo) {Cargo Cargo = novoCargo;
    }

    public void imprimirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Profissao:" + profissao);
        System.out.println("Salário: " + salario);


    }

}

