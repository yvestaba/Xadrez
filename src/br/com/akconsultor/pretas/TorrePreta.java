package br.com.akconsultor.pretas;

import br.com.akconsultor.Tabuleiro;
import br.com.akconsultor.Rocker;

public class TorrePreta extends PecaPreta implements Rocker{
	private String nome = "t";
	private int colunaInicial;


	@Override
	public void casaInicial() {
		if (Tabuleiro.temPecaPreta[7][7] == false) {
			this.setPosicao(7, 7);
			this.colunaInicial = 7;
		} else {
			this.setPosicao(0, 7);
			this.colunaInicial = 0;
		}

	}

	@Override
	public void ondePodeAndar() {

		// verificando se pode andar para a direita
		for (int i = this.posicaoColuna; i < 7; i++) {
			if (Tabuleiro.temPecaPreta[i + 1][this.posicaoLinha]
					|| Tabuleiro.temPecaBranca[i + 1][this.posicaoLinha]) {
				break;
			} else {
				this.podeMover[i + 1][this.posicaoLinha] = true;
			}
		}

		// verificando se pode andar para a esquerda
		for (int i = this.posicaoColuna; i > 0; i--) {
			if (Tabuleiro.temPecaPreta[i - 1][this.posicaoLinha]
					|| Tabuleiro.temPecaBranca[i - 1][this.posicaoLinha]) {
				break;
			} else {
				this.podeMover[i - 1][this.posicaoLinha] = true;
			}
		}

		// verificando se pode andar para frente
		for (int i = this.posicaoLinha; i < 7; i++) {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][i + 1]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna][i + 1]) {
				break;
			} else {
				this.podeMover[this.posicaoColuna][i + 1] = true;
			}
		}

		// verificando se pode andar para trás
		for (int i = this.posicaoLinha; i > 0; i--) {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][i - 1]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna][i - 1]) {
				break;
			} else {
				this.podeMover[this.posicaoColuna][i - 1] = true;
			}
		}

	}

	@Override
	public void podeCapturar() {
		// verificando se pode capturar para a direita
		for (int i = this.posicaoColuna; i < 7; i++) {
			if (Tabuleiro.temPecaPreta[i + 1][this.posicaoLinha]) {
				this.atrapalhaRei[i + 1][this.posicaoLinha] = true;
				break;
			}
			if (Tabuleiro.temPecaBranca[i + 1][this.posicaoLinha]) {
				this.podeCapturar[i + 1][this.posicaoLinha] = true;
				break;
			}
		}

		// verificando se pode capturar para a esquerda
		for (int i = this.posicaoColuna; i > 0; i--) {
			if (Tabuleiro.temPecaPreta[i - 1][this.posicaoLinha]) {
				this.atrapalhaRei[i - 1][this.posicaoLinha] = true;
				break;
			}
			if (Tabuleiro.temPecaBranca[i - 1][this.posicaoLinha]) {
				this.podeCapturar[i - 1][this.posicaoLinha] = true;
				break;
			}
		}

		// verificando se pode capturar para frente
		for (int i = this.posicaoLinha; i < 7; i++) {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][i + 1]) {
				this.atrapalhaRei[this.posicaoColuna][i + 1] = true;
				break;
			}
			if (Tabuleiro.temPecaBranca[this.posicaoColuna][i + 1]) {
				this.podeCapturar[this.posicaoColuna][i + 1] = true;
				break;
			}
		}

		// verificando se pode capturar para trás
		for (int i = this.posicaoLinha; i > 0; i--) {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][i - 1]) {
				this.atrapalhaRei[this.posicaoColuna][i - 1] = true;
				break;
			}
			if (Tabuleiro.temPecaBranca[this.posicaoColuna][i - 1]) {
				this.podeCapturar[this.posicaoColuna][i - 1] = true;
				break;
			}
		}

	}

	public String getNome() {
		return nome;
	}

	public TorrePreta() {

		casaInicial();
		Tabuleiro.listaPretas.add(this);

	}

	@Override
	public void verificaRoque() {
		if ((this.posicaoColuna != 0 || this.posicaoLinha != 7) && this.colunaInicial == 0) {
			Tabuleiro.setPretoPodeRoqueGrande(false);
		}
		if ((this.posicaoColuna != 7 || this.posicaoLinha != 7) && this.colunaInicial == 7) {
			Tabuleiro.setPretoPodeRoquePequeno(false);
		}
		
	}
	
	public void getVerificaDestino() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
					
					this.verificaDestino[i][j] = false;
					this.podeMover[i][j] = false;
					this.podeCapturar[i][j] = false;
					this.podeMoverOuCapturar[i][j] = false;
				
			}
		}
		ondePodeAndar();
		podeCapturar();
		podeAndarOuCapturar();
		verificaRoque();
		protegeRei();
		if (Tabuleiro.isCheck() && Tabuleiro.isVezDosBrancos() == false) {
			this.resolveCheck();
		}
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				System.out.print(j +"," + i + "" + this.verificaDestino[j][i] + " ");
			}
			System.out.println();
		} System.out.println();

	}


}
