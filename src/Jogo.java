import java.util.*;

public class Jogo extends EntidadeE implements Avaliavel {

    private String nome;
    private double preco;
    private int anoLancamento;
    private double avaliacao;
    private int numAvaliacoes;

    public Jogo(String nome, double preco, int anoLancamento, double avaliacao) {
        super(IdGenerator.getNextId());
        this.nome = nome;
        this.preco = preco;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.numAvaliacoes = 1;
    }

    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void addAvaliacao(double avaliacao) {
        this.avaliacao += avaliacao;
        this.numAvaliacoes++;
    }

    //implementação do método da interface Avaliavel
    @Override
    public double mediaAvaliacoes() {
        return avaliacao / numAvaliacoes;
    }
}
