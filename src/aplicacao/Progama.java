package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidade.Reserva;
import model.excecao.DominioExcecao;

public class Progama {

	public static void main(String[] args) {

		Scanner edd = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		System.out.print("NÚMERO DO QUARTO:");
		int numero = edd.nextInt();
		System.out.print("DIA DE CHEGADA:");
		Date checkIn = sdf.parse(edd.next());
		System.out.print("DIA DE SAIDA:");
		Date checkOut = sdf.parse(edd.next());

		Reserva reserva = new Reserva(numero, checkIn, checkOut);
		System.out.print("RESERVA: " + reserva);

		System.out.println();
		System.out.println();
		System.out.println("ATUALIZAÇÃO DE DATAS");
		System.out.print("DIA DE CHEGADA:");
		checkIn = sdf.parse(edd.next());
		System.out.print("DIA DE SAIDA:");
		checkOut = sdf.parse(edd.next());

		reserva.atualizacaoDatas(checkIn, checkOut);

		System.out.print(reserva);
		}
		catch(ParseException e) {
			System.out.println("FORMATO DE DATA INVALIDO");
		}
		catch(DominioExcecao e) {
			System.out.println("ERRO NA RESERVA: " +e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("ERRO INESPERADO: ");
		}
		edd.close();
	}
}
