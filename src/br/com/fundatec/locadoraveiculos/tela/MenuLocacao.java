package br.com.fundatec.locadoraveiculos.tela;
import br.com.fundatec.locadoraveiculos.util.Teclado;
public class MenuLocacao {

	private Teclado teclado;

	public MenuLocacao(Teclado teclado) {
		this.teclado = teclado;
	}

	public void mostrarMenu() {
		int opcao;

		do {
			System.out.println("MENU LOCACAO");
			System.out.println(" [1] - Cadastrar Locacao");
			System.out.println(" [2] - Listar Locacoes");
			System.out.println(" [0] - Voltar");

			opcao = teclado.lerOpcaoUsuario("Informe a opção desejada");

			switch (opcao) {
			case 1:
				System.out.println("Cadastrar Locacao");
				break;

			case 2:
				System.out.println("Listar Locacoes");
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
