package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	//n�mero quarto
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	//o sdf � static para que n�o seja instanciado outro Dateformat
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut){
		//tratar exce��es no come�o do m�todo. Programa��o defensiva
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getChechOut() {
		return checkOut;
	}
	
	//dura��o reserva
	public long duration() {
		//diferern�a entre duas datas em milissegundos
		long diff = checkOut.getTime() - checkIn.getTime();
		
		//converter milissegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut){
		
		//As datas n�o podem ser anteriores da atual
		Date now = new Date();
		
		//se alguma das datas forem antes da data atual
		if (checkIn.before(now) || checkOut.before(now)) {
			//para lan�ar uma exce��o quando os argumentos s�o inv�lidos. Erro no argumento do m�todo
			throw new DomainException("Reservation dates for update must be future dates");
		}
		
		//se data checkOut n�o for posterior a data de checkIn
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
    }
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
				
	}


}
