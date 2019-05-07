package lab5;

import java.util.HashMap;

public class ControladorCliente {
	private HashMap<String, Cliente> clientes;

	public ControladorCliente() {
		this.clientes = new HashMap<>();
	}

	public String cadastraCliente(String nome, String cpf, String localizacao, String email) {
		if (this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Cpf já cadastrado!");
		} else {
			Cliente cliente = new Cliente(nome, localizacao, email, cpf);
			this.clientes.put(cpf, cliente);
			return cpf;
		}

	}

	public String getCliente(String cpf) {
		return clientes.get(cpf).toString();
	}
	
	public String listaCliente() {
		String a = "";
		for (Cliente cliente : this.clientes.values()) {
			a += cliente.toString();
			a += " | ";
		}
		String b = a.substring(0, a.length() - 3);
		return b;
	}
	
	public boolean editaNome(String cpf, String nome) {
		if (nome.equals(null) || nome.trim().equals("")) {
			return false;
		}
		this.clientes.get(cpf).setNome(nome);
		return true;
	}
	
	public boolean editaEmail(String cpf, String email) {
		if (email.equals(null) || email.trim().equals("")) {
			return false;
		}
		this.clientes.get(cpf).setNome(email);
		return true;
	}
	
	public boolean editaLocalizacao(String cpf, String localizacao) {
		if (localizacao.equals(null) || localizacao.trim().equals("")) {
			return false;
		}
		this.clientes.get(cpf).setNome(localizacao);
		return true;
	}
	
	public boolean removeCadastroCliente(String cpf) {
		if (!this.clientes.containsKey(cpf)) {
			return false;
		} else {
			this.clientes.remove(cpf);
			return true;
		}
	}
}
