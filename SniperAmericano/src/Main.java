import java.util.Map.Entry;

import br.com.desafio.Util.Util;
import br.com.desafio.controller.Parser;
import br.com.desafio.controller.Ranking;
import br.com.desafio.model.Jogador;
import br.com.desafio.model.Partida;

/**
 * Pre-Dojo Amil
 * @author Damiana Costa
 */

public class Main {

	public static void main(String[] args) {
		System.out.println("iniciando....");
		
		Parser parser = new Parser("partidas.log");
		parser.parse();

		for (Partida partida : parser.getPartidas()) {
			Ranking ranking = new Ranking(partida);
			ranking.ignorarJogadorNoTotalAssassinatos(new Jogador("<WORLD>"));
			ranking.calcular();
			
			System.out.println("Ranking::: " + ranking.getPartida().getId());
			System.out.println("Inicio::: " + Util.formatarData(ranking.getPartida().getInicio())); 
			System.out.println("Fim:::" + Util.formatarData(ranking.getPartida().getFim()));
			
			for (Entry<String, Jogador> jogador : ranking.getPartida().getJogadores().entrySet()) {
				System.out.println("Jogador: " + jogador.getValue().getNome() + "\tMortes:" + jogador.getValue().getMortes() 
						+ "\tAssassinatos:" + jogador.getValue().getAssassinatos().size() 
						+ "\tArmas: " + jogador.getValue().getArma());
			}
			
			System.out.println("Total de assassinatos:" + ranking.getTotalAssassinatos());

		}
		
	}
}
