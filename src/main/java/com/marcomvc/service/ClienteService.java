package com.marcomvc.service;

import java.util.List;

import com.marcomvc.model.Cliente;

public interface ClienteService {

	public void addCliente(Cliente cliente);
	public void updateCliente(Cliente cliente);
	public List<Cliente> listaClientes();
	public Cliente getClienteById(int id);
	public void removeCliente(int id);
	
}
