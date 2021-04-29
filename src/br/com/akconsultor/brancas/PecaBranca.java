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
	
	public void getCapturou() {
		if(this.podeCapturar[this.posicaoColuna][this.posicaoLinha]) {
			Tabuleiro.temPecaPreta[this.posicaoColuna][this.posicaoLinha] = false;
			System.out.println("Peça preta capturada\n");
		}
	}
}
