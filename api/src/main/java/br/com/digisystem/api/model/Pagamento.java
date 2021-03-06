package br.com.digisystem.api.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode ( onlyExplicitlyIncluded = true)

@Builder
@Entity
public class Pagamento {
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private int id;
	
	private Date dataPagamento;
	
	@OneToOne ( mappedBy = "pagamento", cascade = CascadeType.ALL)
	private Pedido pedido;
	
	private double valor;
	
}