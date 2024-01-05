package br.com.fundatec.locadoraveiculos.tela;
import br.com.fundatec.locadoraveiculos.util.Teclado;
public class MenuPrincipal {

	private Teclado teclado;
	private MenuVeiculo menuVeiculo;
	private MenuCliente menuCliente;
	private MenuLocacao menuLocacao;

	public MenuPrincipal() {
		teclado = new Teclado();
		menuVeiculo = new MenuVeiculo(teclado);
		menuCliente = new MenuCliente(teclado);
		menuLocacao = new MenuLocacao(teclado);
	}

	public void mostrarMenu() {
		int opcao;

		do {
			System.out.println("MENU PRINCIPAL");
			System.out.println(" [1] - Menu Veiculos");
			System.out.println(" [2] - Menu Clientes");
			System.out.println(" [3] - Menu Locacoes");
			System.out.println(" [0] - Encerrar Locadora");

			opcao = teclado.lerOpcaoUsuario("Informe a opção desejada");
			
			switch (opcao) {
			case 1:
				menuVeiculo.mostrarMenu();
				break;

			case 2:
				menuCliente.mostrarMenu();
				break;

			case 3:
				menuLocacao.mostrarMenu();
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
