package controle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.Autor;
import negocio.Biblioteca;
import negocio.Livro;

/**
 * Servlet implementation class BibliotecaController
 */
public class BibliotecaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Biblioteca biblioteca;
	private Livro livro;
	private int qtdeMalote;
	private FileWriter file;
	private BufferedWriter escritor;
	private String arquivo;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BibliotecaController() {
        super();
        qtdeMalote = 0;
        arquivo = "";
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		qtdeMalote--;
		
		livro = new Livro();
		livro.setTitulo(request.getParameter("titulo"));
		livro.setEditora(request.getParameter("editora"));
		livro.setAno(Integer.valueOf(request.getParameter("ano")));
		
		Autor autor1 = new Autor();
		autor1.setNome(request.getParameter("nome1"));
		autor1.setSobrenome(request.getParameter("sobrenome1"));
		
		Autor autor2 = new Autor();
		autor2.setNome(request.getParameter("nome2"));
		autor2.setSobrenome(request.getParameter("sobrenome2"));
		
		livro.adicionar(autor1);
		livro.adicionar(autor2);
		
		biblioteca.adicionar(livro);
		
		biblioteca.exibir();
		
		if ("S".equals(request.getParameter("impressao"))) {
			biblioteca.exibir();
		}
		
		this.impressaoHTML(qtdeMalote == 0, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		biblioteca = new Biblioteca();
		biblioteca.setNome(request.getParameter("nome"));
		biblioteca.setEmail(request.getParameter("email"));
		biblioteca.setUf(request.getParameter("uf"));
		
		qtdeMalote = Integer.valueOf(request.getParameter("qtde"));
		
		impressaoHTML(response);
		
		arquivo = String.format("C:\\%s_%s.txt", biblioteca.getNome(), qtdeMalote);
		try {
			file = new FileWriter(arquivo);
			escritor = new BufferedWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private void impressaoHTML(HttpServletResponse response) throws IOException {
		impressaoHTML(false, response);
	}
	
	private void impressaoHTML(boolean impressaoMalote, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		if (impressaoMalote) {
			escritor.write(biblioteca.obterConteudo());
			escritor.flush();
			escritor.close();
			
			out.println(
					  "<html>"
					+ "<head>"
					+ "<meta charset='ISO-8859-1'>"
					+ "<title>Sistema de Gerenciamento de Bibliotecas</title>"
					+ "</head>"
					+ "<body>"
					+ "	<form action='biblioteca.html' method='get'>"
					+ "		<input type='submit' value='Finalizar'>"
					+ "		<hr>"
					+ "		<h3>"
					+ 			biblioteca.getNome()
					+			" - " 
					+ 			biblioteca.getEmail() 
					+ 			" - " 
					+ 			biblioteca.getUf() 
					+ "  	</h3>"
					+ "		<hr>"
					+ "		<h2>O arquivo " + arquivo + " foi criado com sucesso.</h2>"
					+ "	</form>"
					+ "<input type='checkbox' value='S' name='impressao'>"
					+ "	<form action='biblioteca.html'>"
					+ "		<input type='submit' value='Voltar'>"
					+ "	</form>"
					+ "</body>"
					+ "</html>");
		} else {
			out.println(
					  "<html>"
					+ "<head>"
					+ "<meta charset='ISO-8859-1'>"
					+ "<title>Sistema de Gerenciamento de Bibliotecas</title>"
					+ "</head>"
					+ "<body>"
					+ "	<form action='BibliotecaController' method='get'>"
					+ "		<input type='submit' value='Registrar'>"
					+ "		<hr>"
					+ "		<h3>"
					+ 			biblioteca.getNome()
					+			" - " 
					+ 			biblioteca.getEmail() 
					+ 			" - " 
					+ 			biblioteca.getUf() 
					+ "  	</h3>"
					+ "		<hr>"
					+ "		<fieldset>"
					+ "			<legend>Livro</legend>"
					+ "			<h3>Título</h3>"
					+ "			<input type='text' name='titulo'>"
					+ "			<h3>Editora</h3>"
					+ "			<input type='text' name='editora'>"
					+ "			<h3>Ano</h3>"
					+ "			<input type='number' name='ano'>"
					+ "		</fieldset>"
					+ "		<fieldset>"
					+ "			<legend>Primeiro Autor</legend>"
					+ "			<h3>Nome</h3>"
					+ "			<input type='text' name='nome1'>"
					+ "			<h3>Sobrenome</h3>"
					+ "			<input type='text' name='sobrenome1'>"
					+ "		</fieldset>"
					+ "		<fieldset>"
					+ "			<legend>Segundo Autor</legend>"
					+ "			<h3>Nome</h3>"
					+ "			<input type='text' name='nome2'>"
					+ "			<h3>Sobrenome</h3>"
					+ "			<input type='text' name='sobrenome2'>"
					+ "		</fieldset>"
					+ "	</form>"
					+ "<input type='checkbox' value='S' name='impressao'>"
					+ "	<form action='biblioteca.html'>"
					+ "		<input type='submit' value='Voltar'>"
					+ "	</form>"
					+ "</body>"
					+ "</html>");
		}
	}

}
