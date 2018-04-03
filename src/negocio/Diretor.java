package negocio;

public class Diretor {
	 private String nome, cpf;
	 private int anoInicioCargo, anoFimCargo;
	 private Contato contato;
	 
	 public void exibir() {
		 System.out.printf(
				 "%s %s %d %d",
				 this.getNome(),
				 this.getCpf(),
				 this.getAnoInicioCargo(),
				 this.getAnoFimCargo());
	 }
	 
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getAnoInicioCargo() {
		return anoInicioCargo;
	}
	public void setAnoInicioCargo(int anoInicioCargo) {
		this.anoInicioCargo = anoInicioCargo;
	}
	public int getAnoFimCargo() {
		return anoFimCargo;
	}
	public void setAnoFimCargo(int anoFimCargo) {
		this.anoFimCargo = anoFimCargo;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
}
