package br.com.akconsultor.brancas;

import br.com.akconsultor.Tabuleiro;


public class PeaoBranco extends PecaBranca{

	private String nome = "P";


	@Override
	public void casaInicial() {
		// cada vez que um pe�o � criado, esse m�todo verifica se a linha de pe�o j�
		// est� formada e posiciona em uma casa vazia
		for (int i = 0; i < 8; i++) {
			if (Tabuleiro.temPecaBranca[i][1] == false) {
				this.setPosicao(i, 1);
				break;
			}
		}

	}

	@Override
	public void ondePodeAndar() {

		// se o peao est� na casa inicial...
		if (this.posicaoLinha == 1) {
			// ...pode mover duas casas
			for (int i = 1; i <= 2; i++) {
				// mas antes verifica se tem pe�a no meio do caminho
				if (Tabuleiro.temPecaPreta[this.posicaoColuna][1 + i] == true
						|| Tabuleiro.temPecaBranca[this.posicaoColuna][1 + i] == true) {
					break;
				} else {
					this.podeMover[this.posicaoColuna][1 + i] = true;
				}
			}
		}
		// se n�o est� na casa inicial, n�o se considera que pode andar 2 espa�os, mas
		// ainda verifica se tem pe�a no caminho
		else if (Tabuleiro.temPecaPreta[this.posicaoColuna][this.posicaoLinha + 1] == false
				&& Tabuleiro.temPecaBranca[this.posicaoColuna][this.posicaoLinha + 1] == false) {
			this.podeMover[this.posicaoColuna][this.posicaoLinha + 1] = true;
		}

	}

	@Override
	public void podeCapturar() {
		// o pe�o pode capturar na diagonal para a esquerda (coluna -1 == esquerda;
		// linha + 1 == frente)
		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha + 1]) {
				this.podeCapturar[this.posicaoColuna - 1][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
		}

		// o mesmo acontece com diagonal para a direita (coluna + 1 == direita)
		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha + 1]) {
				this.podeCapturar[this.posicaoColuna + 1][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

	}

	public String getNome() {
		return nome;
	}

	public boolean isEnPassantDireita() {
		return enPassantDireita;
	}

	public void setEnPassantDireita(boolean enPassant) {
		try {
		if (Tabuleiro.checaEnPassant[this.posicaoColuna +1]
			&& this.posicaoLinha == 4) {
			this.enPassantDireita = enPassant;
			this.verificaDestino[this.posicaoColuna + 1][5] = true;
		}
		} catch(Exception ex) {
			
		}
	}

	public boolean isEnPassantEsquerda() {
		return enPassantEsquerda;
	}

	public void setEnPassantEsquerda(boolean enPassant) {
		try {
			if (Tabuleiro.checaEnPassant[this.posicaoColuna - 1]
				&& this.posicaoLinha == 4) {
				this.enPassantEsquerda = enPassant;
				this.verificaDestino[this.posicaoColuna - 1][5] = true;
			}
			} catch(Exception ex) {
				
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
		setEnPassantDireita(true);
		setEnPassantEsquerda(true);
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				System.out.print(j +"," + i + "" + this.verificaDestino[j][i] + " ");
			}
			System.out.println();
		} System.out.println();

	}
	
	public void resetEnPassant() {
		this.enPassantDireita = false;
		this.enPassantEsquerda = false;
		

	}
	


	public PeaoBranco() {

		casaInicial();
		Tabuleiro.listaBrancas.add(this);

	}

}
