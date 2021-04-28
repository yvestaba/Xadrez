package br.com.akconsultor;

public class Tabuleiro {
	public static boolean[][] temPecaBranca = new boolean[8][8];
	public static boolean[][] temPecaPreta = new boolean[8][8];
	public boolean[][] podeMover = new boolean[8][8];
	public boolean[][] podeCapturar = new boolean[8][8];
	public boolean[][] podeMoverOuCapturar = new boolean[8][8];
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

		for (int m = 0; m < 8; m++) {
			for (int n = 0; n < 8; n++) {
				podeMover[m][n] = false;
			}
		}
		for (int o = 0; o < 8; o++) {
			for (int p = 0; p < 8; p++) {
				layout[o][p] = " ";
			}
		}
	}

}
