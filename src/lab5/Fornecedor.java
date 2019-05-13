package lab5;

import java.util.HashMap;
import java.util.HashSet;

public class Fornecedor {
	/*
	 * Nome do fornecedor
	 */
	private String nome; 
	/**
	 * email do fornecedor
	 */
	private String email;
	/**
	 * telefone do fornecedor
	 */
	private String telefone;
	/**
	 * Mapa dos produtos do fornecedor
	 */
	private HashMap<String, Produto> produtos;
	
	/**
	 * Construtor do fornecedor para a inicialização
	 * @param nome : nome do fornecedor
	 * @param email : email do fornecedor
	 * @param telefone : telefone do fornecedor 
	 */
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<>();
	}
	
	/**
	 * Método que retorna o nome do fornecedor
	 * @return
	 */
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
	
	/**
	 * Método que retorna a representação textual dos atributos da classe
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}
	
	/**
	 * Método que recebe um valor para o campo email
	 * @param email : email do fornecedor
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Método que recebe um valor para o campo telefone
	 * @param telefone : telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	/**
	 * Método que realiza o cadastro de um produto no mapa de produtos
	 * @param nome : nome do produto
	 * @param descricao: descricao do produto
	 * @param preco : preco do produto
	 */
	public void cadastraProduto(String nome, String descricao, double preco) {
		String id = nome + "/" + descricao;
		Produto produtos = new Produto(nome, descricao, preco);
		this.produtos.put(id, produtos);
	}
	
	/**
	 * Método que verifica se o fornecedor possui o produto
	 * @param nome : nome do produto
	 * @param descricao : descricao do produto
	 * @return
	 */
	public boolean verificaProduto(String nome, String descricao) {
		String id = nome + "/" + descricao;
		if(produtos.containsKey(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Método que retorna os produtos de um fornecedor
	 * @return
	 */
	public String listaProdutos() {
		String n = "";
		for (Produto produto : this.produtos.values()) {
			n += produto.toString();
			n += " | ";
		}
		String b = n.substring(0, n.length() - 3);
		return b;
	}
	
	/**
	 * Método que retorna o nome do fornecedor concatenado com seus produtos
	 * @return
	 */
	
	public String listaProdutosEFornecedor() {
		String a = "";
		for (Produto produto : this.produtos.values()) {
			a += this.nome + " - " + produto.toString() + " | ";
		}
		String b = a.substring(0, a.length() - 3);
		return b;
	}
	/**
	 * Método que edita o preco de um produto
	 * @param nome : nome do produto
	 * @param descricao : descricao do produto
	 * @param preco : preco do produto
	 */
	public void editaPreco(String nome, String descricao, double preco) {
		String id = nome + "/" + descricao;
		this.produtos.get(id).setPreco(preco);
	}
	
	/**
	 * Método que remove produto indicado do Mapa de produtos
	 * @param nome : nome do produto
	 * @param descricao : descricao do produto
	 */
	public void excluiProduto(String nome, String descricao) {
		String id = nome + "/" + descricao;
		this.produtos.remove(id);
	}
 	
}
