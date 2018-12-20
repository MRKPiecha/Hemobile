package com.marcomvc.dao;

import java.util.List;

import com.marcomvc.model.Hemocentro;

public interface HemocentroDAO {

	public void addHemocentro(Hemocentro hemocentro);
	public void updateHemocentro(Hemocentro hemocentro);
	public List<Hemocentro> listaHemocentros();
	public Hemocentro getHemocentroById(int id);
	public void removeHemocentro(int id);
}
