package br.com.akconsultor;

import br.com.akconsultor.brancas.*;
import br.com.akconsultor.pretas.*;

public class Tabuleiro {
	public static boolean[][] temPecaBranca = new boolean[8][8];
	public static boolean[][] temPecaPreta = new boolean[8][8];
	public static String[][] layout = new String[8][8];

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
			a.desfazPosicao();
			a.setPosicao(colunaDestino, linhaDestino);
		} else {
			System.out.println("Essa peça não pode mover assim");
		}

		verTabuleiro();
		a.getCapturou();
	}

	public void movePecaPreta(PecaPreta a, int colunaDestino, int linhaDestino) {

		if (a.verificaDestino[colunaDestino][linhaDestino]) {
			a.desfazPosicao();
			a.setPosicao(colunaDestino, linhaDestino);
		} else {
			System.out.println("Essa peça não pode mover assim");
		}

		verTabuleiro();
		a.getCapturou();
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
}
