package model.exceptions;

//Exce��o personalizada
public class DomainException extends RuntimeException{
    //vers�o de uma classe serialzable
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		//permitir eu estanciar a vers�o passando uma msg
		super(msg);
	}

}
