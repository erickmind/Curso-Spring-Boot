package br.com.digisystem.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digisystem.api.dto.ClienteDTO;
import br.com.digisystem.api.model.Cliente;
import br.com.digisystem.api.services.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping ( value = "clientes")
	public ResponseEntity< List<ClienteDTO> > getAll(){
		return  ResponseEntity.ok().body( this.clienteService.findAll() );
	}
}