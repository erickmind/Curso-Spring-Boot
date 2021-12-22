package br.com.digisystem.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digisystem.api.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	// Spring boot faz: SELECT * FROM Produto WHERE nome like {%search%} and preco > {preco}
	public List<Produto> findByNomeContainsOrPrecoGreaterThan(String nome, float preco);
}
