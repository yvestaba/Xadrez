package br.com.akconsultor.brancas;

import br.com.akconsultor.Tabuleiro;

public class DamaBranca extends PecaBranca {
	private String nome = "D";

	@Override
	public void casaInicial() {
		this.setPosicao(3, 0);
	}

	@Override
	public void ondePodeAndar() {

		// verificando se pode andar para a direita
		for (int i = this.posicaoColuna; i < 7; i++) {
			if (Tabuleiro.temPecaPreta[i + 1][this.posicaoLinha] || Tabuleiro.temPecaBranca[i + 1][this.posicaoLinha]) {
				break;
			} else {
				this.podeMover[i + 1][this.posicaoLinha] = true;
			}
		}

		// verificando se pode andar para a esquerda
		for (int i = this.posicaoColuna; i > 0; i--) {
			if (Tabuleiro.temPecaPreta[i - 1][this.posicaoLinha] || Tabuleiro.temPecaBranca[i - 1][this.posicaoLinha]) {
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

		// verificando se pode andar para a diagonal direita-frente
		for (int i = this.posicaoColuna; i < 7; i++) {
			int j = this.posicaoLinha + (i - this.posicaoColuna);
			try {
				if (Tabuleiro.temPecaPreta[i + 1][j + 1] || Tabuleiro.temPecaBranca[i + 1][j + 1]) {
					break;
				} else {
					this.podeMover[i + 1][j + 1] = true;
				}
			} catch (ArrayIndexOutOfBoundsException ex) {
				break;
			}

		}

		// verificando se pode andar para a diagonal direita-trás
		for (int i = this.posicaoColuna; i < 7; i++) {
			int j = this.posicaoLinha - (i - this.posicaoColuna);
			try {
				if (Tabuleiro.temPecaPreta[i + 1][j - 1] || Tabuleiro.temPecaBranca[i + 1][j - 1]) {
					break;
				} else {
					this.podeMover[i + 1][j - 1] = true;
				}
			} catch (ArrayIndexOutOfBoundsException ex) {
				break;
			}

		}

		// verificando se pode andar para a diagonal esquerda-trás
		for (int i = this.posicaoColuna; i > 0; i--) {
			int j = this.posicaoLinha - (this.posicaoColuna - i);
			try {
				if (Tabuleiro.temPecaPreta[i - 1][j - 1] || Tabuleiro.temPecaBranca[i - 1][j - 1]) {
					break;
				} else {
					this.podeMover[i - 1][j - 1] = true;
				}
			} catch (ArrayIndexOutOfBoundsException ex) {
				break;
			}

		}

		// verificando se pode andar para a diagonal esquerda-frente
		for (int i = this.posicaoColuna; i > 0; i--) {
			int j = this.posicaoLinha + (this.posicaoColuna - i);
			try {
				if (Tabuleiro.temPecaPreta[i - 1][j + 1] || Tabuleiro.temPecaBranca[i - 1][j + 1]) {
					break;
				} else {
					this.podeMover[i - 1][j + 1] = true;
				}
			} catch (ArrayIndexOutOfBoundsException ex) {
				break;
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

		// verificando se pode capturar para a diagonal direita-frente
		for (int i = this.posicaoColuna; i < 7; i++) {
			int j = this.posicaoLinha + (i - this.posicaoColuna);
			try {
				if (Tabuleiro.temPecaBranca[i + 1][j + 1]) {
					this.atrapalhaRei[i + 1][j + 1] = true;
					break;
				}
				if (Tabuleiro.temPecaPreta[i + 1][j + 1]) {
					this.podeCapturar[i + 1][j + 1] = true;
					break;
				}
			} catch (ArrayIndexOutOfBoundsException ex) {
				break;
			}

		}

		// verificando se pode capturar para a diagonal direita-trás
		for (int i = this.posicaoColuna; i < 7; i++) {
			int j = this.posicaoLinha - (i - this.posicaoColuna);
			try {
				if (Tabuleiro.temPecaBranca[i + 1][j - 1]) {
					this.atrapalhaRei[i + 1][j - 1] = true;
					break;
				}
				if (Tabuleiro.temPecaPreta[i + 1][j - 1]) {
					this.podeCapturar[i + 1][j - 1] = true;
					break;
				}
			} catch (ArrayIndexOutOfBoundsException ex) {
				break;
			}

		}

		// verificando se pode capturar para a diagonal esquerda-trás
		for (int i = this.posicaoColuna; i > 0; i--) {
			try {
				int j = this.posicaoLinha - (this.posicaoColuna - i);
				if (Tabuleiro.temPecaBranca[i - 1][j - 1]) {
					this.atrapalhaRei[i - 1][j - 1] = true;
					break;
				}
				if (Tabuleiro.temPecaPreta[i - 1][j - 1]) {
					this.podeCapturar[i - 1][j - 1] = true;
					break;
				}
			} catch (ArrayIndexOutOfBoundsException ex) {
				break;
			}

		}

		// verificando se pode capturar para a diagonal esquerda-frente
		for (int i = this.posicaoColuna; i > 0; i--) {
			int j = this.posicaoLinha + (this.posicaoColuna - i);
			try {
				if (Tabuleiro.temPecaBranca[i - 1][j + 1]) {
					this.atrapalhaRei[i - 1][j + 1] = true;
					break;
				}
				if (Tabuleiro.temPecaPreta[i - 1][j + 1]) {
					this.podeCapturar[i - 1][j + 1] = true;
					break;
				}
			} catch (ArrayIndexOutOfBoundsException ex) {
				break;
			}

		}

	}

	public String getNome() {
		return nome;
	}

	public DamaBranca() {

		casaInicial();
		Tabuleiro.listaBrancas.add(this);

	}
	
	public DamaBranca(int i, int j) {
		this.setPosicao(i, j);
//		Tabuleiro.listaBrancas.add(this);
//		this.getVerificaDestino();
		Tabuleiro.setRainhaBrancaPromovida(this);
		Tabuleiro.listaBrancas.add(this);

//		if (this.verificaDestino[Tabuleiro.reiPreto[0]][Tabuleiro.reiPreto[1]]) {
//			Tabuleiro.setCheck(true);
//
//			Tabuleiro.setColunaCheck(this.getPosicaoColuna());
//			Tabuleiro.setLinhaCheck(this.getPosicaoLinha());
//			Tabuleiro.setQuantasPecasFazemCheck(Tabuleiro.getQuantasPecasFazemCheck() + 1);
//			
//			if (Tabuleiro.reiPreto[0] - Tabuleiro.getColunaCheck() == Tabuleiro.reiPreto[1] - Tabuleiro.getLinhaCheck()) {
//				Tabuleiro.setDirecaoCheck(Direcao.DIAGONALHORARIO);
//			} else if (Tabuleiro.reiPreto[0] - Tabuleiro.getColunaCheck() == -1 * (Tabuleiro.reiPreto[1] - Tabuleiro.getLinhaCheck())) {
//				Tabuleiro.setDirecaoCheck(Direcao.DIAGONALANTIHORARIO);
//			} else if (Tabuleiro.reiPreto[0] == Tabuleiro.getColunaCheck()) {
//				Tabuleiro.setDirecaoCheck(Direcao.VERTICAL);
//			} else if (Tabuleiro.reiPreto[1] == Tabuleiro.getLinhaCheck()) {
//				Tabuleiro.setDirecaoCheck(Direcao.HORIZONTAL);
//			} else {
//				Tabuleiro.setDirecaoCheck (Direcao.ELE);
//			}
//		}
	}
}
