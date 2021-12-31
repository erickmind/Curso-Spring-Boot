package br.com.digisystem.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digisystem.api.dto.ClienteDTO;
import br.com.digisystem.api.model.Cliente;
import br.com.digisystem.api.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<ClienteDTO> findAll(){
		/*Convertendo Cliente para ClienteDTO*/
		
		List<Cliente> listCliente = this.clienteRepository.findAll();
		
		List<ClienteDTO> listClienteDTO = new ArrayList<ClienteDTO>();
		
		for(Cliente cli : listCliente) {
			ClienteDTO clienteDTO = ClienteDTO
					.builder()
					.cpf(cli.getCpf())
					.email(cli.getEmail())
					.id(cli.getId())
					.nome(cli.getNome())
					.build();
			
			listClienteDTO.add(clienteDTO);
		}
		return listClienteDTO;
	}
	
	public Cliente findByEmail(String email) {
		return this.clienteRepository.findByEmail(email);		
	}
	
	public Optional<Cliente> findById(int idCliente) {
		return this.clienteRepository.findById(idCliente);
	}
}
