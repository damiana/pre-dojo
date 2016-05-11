package br.com.desafio.teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.desafio.controller.Parser;
import br.com.desafio.controller.Ranking;
import br.com.desafio.model.Jogador;
import br.com.desafio.model.Partida;

public class Teste {

	Parser parser;

	@Before
	public void setupParser() {
		parser = new Parser("partidas-teste.log");
		parser.parse();
		assertNotNull(parser);
	}

	@Test
	public void isExistemDoisAssassinatos() {
		for (Partida partida : parser.getPartidas()) {
			Ranking ranking = new Ranking(partida);
			ranking.calcular();
			assertTrue(ranking.getTotalAssassinatos() == 2);	
		}
	}

	@Test
	public void ignorarMorteJogador() {
		for (Partida partida : parser.getPartidas()) {
			Ranking ranking = new Ranking(partida);
			ranking.ignorarJogadorNoTotalAssassinatos(new Jogador("<WORLD>"));
			ranking.calcular();
			assertTrue(ranking.getTotalAssassinatos() == 1);
		}
	}

	@Test
	public void calcularMortes() {
		for (Partida partida : parser.getPartidas()) {
			Ranking rank = new Ranking(partida);
			rank.calcular();
			assertTrue(rank.getTotalAssassinatos() == 2);
		}
	}	
}
