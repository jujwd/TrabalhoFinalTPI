package br.com.fundatec.locadoraveiculos.bancodados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import br.com.fundatec.loradoraveiculos.modelo.Cliente;

public class TabelaCliente {
	
	private static TabelaCliente instancia;
	
	private List<Cliente> clientes;
	
	private TabelaCliente() {
		this.clientes = new ArrayList<>();
		}
	
	public static TabelaCliente obter() {
		if (instancia == null) {
			instancia = new TabelaCliente();
		}
		
		return instancia;
	}
	
	//public List<Cliente> clientes () {
	//	for (Cliente cliente : clientes);
	//	return clientes;
	//}
	
	public void incluir (Cliente novoCliente) {
		this.clientes.add(novoCliente);
		
	}
	
	public List<Cliente> getClientes() {
		return Collections.unmodifiableList(clientes);
	}
}
