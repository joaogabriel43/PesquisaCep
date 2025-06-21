package Principal;

import Classes.ConsultaApi;
import Classes.Endereco;
import Classes.GeradorArquivo;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principal da aplicação, responsável por interagir com o usuário.
 * Apresenta um menu de opções para consultar, listar e excluir CEPs.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConsultaApi consultaApi = new ConsultaApi();
        GeradorArquivo gerador = new GeradorArquivo();

        while (true) {
            System.out.println("\n################################################");
            System.out.println("###           CONSULTA DE CEP                ###");
            System.out.println("################################################");
            System.out.println("\n### Menu de Opções ###");
            System.out.println("1. Consultar novo CEP");
            System.out.println("2. Listar CEPs salvos");
            System.out.println("3. Excluir CEP salvo");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = sc.nextLine();

            try {
                switch (opcao) {
                    case "1":
                        System.out.print("Digite o CEP que deseja pesquisar (apenas números): ");
                        String cep = sc.nextLine();

                        // Validação simples para o formato do CEP
                        if (!cep.matches("\\d{8}")) {
                            System.out.println("Formato de CEP inválido. Por favor, digite 8 números.");
                            continue;
                        }

                        Endereco novoEndereco = consultaApi.buscaEndereco(cep);
                        List<Endereco> enderecos = gerador.carregarEnderecos();
                        enderecos.add(novoEndereco);
                        gerador.salvarEnderecos(enderecos);
                        System.out.println("CEP consultado e salvo com sucesso!");
                        System.out.println(novoEndereco);
                        break;
                    case "2":
                        listarEnderecosSalvos(gerador);
                        break;
                    case "3":
                        List<Endereco> enderecosParaExcluir = gerador.carregarEnderecos();
                        if (enderecosParaExcluir.isEmpty()) {
                            System.out.println("Nenhum CEP para excluir.");
                            break;
                        }
                        listarEnderecosSalvos(gerador); // Reutiliza o método de listagem
                        System.out.print("Digite o ID do CEP que deseja excluir: ");
                        try {
                            int idParaExcluir = Integer.parseInt(sc.nextLine());
                            if (idParaExcluir > 0 && idParaExcluir <= enderecosParaExcluir.size()) {
                                enderecosParaExcluir.remove(idParaExcluir - 1);
                                gerador.salvarEnderecos(enderecosParaExcluir);
                                System.out.println("CEP excluído com sucesso!");
                            } else {
                                System.out.println("ID inválido.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. Por favor, digite um número.");
                        }
                        break;
                    case "4":
                        System.out.println("Finalizando a aplicação.");
                        sc.close();
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (RuntimeException | IOException e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    }

    /**
     * Lista os endereços salvos no arquivo JSON.
     *
     * @param gerador A instância de GeradorArquivo para carregar os endereços.
     * @throws IOException Se ocorrer um erro ao ler o arquivo.
     */
    private static void listarEnderecosSalvos(GeradorArquivo gerador) throws IOException {
        List<Endereco> enderecosSalvos = gerador.carregarEnderecos();
        if (enderecosSalvos.isEmpty()) {
            System.out.println("Nenhum CEP salvo ainda.");
        } else {
            System.out.println("\n--- CEPs Salvos ---");
            for (int i = 0; i < enderecosSalvos.size(); i++) {
                System.out.println("ID: " + (i + 1) + " | " + enderecosSalvos.get(i));
            }
            System.out.println("-------------------");
        }
    }
}