package br.com.akconsultor.pretas;

import br.com.akconsultor.*;

public abstract class PecaPreta extends Peca{
	
	public void desfazPosicao() {
		Tabuleiro.temPecaPreta[this.posicaoColuna][this.posicaoLinha] = false;
		Tabuleiro.layout[this.posicaoColuna][this.posicaoLinha] = " ";
	}

	public void setPosicao(int coluna, int linha) {
		this.posicaoColuna = coluna;
		this.posicaoLinha = linha;
		Tabuleiro.temPecaPreta[coluna][linha] = true;
		Tabuleiro.layout[coluna][linha] = this.getNome();

	}

}
