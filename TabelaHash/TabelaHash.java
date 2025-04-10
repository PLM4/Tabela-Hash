package TabelaHash;

public class TabelaHash {

    private int tamanho;
    private LinkedListAluno[] lista;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        lista = new LinkedListAluno[tamanho];
        for (int i = 0; i < tamanho; i++) {
            lista[i] = new LinkedListAluno();
        }
    }

    public int funcaoHash(int matricula) {
        return matricula % this.tamanho;
    }

    public void inserirValor(Aluno aluno) {
        int indice = funcaoHash(aluno.getMatricula());
        lista[indice].add(aluno);
    }

    public void getAluno(int matricula) {
        int indice = funcaoHash(matricula);
        LinkedListAluno sublista = lista[indice];

        for (Aluno alunoCorrente : sublista) {
            if (alunoCorrente.getMatricula() == matricula) {
                System.out.println("O " + alunoCorrente + " consta no sistema.\n");
                return;
            }
        }
        System.out.println("O aluno não consta no sistema.\n");
    }

    public void removerValor(int matricula) {
        int indice = funcaoHash(matricula);
        LinkedListAluno sublista = lista[indice];

        for (int i = 0; i < sublista.size(); i++) {
            if (sublista.get(i).getMatricula() == matricula) {
                sublista.removeIndex(i);
                System.out.println("Aluno de matricula " + matricula + " foi removido.\n");
                return;
            }
        }
        System.out.println("Aluno de matricula " + matricula + " não encontrada.\n");
    }

    public void mostrarTabela() {
        for (int i = 0; i < this.tamanho; i++) {
            System.out.println("Indice " + i + ":");
            lista[i].mostrarLista();
        }
    }
}