package lab5;

import java.util.HashMap;

public class ControladorFornecedor {
	public HashMap<String, Fornecedor> fornecedores;

	public ControladorFornecedor() {
		this.fornecedores = new HashMap<>();
	}

	public boolean cadastraFornecedor(String nome, String email, String telefone) {
		if (this.fornecedores.containsKey(nome)) {
			return false;
		} else {
			Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
			this.fornecedores.put(nome, fornecedor);
			return true;
		}
	}

	public String getFornecedor(String nome) {
		return fornecedores.get(nome).toString();
	}

	public String listaFornecedores() {
		String n = "";
		for (Fornecedor fornecedor : this.fornecedores.values()) {
			n += fornecedor.toString();
			n += " | ";
		}
		String b = n.substring(0, n.length() - 3);
		return b;
	}

	public boolean editaEmail(String nome, String email) {
		if (email.equals(null) || email.trim().equals("")) {
			return false;
		}
		this.fornecedores.get(nome).setEmail(email);
		return true;
	}

	public boolean editaTelefone(String nome, String telefone) {
		if (telefone.equals(null) || telefone.trim().equals("")) {
			return false;
		}
		this.fornecedores.get(nome).setTelefone(telefone);
		return true;
	}

	public boolean removeCadastroFornecedor(String nome) {
		if (!this.fornecedores.containsKey(nome)) {
			return false;
		} else {
			this.fornecedores.remove(nome);
			return true;
		}
	}

	public boolean cadastraProduto(String nome, String nomeProduto, String descricaoProduto, double precoProduto) {
		if (this.fornecedores.containsKey(nome)) {
			this.fornecedores.get(nome).cadastraProduto(nomeProduto, descricaoProduto, precoProduto);
			return true;
		} else {
			return false;
		}
	}

	public String retornaId(String nome, String descricao) {
		String id = nome + "/" + descricao;
		return id;
	}

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

	public String listaProdutos(String nomeFornecedor) {
		if(this.fornecedores.containsKey(nomeFornecedor)) {
			return this.fornecedores.get(nomeFornecedor).listaProdutos();
		} else {
			throw new NullPointerException("Fornecedor inexistente!");
		}
	}
}
