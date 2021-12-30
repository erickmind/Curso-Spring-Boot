package br.com.digisystem.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digisystem.api.model.Categoria;
import br.com.digisystem.api.services.CategoriaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping ( value = "categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;  
	
	@GetMapping
	public ResponseEntity< List<Categoria> > getAll(){
		
		List<Categoria> list  = this.categoriaService.getAll();		
		return ResponseEntity.ok().body( list );
	}
	
	@GetMapping (value = "{id}")
	public ResponseEntity< Categoria > getOne ( @PathVariable("id") int id ){
		
		Categoria resource  = this.categoriaService.getOne( id ).get();	
		
		return ResponseEntity.ok().body( resource );
	}
	
	@PostMapping
	public ResponseEntity< Categoria > create(  @RequestBody Categoria resource ){
		
		resource = this.categoriaService.create(resource);		
		return ResponseEntity.ok().body( resource );
	}
	
	//PUT ou PATCH
	@PutMapping ( value = "{id}" )
	public ResponseEntity< Categoria > update( @PathVariable("id") int id, @RequestBody Categoria resource ) {
		
		resource =  this.categoriaService.update(id, resource);	
		return ResponseEntity.ok().body( resource );
	}
	
	@DeleteMapping ( value = "{id}" )
	public boolean delete( @PathVariable("id") int id ) {
		return this.categoriaService.deleteById(id);
	}	
}