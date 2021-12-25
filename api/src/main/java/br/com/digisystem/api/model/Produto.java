package br.com.digisystem.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
public class Produto{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private int id;
	
	private String nome;
	private float preco;

}
