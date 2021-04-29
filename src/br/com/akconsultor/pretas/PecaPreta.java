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
	
	public void getCapturou() {
		if(this.podeCapturar[this.posicaoColuna][this.posicaoLinha]) {
			Tabuleiro.temPecaBranca[this.posicaoColuna][this.posicaoLinha] = false;
			System.out.println("Peça branca capturada\n");
		}
	}
	
	

}
