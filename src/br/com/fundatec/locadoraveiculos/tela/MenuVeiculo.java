package br.com.fundatec.locadoraveiculos.tela;
import br.com.fundatec.locadoraveiculos.util.Teclado;
public class MenuVeiculo {

	private Teclado teclado;

	public MenuVeiculo(Teclado teclado) {
		this.teclado = teclado;
	}

	public void mostrarMenu() {
		int opcao;

		do {
			System.out.println("MENU VEICULOS");
			System.out.println(" [1] - Cadastrar Veiculo");
			System.out.println(" [2] - Listar Veiculos");
			System.out.println(" [0] - Voltar");
			opcao = teclado.lerOpcaoUsuario("Informe a opção desejada");
			
			switch (opcao) {
			case 1:
				System.out.println("Cadastrar Veículo");
				break;

			case 2:
				System.out.println("Listar Veículos");
				break;

			case 0:
				return;

			default:
				System.out.println("Opcao invalida");
				break;
			}
		} while (opcao != 0);
	}
}
