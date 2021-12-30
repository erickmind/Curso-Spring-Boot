package br.com.digisystem.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.digisystem.api.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	// SELECT * FROM Produto WHERE nome like {%search%} and preco > {preco} 
		@Query("select prod from Produto prod where prod.nome = :nomeProduto and prod.preco >= :precoProduto")
		public List<Produto> findByNomeContainsAndPrecoGreaterThan (
				@Param ("nomeProduto") String nome,
				@Param ("precoProduto") double preco    );
		
		@Query("select prod from Produto prod JOIN prod.categorias cat where prod.nome = :nomeProduto and prod.preco >= :precoProduto")
		public List<Produto> procurarPorProdutoePreco (
				@Param ("nomeProduto") String nome,
				@Param ("precoProduto") double preco    );
	
	
	//public Optional<List<Produto>> findByNomeContainsOrPrecoGreaterThan(String nome, float preco);

}
