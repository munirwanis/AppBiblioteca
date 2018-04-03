package negocio;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	private String nome;
	private String email;
	private String uf;
	private List<Livro> catalogo;
	private Diretor diretor;

	public Biblioteca() {
		super();
		this.catalogo = new ArrayList<Livro>();
	}
	
	public Biblioteca(String nome, String email, String uf) {
		this();
		this.nome = nome;
		this.email = email;
		this.uf = uf;
	}
	
	public Biblioteca(String nome, String email, String uf, List<Livro> livros) {
		this();
		this.nome = nome;
		this.email = email;
		this.uf = uf;
		this.catalogo = livros;
	}
	
	public void exibir() {
		System.out.printf(this.obterConteudo());
		
		if (this.getDiretor() != null) {
			this.getDiretor().exibir();			
		}
	}
	
	public String obterConteudo() {
		String livros = "";
		
		for (Livro livro : this.getCatalogo()) {
			livros += livro.obterConteudo();
		}
		return String.format(
				"%s - %s - %s \n%s",
				this.getNome(),
				this.getEmail(),
				this.getUf(),
				livros
				);
	}
	
	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}
	
	public List<Livro> getCatalogo() {
		return catalogo;
	}

	public void adicionar(Livro livro) {
		this.catalogo.add(livro);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public Livro buscarLivro(String titulo) {
		for (Livro livro : this.getCatalogo()) {
			if (livro.getTitulo().toUpperCase().contains(titulo.toUpperCase())) {
				return livro;
			}
		}
		return null;
	}
	
	public void remover(String titulo) {
		Livro livro = this.buscarLivro(titulo);
		if (livro != null) {
			this.getCatalogo().remove(livro);
			System.out.println("Livro removido com sucesso!");
		} else {
			System.out.println("Livro não encontrado.");
		}
	}
}
