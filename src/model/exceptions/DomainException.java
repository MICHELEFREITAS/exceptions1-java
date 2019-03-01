package model.exceptions;

//Exceção personalizada
public class DomainException extends RuntimeException{
    //versão de uma classe serialzable
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		//permitir eu estanciar a versão passando uma msg
		super(msg);
	}

}
