package br.com.fundatec.locadoraveiculos.util;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.fundatec.loradoraveiculos.modelo.TipoDocumento;
import br.com.fundatec.loradoraveiculos.modelo.TipoPessoa;

public class Teclado {
	
	private Scanner scanner;
	
	public Teclado() {
		this.scanner = new Scanner(System.in);
	}
	
	public int lerOpcaoUsuario(String mensagem) {
		int opcao;
		System.out.println(mensagem);
		
		try {
			opcao = scanner.nextInt();
		} catch (InputMismatchException excecao) {
			opcao = -1;
		}
		scanner.nextLine();
		return opcao;
	} 
	
	public TipoPessoa lerTipoPessoa(String mensagem) {
		String tipoPessoa;
		do {
			System.out.println(mensagem);
			try {
			tipoPessoa = scanner.nextLine();
			return TipoPessoa.valueOf(tipoPessoa.toUpperCase());
			} catch (IllegalArgumentException excecao) {
				System.out.println("Opção inválida.");
			}
		} while (true);
	}
	
	public String lerString(String mensagem) {
		System.out.println(mensagem);
		return scanner.nextLine();
	}
	
	public Long lerLong(String mensagem) {
		do {
			System.out.println(mensagem);
			try {
			Long numero = scanner.nextLong();
			scanner.nextLine();
			return numero;
			} catch (InputMismatchException excecao) {
				System.out.println("Número informado inválido.");
			}
		} while (true);
	}
	
	public TipoDocumento lerTipoDocumento(String mensagem) {
		String tipoDocumento;
		do {
			System.out.println(mensagem);
			try {
			tipoDocumento = scanner.nextLine();
			return TipoDocumento.valueOf(tipoDocumento.toUpperCase());
			} catch (IllegalArgumentException excecao) {
				System.out.println("Opção inválida.");
			}
		} while (true);
	}
	
	public Integer lerInteger(String mensagem) {
		do {
			System.out.println(mensagem);
			try {
			Integer numero = scanner.nextInt();
			scanner.nextLine();
			return numero;
			} catch (InputMismatchException excecao) {
				System.out.println("Número informado inválido.");
			}
		} while (true);
	}
	
	
}
