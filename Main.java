import TabelaHash.Aluno;
import TabelaHash.TabelaHash;

public class Main {
    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash(5);
        Aluno pedro = new Aluno(1, "Pedro Lucas");
        Aluno joao = new Aluno(2, "Joao Lucas");
        Aluno carlos = new Aluno(3, "Carlos Miguel");
        Aluno tauan = new Aluno(4, "Tauan Geraldo");
        Aluno cecilia = new Aluno(5, "Cecilia Amado");

        tabela.inserirValor(pedro);
        tabela.inserirValor(joao);
        tabela.inserirValor(carlos);
        tabela.inserirValor(tauan);
        tabela.inserirValor(cecilia);

        tabela.mostrarTabela();

        tabela.removerValor(5);
        tabela.removerValor(4);

        tabela.getAluno(2);

        tabela.mostrarTabela();
    }
}
