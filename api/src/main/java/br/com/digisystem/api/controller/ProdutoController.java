package br.com.digisystem.api.controller;

import java.util.ArrayList;
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

import com.google.common.base.Optional;

import br.com.digisystem.api.model.Produto;
import br.com.digisystem.api.services.ProdutoService;
import br.com.digisystem.api.services.exceptions.ObjectNotFoundDigiException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ProdutoController {

	List<Produto> listaProduto = new ArrayList<Produto>();
	
	//Injecao de dependencias
	@Autowired
	private ProdutoService produtoService;
	
	// GET para pegar informacoes ja existentes (Read do CRUD)
	//@RequestMapping (method = RequestMethod.GET, value = "produtos")
	@GetMapping(value = "produtos")
	public ResponseEntity<List<Produto>> getAll() {
		List<Produto> list = this.produtoService.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	// GET para pegar informacoes ja existentes (Read do CRUD)
	@GetMapping(value = "produtos/{id}")
	public ResponseEntity<Produto> get(@PathVariable("id") int idProduto) {
		Produto p = this.produtoService.findById(idProduto).orElseThrow( 
				() -> new ObjectNotFoundDigiException("ID do produto não encontrado")
				);
		
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
	
	// POST para enviar dados novos (Create do CRUD)
	@PostMapping (value = "produtos")
	public ResponseEntity<Produto> create(@RequestBody Produto p) {
		Produto prod = this.produtoService.create(p);
		
		return ResponseEntity.ok().body(prod);
	}
	
	//PUT ou PATCH para alterar algo que ja existe (Update do CRUD)
	@PutMapping (value = "produtos/{id}")
	public ResponseEntity<Produto> update(@PathVariable("id") int id, @RequestBody Produto p) {
		Produto prod = this.produtoService.update(id, p);
		
		return ResponseEntity.ok().body(prod);
	}
	
	@DeleteMapping (value = "produtos/{id}")
	public void delete(@PathVariable("id") int id) {
		this.produtoService.deleteById(id);
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
	
}
