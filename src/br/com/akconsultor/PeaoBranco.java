package br.com.akconsultor;

public class PeaoBranco extends PecaBranca {

	private String nome = "P";
	
	Tabuleiro tabuleiro = new Tabuleiro();

	@Override
	public void casaInicial() {
		// cada vez que um peão é criado, esse método verifica se a linha de peão já
		// está formada e posiciona em uma casa vazia
		for (int i = 0; i < 8; i++) {
			if (Tabuleiro.temPecaBranca[i][1] == false) {
				Tabuleiro.temPecaBranca[i][1] = true;
				this.posicaoColuna = i;
				this.posicaoLinha = 1;
				Tabuleiro.layout[i][1] = this.nome;
				break;
			}
		}

	}

	@Override
	public void ondePodeAndar() {

		// se o peao está na casa inicial...
		if (this.posicaoLinha == 1) {
			// ...pode mover duas casas
			for (int i = 1; i <= 2; i++) {
				// mas antes verifica se tem peça no meio do caminho
				if (Tabuleiro.temPecaPreta[this.posicaoColuna][1 + i] == true
						|| Tabuleiro.temPecaBranca[this.posicaoColuna][1 + i] == true) {
					break;
				} else {
					this.tabuleiro.podeMover[this.posicaoColuna][1 + i] = true;
				}
			}
		}
		// se não está na casa inicial, não se considera que pode andar 2 espaços, mas
		// ainda verifica se tem peça no caminho
		else if (Tabuleiro.temPecaPreta[this.posicaoColuna][this.posicaoLinha + 1] == false
				|| Tabuleiro.temPecaBranca[this.posicaoColuna][this.posicaoLinha + 1] == false) {
			this.tabuleiro.podeMover[this.posicaoColuna][this.posicaoLinha + 1] = true;
		}

	}

	@Override
	public void podeCapturar() {
		// o peão pode capturar na diagonal para a esquerda (coluna -1 == esquerda;
		// linha + 1 == frente)
		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha + 1]) {
				this.tabuleiro.podeCapturar[this.posicaoColuna - 1][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
		}

		// o mesmo acontece com diagonal para a direita (coluna + 1 == direita)
		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha + 1]) {
				this.tabuleiro.podeCapturar[this.posicaoColuna + 1][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

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
		ondePodeAndar();
		podeCapturar();
		podeAndarOuCapturar();
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				System.out.print(this.verificaDestino[j][i] + " ");
			}
			System.out.println();
		} System.out.println();

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

	PeaoBranco() {

		casaInicial();

	}

}
