package pecas;

import movimentos.Lmove;
import tabuleiro.Consts;
import vetor.Vet;

public class Cavalo extends Peca{
	Lmove lmove = new Lmove();
	
	/**
	 * 
	 *	Construtores de Peca
	 *
	 * */
	
	public Cavalo(int x, int y, char cor)
	{
		super(x, y, cor);
		lmove.Lmoves(v, AllMoves);
	}
	
	public Cavalo(Vet v, char cor)
	{
		super(v, cor);
		lmove.Lmoves(this.v, AllMoves);
	}
	
	/**
	 * 
	 *	Retorna o path da imagem
	 *
	 * */
	
	public String imgPeca()
	{
		if(this.cor == 'p')
			return Consts.cavaloP.getPath();
		else
			return Consts.cavaloB.getPath();
	}
}