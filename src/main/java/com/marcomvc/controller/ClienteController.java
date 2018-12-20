package com.marcomvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marcomvc.model.Cliente;
import com.marcomvc.service.ClienteService;

@Controller
public class ClienteController {
	
	private ClienteService clienteService;
	
	@Autowired(required=true)
	@Qualifier(value="clienteService")
	public void setClienteService(ClienteService clienteService){
		this.clienteService = clienteService;
	}

	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	public String listaClientes(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("listaClientes", this.clienteService.listaClientes());
		return "cliente";
	}
	
	@RequestMapping(value= "/cliente/add", method = RequestMethod.POST)
	public String addCliente(@ModelAttribute("cliente") Cliente cliente){
		if(cliente.getId() == 0){
			this.clienteService.addCliente(cliente);
		}else{
			this.clienteService.updateCliente(cliente);
		}
		
		return "redirect:/cliente";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeClientes(@PathVariable("id") int id){
		
        this.clienteService.removeCliente(id);
        return "redirect:/cliente";
    }
    @RequestMapping("/edit/{id}")
    public String editCliente(@PathVariable("id") int id, Model model){
        model.addAttribute("cliente", this.clienteService.getClienteById(id));
        model.addAttribute("listaClientes", this.clienteService.listaClientes());
        return "cliente";
    }
	
}
