package com.marcomvc.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.marcomvc.model.Cliente;

@Repository
public class ClienteDAOImpl implements ClienteDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ClienteDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	
	@Override
	public void addCliente(Cliente cliente) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(cliente);
		logger.info(cliente + " salvo com sucesso");
	}
	

	@Override
	public void updateCliente(Cliente cliente) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(cliente);
		logger.info(cliente+" atualizado com sucesso");
	}
	
	@SuppressWarnings("unchecked")
	
	@Override
	public List<Cliente> listaClientes() {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		List<Cliente> clientesList = session.createQuery("from Cliente").list();
		 
		for(Cliente cliente : clientesList){
			logger.info("Lista de clientes:"+cliente);
		
		}
		return clientesList;
	}

	
	@Override
	public Cliente getClienteById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		
		Cliente cliente = (Cliente) session.load(Cliente.class, new Integer(id));
		logger.info(cliente + " de id " + id);
		return cliente;
	}
	
	
	@Override
	public void removeCliente(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cliente cliente = (Cliente) session.load(Cliente.class, new Integer(id));
		if(null != cliente){
			session.delete(cliente);
		}
		logger.info(cliente + " deletado");
	}

}
