package testes;

import negocio.Autor;
import negocio.Biblioteca;
import negocio.Livro;

public class TestaBiblioteca {

	public static void main(String[] args) {
		Livro livro = new Livro("A Arte da Gambiarra", "Sou Contra LTDA", 2018);
		Autor autor = new Autor("Munir", "Wanis");
		livro.adicionar(autor);
		
		Livro livro2 = new Livro("C# é melhor que Java", "HUE BR Co.", 2014);
		livro2.adicionar(autor);
		
		Livro livro3 = new Livro("Jesus não tem Dentes no País dos Banguelas", "Anti Cristo S.A.", 2015);
		livro3.adicionar(autor);
		
		Biblioteca biblioteca = new Biblioteca("Biblioteaca Infnet", "infnet@infnet.edu.br", "RJ");
		biblioteca.adicionar(livro);
		biblioteca.adicionar(livro2);
		biblioteca.adicionar(livro3);
		biblioteca.exibir();
	}

}
