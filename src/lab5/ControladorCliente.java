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
	 * @param nome : nome
	 * @param cpf : cpf do cliente (chave)
	 * @param localizacao : localizacao
	 * @param email : email
	 * @return
	 */
	public String cadastraCliente(String nome, String cpf, String localizacao, String email) {
		if (this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Cpf já cadastrado!");
		} else {
			Cliente cliente = new Cliente(nome, localizacao, email, cpf);
			this.clientes.put(cpf, cliente);
			return cpf;
		}
	}
	
	/**
	 * Método que retorna um cliente pelo cpf (chave)
	 * @param cpf : cpf do cliente
	 * @return
	 */
	public String getCliente(String cpf) {
		return clientes.get(cpf).toString();
	}
	
	/**
	 * método que Lista os clientes do mapa de clientes
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
	 * Método que edita o nome de um determinado cliente
	 * @param cpf : cpf do cliente (chave)
	 * @param nome : nome do cliente
	 * @return
	 */
	public boolean editaNome(String cpf, String nome) {
		if (nome.equals(null) || nome.trim().equals("")) {
			return false;
		}
		this.clientes.get(cpf).setNome(nome);
		return true;
	}
	
	/**
	 *  Método que edita o email de um determinado cliente 
	 * @param cpf : cpf do cliente (chave)
	 * @param email : email do cliente
	 * @return
	 */
	public boolean editaEmail(String cpf, String email) {
		if (email.equals(null) || email.trim().equals("")) {
			return false;
		}
		this.clientes.get(cpf).setNome(email);
		return true;
	}
	
	/**
	 * Método que edita a localização de um determinado cliente
	 * @param cpf : cpf do cliente(chave)
	 * @param localizacao : localização do cliente
	 * @return
	 */
	public boolean editaLocalizacao(String cpf, String localizacao) {
		if (localizacao.equals(null) || localizacao.trim().equals("")) {
			return false;
		}
		this.clientes.get(cpf).setNome(localizacao);
		return true;
	}
	
	/**
	 * Método que remove o cadastro de um determinado cliente do mapa de clientes
	 * @param cpf : cpf (chave) do cliente a ser excluído
	 * @return
	 */
	public boolean removeCadastroCliente(String cpf) {
		if (!this.clientes.containsKey(cpf)) {
			return false;
		} else {
			this.clientes.remove(cpf);
			return true;
		}
	}
}
