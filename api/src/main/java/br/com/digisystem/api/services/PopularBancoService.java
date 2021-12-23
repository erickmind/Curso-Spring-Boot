package br.com.digisystem.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.digisystem.api.model.Produto;
import br.com.digisystem.api.repositories.ProdutoRepository;

@Service
public class PopularBancoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Value("${mode}")
	private String mode;
	
	public void criarMassaDados() {
		if (this.mode.contains("dev")) {
			Produto p1 = Produto
					.builder()
					.nome("P1")
					.preco(100)
					.build();
			
			this.produtoRepository.save(p1);
		}
		
	}
	
	
}
