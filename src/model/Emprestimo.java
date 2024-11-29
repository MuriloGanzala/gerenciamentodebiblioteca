package model;

import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
    }

    public void devolver() {
        this.dataDevolucao = LocalDate.now();
    }

    public String getDetalhes() {
        return "Livro: " + livro.getTitulo() + ", Usuário: " + usuario.getNome() +
                ", Data Empréstimo: " + dataEmprestimo +
                (dataDevolucao != null ? ", Data Devolução: " + dataDevolucao : "");
    }
}
