package br.com.digisystem.api.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode ( onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor

@Builder
@Entity
public class Cliente {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private int id;
	
	private String nome;
	private String email;
	
	//@JsonProperty(access = Access.WRITE_ONLY)
	private String senha;
	
	private String cpf;
		
	@OneToMany( mappedBy = "cliente")	
	private List<Endereco> enderecos;
	
	@ElementCollection
	@CollectionTable ( name = "telefone" )
	private Set<String> telefone = new HashSet<String>();
	
}