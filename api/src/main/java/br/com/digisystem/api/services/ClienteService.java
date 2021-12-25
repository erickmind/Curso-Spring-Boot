package br.com.digisystem.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digisystem.api.model.Cliente;
import br.com.digisystem.api.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findAll(){
		return this.clienteRepository.findAll();
	}
	
	public Optional<Cliente> findById(int idCliente) {
		return this.clienteRepository.findById(idCliente);
	}
}
