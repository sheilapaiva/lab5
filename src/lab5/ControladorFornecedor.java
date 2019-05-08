package lab5;

import java.util.HashMap;

public class ControladorFornecedor {
	/*
	 * Mapa de fornecedores
	 */
	public HashMap<String, Fornecedor> fornecedores;

	/*
	 * Construtor do controller que inicializa um mapa de fornecedores
	 */
	public ControladorFornecedor() {
		this.fornecedores = new HashMap<>();
	}

	/**
	 * Método que cadastra um novo fornecedor no mapa de fornecedores 
	 * @param nome : nome do fornecedor
	 * @param email : email do fornecedor
	 * @param telefone : telefone do fornecedor
	 * @return
	 */
	public boolean cadastraFornecedor(String nome, String email, String telefone) {
		if (this.fornecedores.containsKey(nome)) {
			return false;
		} else {
			Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
			this.fornecedores.put(nome, fornecedor);
			return true;
		}
	}

	/**
	 * Método que retorna 
	 * @param nome
	 * @return
	 */
	public String getFornecedor(String nome) {
		return fornecedores.get(nome).toString();
	}

	/**
	 * Método que lista os fornecedores do para concatenando em uma string
	 * @return
	 */
	public String listaFornecedores() {
		String n = "";
		for (Fornecedor fornecedor : this.fornecedores.values()) {
			n += fornecedor.toString();
			n += " | ";
		}
		String b = n.substring(0, n.length() - 3);
		return b;
	}

	/**
	 * Método que edita o email do fornecedor
	 * @param nome : nome do fornecedor (chave)
	 * @param email : email do fornecedor
	 * @return
	 */
	public boolean editaEmail(String nome, String email) {
		if (email.equals(null) || email.trim().equals("")) {
			return false;
		}
		this.fornecedores.get(nome).setEmail(email);
		return true;
	}

	/**
	 *  Método que edita o telefone do fornecedor
	 * @param nome : nome do fornecedor (chave)
	 * @param telefone : telefone do fornecedor
	 * @return
	 */
	public boolean editaTelefone(String nome, String telefone) {
		if (telefone.equals(null) || telefone.trim().equals("")) {
			return false;
		}
		this.fornecedores.get(nome).setTelefone(telefone);
		return true;
	}

	/**
	 * Métoro que remove o cadastro de um fornecedor do mapa de fornecedores
	 * @param nome
	 * @return
	 */
	public boolean removeCadastroFornecedor(String nome) {
		if (!this.fornecedores.containsKey(nome)) {
			return false;
		} else {
			this.fornecedores.remove(nome);
			return true;
		}
	}
	
	/**
	 * Método que cadastra um produto no mapa de produtos de um determinado fornecedor
	 * @param nome : nome do fornecedor
	 * @param nomeProduto
	 * @param descricaoProduto
	 * @param precoProduto
	 * @return
	 */

	public boolean cadastraProduto(String nome, String nomeProduto, String descricaoProduto, double precoProduto) {
		if (this.fornecedores.containsKey(nome)) {
			this.fornecedores.get(nome).cadastraProduto(nomeProduto, descricaoProduto, precoProduto);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Método que retorna o id de um produto, o que é basicamente o nome do produto concatenado com a descrição
	 * @param nome : nome do produto
	 * @param descricao : descriçao do produto
	 * @return
	 */

	public String retornaId(String nome, String descricao) {
		String id = nome + "/" + descricao;
		return id;
	}

	/**
	 * Retorna um determinado produto de um determinado fornecedor
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricaoProduto
	 * @return
	 */
	public String getProduto(String nomeFornecedor,String nomeProduto,String descricaoProduto) {
		if(this.fornecedores.containsKey(nomeFornecedor)) {
			if(!this.fornecedores.get(nomeFornecedor).verificaProduto(nomeProduto, descricaoProduto)) {  
				throw new NullPointerException("Produto inexistente!");
		} else {
			return this.fornecedores.get(nomeFornecedor).getProdutos().get(retornaId(nomeProduto, descricaoProduto)).toString();
			}
		} else {
			throw new NullPointerException("Fornecedor Inexistente!");
		}
	}
/**
 * Método que retorna as produtos de um determinado fornecedor
 * @param nomeFornecedor : nome do fornecedor
 * @return
 */
	public String listaProdutos(String nomeFornecedor) {
		if(this.fornecedores.containsKey(nomeFornecedor)) {
			return this.fornecedores.get(nomeFornecedor).listaProdutos();
		} else {
			throw new NullPointerException("Fornecedor inexistente!");
		}
	}
	
	/**
	 * Método que retorna todos os produtos de todos os fornecedores cadastrados no sistema
	 * @return
	 */
	public String listaFornecedoresEProdutos() {
		String string = "";
		for(Fornecedor fornecedor : this.fornecedores.values()) {
			string += fornecedor.listaProdutosEFornecedor() + " | ";			
		}
		String k = string.substring(0, string.length()- 3);
		return k;
	}
	
	/**
	 * Método que edita o preco de um produto do fornecedor
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricaoProduto
	 * @param preco
	 * @return
	 */
	public boolean editaProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto, double preco) {
		if(this.fornecedores.containsKey(nomeFornecedor)) {
			this.fornecedores.get(nomeFornecedor).editaPreco(nomeProduto, descricaoProduto, preco);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Método que remove algum produto do mapa de produtos de algum fornecedor
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricaoProduto
	 * @return
	 */
	
	public boolean removeProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto) {
		if(this.fornecedores.containsKey(nomeFornecedor)) {
			this.fornecedores.get(nomeFornecedor).excluiProduto(nomeProduto, descricaoProduto);
			return true;
		} else {
			return false;
		}
	}

}
