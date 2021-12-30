package br.com.digisystem.api.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Builder
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Cliente {

	@Id //Chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Auto increment
	@EqualsAndHashCode.Include
	private int id;
	
	private String nome;
	private String email;
	private String cpf;
	
	@OneToMany (mappedBy = "cliente")
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	@ElementCollection
	@CollectionTable ( name = "telefone" )
	private Set<String> telefone = new HashSet<String>();
}
