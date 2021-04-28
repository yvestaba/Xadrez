package br.com.akconsultor;

public class VerTabuleiro {
	//esses padrão de "for" é a maneira de visualizar o tabuleiro com a casa a1 na ponta inferior esquerda
	VerTabuleiro(){
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				System.out.print(Tabuleiro.layout[j][i] + " ");
			}
			System.out.println();
		}
	}

}
