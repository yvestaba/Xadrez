package br.com.akconsultor.brancas;

import br.com.akconsultor.Tabuleiro;

public class BispoBranco extends PecaBranca {

	private String nome = "B";

	


	@Override
	protected void casaInicial() {
		if (Tabuleiro.temPecaBranca[2][0] == false) {
			this.setPosicao(2, 0);
		} else {
			this.setPosicao(5, 0);
		}

	}

	@Override
	public void ondePodeAndar() {
		// verificando se pode andar para a diagonal direita-frente
		for (int i  = this.posicaoColuna; i < 7 ; i++) {
			int j = this.posicaoLinha + (i - this.posicaoColuna);
			try {
			if (Tabuleiro.temPecaPreta[i + 1][j + 1] || 
					Tabuleiro.temPecaBranca[i + 1][j + 1]) {
				break;
			} else {
				this.podeMover[i + 1][j + 1] = true;
			}
			} catch(ArrayIndexOutOfBoundsException ex) {
				break;
			}
			
		}

		// verificando se pode andar para a diagonal direita-tr�s
		for (int i  = this.posicaoColuna; i < 7 ; i++) {
			int j = this.posicaoLinha - (i - this.posicaoColuna);
			try {
			if (Tabuleiro.temPecaPreta[i + 1][j - 1] || 
					Tabuleiro.temPecaBranca[i + 1][j - 1]) {
				break;
			} else {
				this.podeMover[i + 1][j - 1] = true;
			}
			} catch(ArrayIndexOutOfBoundsException ex) {
				break;
			}
			
		}

		// verificando se pode andar para a diagonal esquerda-tr�s
		for (int i  = this.posicaoColuna; i > 0 ; i--) {
			int j = this.posicaoLinha - (this.posicaoColuna - i);
			try {
			if (Tabuleiro.temPecaPreta[i - 1][j - 1] || 
					Tabuleiro.temPecaBranca[i - 1][j - 1]) {
				break;
			} else {
				this.podeMover[i - 1][j - 1] = true;
			}
			} catch(ArrayIndexOutOfBoundsException ex) {
				break;
			}
			
		}

		// verificando se pode andar para a diagonal esquerda-frente
		for (int i  = this.posicaoColuna; i > 0 ; i--) {
			int j = this.posicaoLinha + (this.posicaoColuna - i);
			try {
			if (Tabuleiro.temPecaPreta[i - 1][j + 1] || 
					Tabuleiro.temPecaBranca[i - 1][j + 1]) {
				break;
			} else {
				this.podeMover[i - 1][j + 1] = true;
			}
			} catch(ArrayIndexOutOfBoundsException ex) {
				break;
			}
			
		}

	}

	@Override
	public void podeCapturar() {

		// verificando se pode capturar para a diagonal direita-frente
		for (int i  = this.posicaoColuna; i < 7 ; i++) {
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
			} catch(ArrayIndexOutOfBoundsException ex) {
				break;
			}
			
		}

		// verificando se pode capturar para a diagonal direita-tr�s
		for (int i  = this.posicaoColuna; i < 7 ; i++) {
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
			} catch(ArrayIndexOutOfBoundsException ex) {
				break;
			}
			
		}

		// verificando se pode capturar para a diagonal esquerda-tr�s
		for (int i  = this.posicaoColuna; i > 0 ; i--) {
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
			}catch(ArrayIndexOutOfBoundsException ex) {
				break;
			}
			
		}

		// verificando se pode capturar para a diagonal esquerda-frente
		for (int i  = this.posicaoColuna; i > 0 ; i--) {
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
			}catch(ArrayIndexOutOfBoundsException ex) {
				break;
			}
			
		}

	}

	public String getNome() {
		return nome;
	}

	public BispoBranco() {

		casaInicial();
		Tabuleiro.listaBrancas.add(this);

	}

}
