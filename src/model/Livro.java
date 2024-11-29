package model;

public abstract class Livro {
    private String titulo;
    private Autor autor;
    private Genero genero;

    public Livro(String titulo, Autor autor, Genero genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public abstract String getTipo();

    public String getDetalhes() {
        return "Título: " + titulo + ", Autor: " + autor.getNome() + ", Gênero: " + genero.getNome() + ", Tipo: " + getTipo();
    }
}
