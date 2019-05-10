package lab5;

import java.util.HashMap;

public class ControladorCliente {
	/**
	 * Mapa dos clientes
	 */
	private HashMap<String, Cliente> clientes;

	/**
	 * Controlador que inicializa um mapa de clientes
	 */
	public ControladorCliente() {
		this.clientes = new HashMap<>();
	}

	/**
	 * Método que cadastra cliente no mapa de clientes
	 * 
	 * @param nome        : nome
	 * @param cpf         : cpf do cliente (chave)
	 * @param localizacao : localizacao
	 * @param email       : email
	 * @return
	 */
	public String cadastraCliente(String nome, String cpf, String localizacao, String email) {
		if (this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Cpf já cadastrado!");
		} else {
			if (nome.equals(null) || nome.equals("")) {
				throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
			} else if (email.equals(null) || email.equals("")) {
				throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
			} else if (localizacao.equals(null) || localizacao.equals("")) {
				throw new IllegalArgumentException(
						"Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
			} else if (cpf.length() != 11) {
				throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
			}
			Cliente cliente = new Cliente(nome, localizacao, email, cpf);
			this.clientes.put(cpf, cliente);
			return cpf;
		}
	}

	/**
	 * Método que retorna um cliente pelo cpf (chave)
	 * 
	 * @param cpf : cpf do cliente
	 * @return
	 */
	public String getCliente(String cpf) {
		return clientes.get(cpf).toString();
	}

	/**
	 * método que Lista os clientes do mapa de clientes
	 * 
	 * @return
	 */
	public String listaCliente() {
		String a = "";
		for (Cliente cliente : this.clientes.values()) {
			a += cliente.toString();
			a += " | ";
		}
		String b = a.substring(0, a.length() - 3);
		return b;
	}

	
	/**
	 * Método que edita os atributos do cliente de acordo com a demanda do usuário
	 * @param cpf : cpf do cliente (chave)
	 * @param atributo : o atributo que o usuário deseja alterar
	 * @param novoValor : o novo valor para o atributo
	 * @return
	 */
	public boolean editaCliente(String cpf, String atributo, String novoValor) {
		if (!atributo.equals("nome") || !atributo.equals("localizacao") || !atributo.equals("email")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
		if (atributo.equals("nome")) {
			if (novoValor.equals(null) || novoValor.trim().equals("")) {
				throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
			} else {
				this.clientes.get(cpf).setNome(novoValor);
				return true;
			}
		} else if (atributo.equals("email")) {
			if (novoValor.equals(null) || novoValor.trim().equals("")) {
				throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
			} else {
				this.clientes.get(cpf).setEmail(novoValor);
				return true;
			}
		}
		else if (atributo.equals("localizacao")) {
			if (novoValor.equals(null) || novoValor.trim().equals("")) {
				throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
			} else {
				this.clientes.get(cpf).setLocalizacao(novoValor);
				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * Método que remove o cadastro de um determinado cliente do mapa de clientes
	 * 
	 * @param cpf : cpf (chave) do cliente a ser excluído
	 * @return
	 */
	public boolean removeCadastroCliente(String cpf) {
		if (!this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		} else {
			this.clientes.remove(cpf);
			return true;
		}
	}
}
