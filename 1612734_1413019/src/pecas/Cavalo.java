package pecas;

import movimentos.Lmove;
import tabuleiro.Consts;
import tabuleiro.Tabuleiro;
import vetor.Vet;

public class Cavalo extends Peca{

	/**
	 * 
	 *	Construtores de Peca
	 *
	 * */

	public Cavalo(int x, int y, char cor){super(x, y, cor);}

	public Cavalo(Vet v, char cor){super(v, cor);}

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

	public String nomePeca()
	{
		if(this.getCor() == 'b')
		{
			return "Cavalo Branco";
		}
		else
		{
			return "Cavalo Preto";
		}
	}

	public void AtualizaMoves(Tabuleiro tab)
	{
		Lmove lmove = new Lmove(tab);
		
		AllMoves.clear();
		
		lmove.Lmoves(this.v, AllMoves);
	}
}
