package com.marcomvc.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcomvc.dao.HemocentroDAO;
import com.marcomvc.model.Hemocentro;

@Service
public class HemocentroServiceImpl implements HemocentroService {
	
	private HemocentroDAO hemocentroDAO;
	
	
	public void setHemocentroDAO(HemocentroDAO hemocentroDAO) {
		this.hemocentroDAO = hemocentroDAO;
	}

	@Override
	@Transactional
	public void addHemocentro(Hemocentro hemocentro) {
		this.hemocentroDAO.addHemocentro(hemocentro);
	}

	@Override
	@Transactional
	public void updateHemocentro(Hemocentro hemocentro) {
		this.hemocentroDAO.updateHemocentro(hemocentro);
	}

	@Override
	@Transactional
	public List<Hemocentro> listaHemocentros() {
		return this.hemocentroDAO.listaHemocentros();
	}

	@Override
	@Transactional
	public Hemocentro getHemocentroById(int id) {
		return this.hemocentroDAO.getHemocentroById(id);
	}

	@Override
	@Transactional
	public void removeHemocentro(int id) {
		this.hemocentroDAO.removeHemocentro(id);
	}


}
