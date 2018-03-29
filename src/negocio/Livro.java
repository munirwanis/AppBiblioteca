package negocio;

import java.util.ArrayList;
import java.util.List;

public class Livro {
	private String titulo;
	private String editora;
	private int ano;
	private List<Autor> autores;
	
	public Livro() {
		super();
		this.autores = new ArrayList<Autor>();
	}
	
	public Livro(String titulo, String editora, int ano) {
		this();
		this.titulo = titulo;
		this.editora = editora;
		this.ano = ano;
	}
	
	public Livro(String titulo, String editora, int ano, List<Autor> autores) {
		this();
		this.titulo = titulo;
		this.editora = editora;
		this.ano = ano;
		this.autores = autores;
	}
	
	public void exibir() {
		System.out.printf(this.obterConteudo());
	}
	
	public String obterConteudo() {
		String autores = "";
		for (Autor autor : this.getAutores()) {
			autores += autor.obterConteudo();
		}
		
		return String.format(
				"%s(%d) %s. %s, %d\n",
				autores,
				this.getAno(),
				this.getTitulo(),
				this.getEditora(),
				this.getAno()
				);
	}

	public void imprimirFichaCatalografica() {
		System.out.printf(this.obterConteudo());
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void adicionar(Autor autor) {
		this.autores.add(autor);
	}
	
	public void remover(String nome) {
		
	}
}
