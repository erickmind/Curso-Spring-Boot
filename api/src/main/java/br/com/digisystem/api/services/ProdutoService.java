package br.com.digisystem.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digisystem.api.model.Produto;
import br.com.digisystem.api.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> findAll() {
		return this.produtoRepository.findAll();
	}
	
	public Optional<Produto> findById(int id){
		//return this.produtoRepository.findById(id).get();
		return this.produtoRepository.findById(id);
	}
	
	public Produto create(Produto p) {
		return this.produtoRepository.save(p);
	}
	
	public Produto update(int id, Produto prod) {
		Optional<Produto> searchProduto = this.produtoRepository.findById(id);
		
		if (searchProduto.isPresent()) {
			Produto p = searchProduto.get();
			p.setNome(prod.getNome());
			p.setPreco(prod.getPreco());
			
			return this.produtoRepository.save(p);
		}
		
		return null;
	}
	
	public void deleteById(int id) {
		this.produtoRepository.deleteById(id);
	}
	
	public List<Produto> findByNome(String nome, float preco) {
		return this.produtoRepository.findByNomeContainsAndPrecoGreaterThan(nome, preco);
	}
	
	
}
