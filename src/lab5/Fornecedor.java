package lab5;

import java.util.HashMap;
import java.util.HashSet;

public class Fornecedor {
	private String nome;
	private String email;
	private String telefone;
	private HashMap<String, Produto> produtos;
	
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<>();
	}

	public String getNome() {
	 	return this.nome;
	}
	
	/**
	 * Método que retorna o Mapa de Produtos 
	 * @return
	 */
	public HashMap<String, Produto> getProdutos() {
		return this.produtos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	public void cadastraProduto(String nome, String descricao, double preco) {
		String id = nome + "/" + descricao;
		Produto produtos = new Produto(nome, descricao, preco);
		this.produtos.put(id, produtos);
	}
	
	public boolean verificaProduto(String nome, String descricao) {
		String id = nome + "/" + descricao;
		if(produtos.containsKey(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String listaProdutos() {
		String n = "";
		for (Produto produto : this.produtos.values()) {
			n += produto.toString();
			n += " | ";
		}
		String b = n.substring(0, n.length() - 3);
		return b;
	}
	
}
