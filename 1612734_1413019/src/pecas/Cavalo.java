package pecas;

import movimentos.Lmove;
import tabuleiro.Consts;
import tabuleiro.Tabuleiro;
import vetor.Vet;

public class Cavalo extends Peca{
	public float valor = 0.5f;
	/**
	 * 
	 *	Construtores de Peca
	 *
	 * */

	public Cavalo(int x, int y, char cor){super(x, y, cor, 0.5f);}

	public Cavalo(Vet v, char cor){super(v, cor, 0.5f);}

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

	public String nome()
	{
		return "Cavalo";
	}

	public void AtualizaMoves(Tabuleiro tab)
	{
		Lmove lmove = new Lmove(tab, this.v);

		AllMoves.clear();
		comiveis.clear();

		lmove.Lmoves(this.AllMoves, this.comiveis);
	}
}