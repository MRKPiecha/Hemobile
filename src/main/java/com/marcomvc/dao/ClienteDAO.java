package com.marcomvc.dao;

import java.util.List;

import com.marcomvc.model.Cliente;

public interface ClienteDAO {

	public void addCliente(Cliente cliente);
	public void updateCliente(Cliente cliente);
	public List<Cliente> listaClientes();
	public Cliente getClienteById(int id);
	public void removeCliente(int id);
}
