package TabelaHash;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListAluno implements Iterable<Aluno> {
    private AlunoNo cabeca;
    private AlunoNo calda;
    private int tamanho;

    public LinkedListAluno() {
        this.cabeca = null;
        this.calda = null;
        this.tamanho = 0;
    }

    public void add(Aluno valor) {
        AlunoNo novoNo = new AlunoNo(valor);
        if (cabeca == null) {
            cabeca = novoNo;
            calda = novoNo;
        } else {
            this.calda.setProx(novoNo);
            this.calda = novoNo;
        }
        this.tamanho++;
    }

    public void removeIndex(int index) {
        if (index < 0 || index >= size()) {
            System.out.println("Índice inválido. Falha na remoção.\n");
            return;
        }

        if (index == 0) {
            this.cabeca = this.cabeca.getProx();
        } else {
            AlunoNo corrente = this.cabeca;
            for (int i = 0; i < index - 1; i++) {
                corrente = corrente.getProx();
            }
            corrente.setProx(corrente.getProx().getProx());
        }
        this.tamanho--;
    }

    public int size() {
        return this.tamanho;
    }

    public Aluno get(int index) {
        if (index < 0 || index >= this.tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido.\n");
        }
        AlunoNo atual = cabeca;
        for (int i = 0; i < index; i++) {
            atual = atual.getProx();
        }
        return atual.getValor();
    }

    public void mostrarLista() {
        AlunoNo atual = cabeca;
        while (atual != null) {
            System.out.print(atual.getValor() + " -> ");
            atual = atual.getProx();
        }
        System.out.println("null\n");
    }

    @Override
    public Iterator<Aluno> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Aluno> {
        private AlunoNo atual = cabeca;

        @Override
        public boolean hasNext() {
            return atual != null;
        }

        @Override
        public Aluno next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Aluno valor = atual.getValor();
            atual = atual.getProx();
            return valor;
        }
    }

}
