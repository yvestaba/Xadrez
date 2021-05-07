package br.com.akconsultor.pretas;

import br.com.akconsultor.Tabuleiro;

public class BispoPreto extends PecaPreta{

	private String nome = "b";

	@Override
	protected void casaInicial() {
		if (Tabuleiro.temPecaPreta[5][7] == false) {
			this.setPosicao(5, 7);
		} else {
			this.setPosicao(2, 7);
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

		// verificando se pode andar para a diagonal direita-trás
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

		// verificando se pode andar para a diagonal esquerda-trás
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
			if (Tabuleiro.temPecaPreta[i + 1][j + 1]) {
				break;
			}
			if (Tabuleiro.temPecaBranca[i + 1][j + 1]) {
				this.podeCapturar[i + 1][j + 1] = true;
				break;
			}
			} catch(ArrayIndexOutOfBoundsException ex) {
				break;
			}
			
		}

		// verificando se pode capturar para a diagonal direita-trás
		for (int i  = this.posicaoColuna; i < 7 ; i++) {
			int j = this.posicaoLinha - (i - this.posicaoColuna);
			try {
			if (Tabuleiro.temPecaPreta[i + 1][j - 1]) {
				break;
			}
			if (Tabuleiro.temPecaBranca[i + 1][j - 1]) {
				this.podeCapturar[i + 1][j - 1] = true;
				break;
			}
			} catch(ArrayIndexOutOfBoundsException ex) {
				break;
			}
			
		}

		// verificando se pode capturar para a diagonal esquerda-trás
		for (int i  = this.posicaoColuna; i > 0 ; i--) {
			try {
			int j = this.posicaoLinha - (this.posicaoColuna - i);
			if (Tabuleiro.temPecaPreta[i - 1][j - 1]) {
				break;
			}
			if (Tabuleiro.temPecaBranca[i - 1][j - 1]) {
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
			if (Tabuleiro.temPecaPreta[i - 1][j + 1]) {
				break;
			}
			if (Tabuleiro.temPecaBranca[i - 1][j + 1]) {
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

	public BispoPreto() {

		casaInicial();
		Tabuleiro.listaPretas.add(this);

	}
}
