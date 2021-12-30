package br.com.digisystem.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digisystem.api.model.Categoria;
import br.com.digisystem.api.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> getAll(){
		return this.categoriaRepository.findAll();
	}
	
	public Optional<Categoria> getOne(int id){
		return this.categoriaRepository.findById(id);
	}
	
	public Categoria create( Categoria resource) {
		return this.categoriaRepository.save(resource);
	}
	
	public Categoria update(int id, Categoria resource) {
		Optional<Categoria> search = this.categoriaRepository.findById(id);
		
		if ( search.isPresent() ) {
			Categoria obj = search.get();
			obj.setNome( resource.getNome()  );
			obj.setDescricao( resource.getDescricao() );
			
			return this.categoriaRepository.save( obj );
		}			
		
		return null;
	}
	
	public boolean deleteById(int id) {
		this.categoriaRepository.deleteById(id);
		
		return true;
	}
	
}