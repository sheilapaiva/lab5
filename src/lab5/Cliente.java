package lab5;

public class Cliente {
	private String nome;
	private String email;
	private String localizacao;
	private String cpf;
	
	public Cliente(String nome, String email, String localizacao, String cpf) {
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
		this.cpf = cpf;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public void setLocalizacao (String localizacao) {
		this.localizacao = localizacao;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return nome + " - " + localizacao + " - " + email;
	}
	

}
