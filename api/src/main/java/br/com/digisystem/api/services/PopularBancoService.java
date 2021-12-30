package br.com.digisystem.api.services;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.digisystem.api.model.Cliente;
import br.com.digisystem.api.model.Endereco;
import br.com.digisystem.api.model.Pagamento;
import br.com.digisystem.api.model.Pedido;
import br.com.digisystem.api.model.Produto;
import br.com.digisystem.api.repositories.ClienteRepository;
import br.com.digisystem.api.repositories.EnderecoRepository;
import br.com.digisystem.api.repositories.PagamentoRepository;
import br.com.digisystem.api.repositories.PedidoRepository;
import br.com.digisystem.api.repositories.ProdutoRepository;
import lombok.Builder;

@Service
public class PopularBancoService {
	
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
			
			Cliente cli1 = Cliente
					.builder()
					.cpf("576.047.080-99")
					.email("cliente@springboot.com")
					.nome("Cliente1 ")
					.build();
			
			Endereco end1 = Endereco
					.builder()
					.logradouro("Avenida Paulista")
					.bairro("Bela Vista")
					.numero("1159")
					.complemento("1 andar")
					.cidade("Sao Paulo")
					.cep("01311-200")
					.cliente(cli1)
					.build();
			
			Endereco end2 = Endereco
					.builder()
					.logradouro("Avenida Paulista")
					.bairro("Bela Vista")
					.numero("1159")
					.complemento("1 andar")
					.cidade("Sao Paulo")
					.cep("01311-200")
					.cliente(cli1)
					.build();
			
			cli1.setEnderecos(Arrays.asList(end1, end2)); // Para adicionar enderecos direto como um tipo Lista
			
			this.clienteRepository.save(cli1);
			this.enderecoRepository.saveAll(Arrays.asList(end1, end2));
			
			Pedido ped1 = Pedido
					.builder()
					.dataPedido( new Date())
					.build();
			
			Pagamento pag1 = Pagamento
					.builder()
					.valor(1000)
					.dataPagamento(new Date())
					.pedido(ped1)
					.build();
			
			ped1.setPagamento(pag1);
			
			this.pagamentoRepository.save(pag1);
			this.pedidoRepository.save(ped1);
			
		}	
	}
}
