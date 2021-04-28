package br.com.akconsultor;

public class MovePecaBranca {
	MovePecaBranca(Peca a, int colunaDestino, int linhaDestino){
		int colunaAtual = a.getPosicaoColuna();
		int linhaAtual = a.getPosicaoLinha();
		
		if(a.verificaDestino[colunaDestino][linhaDestino]) {
			a.setPosicaoColuna(colunaDestino);
			a.setPosicaoLinha(linhaDestino);
			Tabuleiro.temPecaBranca[colunaAtual][linhaAtual] = false;
			Tabuleiro.temPecaBranca[colunaDestino][linhaDestino] = true;
			Tabuleiro.layout[colunaAtual][linhaAtual] = " ";
			Tabuleiro.layout[colunaDestino][linhaDestino] = a.getNome();
		} else {
			System.out.println("Essa peça não pode mover assim");
		}
		
	}
}
