package kiellen.tech.com.main;

import kiellen.tech.com.pessoas.Cliente;
import kiellen.tech.com.pessoas.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static List<Funcionario> funcionarios = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("==== MENU PRINCIPAL ====");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Funcionário");
            System.out.println("3. Reajustar Salário");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarCliente();
                    break;
                case "2":
                    cadastrarFuncionario();
                    break;
                case "3":
                    reajustarSalario();
                    break;
                case "4":
                    System.out.println("Saindo...");
                    running = false;
                    saiuMesmo();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void cadastrarFuncionario() {
        System.out.println("==== Cadastro de Funcionário ====");
        Funcionario funcionario = new Funcionario();
        funcionario.cadastrar();
        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
        System.out.println(funcionario);
    }

    private static void reajustarSalario() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado para reajustar salário.");
            return;
        }

        System.out.println("==== Reajuste Salarial ====");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do funcionário: ");
        String nomeParaReajuste = scanner.nextLine();

        Funcionario funcionarioEncontrado = null;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nomeParaReajuste)) {
                funcionarioEncontrado = funcionario;
                break;
            }
        }

        if (funcionarioEncontrado != null) {
            System.out.print("Digite o percentual de reajuste (exemplo: 10 para 10%): ");
            double percentual = scanner.nextDouble();
            scanner.nextLine();
            funcionarioEncontrado.reajustarSalario(percentual);
            System.out.println("Salário reajustado com sucesso!");
            System.out.println(funcionarioEncontrado);
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public static void cadastrarCliente() {
        System.out.println("==== Cadastro de Cliente ====");
        Cliente cliente = new Cliente();
        cliente.cadastrar();
        System.out.println("Cliente cadastrado com sucesso!");
        System.out.println(cliente);
    }

    public static void saiuMesmo() {
        System.out.println("Saiu mesmo!");
    }
}
