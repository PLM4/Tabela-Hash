package TabelaHash;

public class AlunoNo {
    private Aluno valor;
    private AlunoNo prox;

    public AlunoNo(Aluno valor) {
        this.valor = valor;
        this.prox = null;
    }

    public Aluno getValor() {
        return valor;
    }

    public void setValor(Aluno valor) {
        this.valor = valor;
    }

    public AlunoNo getProx() {
        return prox;
    }

    public void setProx(AlunoNo prox) {
        this.prox = prox;
    }

    @Override
    public String toString() {
        return "AlunoNo [valor=" + valor + ", prox=" + prox + "]";
    }

}
