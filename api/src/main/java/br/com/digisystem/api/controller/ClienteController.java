package br.com.digisystem.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.digisystem.api.model.Cliente;
import br.com.digisystem.api.services.ClienteService;
import br.com.digisystem.api.services.exceptions.ObjectNotFoundDigiException;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value = "clientes")
	public ResponseEntity<List<Cliente>> getAll() {
		List<Cliente> listCli = this.clienteService.findAll();
		
		return ResponseEntity.ok().body(listCli);
	}
	
	@GetMapping(value = "clientes/{id}")
	public ResponseEntity<Cliente> get(@PathVariable("id") int idCliente){
		Cliente cli = this.clienteService.findById(idCliente).orElseThrow(
				() -> new ObjectNotFoundDigiException("ID do cliente nao encontrado")
				);
		return ResponseEntity.ok().body(cli);
	}
}
