import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Leitura do arquivo entrada1.txt
        ArrayList<Avaliavel> listaEntidades1 = lerArquivo1("entrada1.txt");

        // Manipulação dos objetos do primeiro ArrayList
        int contagemJogos = contarJogos(listaEntidades1);

        // Escrita do resultado no arquivo resultado1.txt
        escreverArquivo("resultado1.txt", "Quantidade de jogos na lista: " + contagemJogos);

        // Leitura do arquivo entrada2.txt
        ArrayList<Identificavel> listaEntidades2 = lerArquivo2("entrada2.txt");

        // Manipulação dos objetos do segundo ArrayList
        double somaChat = somarMensagensChat(listaEntidades2);

        // Escrita do resultado no arquivo resultado2.txt
        escreverArquivo("resultado2.txt", "Soma das avaliações dos chats: " + somaChat);
    }

    public static ArrayList<Avaliavel> lerArquivo1(String nomeArquivo) {
        ArrayList<Avaliavel> listaEntidades = new ArrayList<>();

        try {
            File arquivo = new File(nomeArquivo);
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNext()) {
                String tipoEntidade = scanner.nextLine();

                switch (tipoEntidade) {
                    case "#Jogo":
                        String nomeJogo = scanner.nextLine().split(": ")[1];
                        double precoJogo = Double.parseDouble(scanner.nextLine().split(": ")[1]);
                        int anoLancamentoJogo = Integer.parseInt(scanner.nextLine().split(": ")[1]);
                        double avaliacaoJogo = Double.parseDouble(scanner.nextLine().split(": ")[1]);
                        String descricaoJogo = scanner.nextLine().split(": ")[1];
                        String classificacaoJogo = scanner.nextLine().split(": ")[1];
                        String plataformaJogo = scanner.nextLine().split(": ")[1];

                        listaEntidades.add(new Jogo(nomeJogo, precoJogo, anoLancamentoJogo, avaliacaoJogo,
                                descricaoJogo, classificacaoJogo, plataformaJogo));
                        break;

                    case "#Assinatura":
                        String planoAssinatura = scanner.nextLine().split(": ")[1];
                        double precoAssinatura = Double.parseDouble(scanner.nextLine().split(": ")[1]);
                        String duracaoAssinatura = scanner.nextLine().split(": ")[1];
                        String beneficiosAssinatura = scanner.nextLine().split(": ")[1];

                        listaEntidades.add(new Assinatura(planoAssinatura, precoAssinatura, duracaoAssinatura,
                                beneficiosAssinatura));
                        break;
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
            e.printStackTrace();
        }

        return listaEntidades;
    }

    public static ArrayList<Identificavel> lerArquivo2(String nomeArquivo) {
        ArrayList<Identificavel> listaEntidades = new ArrayList<>();

        try {
            File arquivo = new File(nomeArquivo);
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNext()) {
                String tipoEntidade = scanner.nextLine();

                switch (tipoEntidade) {
                    case "#Cliente":
                        String nomeCliente = scanner.nextLine().split(": ")[1];
                        String cpfCliente = scanner.nextLine().split(": ")[1];
                        String emailCliente = scanner.nextLine().split(": ")[1];
                        String enderecoCliente = scanner.nextLine().split(": ")[1];
                        listaEntidades.add(new Cliente(nomeCliente, cpfCliente, emailCliente, enderecoCliente));
                        break;

                    case "#Chat":
                        String nomeClienteChat = scanner.nextLine().split(": ")[1];
                        String dataHoraChat = scanner.nextLine().split(": ")[1];
                        String mensagemChat = scanner.nextLine().split(": ")[1];

                        listaEntidades.add(new Chat(nomeClienteChat, dataHoraChat, mensagemChat));
                        break;
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
            e.printStackTrace();
        }

        return listaEntidades;
    }

    public static int contarJogos(ArrayList<Avaliavel> listaEntidades) {
        int contagem = 0;

        for (Avaliavel entidade : listaEntidades) {
            if (entidade instanceof Jogo) {
                contagem++;
            }
        }

        return contagem;
    }

    public static double somarMensagensChat(ArrayList<Identificavel> listaEntidades) {
        double soma = 0;

        for (Identificavel entidade : listaEntidades) {
            if (entidade instanceof Chat) {
                soma += ((Chat) entidade).getAvaliacao();
            }
        }

        return soma;
    }

    public static void escreverArquivo(String nomeArquivo, String texto) {
        try {
            PrintWriter writer = new PrintWriter(nomeArquivo);
            writer.println(texto);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao escrever no arquivo!");
            e.printStackTrace();
        }
    }
}
