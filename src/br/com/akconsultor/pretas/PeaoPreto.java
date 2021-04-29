package br.com.akconsultor.pretas;

import br.com.akconsultor.Tabuleiro;

public class PeaoPreto extends PecaPreta{
	
	private String nome = "i";
	

	@Override
	public void casaInicial() {
		// cada vez que um peão é criado, esse método verifica se a linha de peão já
		// está formada e posiciona em uma casa vazia
		for (int i = 7; i >= 0; i--) {
			if (Tabuleiro.temPecaPreta[i][6] == false) {
				this.setPosicao(i, 6);
				break;
			}
		}

	}
	


	@Override
	public void ondePodeAndar() {

		// se o peao está na casa inicial...
		if (this.posicaoLinha == 6) {
			// ...pode mover duas casas
			for (int i = 1; i <= 2; i++) {
				// mas antes verifica se tem peça no meio do caminho
				if (Tabuleiro.temPecaPreta[this.posicaoColuna][6 - i] == true
						|| Tabuleiro.temPecaBranca[this.posicaoColuna][6 - i] == true) {
					break;
				} else {
					this.podeMover[this.posicaoColuna][6 - i] = true;
				}
			}
		}
		// se não está na casa inicial, não se considera que pode andar 2 espaços, mas
		// ainda verifica se tem peça no caminho
		else if (Tabuleiro.temPecaPreta[this.posicaoColuna][this.posicaoLinha - 1] == false
				|| Tabuleiro.temPecaBranca[this.posicaoColuna][this.posicaoLinha - 1] == false) {
			this.podeMover[this.posicaoColuna][this.posicaoLinha + 1] = true;
		}

	}

	@Override
	public void podeCapturar() {
		// o peão pode capturar na diagonal para a esquerda (coluna -1 == esquerda; linha + 1 == frente)
		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha - 1]) {
				this.podeCapturar[this.posicaoColuna - 1][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
		}

		// o mesmo acontece com diagonal para a direita (coluna + 1 == direita)
		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha - 1]) {
				this.podeCapturar[this.posicaoColuna + 1][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

	}

	public String getNome() {
		return nome;
	}

	public PeaoPreto() {

		casaInicial();

	}


}
