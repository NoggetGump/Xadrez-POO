package pecas;

import java.util.ArrayList;
import tabuleiro.Consts;

public abstract class Peca {
	/*Variaveis propositalmente sem modificador 
	* para serem acessada somente dentro do mesmo pacote*/
	int v[] = new int[2];	//Vetor coordenada x e y.
	char cor;				//Cor preta "p" ou branca "b".
	boolean vivo;			//Consts.y para peca viva e Consts.x para peca comida.

	public Peca(int x, int y, char cor) {
		this.v[Consts.x] = x;
		this.v[Consts.y] = y;
		this.cor = cor;
	}

	public int getX() {
		return v[Consts.x];
	}

	public void setX(int x) {
		this.v[Consts.x] = x;
	}

	public int getY() {
		return v[Consts.y];
	}

	public void setY(int y) {
		this.v[Consts.y] = y;
	}

	public void setv(int x, int y) {
		this.v[Consts.x] = x;
		this.v[Consts.y] = y;
	}

	public char getCor() {
		return this.cor;
	}

	public abstract ArrayList<int[]> movimentoValido(int[] v);

}
