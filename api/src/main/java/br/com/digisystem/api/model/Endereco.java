package br.com.digisystem.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@EqualsAndHashCode (onlyExplicitlyIncluded = true) // Para que tenhamos que explicitar quais atributos terao o equals e hashcode alterados
@AllArgsConstructor
@NoArgsConstructor

@Entity
// @Table (name = "enderecao") para mudar o nome da tabela de "Endereco" para "enderecao"
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include // Medida de seguranca para garantir que a comparacao entre dois objetos so sera igual se tiverem o mesmo id (chave primaria)
	private int id;
	
	// @JsonProperty(value = "logradouro-do-teste") Para mudar o atributo no JSON retornado na requisicao
	// @Column(name="rua") Para trocar o nome da coluna "logradouro" para "rua"
	@NotNull // Para que o campo não inicie vazio
	private String logradouro;
	
	private String numero;
	private String complemento;
	private String cidade;
	private String bairro;
	private String cep;
	
	@ManyToOne // relacao n para 1
	@JoinColumn(name = "cliente_id") // Para saber que a chave estrangeira eh o id da classe: cliente
	@JsonIgnore // Para que o json nao cicle e retorne clientes dentro de enderecos... ate o infinito
	private Cliente cliente;
}
