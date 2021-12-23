package br.com.digisystem.api.handlers;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

//Classe que possui objetos que armazenam as informacoes de erro
@Data
@Builder
public class StandardError {
	
	private String mensagem;
	private int status;
	private Date timestamp;
}
