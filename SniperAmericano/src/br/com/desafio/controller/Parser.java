package br.com.desafio.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.desafio.Util.Util;
import br.com.desafio.model.Jogador;
import br.com.desafio.model.Partida;


public class Parser {

	private List<String> linhas;
	private List<Partida> partidas = new ArrayList<>();
	private String arquivo = "";

	public Parser(String arquivo) {
		this.arquivo = arquivo;
	}

	public void parse() {

		try {
			linhas = Files.readAllLines(Paths.get(this.arquivo), Charset.forName("UTF-8"));
			Scanner scan = null;

			for (String linha : linhas) {

				scan = new Scanner(linha);

				//inicio da partida
				if (linha.contains(PalavrasReservadas.INCIO_PARTIDA.toString())) {
					verificaInicioPartida(scan);

				} //fim da partida
				else if (linha.contains(PalavrasReservadas.FIM_PARTIDA.toString())) {
					verificaFimPartida(scan);

				} //obtem assassinato
				else if (linha.contains(PalavrasReservadas.ASSASSINATO.toString())) {
					verificaAssassinato(scan);
				}
			}

		} catch (IOException e) {
			System.err.println("erro: " + e.getMessage());
		}
	}

	private void verificaFimPartida(Scanner scan) {
		String data;
		scan.useDelimiter(" ");
		data = scan.next();
		data += " " + scan.next();
		partidas.get(partidas.size() - 1).setFim(Util.formatarData(data));
	}

	private void verificaInicioPartida(Scanner scan) {
		String data;
		scan.useDelimiter(" ");
		data = scan.next();
		data += " " + scan.next();
		scan.next();
		scan.next();
		scan.next();
		Partida partida = new Partida(scan.next());
		partida.setInicio(Util.formatarData(data));
		partidas.add(partida);
	}

	private void verificaAssassinato(Scanner scan) {
		String jogadorAssassino;
		String jogadorAssassinado;
		String arma;
		scan.next();// Skip na Data
		scan.next();// Skip na Hora
		scan.next();// Skip no hifen

		jogadorAssassino = scan.next();
		scan.next();// Skip na palavra "killed"
		jogadorAssassinado = scan.next();

		scan.next();// Skip na palavra "using ou by"
		arma = scan.next();

		Jogador assassino = partidas.get(partidas.size() - 1).getJogadores().get(jogadorAssassino);
		Jogador assassinado = partidas.get(partidas.size() - 1).getJogadores().get(jogadorAssassinado);

		if (assassino == null) {	
			assassino = new Jogador(jogadorAssassino, arma);
			partidas.get(partidas.size() - 1).addJogador(jogadorAssassino, assassino);
			assassino = partidas.get(partidas.size() - 1).getJogadores().get(jogadorAssassino);
		}

		if (assassinado == null) {
			assassinado = new Jogador(jogadorAssassinado, arma);
			partidas.get(partidas.size() - 1).addJogador(jogadorAssassinado, assassinado);
			assassinado = partidas.get(partidas.size() - 1).getJogadores().get(jogadorAssassinado);
		}

		assassino.addAssassinato(assassinado);
		assassinado.quantidadeDeMortes();
	}

	public List<Partida> getPartidas() {
		return this.partidas;
	}	
}
