package br.com.desafio.controller;

import java.util.HashSet;
import java.util.Map;

import br.com.desafio.model.Jogador;
import br.com.desafio.model.Partida;

public class Ranking {

	private int totalAssassinatos = 0;
	private HashSet<Jogador> jogadoresIgnorados = new HashSet<Jogador>();
	private Partida partida;
	
	public Ranking(Partida partida) {
		this.partida = partida;
	}
	
	public void calcular() {
		for (Map.Entry<String, Jogador> jogador : partida.getJogadores().entrySet()) {
			if (!jogadoresIgnorados.contains(jogador.getValue())) {
				totalAssassinatos += jogador.getValue().getAssassinatos().size();
			}
		}
	}

	public int getTotalAssassinatos() {
		return totalAssassinatos;
	}

	public void ignorarJogadorNoTotalAssassinatos(Jogador jogador) {
		jogadoresIgnorados.add(jogador);	
	}

	public Partida getPartida() {
		return partida;
	}
}
