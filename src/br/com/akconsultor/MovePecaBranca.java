package br.com.akconsultor;

public class MovePecaBranca {
	MovePecaBranca(Peca a, int colunaDestino, int linhaDestino){

		
		if(a.verificaDestino[colunaDestino][linhaDestino]) {
			a.desfazPosicao();
			a.setPosicao(colunaDestino, linhaDestino);
		} else {
			System.out.println("Essa pe�a n�o pode mover assim");
		}
		
		
//nova posicao de linha e destino ok
		
	}
}
