package br.com.desafio.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static Date formatarData(String dataStr) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(dataStr);
		} catch (ParseException e) {
			System.out.println("erro: " + e.getMessage());
		}
		return null;
	}
	
	public static String formatarData(Date date) {
			return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);
	}
}
