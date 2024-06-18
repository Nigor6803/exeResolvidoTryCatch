package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidade.Reserva;

public class Progama {

	public static void main(String[] args) throws ParseException {

		Scanner edd = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("NÚMERO DO QUARTO:");
		int numero = edd.nextInt();
		System.out.print("DIA DE CHEGADA:");
		Date checkIn = sdf.parse(edd.next());
		System.out.print("DIA DE SAIDA:");
		Date checkOut = sdf.parse(edd.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("ERRO: VERIFICAR DATAS DE ENTRADA E SAIDA");
		} 
		else {
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.print(reserva);

			System.out.println();
			System.out.println();
			System.out.println("ATUALIZAÇÃO DE DATAS");
			System.out.print("DIA DE CHEGADA:");
			checkIn = sdf.parse(edd.next());
			System.out.print("DIA DE SAIDA:");
			checkOut = sdf.parse(edd.next());
			
			Date now = new Date();
			if(checkIn.before(now) || (checkOut.before(now))) {
				System.out.println("ERRO: VERIFICAR DATAS DE ENTRADA E SAIDA");
			} 
			else if (!checkOut.after(checkIn)) {
				System.out.println("ERRO: VERIFICAR DATAS DE ENTRADA E SAIDA");
			} 
			else {
			reserva.atualizacaoDatas(checkIn, checkOut);
			System.out.print(reserva);
			}
		}
		edd.close();
	}
}
