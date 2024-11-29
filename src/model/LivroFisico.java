package model;

public class LivroFisico extends Livro {
    private int numPaginas;

    public LivroFisico(String titulo, Autor autor, Genero genero, int numPaginas) {
        super(titulo, autor, genero);
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    @Override
    public String getTipo() {
        return "Físico (" + numPaginas + " páginas)";
    }
}
