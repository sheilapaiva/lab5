package lab5;

public class Facade {
	private ControladorCliente clientes;
	private ControladorFornecedor fornecedores;
	
	public String cadastraCliente(String nome, String email, String localizacao, String cpf) {
		return this.clientes.cadastraCliente(nome, email, cpf, localizacao);
	}
	
	public String retornaCliente(String cpf) {
		return this.clientes.getCliente(cpf);
	}
	
	public String listaClientes() {
		return this.clientes.listaCliente();
	}
	
	public boolean editaEmailCliente(String cpf, String email) {
		return this.clientes.editaEmail(cpf, email);
	}
	
	public boolean editaNomeCliente(String cpf, String nome) {
		return this.clientes.editaEmail(cpf, nome);
	}
	
	public boolean editaLocalizacaoCliente(String cpf, String localizacao) {
		return this.clientes.editaEmail(cpf, localizacao);
	}
	
	public boolean removeCliente(String cpf) {
		return this.clientes.removeCadastroCliente(cpf);
	}
	
	public boolean cadastraFornecedor(String nome, String email, String telefone) {
		return this.fornecedores.cadastraFornecedor(nome, email, telefone);
	}
	
	public String retornaFornecedor(String nome) {
		return this.fornecedores.getFornecedor(nome);
	}
	
	public String listaFornecedores() {
		return this.fornecedores.listaFornecedores();
	}
	
	public boolean editaEmailFornecedor(String nome, String email) {
		return this.fornecedores.editaEmail(nome, email);
	}
	
	public boolean editaTelefoneFornecedor(String nome, String telefone) {
		return this.fornecedores.editaEmail(nome, telefone);
	}
	
	public boolean removeFornecedor(String nome) {
		return this.fornecedores.removeCadastroFornecedor(nome);
	}
	
	public boolean cadastraProdutoFornecedor(String nomeFornecedor, String nomeProduto, String descricaoProduto, double precoProduto) {
		return this.fornecedores.cadastraProduto(nomeFornecedor, nomeProduto, descricaoProduto, precoProduto);
	}
	
	public String consultaProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto) {
		return this.fornecedores.getProduto(nomeFornecedor, nomeProduto, descricaoProduto);
	}
	
	public String listaProdutos(String nome) {
		return this.fornecedores.listaProdutos(nome);
	}
	
	public boolean editaPrecoProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto, double preco) {
		return this.fornecedores.editaProduto(nomeFornecedor, nomeProduto, descricaoProduto, preco);
	}
	
	public boolean removeProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		return this.fornecedores.removeProduto(nomeFornecedor, nomeProduto, descricao);
	}
}
