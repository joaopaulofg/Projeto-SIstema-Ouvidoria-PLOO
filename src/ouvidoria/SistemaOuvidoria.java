package ouvidoria;

import java.util.*;

public class SistemaOuvidoria {
    private final List<Manifestacao> manifestacoes;
    private final ManifestacaoDAO manifestacaoDAO;
    private final Map<Integer, String> tiposManifestacao;

    public SistemaOuvidoria() {
        this.manifestacoes = new ArrayList<>();
        this.manifestacaoDAO = new ManifestacaoDAO();
        this.tiposManifestacao = new HashMap<>();
        this.tiposManifestacao.put(1, "Reclamação");
        this.tiposManifestacao.put(2, "Sugestão");
        this.tiposManifestacao.put(3, "Elogio");
    }

    public void listarManifestacoes() {
        List<Manifestacao> manifestacoesCadastradas = manifestacaoDAO.listarTodasAsManifestacoes();

        for(Manifestacao manifestacao : manifestacoesCadastradas){
            System.out.println("\nManifestação ID #" + manifestacao.getIdManifestacao() +
            "\nTipo Manifestação: " + manifestacao.getTipoManifestacao() +
            "\nManifestante: " + manifestacao.getNomeManifestante() +
            "\nRelato: " + manifestacao.getTextoManifestacao());
        }
    }

    public void listarManifestacoesPorTipo(int tipoManifestacao) {
        String tipoStr = tiposManifestacao.get(tipoManifestacao);
        List<Manifestacao> manifestacoesCadastradas = manifestacaoDAO.listarManifestacoesPorTipo(tipoStr);

        for(Manifestacao manifestacao : manifestacoesCadastradas){
            System.out.println("\nManifestação ID #" + manifestacao.getIdManifestacao() +
                    "\nTipo Manifestação: " + manifestacao.getTipoManifestacao() +
                    "\nManifestante: " + manifestacao.getNomeManifestante() +
                    "\nRelato: " + manifestacao.getTextoManifestacao());
        }
    }

    public void criarManifestacao(int tipoManifestacao, String nomeManifestante, String descricao) {
        String tipoStr = tiposManifestacao.get(tipoManifestacao);
        if(tipoStr == null) {
            System.out.println("\nTipo de manifestação selecionado é inválido.");
            return;
        }
        Manifestacao manifestacao = new Manifestacao(tipoStr, nomeManifestante, descricao);
        manifestacaoDAO.criarManifestacao(manifestacao);
        System.out.println("\nManifestação cadastrada com sucesso!");
    }

    public void exibirQuantidadeDeManifestacoes() {
        if(manifestacoes.isEmpty()) {
            System.out.println("\nNão há manifestações cadastradas.");
        } else {
            System.out.println("\nQuantidade de manifestações cadastradas: " + manifestacoes.size());
        }
    }

    public void buscarManifestacaoPorId(int idProcurado) {
        for(Manifestacao manifestacao : manifestacoes) {
            if(manifestacao.getIdManifestacao() == idProcurado) {
                System.out.println(manifestacao.toString());
                break;
            }
        }
        System.out.println("\nNenhuma manifestação cadastrada com o ID informado.");
    }

    public void excluirManifestacaoPorId(int idExclusao) {
        for(Manifestacao manifestacao : manifestacoes) {
            if(manifestacao.getIdManifestacao() == idExclusao) {
                manifestacoes.remove(manifestacao);
                System.out.println("\nManifestação excluída com sucesso!");
                return;
            }
        }
        System.out.println("\nManifestação não encontrada...");
    }

    public static void main(String[] args) {
        SistemaOuvidoria ouvidoria = new SistemaOuvidoria();
        Scanner sc = new Scanner(System.in);

        System.out.println("### Bem-vindo ao sistema de Ouvidoria! ###");

        while(true){
            System.out.println("""

                    Selecione uma opção:

                    1) Listagem das manifestações
                    2) Listagem de manifestações por tipo
                    3) Criar uma nova manifestação
                    4) Exibir quantidade de manifestações
                    5) Pesquisar uma manifestação por código
                    6) Excluir uma manifestação pelo código
                    7) Sair do sistema
                    """);

            int opcaoMenu = sc.nextInt();
            sc.nextLine();

            switch (opcaoMenu){
                case 1:
                    ouvidoria.listarManifestacoes();
                    System.out.println("\nPressione qualquer tecla para continuar...");
                    sc.nextLine();
                    break;
                case 2:
                    System.out.println("""
                            
                            Informe o tipo de manifestação que deseja listar:
                            1 - Reclamação
                            2 - Sugestão
                            3 - Elogio
                            """);
                    int tipoListagem = sc.nextInt();
                    sc.nextLine();
                    ouvidoria.listarManifestacoesPorTipo(tipoListagem);

                    System.out.println("\nPressione qualquer tecla para continuar...");
                    sc.nextLine();
                    break;
                case 3:
                    System.out.println("""
                            
                            Informe o tipo de manifestação que deseja cadastrar:
                            1 - Reclamação
                            2 - Sugestão
                            3 - Elogio
                            """);
                    int tipoManifestacao = sc.nextInt();
                    sc.nextLine();
                    System.out.println("\nInforme o seu nome: ");
                    String manifestante = sc.nextLine();
                    System.out.println("\nInforme a descrição da sua manifestação: ");
                    String descricao = sc.nextLine();
                    ouvidoria.criarManifestacao(tipoManifestacao, manifestante, descricao);

                    System.out.println("\nPressione qualquer tecla para continuar...");
                    sc.nextLine();
                    break;
                case 4:
                    ouvidoria.exibirQuantidadeDeManifestacoes();

                    System.out.println("\nPressione qualquer tecla para continuar...");
                    sc.nextLine();
                    break;
                case 5:
                    System.out.println("\nInsira o ID da manifestação que deseja buscar: ");
                    int idManifestacaoProcurada = sc.nextInt();
                    sc.nextLine();
                    ouvidoria.buscarManifestacaoPorId(idManifestacaoProcurada);

                    System.out.println("\nPressione qualquer tecla para continuar...");
                    sc.nextLine();
                    break;
                case 6:
                    System.out.println("\nInsira o ID da manifestação que deseja excluir: ");
                    int idExclusao = sc.nextInt();
                    sc.nextLine();
                    ouvidoria.excluirManifestacaoPorId(idExclusao);

                    System.out.println("\nPressione qualquer tecla para continuar...");
                    sc.nextLine();
                    break;
                case 7:
                    System.out.println("Obrigado por usar nosso sistema de Ouvidoria");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }

        }

    }

}
