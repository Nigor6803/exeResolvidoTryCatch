package model.entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		};
	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}
	
	public void setNumeroQuarto (Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	
	public Date getCheckIn() {
		return checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracao() {
		long diferenca = checkOut.getTime()-checkIn.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public String atualizacaoDatas(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if(checkIn.before(now) || (checkOut.before(now))) {
			return "ERRO: VERIFICAR DATAS DE ENTRADA E SAIDA";
		} 
		if (!checkOut.after(checkIn)) {
			return "ERRO: VERIFICAR DATAS DE ENTRADA E SAIDA";
		} 
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		return "QUARTO: "
				+numeroQuarto
				+" - ENTRADA: "
				+sdf.format(checkIn)
				+" - SAIDA: "
				+sdf.format(checkOut)
				+" - "
				+duracao()
				+" NOITES";
	}
	
}
