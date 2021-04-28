package br.com.akconsultor;

public class BispoBranco extends PecaBranca {

	private String nome = "B";

	Tabuleiro tabuleiro = new Tabuleiro();

	@Override
	public void casaInicial() {
		if (Tabuleiro.temPecaBranca[2][0] == false) {
			this.posicaoColuna = 2;
			this.posicaoLinha = 0;
			Tabuleiro.temPecaBranca[2][0] = true;
			Tabuleiro.layout[2][0] = this.nome;
		} else {
			this.posicaoColuna = 5;
			this.posicaoLinha = 0;
			Tabuleiro.temPecaBranca[5][0] = true;
			Tabuleiro.layout[5][0] = this.nome;
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
				this.tabuleiro.podeMover[i + 1][j + 1] = true;
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
				this.tabuleiro.podeMover[i + 1][j - 1] = true;
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
				this.tabuleiro.podeMover[i - 1][j - 1] = true;
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
				this.tabuleiro.podeMover[i - 1][j + 1] = true;
			}
			} catch(ArrayIndexOutOfBoundsException ex) {
				break;
			}
			
		}

	}

	@Override
	public void podeCapturar() {

		// verificando se pode andar para a diagonal direita-frente
		for (int i  = this.posicaoColuna; i < 7 ; i++) {
			int j = this.posicaoLinha + (i - this.posicaoColuna);
			try {
			if (Tabuleiro.temPecaBranca[i + 1][j + 1]) {
				break;
			}
			if (Tabuleiro.temPecaPreta[i + 1][j + 1]) {
				this.tabuleiro.podeCapturar[i + 1][j + 1] = true;
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
				break;
			}
			if (Tabuleiro.temPecaPreta[i + 1][j - 1]) {
				this.tabuleiro.podeCapturar[i + 1][j - 1] = true;
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
				break;
			}
			if (Tabuleiro.temPecaPreta[i - 1][j - 1]) {
				this.tabuleiro.podeCapturar[i - 1][j - 1] = true;
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
				break;
			}
			if (Tabuleiro.temPecaPreta[i - 1][j + 1]) {
				this.tabuleiro.podeCapturar[i - 1][j + 1] = true;
				break;
			}
			}catch(ArrayIndexOutOfBoundsException ex) {
				break;
			}
			
		}

	}

	@Override
	public void podeAndarOuCapturar() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (this.tabuleiro.podeMover[i][j] || this.tabuleiro.podeCapturar[i][j]) {
					this.verificaDestino[i][j] = true;
				}
			}
		}

	}

	@Override
	public void getVerificaDestino() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
					
					this.verificaDestino[i][j] = false;
					this.tabuleiro.podeMover[i][j] = false;
					this.tabuleiro.podeCapturar[i][j] = false;
					this.tabuleiro.podeMoverOuCapturar[i][j] = false;
				
			}
		}
		ondePodeAndar();
		podeCapturar();
		podeAndarOuCapturar();
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				System.out.print(this.verificaDestino[j][i] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

	public int getPosicaoColuna() {
		return posicaoColuna;
	}

	public void setPosicaoColuna(int posicaoColuna) {
		this.posicaoColuna = posicaoColuna;
	}

	public int getPosicaoLinha() {
		return posicaoLinha;
	}

	public void setPosicaoLinha(int posicaoLinha) {
		this.posicaoLinha = posicaoLinha;
	}

	public String getNome() {
		return nome;
	}

	BispoBranco() {

		casaInicial();

	}

}