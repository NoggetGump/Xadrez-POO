package pecas;

import vetor.Vet;

public class Peca{
	/*Variaveis propositalmente sem modificador 
	* para serem acessada somente dentro do mesmo pacote*/
	Vet v;					//Vetor coordenada x e y.
	char cor;				//Cor preta "p" ou branca "b".
	boolean vivo = true;	//Consts.y para peca viva e Consts.x para peca comida.

	public Peca(int x, int y, char cor) {
		this.v = new Vet(x,y);
		this.cor = cor;
	}

	public char getCor() {
		return this.cor;
	}
}