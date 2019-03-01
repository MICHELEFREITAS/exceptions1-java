package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			
			System.out.print("Check-in date (dd/MM/yyyy)");
			checkIn = sdf.parse(sc.next());
			
			System.out.print("Check-out date (dd/MM/yyyy)");
			checkOut = sdf.parse(sc.next());
			
			//para atualizar as datas
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
		}
		catch(DomainException e) {
			//esse getMessage pega a mens. que passei no Reservation. Msg personalizada
			System.out.println("Error in reservation " + e.getMessage());
		}
		//qualquer outra exceção inesperada eu vou mostrar a msg
		catch(RuntimeException e) {
			System.out.println("Unexpected erro");
		}
		
		
		sc.close();
	}

}
