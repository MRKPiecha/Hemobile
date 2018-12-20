package com.marcomvc.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcomvc.dao.ClienteDAO;
import com.marcomvc.model.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private ClienteDAO clienteDAO;
	
	
	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	@Override
	@Transactional
	public void addCliente(Cliente cliente) {
		this.clienteDAO.addCliente(cliente);
	}

	@Override
	@Transactional
	public void updateCliente(Cliente cliente) {
		this.clienteDAO.updateCliente(cliente);
	}

	@Override
	@Transactional
	public List<Cliente> listaClientes() {
		return this.clienteDAO.listaClientes();
	}

	@Override
	@Transactional
	public Cliente getClienteById(int id) {
		return this.clienteDAO.getClienteById(id);
	}

	@Override
	@Transactional
	public void removeCliente(int id) {
		this.clienteDAO.removeCliente(id);
	}


}
