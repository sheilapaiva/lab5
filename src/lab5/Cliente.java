package lab5;

public class Cliente {
	/**
	 * nome do cliente
	 */
	private String nome;
	/**
	 * email do cliente
	 */
	private String email;
	/**
	 * localização do cliente
	 */
	private String localizacao;
	/**
	 * cpf do cliente
	 */
	private String cpf;
	
	/**
	 * Construtor de Cliente
	 * @param nome : nome do cliente
	 * @param email : email do cliente
	 * @param localizacao : localizacao do cliente
	 * @param cpf : cpf do cliente
	 */
	public Cliente(String nome, String email, String localizacao, String cpf) {
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
		this.cpf = cpf;
	}
	
	/**
	 * método que altera o nome do cliente
	 * @param nome : nome do cliente
	 */
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	/**
	 * método que altera a localização do cliente
	 * @param localizacao : localização do cliente
	 */
	public void setLocalizacao (String localizacao) {
		this.localizacao = localizacao;
	}
	
	/**
	 * Método que altera o email do cliente
	 * @param email : email do cliente
	 */
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
	
	/**
	 * Método que retorna a representação textual dos atributos da classe cliente
	 */
	@Override
	public String toString() {
		return nome + " - " + localizacao + " - " + email;
	}
	

}
