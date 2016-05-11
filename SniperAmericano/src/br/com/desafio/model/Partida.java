package br.com.desafio.model;

import java.util.Date;
import java.util.TreeMap;

/**
 * Pre-Dojo Amil
 * @author Damiana Costa
 */
public class Partida {
	
	private String id;
	private Date inicio;
	private Date fim;
	private long duracao; //miliSegundos
	private TreeMap<String, Jogador> jogadores = new TreeMap<String, Jogador>();
	
	
	public Partida(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFim() {
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	public long getDuracao() {
		
		if (this.getInicio()!=null && this.getFim()!=null) {
			this.duracao = this.getFim().getTime()-this.getInicio().getTime();
		}
		return duracao;
	}
	public void setDuracao(long duracao) {
		this.duracao = duracao;
	}
	
	public void addJogador(String nome, Jogador jogador) {
		this.jogadores.put(nome, jogador);
	}
	
	public TreeMap<String, Jogador> getJogadores() {
		return jogadores;
	}
	
}
