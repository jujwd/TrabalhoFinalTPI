package br.com.fundatec.locadoraveiculos.tela;
import br.com.fundatec.locadoraveiculos.bancodados.TabelaCliente;
import br.com.fundatec.locadoraveiculos.util.Teclado;
import br.com.fundatec.loradoraveiculos.modelo.Cliente;
import br.com.fundatec.loradoraveiculos.modelo.Endereco;
import br.com.fundatec.loradoraveiculos.modelo.TipoDocumento;
import br.com.fundatec.loradoraveiculos.modelo.TipoPessoa;
public class MenuCliente {

	private Teclado teclado;

	public MenuCliente(Teclado teclado) {
		this.teclado = teclado;
	}

	public void mostrarMenu() {
		int opcao;

		do {
			System.out.println("MENU CLIENTE");
			System.out.println(" [1] - Cadastrar Cliente");
			System.out.println(" [2] - Listar Clientes");
			System.out.println(" [0] - Voltar");

			opcao = teclado.lerOpcaoUsuario("Informe a opção desejada");

			switch (opcao) {
			case 1:
				this.cadastrarCliente();
				break;

			case 2:
				this.listarClientes();
				break;

			case 0:
				return;

			default:
				System.out.println("Opcao invalida");
				break;
			}
		} while (opcao != 0);
	}

	private void listarClientes() {
		if (TabelaCliente.obter().getClientes().isEmpty()) {
			System.out.println("Ainda não há clientes cadastrados.");
		} else {
			System.out.println("ID | Tipo de Cliente | Nome/Razão Social | Tipo Documento | Número Documento | Endereço ");
			for (Cliente cliente : TabelaCliente.obter().getClientes()) {
				System.out.println(cliente.getId() + " | " +
						this.obterTipoCliente(cliente) + " | " +
						this.obterNomeOuRazaoSocial(cliente) + " | " +
						this.obterTipoDocumento(cliente) + " | " +
						this.obterNumeroDocumento(cliente) + " | " +
						this.obterEndereco(cliente));
			}
		}
	}
	
	private String obterEndereco(Cliente cliente) {
		Endereco endereco = cliente.getEndereco();

		return endereco.getLogradouro() + ", " + endereco.getNumero()
		+ ", " + endereco.getComplemento() + " - "
		+ endereco.getBairro() + ". " + endereco.getCidade()
		+ ". CEP: " + endereco.getCep();	
	}

	private Long obterNumeroDocumento(Cliente cliente) {
		if (TipoPessoa.PESSOA_JURIDICA == cliente.getTipoPessoa()) {
			return cliente.getCnpj();
		}
		return null;
	}

	private String obterTipoDocumento (Cliente cliente) {
		if (TipoPessoa.PESSOA_JURIDICA == cliente.getTipoPessoa()) {
			return "CNPJ";
		}
		
		if (TipoDocumento.CNH == cliente.getTipoDocumento()) {
			return "CNH";
		}
		if (TipoDocumento.CPF == cliente.getTipoDocumento()) {
			return "CPF";
		}
		return "RG";
	}
	
	private String obterNomeOuRazaoSocial (Cliente cliente) {
		if (TipoPessoa.PESSOA_FISICA == cliente.getTipoPessoa()) {
			return cliente.getNome();
		}
		return cliente.getRazaoSocial();
	}
	
	private String obterTipoCliente(Cliente cliente) {
		if (TipoPessoa.PESSOA_FISICA == cliente.getTipoPessoa()) {
			return "PF";
		}
		return "PJ";
	}

	private void cadastrarCliente() {
		TipoPessoa tipoPessoa = teclado.lerTipoPessoa("Deseja cadastrar uma PESSOA_FISICA ou PESSOA_JURIDICA?");
		
		if (TipoPessoa.PESSOA_FISICA == tipoPessoa) {
			this.cadastarPessoaFisica();
		} else {
			this.cadastrarPessoaJuridica();
		}
	}
	
	private void cadastarPessoaFisica() {
		 String nome = teclado.lerString("Informe o nome.");
		 TipoDocumento tipoDocumento = teclado.lerTipoDocumento("Informe o tipo de documento: CNH, CPF ou RG");
		 Long numeroDocumento = teclado.lerLong("Informe o número do documento.");
		 Endereco endereco = this.preencherEndereco();
		 
		 Cliente pessoaFisica = new Cliente(nome, tipoDocumento, numeroDocumento, endereco);
		
		 this.incluirCliente(pessoaFisica);
	}
	
	private void cadastrarPessoaJuridica() {
		String razaoSocial = teclado.lerString("Informe a razão social.");
		Long cnpj = teclado.lerLong("Informe o número do CNPJ.");
		Endereco endereco = this.preencherEndereco();
		
		Cliente pessoaJuridica = new Cliente(razaoSocial, cnpj, endereco);
		
		this.incluirCliente(pessoaJuridica);
	}
	
	private void incluirCliente(Cliente cliente) {
		TabelaCliente tabela = TabelaCliente.obter();
		tabela.incluir(cliente);
	}
	
	private Endereco preencherEndereco() {
		String logradouro = teclado.lerString("Informe o logradouro.");
		Integer numero = teclado.lerInteger("Informe o número.");
		String complemento = teclado.lerString("Informe o complemento.");
		String bairro = teclado.lerString("Informe o bairro.");
		String cidade = teclado.lerString("Informe a cidade.");
		String uf = teclado.lerString("Informe a UF.");
		Integer cep = teclado.lerInteger("Informe o CEP.");
		
		return new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep);
	}
	
}
