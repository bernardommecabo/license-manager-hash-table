package main;

import controller.LicenseController;
import model.License;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite sua matrícula: ");
        String matricula = scanner.nextLine().trim();

        LicenseController controller = new LicenseController(matricula);

        controller.generateLicences(1000);
        System.out.println("\n✅ 1000 licenças geradas e inseridas na tabela hash!");

        int opcao;
        do {
            System.out.println("\n===== MENU LICENÇAS =====");
            System.out.println("1 - Mostrar tabela");
            System.out.println("2 - Consultar licença");
            System.out.println("3 - Remover licença");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    controller.listLicences();
                    break;
                case 2:
                    System.out.print("Informe o ID da licença: ");
                    int idConsulta = scanner.nextInt();
                    License lic = controller.getLicence(idConsulta);
                    if (lic != null) {
                        System.out.println("✔ Licença encontrada: ID " + lic.getId() + " | Ativa: " + lic.isActive());
                    } else {
                        System.out.println("✘ Licença não encontrada.");
                    }
                    break;
                case 3:
                    System.out.print("Informe o ID da licença a remover: ");
                    int idRemover = scanner.nextInt();
                    boolean removida = controller.removeLicence(idRemover);
                    System.out.println(removida ? "✔ Licença removida com sucesso." : "✘ Licença não encontrada.");
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
