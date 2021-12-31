package br.com.digisystem.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.digisystem.api.model.Produto;
import br.com.digisystem.api.services.ProdutoService;
import br.com.digisystem.api.services.exceptions.ObjectNotFoundDigiException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ProdutoController {
	
	//Injeção de dependências
	@Autowired
	private ProdutoService produtoService;
	//private ProdutoService produtoService = new ProdutoService();

	//@RequestMapping( method = RequestMethod.GET, value = "produtos" )
	@GetMapping( value = "produtos" )
	public ResponseEntity < List<Produto> > getAll() {
		
		List<Produto> list = this.produtoService.findAll();
		
		return ResponseEntity.ok().body( list );
	}
	
	@GetMapping( value = "produtos/{id}" )
	public ResponseEntity <Produto> get( @PathVariable("id") int idProduto ) {
				
		Produto p = this.produtoService.findById(idProduto)
				.orElseThrow( 
						() -> new ObjectNotFoundDigiException("ID do produto não encontrado!") 
				);
		return ResponseEntity.status( HttpStatus.OK ).body( p );	
	}
	

	
	@PostMapping ( value = "produtos" )
	public Produto create( @RequestBody Produto p  ) {
		
		log.info( p.toString() );
		
		return this.produtoService.create(p);		
	}
	
	//PUT ou PATCH
	@PutMapping ( value = "produtos/{id}" )
	public Produto update( @PathVariable("id") int id, @RequestBody Produto p ) {
		log.info( p.toString() );
		return this.produtoService.update(id, p);		
	}
	
	@DeleteMapping ( value = "produtos/{id}" )
	public boolean delete( @PathVariable("id") int id ) {
		return this.produtoService.deleteById(id);
	}	
	
	@GetMapping( value = "produtos/search/{nome}/{preco}" )
	public List<Produto> getByName( 			
			@PathVariable("nome") String nome,
			@PathVariable("preco") float preco,
			@RequestParam(value = "fcid", defaultValue = "") String fcid 
		) {
		System.out.println( fcid );
		return this.produtoService.findByNome( nome, preco );		
	}
	
	
	@GetMapping( value = "produtos/search/{nome}" )
	public List<Produto> getByNameWithouPreco( 			
			@PathVariable("nome") String nome,			
			@RequestParam(value = "autoplay", defaultValue = "0") String autoplay
		) {
		System.out.println( autoplay );
		return this.produtoService.findByNome( nome, 0 );		
	}

	
}