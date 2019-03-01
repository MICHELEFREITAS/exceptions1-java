package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.zip.CheckedOutputStream;

import javax.security.auth.callback.ChoiceCallback;

public class Reservation {
	//n�mero quarto
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	//o sdf � static para que n�o seja instanciado outro Dateformat
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date chechOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = chechOut;
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
	
	public String updateDates(Date checkIn, Date checkOut) {
		
		//As datas n�o podem ser anteriores da atual
		Date now = new Date();
		
		//se alguma das datas forem anterior a de agora
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Reservation: Reservation dates for update must be future dates";
		}
		
		//se data checkOut n�o for posterior a data de checkIn
		if (!checkOut.after(checkIn)) {
			return "Check-out date must be after check-in date";
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		//para falar que a oper��o n�o deu nehum erro.
		return null;
		
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
