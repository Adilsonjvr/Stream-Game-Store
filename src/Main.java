import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    // Leitura dos dados presentes no arquivo "entrada1.txt" e criação do ArrayList de objetos
    ArrayList<String> itensLoja1 = new ArrayList<String>();
    try {
        File arquivo = new File("entrada1.txt");
        Scanner scanner = new Scanner(arquivo);
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine().trim();

            if (linha.startsWith("#Jogo")) {
                String titulo = null;
                double preco = 0;
                String descricao = null;
                int classificacao = 0;
                String plataforma = null;

                while (scanner.hasNextLine()) {
                    linha = scanner.nextLine().trim();

                    if (linha.startsWith("titulo:")) {
                        titulo = linha.substring(7).trim();
                    } else if (linha.startsWith("preco:")) {
                        preco = Double.parseDouble(linha.substring(6).trim());
                    } else if (linha.startsWith("descricao:")) {
                        descricao = linha.substring(10).trim();
                    } else if (linha.startsWith("classificacao:")) {
                        classificacao = Integer.parseInt(linha.substring(14).trim());
                    } else if (linha.startsWith("plataforma:")) {
                        plataforma = linha.substring(11).trim();
                    } else if (linha.isEmpty()) {
                        break;
                    }
                }

                itensLoja1.add(new Jogo(titulo, preco, descricao, classificacao, plataforma));
            } else if (linha.startsWith("#Assinatura")) {
                String plano = null;
                double preco = 0;
                String duracao = null;
                String beneficios = null;

                while (scanner.hasNextLine()) {
                    linha = scanner.nextLine().trim();

                    if (linha.startsWith("plano:")) {
                        plano = linha.substring(6).trim();
                    } else if (linha.startsWith("preco:")) {
                        preco = Double.parseDouble(linha.substring(6).trim());
                    } else if (linha.startsWith("duracao:")) {
                        duracao = linha.substring(8).trim();
                    } else if (linha.startsWith("beneficios:")) {
                        beneficios = linha.substring(11).trim();
                    } else if (linha.isEmpty()) {
                        break;
                    }
                }

                itensLoja1.add(new Assinatura(plano, preco, duracao, beneficios));
            }
        }

        scanner.close();
    } catch (FileNotFoundException e) {
        System.out.println("Arquivo 'entrada1.txt' não encontrado.");
    }

    // Manipulação dos objetos do ArrayList com um algoritmo de livre escolha (no caso, somatório dos preços dos jogos)
    double somaPrecosAssinaturas = 0;
    int contadorAssinaturas = 0;
    for (String item : itensLoja1) {
        if (item instanceof Assinatura) {
            somaPrecosAssinaturas += item.getPreco();
            contadorAssinaturas++;
        }
    }
    double mediaPrecosAssinaturas = somaPrecosAssinaturas / contadorAssinaturas;
    double totalPrecosAssinaturas = somaPrecosAssinaturas;
    

    // Escrita da saída no arquivo "resultado1.txt"
    try {
        File arquivo = new File("resultado1.txt");
        PrintWriter printWriter = new PrintWriter(arquivo);

       // Escreve a média de preços dos jogos no arquivo de saída
        printWriter.println(String.format("Média de preços dos jogos: R$ %.2f", mediaPrecosJogos));
        printWriter.println();

    // Escreve os dados dos itens presentes no ArrayList de objetos no arquivo de saída
    for (String item : itensLoja1) {
        if (item instanceof Jogo) {
            printWriter.println("#Jogo");
            printWriter.println("titulo: " + item.getTitulo());
            printWriter.println("preco: " + item.getPreco());
            printWriter.println("descricao: " + item.getDescricao());
            printWriter.println("classificacao: " + ((Jogo) item).getClassificacao());
            printWriter.println("plataforma: " + ((Jogo) item).getPlataforma());
            printWriter.println();
        } else if (item instanceof Assinatura) {
            printWriter.println("#Assinatura");
            printWriter.println("plano: " + item.getTitulo());
            printWriter.println("preco: " + item.getPreco());
            printWriter.println("duracao: " + ((Assinatura) item).getDuracao());
            printWriter.println("beneficios: " + ((Assinatura) item).getBeneficios());
            printWriter.println();
        }
    }

    printWriter.close(); 

    } catch (FileNotFoundException e) {
        System.out.println("Erro ao escrever no arquivo 'resultado1.txt'.");
    }

    // Leitura dos dados presentes no arquivo "entrada2.txt" e criação do ArrayList de objetos
    ArrayList<ItemLoja> itensLoja2 = new ArrayList<ItemLoja>();
    try {
    File arquivo = new File("entrada2.txt");
    Scanner scanner = new Scanner(arquivo);
    while (scanner.hasNextLine()) {
        String linha = scanner.nextLine().trim();

    if (linha.startsWith("#Cliente")) {
        String nome = null;
        String cpf = null;
        String email = null;
        String endereco = null;
        String telefone = null;

        while (scanner.hasNextLine()) {
            linha = scanner.nextLine().trim();

            if (linha.startsWith("nome:")) {
                nome = linha.substring(5).trim();
            } else if (linha.startsWith("cpf:")) {
                cpf = linha.substring(4).trim();
            } else if (linha.startsWith("email:")) {
                email = linha.substring(6).trim();
            } else if (linha.startsWith("endereco:")) {
                endereco = linha.substring(9).trim();
            } else if (linha.startsWith("telefone:")) {
                telefone = linha.substring(9).trim();
            } else if (linha.isEmpty()) {
                break;
            }
        }

        itensLoja2.add(new Cliente(nome, cpf, email, endereco, telefone));
    } else if (linha.startsWith("#Chat")) {
        String cliente = null;
        String email = null;
        String mensagem = null;
        Date dataHora = null;

        while (scanner.hasNextLine()) {
            linha = scanner.nextLine().trim();

            if (linha.startsWith("#Cliente")) {
                String nome = null;
                String cpf = null;
                String email = null;
                String endereco = null;
                String telefone = null;

                while (scanner.hasNextLine()) {
                    linha = scanner.nextLine().trim();

                    if (linha.startsWith("nome:")) {
                        nome = linha.substring(5).trim();
                    } else if (linha.startsWith("cpf:")) {
                        cpf = linha.substring(4).trim();
                    } else if (linha.startsWith("email:")) {
                        email = linha.substring(6).trim();
                    } else if (linha.startsWith("endereco:")) {
                        endereco = linha.substring(9).trim();
                    } else if (linha.startsWith("telefone:")) {
                        telefone = linha.substring(9).trim();
                    } else if (linha.isEmpty()) {
                        break;
                    }
                }

        itensLoja2.add(new Cliente(nome, cpf, email, endereco, telefone));
        } else if (linha.startsWith("#Chat")) {
            String cliente = null;
            String email = null;
            String mensagem = null;
            Date dataHora = null;

            while (scanner.hasNextLine()) {
                linha = scanner.nextLine().trim();
                if (linha.startsWith("cliente:")) {
                    cliente = linha.substring(linha.indexOf(":") + 1).trim();
            } else if (linha.startsWith("email:")) {
                email = linha.substring(linha.indexOf(":") + 1).trim();
            } else if (linha.startsWith("mensagem:")) {
                mensagem = linha.substring(linha.indexOf(":") + 1).trim();
            } else if (linha.startsWith("datahora:")) {
                String dataHoraString = linha.substring(linha.indexOf(":") + 1).trim();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy 'ás' HH:mm");
                try {
                    dataHora = format.parse(dataHoraString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else if (linha.startsWith("#")) {
                // Chegou ao próximo objeto, armazenando chat anterior
                Chat chat = new Chat(cliente, email, mensagem, dataHora);
                itensLoja2.add(chat);
                break;
            }
    // Executando o algoritmo de ordenação por data e escrevendo a saída no arquivo "resultado2.txt"
        Collections.sort(itensLoja2, new Comparator<Object>() {

        @Override
        public int compare(Object o1, Object o2) {
            if (o1 instanceof Chat && o2 instanceof Chat) {
                Chat chat1 = (Chat) o1;
                Chat chat2 = (Chat) o2;
                return chat1.getDataHora().compareTo(chat2.getDataHora());
            }
            return 0;
        }
    });

    try {
        PrintWriter writer = new PrintWriter("resultado2.txt", "UTF-8");
        for (Object item : itensLoja2) {
            if (item instanceof Chat) {
                Chat chat = (Chat) item;
                writer.println("Cliente: " + chat.getCliente());
                writer.println("E-mail: " + chat.getEmail());
                writer.println("Mensagem: " + chat.getMensagem());
                writer.println("Data/Hora: " + chat.getDataHora());
                writer.println();
            }
        }
        writer.close();
    } catch (FileNotFoundException | UnsupportedEncodingException e) {
        e.printStackTrace();
    }       
}
}
}
