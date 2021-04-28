package br.com.akconsultor;

public class VerOndeTemPecaBranca {
	public VerOndeTemPecaBranca() {
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				System.out.print(Tabuleiro.temPecaBranca[j][i] + " ");
			}
			System.out.println();
		} System.out.println();
	}
}
