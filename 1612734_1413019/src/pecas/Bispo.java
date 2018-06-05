package pecas;

import movimentos.Diagonal;
import tabuleiro.Consts;
import vetor.Vet;

public class Bispo extends Peca
{
	Diagonal D = new Diagonal();
	
	/**
	 *
	 *	Construtores de Peca
	 *
	 * */

	public Bispo(int x, int y, char cor)
	{
		super(x, y, cor);
		D.allMovDiag(this.v, this.AllMoves);
	}

	public Bispo(Vet v, char cor)
	{
		super(v , cor);
		D.allMovDiag(this.v, this.AllMoves);
	}

	/**
	 * 
	 *	Retorna o path da imagem
	 *
	 * */

	public String imgPeca()
	{
		if(this.cor == 'p')
			return Consts.bispoP.getPath();
		else
			return Consts.bispoB.getPath();
	}
}