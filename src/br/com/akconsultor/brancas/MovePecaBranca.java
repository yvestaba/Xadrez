package br.com.akconsultor.brancas;


public class MovePecaBranca {
	public MovePecaBranca(PecaBranca a, int colunaDestino, int linhaDestino){

		
		if(a.verificaDestino[colunaDestino][linhaDestino]) {
			a.desfazPosicao();
			a.setPosicao(colunaDestino, linhaDestino);
		} else {
			System.out.println("Essa peça não pode mover assim");
		}
		
		
//nova posicao de linha e destino ok
		
	}
}
