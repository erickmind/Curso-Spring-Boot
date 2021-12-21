package br.com.digisystem.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.digisystem.api.model.Produto;
import br.com.digisystem.api.services.ProdutoService;

@RestController
public class ProdutoController {

	List<Produto> listaProduto = new ArrayList<Produto>();
	
	//Injecao de dependencias
	@Autowired
	private ProdutoService produtoService;
	
	// GET para pegar informacoes ja existentes (Read do CRUD)
	//@RequestMapping (method = RequestMethod.GET, value = "produtos")
	@GetMapping(value = "produtos")
	public List<Produto> getAll() {
		return this.produtoService.findAll();
	}
	
	// GET para pegar informacoes ja existentes (Read do CRUD)
	@GetMapping(value = "produtos/{id}")
	public Produto get(@PathVariable("id") int idProduto) {
		return listaProduto.get(idProduto);
	}
	
	// POST para enviar dados novos (Create do CRUD)
	@PostMapping (value = "produtos")
	public Produto create(@RequestBody Produto p) {
		return this.produtoService.create(p);
	}
	
	//PUT ou PATCH para alterar algo que ja existe (Update do CRUD)
	@PutMapping (value = "produtos/{id}")
	public Produto update(@PathVariable("id") int id, @RequestBody Produto p) {
			
		Produto oldProduto = listaProduto.get(id);
		oldProduto.setNome(p.getNome());
		oldProduto.setPreco(p.getPreco());
		
		listaProduto.set(id, oldProduto);
		
		return oldProduto;
	}
	
	@DeleteMapping (value = "produtos/{id}")
	public void delete(@PathVariable("id") int id) {
		listaProduto.remove(id);
	}
	
	
}
