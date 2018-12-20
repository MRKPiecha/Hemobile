package com.marcomvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marcomvc.model.Hemocentro;
import com.marcomvc.service.HemocentroService;

@Controller
public class HemocentroController {
	
	private HemocentroService hemocentroService;
	
	@Autowired(required=true)
	@Qualifier(value="hemocentroService")
	public void setHemocentroService(HemocentroService hemocentroService){
		this.hemocentroService = hemocentroService;
	}

	@RequestMapping(value = "/hemocentro", method = RequestMethod.GET)
	public String listaHemocentros(Model model) {
		model.addAttribute("hemocentro", new Hemocentro());
		model.addAttribute("listaHemocentros", this.hemocentroService.listaHemocentros());
		return "hemocentro";
	}
	
	@RequestMapping(value= "/hemocentro/add", method = RequestMethod.POST)
	public String addCliente(@ModelAttribute("hemocentro") Hemocentro hemocentro){
		if(hemocentro.getId() == 0){
			this.hemocentroService.addHemocentro(hemocentro);
		}else{
			this.hemocentroService.updateHemocentro(hemocentro);
		}
		
		return "redirect:/hemocentro";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeHemocentros(@PathVariable("id") int id){
		
        this.hemocentroService.removeHemocentro(id);
        return "redirect:/hemocentro";
    }
    @RequestMapping("/edit/{id}")
    public String editHemocentro(@PathVariable("id") int id, Model model){
        model.addAttribute("hemocentro", this.hemocentroService.getHemocentroById(id));
        model.addAttribute("listaClientes", this.hemocentroService.listaHemocentros());
        return "hemocentro";
    }
	
}