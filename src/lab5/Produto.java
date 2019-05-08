package lab5;

public class Produto {
	/**
	 * nome do produto
	 */
	private String nome;
	/**
	 * preco do produto
	 */
	private double preco;
	/**
	 * descricao do produto
	 */
	private String descricao;
	
	/**
	 * Construtor do produto
	 * @param nome : nome do produto
	 * @param descricao : descricao do produto
	 * @param preco : preco do produto
	 */
	public Produto(String nome, String descricao, double preco) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	/**
	 * Método que retorna a representação textual dos atributos do produto
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.descricao + " - " + this.preco;
	}
	
	/**
	 * Método altera o preco do produto
	 * @param preco : preco do produto
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
 }
