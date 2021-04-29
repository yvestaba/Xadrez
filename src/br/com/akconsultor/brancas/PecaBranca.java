package br.com.akconsultor.brancas;

import br.com.akconsultor.Peca;
import br.com.akconsultor.Tabuleiro;

public abstract class PecaBranca extends Peca{

	public void desfazPosicao() {
		Tabuleiro.temPecaBranca[this.posicaoColuna][this.posicaoLinha] = false;
		Tabuleiro.layout[this.posicaoColuna][this.posicaoLinha] = " ";
	}

	public void setPosicao(int coluna, int linha) {
		this.posicaoColuna = coluna;
		this.posicaoLinha = linha;
		Tabuleiro.temPecaBranca[coluna][linha] = true;
		Tabuleiro.layout[coluna][linha] = this.getNome();

	}
}
