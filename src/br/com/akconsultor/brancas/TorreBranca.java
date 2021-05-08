package br.com.akconsultor.brancas;

import br.com.akconsultor.Tabuleiro;
import br.com.akconsultor.Rocker;
public class TorreBranca extends PecaBranca implements Rocker{

	private String nome = "T";
	private int colunaInicial;


	@Override
	public void casaInicial() {
		if (Tabuleiro.temPecaBranca[0][0] == false) {
			this.setPosicao(0, 0);
			this.colunaInicial = 0;
		} else {
			this.setPosicao(7, 0);
			this.colunaInicial = 7;
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
			if (Tabuleiro.temPecaBranca[i + 1][this.posicaoLinha]) {
				this.atrapalhaRei[i + 1][this.posicaoLinha] = true;
				break;
			}
			if (Tabuleiro.temPecaPreta[i + 1][this.posicaoLinha]) {
				this.podeCapturar[i + 1][this.posicaoLinha] = true;
				break;
			}
		}

		// verificando se pode capturar para a esquerda
		for (int i = this.posicaoColuna; i > 0; i--) {
			if (Tabuleiro.temPecaBranca[i - 1][this.posicaoLinha]) {
				this.atrapalhaRei[i - 1][this.posicaoLinha] = true;
				break;
			}
			if (Tabuleiro.temPecaPreta[i - 1][this.posicaoLinha]) {
				this.podeCapturar[i - 1][this.posicaoLinha] = true;
				break;
			}
		}

		// verificando se pode capturar para frente
		for (int i = this.posicaoLinha; i < 7; i++) {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna][i + 1]) {
				this.atrapalhaRei[this.posicaoColuna][i + 1] = true;
				break;
			}
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][i + 1]) {
				this.podeCapturar[this.posicaoColuna][i + 1] = true;
				break;
			}
		}

		// verificando se pode capturar para trás
		for (int i = this.posicaoLinha; i > 0; i--) {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna][i - 1]) {
				this.atrapalhaRei[this.posicaoColuna][i - 1] = true;
				break;
			}
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][i - 1]) {
				this.podeCapturar[this.posicaoColuna][i - 1] = true;
				break;
			}
		}

	}

	public String getNome() {
		return nome;
	}

	public TorreBranca() {

		casaInicial();
		Tabuleiro.listaBrancas.add(this);

	}

	@Override
	public void verificaRoque() {
		if ((this.posicaoColuna != 0 || this.posicaoLinha != 0) && this.colunaInicial == 0) {
			Tabuleiro.setBrancoPodeRoqueGrande(false);
		}
		if ((this.posicaoColuna != 7 || this.posicaoLinha != 0) && this.colunaInicial == 7) {
			Tabuleiro.setBrancoPodeRoquePequeno(false);
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
		if (Tabuleiro.isCheck() && Tabuleiro.isVezDosBrancos()) {
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
