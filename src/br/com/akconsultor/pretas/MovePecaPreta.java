package br.com.akconsultor.pretas;

public class MovePecaPreta {
	public MovePecaPreta(PecaPreta a, int colunaDestino, int linhaDestino) {

		if (a.verificaDestino[colunaDestino][linhaDestino]) {
			a.desfazPosicao();
			a.setPosicao(colunaDestino, linhaDestino);
		} else {
			System.out.println("Essa peça não pode mover assim");
		}
	}

}
