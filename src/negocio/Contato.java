package negocio;

public class Contato {
	private String email, whatsapp, facebook, telefone;

	public void exibir() {
		System.out.printf(
				"%s %s %s %s\n",
				this.getEmail(),
				this.getWhatsapp(),
				this.getFacebook(),
				this.getTelefone());
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
