package com.marcomvc.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.marcomvc.model.Hemocentro;

@Repository
public class HemocentroDAOImpl implements HemocentroDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(HemocentroDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	
	@Override
	public void addHemocentro(Hemocentro hemocentro) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(hemocentro);
		logger.info(hemocentro + " salvo com sucesso");
	}
	

	@Override
	public void updateHemocentro(Hemocentro hemocentro) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(hemocentro);
		logger.info(hemocentro+" atualizado com sucesso");
	}
	
	@SuppressWarnings("unchecked")
	
	@Override
	public List<Hemocentro> listaHemocentros() {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		List<Hemocentro> hemocentrosList = session.createQuery("from Hemocentro").list();
		 
		for(Hemocentro hemocentro : hemocentrosList){
			logger.info("Lista de hemocentros:"+hemocentro);
		
		}
		return hemocentrosList;
	}

	
	@Override
	public Hemocentro getHemocentroById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		
		Hemocentro hemocentro = (Hemocentro) session.load(Hemocentro.class, new Integer(id));
		logger.info(hemocentro + " de id " + id);
		return hemocentro;
	}
	
	
	@Override
	public void removeHemocentro(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Hemocentro hemocentro = (Hemocentro) session.load(Hemocentro.class, new Integer(id));
		if(null != hemocentro){
			session.delete(hemocentro);
		}
		logger.info(hemocentro + " deletado");
	}

}
