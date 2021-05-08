package br.com.akconsultor.pretas;

import br.com.akconsultor.Tabuleiro;
import br.com.akconsultor.brancas.*;

public class ReiPreto extends PecaPreta {

	private String nome = "r";

	@Override
	public void casaInicial() {
		this.setPosicao(4, 7);
	}

	@Override
	public void ondePodeAndar() {

		// verificando se pode andar para a direita
		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha]) {

			} else {
				this.podeMover[this.posicaoColuna + 1][this.posicaoLinha] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode andar para a esquerda
		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha]) {

			} else {
				this.podeMover[this.posicaoColuna - 1][this.posicaoLinha] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode andar para frente
		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][this.posicaoLinha + 1]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna][this.posicaoLinha + 1]) {

			} else {
				this.podeMover[this.posicaoColuna][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode andar para trás
		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][this.posicaoLinha - 1]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna][this.posicaoLinha - 1]) {

			} else {
				this.podeMover[this.posicaoColuna][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode andar para a diagonal direita-frente

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha + 1]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha + 1]) {

			} else {
				this.podeMover[this.posicaoColuna + 1][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode andar para a diagonal direita-trás

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha - 1]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha - 1]) {
			} else {
				this.podeMover[this.posicaoColuna + 1][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
		}

		// verificando se pode andar para a diagonal esquerda-trás

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha - 1]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha - 1]) {

			} else {
				this.podeMover[this.posicaoColuna - 1][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode andar para a diagonal esquerda-frente

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha + 1]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha + 1]) {

			} else {
				this.podeMover[this.posicaoColuna - 1][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

	}

	@Override
	public void podeCapturar() {
		// verificando se pode capturar para a direita
		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha]) {
				this.podeCapturar[this.posicaoColuna + 1][this.posicaoLinha] = true;
			}
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha]) {
				this.atrapalhaRei[this.posicaoColuna + 1][this.posicaoLinha] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode capturar para a esquerda
		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha]) {
				this.podeCapturar[this.posicaoColuna - 1][this.posicaoLinha] = true;
			}
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha]) {
				this.atrapalhaRei[this.posicaoColuna - 1][this.posicaoLinha] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode capturar para frente
		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna][this.posicaoLinha + 1]) {
				this.podeCapturar[this.posicaoColuna][this.posicaoLinha + 1] = true;
			}
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][this.posicaoLinha + 1]) {
				this.atrapalhaRei[this.posicaoColuna][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode capturar para trás
		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna][this.posicaoLinha - 1]) {
				this.podeCapturar[this.posicaoColuna][this.posicaoLinha - 1] = true;
			}
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][this.posicaoLinha - 1]) {
				this.atrapalhaRei[this.posicaoColuna][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode capturar para a diagonal direita-frente

		try {

			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha + 1]) {
				this.podeCapturar[this.posicaoColuna + 1][this.posicaoLinha + 1] = true;
			}
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha + 1]) {
				this.atrapalhaRei[this.posicaoColuna + 1][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode capturar para a diagonal direita-trás

		try {

			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha - 1]) {
				this.podeCapturar[this.posicaoColuna + 1][this.posicaoLinha - 1] = true;
			}
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha - 1]) {
				this.atrapalhaRei[this.posicaoColuna + 1][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
		}

		// verificando se pode capturar para a diagonal esquerda-trás

		try {

			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha - 1]) {
				this.podeCapturar[this.posicaoColuna - 1][this.posicaoLinha - 1] = true;
			}
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha - 1]) {
				this.atrapalhaRei[this.posicaoColuna - 1][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode capturar para a diagonal esquerda-frente

		try {

			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha + 1]) {
				this.podeCapturar[this.posicaoColuna - 1][this.posicaoLinha + 1] = true;
			}
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha + 1]) {
				this.atrapalhaRei[this.posicaoColuna - 1][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

	}

	public String getNome() {
		return nome;
	}

	public void setRei() {
		Tabuleiro.reiPreto[0] = this.posicaoColuna;
		Tabuleiro.reiPreto[1] = this.posicaoLinha;
	}

	public void protegeRei() {
		if(Tabuleiro.isVezDosBrancos() == false) {

		for (PecaBranca peca : Tabuleiro.listaBrancas) {
			try {
				peca.getVerificaDestino();
			} catch (ArrayIndexOutOfBoundsException ex) {
			}
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					try {
						if (peca.getNome() == "P") {
							try {
							this.verificaDestino[peca.getPosicaoColuna() + 1][peca.getPosicaoLinha() + 1] = false;
							} catch (ArrayIndexOutOfBoundsException ex) {
							}
							try {
							this.verificaDestino[peca.getPosicaoColuna() - 1][peca.getPosicaoLinha() + 1] = false;
							} catch (ArrayIndexOutOfBoundsException ex) {
							}
						} else if (peca.verificaDestino[i][j] == true || peca.atrapalhaRei[i][j]) {
							this.verificaDestino[i][j] = false;
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
					}
				}
			}
		}
		}
	}

	public ReiPreto() {

		casaInicial();
		Tabuleiro.listaPretas.add(this);

	}

}
