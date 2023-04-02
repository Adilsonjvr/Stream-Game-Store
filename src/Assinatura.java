public class Assinatura extends EntidadeE implements Avaliavel {

    private float valor;
    private int duracao;
    private double avaliacao;
    private int numAvaliacoes;

    public Assinatura(String descricao, float valor, int duracao) {
        super(descricao.hashCode()); // converte a String para long usando o método hashCode()
        this.valor = valor;
        this.duracao = duracao;
        this.avaliacao = 0;
        this.numAvaliacoes = 0;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public double mediaAvaliacoes() {
        if (numAvaliacoes == 0) {
            return 0;
        }
        return avaliacao / numAvaliacoes; // calcula a média dividindo pela quantidade de avaliações
    }

    public void addAvaliacao(double avaliacao) {
        this.avaliacao += avaliacao;
        this.numAvaliacoes++;
    }

    public int getNumAvaliacoes() {
        return numAvaliacoes;
    }

    public void setNumAvaliacoes(int numAvaliacoes) {
        this.numAvaliacoes = numAvaliacoes;
    }

}
