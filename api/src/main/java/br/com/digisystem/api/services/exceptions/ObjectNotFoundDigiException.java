package br.com.digisystem.api.services.exceptions;


// Classe que cuida quando ha erros (exceptions) do tipo ObjectNotFoundDigiException
public class ObjectNotFoundDigiException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundDigiException (String mensagem) {
		super(mensagem);
	}
	
	public ObjectNotFoundDigiException (String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
