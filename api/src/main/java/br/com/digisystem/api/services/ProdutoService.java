package br.com.digisystem.api.services;

import java.util.List;

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
	
	public Produto create(Produto p) {
		return this.produtoRepository.save(p);
	}
}
