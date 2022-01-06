package br.com.digisystem.api.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.digisystem.api.model.Categoria;
import br.com.digisystem.api.model.Cliente;
import br.com.digisystem.api.model.Endereco;
import br.com.digisystem.api.model.Pagamento;
import br.com.digisystem.api.model.Pedido;
import br.com.digisystem.api.model.Produto;
import br.com.digisystem.api.repositories.CategoriaRepository;
import br.com.digisystem.api.repositories.ClienteRepository;
import br.com.digisystem.api.repositories.EnderecoRepository;
import br.com.digisystem.api.repositories.PagamentoRepository;
import br.com.digisystem.api.repositories.PedidoRepository;
import br.com.digisystem.api.repositories.ProdutoRepository;

@Service
public class PopularBancoService {
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository; 
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Value("${mode}")
	private String mode;
		
	public void criarMassaDados( ) {
		
		System.out.println("MODE : " + this.mode);
		
		if  ( this.mode.contains( "dev" ) ) {
			
			Produto prod1 = Produto
					.builder()
					.nome("P1")
					.preco(100)
					.build();
			
			Produto prod2 = Produto
					.builder()
					.nome("P2")
					.preco(200)
					.build();
			
			Categoria cat1 = Categoria
					.builder()
					.nome("Categoria 1")
					.descricao("É a categoria 1")
					.build();
			
			Categoria cat2 = Categoria
					.builder()
					.nome("Categoria 2")
					.descricao("É a categoria 2")
					.build();
			
			prod1.setCategorias( Arrays.asList(  cat1, cat2 ) );
			prod2.setCategorias( Arrays.asList( cat2 ) );
			
			cat1.setProdutos( Arrays.asList( prod1  )  );
			cat2.setProdutos( Arrays.asList( prod1, prod2 ) );
			
			this.categoriaRepository.saveAll( Arrays.asList( cat1, cat2 ) );
			this.produtoRepository.saveAll( Arrays.asList( prod1, prod2  ) );
			
			ArrayList<String> telefones = new ArrayList<String>();
			telefones.add("11-982733817");
			telefones.add( "11-989298767");
			
			Cliente cli1 = Cliente
					.builder()
					.cpf("25360975016")
					.email("cliente@springboot.com")
					.senha( this.bCryptPasswordEncoder.encode( "123456" ) )
					.nome("Cliente 1")
					.telefone(   new HashSet<>( telefones ) )
					.build();
			
			Endereco end1 = Endereco
					.builder()
					.logradouro("Avenida Paulista")
					.bairro("Bela Vista")
					.numero("1159")
					.complemento("1 Andar")
					.cidade("São Paulo")
					.cep("01311-200")
					.cliente( cli1 )
					.build();
			
			Endereco end2 = Endereco
					.builder()
					.logradouro("Avenida Paulista")
					.bairro("Bela Vista")
					.numero("1159")
					.complemento("1 Andar")
					.cidade("São Paulo")
					.cep("01311-200")
					.cliente( cli1 )
					.build();
									
			cli1.setEnderecos( Arrays.asList( end1 , end2   )  );
			
			
			this.clienteRepository.save( cli1 );
			this.enderecoRepository.saveAll( Arrays.asList( end1, end2 ) );
			
			Pedido ped1 = Pedido
					.builder()
					.dataPedido( new Date() )
					.build();
			
			Pagamento pag1 = Pagamento
					.builder()
					.valor(1000)
					.dataPagamento( new Date() )
					.pedido( ped1 )
					.build();

			ped1.setPagamento( pag1 );
			
			this.pagamentoRepository.save( pag1 );
			this.pedidoRepository.save(ped1);
				 
			
		}
	}
	
}