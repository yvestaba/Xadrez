package br.com.akconsultor;



import br.com.akconsultor.brancas.*;
import br.com.akconsultor.pretas.*;

public class Tabuleiro {
	public static boolean[][] temPecaBranca = new boolean[8][8];
	public static boolean[][] temPecaPreta = new boolean[8][8];
	public static String[][] layout = new String[8][8];

	public static boolean[] checaEnPassant = new boolean[8];
	private static int jogadas;

	// no jogo principal, usar a função para deixar o tabuleiro vazio
	public void comecouOJogo() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				temPecaPreta[i][j] = false;
			}
		}

		for (int k = 0; k < 8; k++) {
			for (int l = 0; l < 8; l++) {
				temPecaBranca[k][l] = false;
			}
		}

		for (int o = 0; o < 8; o++) {
			for (int p = 0; p < 8; p++) {
				layout[o][p] = " ";
			}
		}
	}

	public void movePecaBranca(PecaBranca a, int colunaDestino, int linhaDestino) {
		
		
		if (a.verificaDestino[colunaDestino][linhaDestino]) {
			
			
			
			for(int i = 0; i < 8; i++) {
				if (Tabuleiro.layout[i][1] == "P") {
					Tabuleiro.checaEnPassant[i] = true;
				} else {
					Tabuleiro.checaEnPassant[i] = false;
				}
			}
			
			int colunaAnterior = a.getPosicaoColuna();
			
			a.desfazPosicao();
			a.setPosicao(colunaDestino, linhaDestino);
			
			if(a.isEnPassantDireita() && a.getPosicaoColuna() == colunaAnterior + 1 && a.getPosicaoLinha() == 5) {
				Tabuleiro.layout[a.getPosicaoColuna()][4] = " ";
				Tabuleiro.temPecaPreta[a.getPosicaoColuna()][4] = false;
				System.out.println("en Passant");
			}
			
			if(a.isEnPassantEsquerda() && a.getPosicaoColuna() == colunaAnterior - 1 && a.getPosicaoLinha() == 5) {
				Tabuleiro.layout[a.getPosicaoColuna()][a.getPosicaoLinha() - 1] = " ";
				Tabuleiro.temPecaPreta[a.getPosicaoColuna()][a.getPosicaoLinha() - 1] = false;
				System.out.println("enPassant");
			}
			verTabuleiro();
			a.getCapturou();
			a.resetEnPassant();
						
			for(int i = 0; i < 8; i++) {
				if (Tabuleiro.layout[i][3] == "P" && Tabuleiro.layout[i][1] == " " && Tabuleiro.checaEnPassant[i]) {
					
				}else {
					Tabuleiro.checaEnPassant[i] = false;
				}
			}
			
			

					
			jogadas++;
		} else {
			System.out.println("Essa peça não pode mover assim");
		}

		
		
	}

	public void movePecaPreta(PecaPreta a, int colunaDestino, int linhaDestino) {

		if (a.verificaDestino[colunaDestino][linhaDestino]) {
			
			for(int i = 0; i < 8; i++) {
				if (Tabuleiro.layout[i][6] == "i") {
					Tabuleiro.checaEnPassant[i] = true;
				} else {
					Tabuleiro.checaEnPassant[i] = false;
				}
			}
			
			int colunaAnterior = a.getPosicaoColuna();
			
			a.desfazPosicao();
			a.setPosicao(colunaDestino, linhaDestino);
			
			if(a.isEnPassantDireita() && a.getPosicaoColuna() == colunaAnterior + 1 && a.getPosicaoLinha() == 2) {
				Tabuleiro.layout[a.getPosicaoColuna()][a.getPosicaoLinha() + 1] = " ";
				Tabuleiro.temPecaBranca[a.getPosicaoColuna()][a.getPosicaoLinha() + 1] = false;
				System.out.println("en Passant");
			}
			
			if(a.isEnPassantEsquerda() && a.getPosicaoColuna() == colunaAnterior - 1 && a.getPosicaoLinha() == 2) {
				Tabuleiro.layout[a.getPosicaoColuna()][a.getPosicaoLinha() + 1] = " ";
				Tabuleiro.temPecaBranca[a.getPosicaoColuna()][a.getPosicaoLinha() + 1] = false;
				System.out.println("en Passant");
			}
			verTabuleiro();
			a.getCapturou();
			a.resetEnPassant();
			
			for(int i = 0; i < 8; i++) {
				if (Tabuleiro.layout[i][4] == "i" && Tabuleiro.layout[i][6] == " " && Tabuleiro.checaEnPassant[i]) {
					
				}else {
					Tabuleiro.checaEnPassant[i] = false;
				}
			}
			
			

			

			
			jogadas++;
			
		} else {
			System.out.println("Essa peça não pode mover assim");
		}

		
	}

	public void verTabuleiro() {
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				System.out.print(Tabuleiro.layout[j][i] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void verOndeTemPecaBranca() {
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				System.out.print(Tabuleiro.temPecaBranca[j][i] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void verOndeTemPecaPreta() {
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				System.out.print(Tabuleiro.temPecaPreta[j][i] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int getJogadas() {
		return jogadas;
	}
}
