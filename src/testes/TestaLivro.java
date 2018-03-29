package testes;

import negocio.Autor;
import negocio.Livro;

public class TestaLivro {

	public static void main(String[] args) {
		Livro livro = new Livro("A Arte da Gambiarra", "Sou Contra LTDA", 2018);
		Autor autor = new Autor("Munir", "Wanis");
		livro.adicionar(autor);
		livro.imprimirFichaCatalografica();
	}

}
