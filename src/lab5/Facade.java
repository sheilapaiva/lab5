package lab5;

public class Facade {
	private ControladorCliente clientes;
	private ControladorFornecedor fornecedores;
	
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
