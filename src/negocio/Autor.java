package negocio;

public class Autor {
	private String nome;
	private String sobrenome;
	private Contato contato;

	public Autor() {
		super();
	}

	public Autor(String nome, String sobrenome) {
		this();
		this.nome = nome;
		this.sobrenome = sobrenome;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobremonme) {
		this.sobrenome= sobremonme;
	}

	public void exibir() {
		System.out.printf(this.obterConteudo());
		
		if (this.getContato() != null) {
			this.getContato().exibir();	
		}
	}
	
	public String obterConteudo() {
		return String.format(
				"%s, %s. ", 
				this.getSobrenome().toUpperCase(), 
				this.getNome().toUpperCase().charAt(0));
	}
	
	public Autor buscarAutor(String nome) {
		return null;
	}
}
