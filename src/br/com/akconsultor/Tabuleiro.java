package br.com.akconsultor;

import java.util.ArrayList;

import br.com.akconsultor.brancas.*;
import br.com.akconsultor.pretas.*;

public class Tabuleiro {
	public static boolean[][] temPecaBranca = new boolean[8][8];
	public static boolean[][] temPecaPreta = new boolean[8][8];
	public static String[][] layout = new String[8][8];

	public static boolean[] checaEnPassant = new boolean[8];
	private static int jogadas;

	public static int[] reiBranco = { 4, 0 };
	public static int[] reiPreto = { 4, 7 };

	public static ArrayList<PecaBranca> listaBrancas = new ArrayList<PecaBranca>();
	public static ArrayList<PecaPreta> listaPretas = new ArrayList<PecaPreta>();

	private static boolean vezDosBrancos = true;
	private static boolean check = false;
	private static int colunaCheck;
	private static int linhaCheck;
	private static int quantasPecasFazemCheck;
	private static Direcao direcaoCheck;
	private static boolean brancoPodeRoquePequeno = true;
	private static boolean brancoPodeRoqueGrande = true;

	private static boolean pretoPodeRoquePequeno = true;
	private static boolean pretoPodeRoqueGrande = true;

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
		if (vezDosBrancos) {

			if (a.verificaDestino[colunaDestino][linhaDestino]) {
				// primeiro if do en passant, o peao deve estar em sua casa inicial
				for (int i = 0; i < 8; i++) {
					if (Tabuleiro.layout[i][1] == "P") {
						Tabuleiro.checaEnPassant[i] = true;
					} else {
						Tabuleiro.checaEnPassant[i] = false;
					}
				}

				int colunaAnterior = a.getPosicaoColuna();
				int linhaAnterior = a.getPosicaoLinha();

				a.desfazPosicao();
				a.setPosicao(colunaDestino, linhaDestino);

				if (colunaAnterior == 4 && linhaAnterior == 0 && isBrancoPodeRoqueGrande() && colunaDestino == 2
						&& linhaDestino == 0) {
					for (PecaBranca peca : listaBrancas) {
						if (peca.getPosicaoColuna() == 0 && peca.getPosicaoLinha() == 0) {
							peca.desfazPosicao();
							peca.setPosicao(3, 0);
							peca.resetAtrapalhaRei();
						}
					}
				} else if (colunaAnterior == 4 && linhaAnterior == 0 && isBrancoPodeRoquePequeno() && colunaDestino == 6
						&& linhaDestino == 0) {
					for (PecaBranca peca : listaBrancas) {
						if (peca.getPosicaoColuna() == 7 && peca.getPosicaoLinha() == 0) {
							peca.desfazPosicao();
							peca.setPosicao(5, 0);
							peca.resetAtrapalhaRei();
						}
					}
				}

				// se o peão andou em en passant, a peça logo atrás dele deve ser removida
				if (a.isEnPassantDireita() && a.getPosicaoColuna() == colunaAnterior + 1 && a.getPosicaoLinha() == 5
						&& Tabuleiro.temPecaPreta[a.getPosicaoColuna()][5] == false) {
					Tabuleiro.layout[a.getPosicaoColuna()][4] = " ";
					Tabuleiro.temPecaPreta[a.getPosicaoColuna()][4] = false;
					System.out.println("en Passant");
				}

				if (a.isEnPassantEsquerda() && a.getPosicaoColuna() == colunaAnterior - 1 && a.getPosicaoLinha() == 5
						&& Tabuleiro.temPecaPreta[a.getPosicaoColuna()][5] == false) {
					Tabuleiro.layout[a.getPosicaoColuna()][4] = " ";
					Tabuleiro.temPecaPreta[a.getPosicaoColuna()][4] = false;
					System.out.println("enPassant");
				}
				// remove a peça do tabuleiro
				a.getCapturou();
				// enPassant passa a ser falso novamente
				a.resetEnPassant();
				// a variável atrapalharei reinicia e só volta a ser true na próxima rodada
				a.resetAtrapalhaRei();
				// se o rei mudou de posição, o tabuleiro deve saber
				a.setRei();
				/*
				 * segundo if que verifica en passant. Se a peça saiu da casa inicial e foi para
				 * duas casas à frente, o en passant será legalizado na próxima rodada
				 */
				for (int i = 0; i < 8; i++) {
					if (Tabuleiro.layout[i][3] == "P" && Tabuleiro.layout[i][1] == " " && Tabuleiro.checaEnPassant[i]) {

					} else {
						Tabuleiro.checaEnPassant[i] = false;
					}
				}
				/*
				 * se a peça foi capturada, ela deve ocupar uma linha e coluna que não existe no
				 * tabuleiro. assim não atrapalha os métodos que usam a posição de determinadas
				 * peças no jogo
				 */
				for (PecaPreta peca : listaPretas) {
					try {
						if (layout[peca.getPosicaoColuna()][peca.getPosicaoLinha()] != peca.getNome()) {
							peca.setPosicaoColuna(50);
							peca.setPosicaoLinha(50);
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
					}
				}
				check = false;
				quantasPecasFazemCheck = 0;
				vezDosBrancos = false;
				verificaCheckBrancas();
				verTabuleiro();

				jogadas++;
			} else {
				System.out.println("Essa peça não pode mover assim");
			}
		} else {
			System.out.println("Não é a vez dos brancos");
		}
	}

	public void movePecaPreta(PecaPreta a, int colunaDestino, int linhaDestino) {
		if (vezDosBrancos == false) {
			if (a.verificaDestino[colunaDestino][linhaDestino]) {

				for (int i = 0; i < 8; i++) {
					if (Tabuleiro.layout[i][6] == "i") {
						Tabuleiro.checaEnPassant[i] = true;
					} else {
						Tabuleiro.checaEnPassant[i] = false;
					}
				}

				int colunaAnterior = a.getPosicaoColuna();
				int linhaAnterior = a.getPosicaoLinha();

				a.desfazPosicao();
				a.setPosicao(colunaDestino, linhaDestino);

				if (colunaAnterior == 4 && linhaAnterior == 7 && isPretoPodeRoqueGrande() && colunaDestino == 2
						&& linhaDestino == 7) {
					for (PecaPreta peca : listaPretas) {
						if (peca.getPosicaoColuna() == 0 && peca.getPosicaoLinha() == 7) {
							peca.desfazPosicao();
							peca.setPosicao(3, 7);
							peca.resetAtrapalhaRei();
						}
					}
				} else if (colunaAnterior == 4 && linhaAnterior == 7 && isPretoPodeRoquePequeno() && colunaDestino == 6
						&& linhaDestino == 7) {
					for (PecaBranca peca : listaBrancas) {
						if (peca.getPosicaoColuna() == 7 && peca.getPosicaoLinha() == 7) {
							peca.desfazPosicao();
							peca.setPosicao(5, 7);
							peca.resetAtrapalhaRei();
						}
					}
				}

				if (a.isEnPassantDireita() && a.getPosicaoColuna() == colunaAnterior + 1 && a.getPosicaoLinha() == 2
						&& Tabuleiro.temPecaBranca[a.getPosicaoColuna()][2] == false) {
					Tabuleiro.layout[a.getPosicaoColuna()][3] = " ";
					Tabuleiro.temPecaBranca[a.getPosicaoColuna()][3] = false;
					System.out.println("en Passant");
				}

				if (a.isEnPassantEsquerda() && a.getPosicaoColuna() == colunaAnterior - 1 && a.getPosicaoLinha() == 2
						&& Tabuleiro.temPecaBranca[a.getPosicaoColuna()][2] == false) {
					Tabuleiro.layout[a.getPosicaoColuna()][3] = " ";
					Tabuleiro.temPecaBranca[a.getPosicaoColuna()][3] = false;
					System.out.println("en Passant");
				}

				a.getCapturou();
				a.resetEnPassant();
				a.resetAtrapalhaRei();
				a.setRei();

				for (int i = 0; i < 8; i++) {
					if (Tabuleiro.layout[i][4] == "i" && Tabuleiro.layout[i][6] == " " && Tabuleiro.checaEnPassant[i]) {

					} else {
						Tabuleiro.checaEnPassant[i] = false;
					}
				}

				for (PecaBranca peca : listaBrancas) {
					try {
						if (layout[peca.getPosicaoColuna()][peca.getPosicaoLinha()] != peca.getNome()) {
							peca.setPosicaoColuna(50);
							peca.setPosicaoLinha(50);
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
					}
				}

				check = false;
				quantasPecasFazemCheck = 0;
				vezDosBrancos = true;
				verificaCheckPretas();
				verTabuleiro();
				jogadas++;

			} else {
				System.out.println("Essa peça não pode mover assim");
			}
		} else {
			System.out.println("Não é a vez dos pretos");
		}

	}

	public static boolean isCheck() {
		return check;
	}

	public static int getColunaCheck() {
		return colunaCheck;
	}

	public static int getLinhaCheck() {
		return linhaCheck;
	}

	public static int getQuantasPecasFazemCheck() {
		return quantasPecasFazemCheck;
	}

	public static Direcao getDirecaoCheck() {
		return direcaoCheck;
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

	public static boolean isVezDosBrancos() {
		return vezDosBrancos;
	}

	private void verificaCheckBrancas() {
		for (PecaBranca peca : listaBrancas) {
			try {
				peca.getVerificaDestino();
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (peca.verificaDestino[i][j] == true && reiPreto[0] == i && reiPreto[1] == j) {
							check = true;

							colunaCheck = peca.getPosicaoColuna();
							linhaCheck = peca.getPosicaoLinha();
							quantasPecasFazemCheck++;
							if (quantasPecasFazemCheck > 1) {
								break;
							}
							if (reiPreto[0] - colunaCheck == reiPreto[1] - linhaCheck) {
								direcaoCheck = Direcao.DIAGONALHORARIO;
							} else if (reiPreto[0] - colunaCheck == -1 * (reiPreto[1] - linhaCheck)) {
								direcaoCheck = Direcao.DIAGONALANTIHORARIO;
							} else if (reiPreto[0] == colunaCheck) {
								direcaoCheck = Direcao.VERTICAL;
							} else if (reiPreto[1] == linhaCheck) {
								direcaoCheck = Direcao.HORIZONTAL;
							} else {
								direcaoCheck = Direcao.ELE;
							}
						}
					}
				}
			} catch (ArrayIndexOutOfBoundsException ex) {
			}
		}
		if (check) {
			int contaCheckMate = 0;
			for (PecaPreta peca : listaPretas) {
				try {
					peca.getVerificaDestino();
					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							if (peca.verificaDestino[i][j]) {
								contaCheckMate--;
								break;
							} else if (i == 7 && j == 7) {
								contaCheckMate++;
							}
						}
					}
				} catch (ArrayIndexOutOfBoundsException ex) {
					contaCheckMate++;
				}
			}
			if (contaCheckMate == 16) {
				System.out.println("CheckMate!");
			} else {
				System.out.println("Check!");
			}
		}

	}

	private void verificaCheckPretas() {
		for (PecaPreta peca : listaPretas) {
			try {
				peca.getVerificaDestino();
				int i = reiBranco[0];
				int j = reiBranco[1];
				if (peca.verificaDestino[i][j]) {
					check = true;

					colunaCheck = peca.getPosicaoColuna();
					linhaCheck = peca.getPosicaoLinha();
					quantasPecasFazemCheck++;
					if (quantasPecasFazemCheck > 1) {
						break;
					}
					if (reiBranco[0] - colunaCheck == reiBranco[1] - linhaCheck) {
						direcaoCheck = Direcao.DIAGONALHORARIO;
					} else if (reiBranco[0] - colunaCheck == -1 * (reiBranco[1] - linhaCheck)) {
						direcaoCheck = Direcao.DIAGONALANTIHORARIO;
					} else if (reiBranco[0] == colunaCheck) {
						direcaoCheck = Direcao.VERTICAL;
					} else if (reiBranco[1] == linhaCheck) {
						direcaoCheck = Direcao.HORIZONTAL;
					} else {
						direcaoCheck = Direcao.ELE;
					}
				}

			} catch (ArrayIndexOutOfBoundsException ex) {
			}
		}
		if (check) {
			int contaCheckMate = 0;
			for (PecaBranca peca : listaBrancas) {
				try {
					peca.getVerificaDestino();
					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							if (peca.verificaDestino[i][j]) {
								contaCheckMate--;
								break;
							} else if (i == 7 && j == 7) {
								contaCheckMate++;
							}
						}
					}
				} catch (ArrayIndexOutOfBoundsException ex) {
					contaCheckMate++;
				}
			}
			if (contaCheckMate == 16) {
				System.out.println("CheckMate!");
			} else {
				System.out.println("Check!");
			}
		}

	}

	public static boolean isBrancoPodeRoquePequeno() {
		return brancoPodeRoquePequeno;
	}

	public static void setBrancoPodeRoquePequeno(boolean brancoPodeRoquePequeno) {
		Tabuleiro.brancoPodeRoquePequeno = brancoPodeRoquePequeno;
	}

	public static boolean isBrancoPodeRoqueGrande() {
		return brancoPodeRoqueGrande;
	}

	public static void setBrancoPodeRoqueGrande(boolean brancoPodeRoqueGrande) {
		Tabuleiro.brancoPodeRoqueGrande = brancoPodeRoqueGrande;
	}

	public static boolean isPretoPodeRoquePequeno() {
		return pretoPodeRoquePequeno;
	}

	public static void setPretoPodeRoquePequeno(boolean pretoPodeRoquePequeno) {
		Tabuleiro.pretoPodeRoquePequeno = pretoPodeRoquePequeno;
	}

	public static boolean isPretoPodeRoqueGrande() {
		return pretoPodeRoqueGrande;
	}

	public static void setPretoPodeRoqueGrande(boolean pretoPodeRoqueGrande) {
		Tabuleiro.pretoPodeRoqueGrande = pretoPodeRoqueGrande;
	}

}
