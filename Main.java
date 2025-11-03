import java.util.Scanner;
import controllers.SistemaAeroporto;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaAeroporto sistema = new SistemaAeroporto();

        // ===== VOOS NACIONAIS =====
        sistema.adicionarVoo("1234", "São Paulo", "Rio de Janeiro", "10:00", "11:00", 2, false);
        sistema.adicionarVoo("5678", "Curitiba", "Salvador", "14:00", "17:00", 3, false);
        sistema.adicionarVoo("9012", "Brasília", "Fortaleza", "09:30", "12:00", 4, false);

        // ===== VOOS INTERNACIONAIS =====
        sistema.adicionarVoo("2001", "São Paulo", "Nova York (EUA)", "22:00", "06:00", 5, true);
        sistema.adicionarVoo("2002", "Rio de Janeiro", "Paris (França)", "19:30", "10:00", 4, true);
        sistema.adicionarVoo("2003", "Brasília", "Londres (Reino Unido)", "21:00", "11:15", 5, true);

        int opcao;
        do {
            System.out.println("\n===== SISTEMA DE CONTROLE DE AEROPORTO =====");
            System.out.println("1 - Listar todos os voos");
            System.out.println("2 - Reservar voo");
            System.out.println("3 - Processar reservas (admin)");
            System.out.println("4 - Realizar check-in");
            System.out.println("5 - Exibir informações de voos");
            System.out.println("6 - Listar apenas voos internacionais 🌍");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> sistema.listarVoos();
                case 2 -> {
                    System.out.print("Número do voo: ");
                    String numero = sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Idade: ");
                    int idade = Integer.parseInt(sc.nextLine());
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    sistema.reservarVoo(numero, nome, idade, cpf, email);
                }
                case 3 -> sistema.processarReservas();
                case 4 -> {
                    System.out.print("CPF do passageiro: ");
                    String cpfCheckin = sc.nextLine();
                    sistema.realizarCheckin(cpfCheckin);
                }
                case 5 -> sistema.exibirVoos();
                case 6 -> sistema.listarVoosInternacionais();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
