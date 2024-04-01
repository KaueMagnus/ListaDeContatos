import java.util.Scanner;
import agenda.Agenda;
import contato.Contato;

// Classe principal que contém o método main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Scanner para entrada de dados
        Agenda agenda = new Agenda();  // Cria uma nova agenda


        try {
            // Loop principal do programa
            while (true) {
                limpaTela();
                System.out.println("======LISTA DE CONTATOS======");
                System.out.println("1- Adicionar contato");
                System.out.println("2- Editar contato");
                System.out.println("3- Remover contato");
                System.out.println("4- Buscar contato pelo nome");
                System.out.println("5- Listar contatos");
                System.out.println("6- Sair");

                System.out.print("Escolha uma opção: ");
                int opcaoMenu = scanner.nextInt();  // Lê a opção do menu
                scanner.nextLine();  // Limpa o buffer do scanner

                // Switch case para as opções do menu
                switch (opcaoMenu) {
                    case 1:
                        limpaTela();
                        System.out.println("=====ADICIONAR CONTATO=====");
                        System.out.print("Nome do contato: ");
                        String nome = scanner.nextLine();

                        System.out.print("Numero do contato: ");
                        String numero = scanner.nextLine();

                        agenda.adicionarContato(new Contato(nome, numero));  // Adiciona o contato à agenda
                        System.out.println("CONTATO ADICIONADO!");
                        esperarTecla();  // Espera o usuário pressionar Enter
                        break;

                    case 2:  // Código para editar um contato
                        limpaTela();
                        System.out.println("=====EDITAR CONTATO=====");
                        System.out.print("Nome do contato a ser editado: ");
                        nome = scanner.nextLine();

                        Contato contatoEditado = agenda.buscarContato(nome);

                        if (contatoEditado != null) {
                            System.out.println("1- Editar nome.");
                            System.out.println("2- Editar numero.");
                            System.out.print("Opção desejada: ");
                            int opcaoEditar = scanner.nextInt();
                            scanner.nextLine();

                            switch (opcaoEditar) {
                                case 1:
                                    System.out.print("Novo nome: ");
                                    String novoNome = scanner.nextLine();
                                    contatoEditado.setNome(novoNome);
                                    System.out.println("NOME ALTERADO!");
                                    break;

                                case 2:
                                    System.out.print("Novo numero: ");
                                    String novoNumero = scanner.nextLine();
                                    contatoEditado.setNumero(novoNumero);
                                    System.out.println("NUMERO ALTERADO!");
                                    break;

                                default:
                                    System.out.println("Opção inválida! Tente novamente");
                            }
                        } else {
                            System.out.println("Contato não encontrado!");
                        }
                        esperarTecla();
                        break;

                    case 3:  // Código para remover um contato
                        limpaTela();
                        System.out.println("=====REMOVER CONTATO=====");
                        System.out.print("Nome do contato a ser removido: ");
                        nome = scanner.nextLine();

                        if (agenda.removerContato(nome)) {
                            System.out.printf("\n%s foi removido!", nome);
                        } else {
                            System.out.println("Contato não encontrado!");
                        }
                        esperarTecla();
                        break;

                    case 4:  // Código para buscar um contato
                        limpaTela();
                        System.out.println("=====BUSCAR CONTATO=====");
                        System.out.print("Nome do contato a ser buscado: ");
                        nome = scanner.nextLine();

                        Contato contatoBuscado = agenda.buscarContato(nome);

                        if (contatoBuscado != null) {
                            System.out.println("Contato encontrado: " + contatoBuscado);
                        } else {
                            System.out.println("Contato não encontrado!");
                        }
                        esperarTecla();
                        break;

                    case 5:  // Código para listar contatos
                        limpaTela();
                        System.out.println("=====LISTAR CONTATOS=====");
                        System.out.println("Lista de contatos:");
                        int indice = 1;

                        for (Contato contato : agenda.listarContatos()) {
                            System.out.println(indice + "- " + contato);
                            indice++;
                        }
                        esperarTecla();
                        break;

                    case 6:  // Encerra o programa
                        limpaTela();
                        System.out.println("Encerrando o programa...");
                        return;

                    default:
                        limpaTela();
                        System.out.println("Opção inválida! Tente novamente.");
                }
            }
        } finally {
            limpaTela();
            scanner.close();  // Fecha o scanner ao finalizar o programa
        }
    }

    // Método para limpar a tela do console
    public static void limpaTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.out.println("Erro ao limpar o console: " + e.getMessage());
        }
    }

    // Método para esperar o usuário pressionar Enter
    public static void esperarTecla() {
        System.out.println("Pressione Enter para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Aguarda o usuário pressionar Enter
    }
}

