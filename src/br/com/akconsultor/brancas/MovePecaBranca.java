package br.com.akconsultor.brancas;

import br.com.akconsultor.VerTabuleiro;

public class MovePecaBranca {
	public MovePecaBranca(PecaBranca a, int colunaDestino, int linhaDestino){

		
		if(a.verificaDestino[colunaDestino][linhaDestino]) {
			a.desfazPosicao();
			a.setPosicao(colunaDestino, linhaDestino);
		} else {
			System.out.println("Essa peça não pode mover assim");
		}
		
		new VerTabuleiro();
		a.getCapturou();
		
		
//nova posicao de linha e destino ok
		
	}
}
