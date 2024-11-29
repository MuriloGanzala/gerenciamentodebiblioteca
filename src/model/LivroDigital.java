package model;

public class LivroDigital extends Livro {
    private double tamanhoArquivo;

    public LivroDigital(String titulo, Autor autor, Genero genero, double tamanhoArquivo) {
        super(titulo, autor, genero);
        this.tamanhoArquivo = tamanhoArquivo;
    }

    public double getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    @Override
    public String getTipo() {
        return "Digital (" + tamanhoArquivo + " MB)";
    }
}
