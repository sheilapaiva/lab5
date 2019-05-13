package lab5;

import java.util.HashMap;

public class ControladorFornecedor {

	/** 
	 * Mapa de fornecedores
	 */
	public HashMap<String, Fornecedor> fornecedores;

	/**
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
			throw new IllegalAccessError("Erro no cadastro de fornecedor: fornecedor ja existe.");
		} else if (nome.equals(null) || nome.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		} else if (email.equals(null) || email.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		} else if (telefone.equals(null) || telefone.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		} else {	
			Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
			this.fornecedores.put(nome, fornecedor);
			return true;
		}
	}

	/**
	 * Método que retorna um determinado fornecedor do mapa de fornecedores
	 * @param nome : nome do fornecedor
	 * @return
	 */
	public String getFornecedor(String nome) {
		if (!this.fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
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
	 * Método que edita atributos do cadastro do fornecedor
	 * @param nome : nome do fornecedor (chave)
	 * @param atributo : atributo que vai ser alterado
	 * @param novoValor: novo valor pra o atributo
	 * @return
	 */
	
	public boolean editaCadastroFornecedor(String nome, String atributo, String novoValor) { 
		if (!atributo.equals("email") || !atributo.equals("telefone")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		} else if(atributo.equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		} else if (atributo.equals(null) || atributo.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		} if (atributo.equals("email")) {
			this.fornecedores.get(nome).setEmail(atributo);
			return true;
		} if (atributo.equals("telefone")) {
			this.fornecedores.get(nome).setTelefone(atributo);
			return true;
		} 
		return false;
	}	
	
	/**
	 * Método que remove o cadastro de um fornecedor do mapa de fornecedores
	 * @param nome
	 * @return
	 */
	public boolean removeCadastroFornecedor(String nome) {
		if (!this.fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		} else if (nome.equals(null) || nome.equals("")){
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		}
		this.fornecedores.remove(nome);
		return true;
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
		if (!this.fornecedores.containsKey(nome)) {	
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}else if (nome.equals(null) || nome.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		} else if(nomeProduto.equals(null) || nomeProduto.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		} else if(descricaoProduto.equals(null) || descricaoProduto.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		} else if(precoProduto < 1) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido."); 
		} else if (this.fornecedores.get(nome).verificaProduto(nomeProduto, descricaoProduto)) {
			throw new IllegalAccessError("Erro no cadastro de produto: produto ja existe.");
		} else {	
			this.fornecedores.get(nome).cadastraProduto(nomeProduto, descricaoProduto, precoProduto);
			return true;
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
	public String getProduto(String nomeProduto,String descricaoProduto, String nomeFornecedor) {
		if (nomeProduto.equals(null) || nomeProduto.equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		} else if (descricaoProduto.contentEquals(null) || descricaoProduto.equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		} else if (nomeFornecedor.equals(null) || nomeFornecedor.equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}
		if(this.fornecedores.containsKey(nomeFornecedor)) {
			if(!this.fornecedores.get(nomeFornecedor).verificaProduto(nomeProduto, descricaoProduto)) {  
				throw new NullPointerException("Erro na exibicao de produto: produto nao existe.");
		} else {
			return this.fornecedores.get(nomeFornecedor).getProdutos().get(retornaId(nomeProduto, descricaoProduto)).toString();
			}
		} else {
			throw new NullPointerException("Erro na exibicao de produto: fornecedor nao existe.");
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
	public boolean editaProduto(String nomeProduto, String descricaoProduto,String nomeFornecedor, double preco) {
		if (nomeProduto.equals(null) || nomeProduto.equals("")) {
			throw new IllegalAccessError("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		} else if(preco <= 0)  {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		} else if (descricaoProduto.equals(null) || descricaoProduto.equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}	else if (nomeFornecedor.contentEquals(null) || nomeFornecedor.equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		} else if (!this.fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}
			else {
		}
			this.fornecedores.get(nomeFornecedor).editaPreco(nomeProduto, descricaoProduto, preco);
			return true;
		}
	
	
	/**
	 * Método que remove algum produto do mapa de produtos de algum fornecedor
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricaoProduto
	 * @return
	 */
	
	public boolean removeProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		if(nomeProduto.equals(null) || nomeProduto.equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		} else if (descricaoProduto.equals(null) || descricaoProduto.equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		} else if(nomeFornecedor.equals(null) || nomeFornecedor.equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		} else if (!this.fornecedores.containsKey(nomeFornecedor))  {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		} else {	
			this.fornecedores.get(nomeFornecedor).excluiProduto(nomeProduto, descricaoProduto);
			return true;
		}
	}
	
}
	