package view;

import model.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    private static List<Livro> livros = new ArrayList<>();
    private static List<Autor> autores = new ArrayList<>();
    private static List<Genero> generos = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Emprestimo> emprestimos = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            String opcao = JOptionPane.showInputDialog("""
                    Escolha uma opção:
                    1 - Cadastrar Autor
                    2 - Cadastrar Gênero
                    3 - Cadastrar Livro
                    4 - Cadastrar Usuário
                    5 - Realizar Empréstimo
                    6 - Listar Livros
                    7 - Sair
                    """);

            switch (opcao) {
                case "1" -> cadastrarAutor();
                case "2" -> cadastrarGenero();
                case "3" -> cadastrarLivro();
                case "4" -> cadastrarUsuario();
                case "5" -> realizarEmprestimo();
                case "6" -> listarLivros();
                case "7" -> System.exit(0);
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    private static void cadastrarAutor() {
        String nome = JOptionPane.showInputDialog("Digite o nome do autor:");
        autores.add(new Autor(nome));
        JOptionPane.showMessageDialog(null, "Autor cadastrado com sucesso!");
    }

    private static void cadastrarGenero() {
        String nome = JOptionPane.showInputDialog("Digite o nome do gênero:");
        generos.add(new Genero(nome));
        JOptionPane.showMessageDialog(null, "Gênero cadastrado com sucesso!");
    }

    private static void cadastrarLivro() {
        String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
        Autor autor = escolherAutor();
        Genero genero = escolherGenero();

        String tipo = JOptionPane.showInputDialog("Digite o tipo do livro (1 - Físico, 2 - Digital):");
        Livro livro;
        if ("1".equals(tipo)) {
            int paginas = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de páginas:"));
            livro = new LivroFisico(titulo, autor, genero, paginas);
        } else {
            double tamanho = Double.parseDouble(JOptionPane.showInputDialog("Digite o tamanho do arquivo (MB):"));
            livro = new LivroDigital(titulo, autor, genero, tamanho);
        }

        livros.add(livro);
        JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
    }

    private static void cadastrarUsuario() {
        String nome = JOptionPane.showInputDialog("Digite o nome do usuário:");
        usuarios.add(new Usuario(nome));
        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
    }

    private static void realizarEmprestimo() {
        Usuario usuario = escolherUsuario();
        Livro livro = escolherLivro();
        emprestimos.add(new Emprestimo(livro, usuario));
        JOptionPane.showMessageDialog(null, "Empréstimo realizado com sucesso!");
    }

    private static void listarLivros() {
        StringBuilder lista = new StringBuilder("Livros cadastrados:\n");
        for (Livro livro : livros) {
            lista.append(livro.getDetalhes()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }

    private static Autor escolherAutor() {
        String lista = "Escolha um autor:\n";
        for (int i = 0; i < autores.size(); i++) {
            lista += (i + 1) + " - " + autores.get(i).getNome() + "\n";
        }
        int escolha = Integer.parseInt(JOptionPane.showInputDialog(lista));
        return autores.get(escolha - 1);
    }

    private static Genero escolherGenero() {
        String lista = "Escolha um gênero:\n";
        for (int i = 0; i < generos.size(); i++) {
            lista += (i + 1) + " - " + generos.get(i).getNome() + "\n";
        }
        int escolha = Integer.parseInt(JOptionPane.showInputDialog(lista));
        return generos.get(escolha - 1);
    }

    private static Usuario escolherUsuario() {
        String lista = "Escolha um usuário:\n";
        for (int i = 0; i < usuarios.size(); i++) {
            lista += (i + 1) + " - " + usuarios.get(i).getNome() + "\n";
        }
        int escolha = Integer.parseInt(JOptionPane.showInputDialog(lista));
        return usuarios.get(escolha - 1);
    }

    private static Livro escolherLivro() {
        String lista = "Escolha um livro:\n";
        for (int i = 0; i < livros.size(); i++) {
            lista += (i + 1) + " - " + livros.get(i).getTitulo() + "\n";
        }
        int escolha = Integer.parseInt(JOptionPane.showInputDialog(lista));
        return livros.get(escolha - 1);
    }
}
