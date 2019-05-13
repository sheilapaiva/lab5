package lab5;

import easyaccept.EasyAccept;

public class Facade {
	private ControladorCliente clientes;
	private ControladorFornecedor fornecedores;
	
	public static void main(String[] args) {
		args = new String[]{"lab5.Facade", "acceptance_test/use_case_1.txt", "acceptance_test/use_case_2.txt", "acceptance_test/use_case_3.txt"};
		EasyAccept.main(args);
	}
	
	
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.clientes.cadastraCliente(cpf, nome, email, localizacao);
	}
	
	public String exibeCliente(String cpf) {
		return this.clientes.getCliente(cpf);
	}
	
	public String listaClientes() {
		return this.clientes.listaCliente();
	}
	
	public boolean editaCliente(String cpf, String atributo, String novoValor) {
		return this.clientes.editaCliente(cpf, atributo, novoValor);
	}
	
	
	public boolean removeCliente(String cpf) {
		return this.clientes.removeCadastroCliente(cpf);
	}
	
	public boolean adicionaFornecedor(String nome, String email, String telefone) {
		return this.fornecedores.cadastraFornecedor(nome, email, telefone);
	}
	
	public String retornaFornecedor(String nome) {
		return this.fornecedores.getFornecedor(nome);
	}
	
	public String listaFornecedores() {
		return this.fornecedores.listaFornecedores();
	}
	
	public boolean editaFornecedor(String nome, String atributo, String novoValor) {
		return this.fornecedores.editaCadastroFornecedor(nome, atributo, novoValor);
	}
	
	public boolean removeFornecedor(String nome) {
		return this.fornecedores.removeCadastroFornecedor(nome);
	}
	
	public boolean adicionaProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto, double precoProduto) {
		return this.fornecedores.cadastraProduto(nomeFornecedor, nomeProduto, descricaoProduto, precoProduto);
	}
	
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return this.fornecedores.getProduto(nome, descricao, fornecedor);
	}
	
	public String listaProdutos(String nome) {
		return this.fornecedores.listaProdutos(nome);
	}
	
	public boolean editaProduto(String nome, String descricao, String fornecedor,  double novoPreco) {
		return this.fornecedores.editaProduto(nome, descricao,fornecedor, novoPreco);
	}
	
	public boolean removeProduto(String nome, String descricao, String fornecedor) {
		return this.fornecedores.removeProduto(nome, descricao, fornecedor);
	}
}
