package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
	
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		
		System.out.print("Check-in date (dd/MM/yyyy)");
		Date checkIn = sdf.parse(sc.next());
		
		System.out.print("Check-out date (dd/MM/yyyy)");
		Date checkOut = sdf.parse(sc.next());
		
		//after testa se uma data � depois da outra
		//se checkOut n�o � depois de checkIn
		if (!checkOut.after(checkIn)) {
			//Erro na reserva: a data de check-out deve ser posterior � data de check-in.
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			
			System.out.print("Check-in date (dd/MM/yyyy)");
			checkIn = sdf.parse(sc.next()	);
			
			System.out.print("Check-out date (dd/MM/yyyy)");
			checkOut = sdf.parse(sc.next());
			
			
			//para atualizar as datas
			//agora o updateDates vai retornar uma String
			String error = reservation.updateDates(checkIn, checkOut);
			//se error for diferente de null, signfica que veio alguma String com erro
			if(error != null) {
			    System.out.println("Error in reservation: " + error);
			}
			//se o error for null, significa que n�o teve nenhum erro
			else {
				//dados atualizados da reserva
				System.out.println("Reservation: " + reservation);
			}
		}
		
		
		sc.close();
	}

}
