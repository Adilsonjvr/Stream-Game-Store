import java.util.List;
import java.util.ArrayList;

public class Chat extends EntidadeF {
    private Cliente cliente1;
    private Cliente cliente2;
    private List<String> mensagens;

    public Chat(String descricao, Cliente cliente1, Cliente cliente2, float valor) {
        super(IdGenerator.getNextId(), descricao);
        this.cliente1 = cliente1;
        this.cliente2 = cliente2;
        this.mensagens = new ArrayList<>();
    }

    public void enviarMensagem(Cliente remetente, String mensagem) {
        if (remetente.equals(cliente1) || remetente.equals(cliente2)) {
            mensagens.add(remetente.getNome() + ": " + mensagem);
        }
    }

    public List<String> getMensagens() {
        return mensagens;
    }

    public Cliente getCliente1() {
        return cliente1;
    }

    public void setCliente1(Cliente cliente1) {
        this.cliente1 = cliente1;
    }

    public Cliente getCliente2() {
        return cliente2;
    }

    public void setCliente2(Cliente cliente2) {
        this.cliente2 = cliente2;
    }
}
