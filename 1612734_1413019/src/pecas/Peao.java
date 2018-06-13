package pecas;

import movimentos.Diagonal;
import movimentos.Vertical;
import tabuleiro.Consts;
import tabuleiro.Tabuleiro;
import vetor.Vet;

public class Peao extends Peca{

	/**
	 * 
	 *	Construtores de Peca.
	 *
	 * */

	public Peao(int x, int y, char cor){super(x, y, cor);}

	public Peao(Vet v, char cor){super(v, cor);}

	/**
	 * 
	 *	Checa se o movimento do peao
	 *	eh especial ou nao, e adiciona ao seu
	 *	conjunto de movimentos AllMove a quantidade
	 *	apropriada de coordenadas.
	 *
	 * */

	private void ifEspecial(Vertical V, Diagonal D, boolean p)
	{
		Vet Temp = new Vet(v);
		Vet Temp2 = new Vet(v);
		int casaEspecialP = 1;
		int casaEspecialB = 6;

		if(p)
		{
			if(Temp.getY() == casaEspecialP)
			{
				V.addIfTrue(new Vet(Temp), Temp, AllMoves, null, true);
				V.addIfTrue(new Vet(Temp), null, AllMoves, null, true);
			}
			else
			{	V.addIfTrue(new Vet(Temp), null, AllMoves, null, true);}
			D.DPPmove(new Vet(Temp2), null, comiveis);
			D.DNPmove(new Vet(Temp2), null, comiveis);
		}
		else
		{
			if(Temp.getY() == casaEspecialB)
			{
				V.addIfTrue(new Vet(Temp), Temp, AllMoves, null, false);
				V.addIfTrue(new Vet(Temp), null, AllMoves, null, false);
			}
			else
			{	V.addIfTrue(new Vet(Temp), null, AllMoves, null, false);}
			D.DNNmove(new Vet(Temp2), null, comiveis);
			D.DPNmove(new Vet(Temp2), null, comiveis);
		}
	}

	/**
	 * 
	 *	Retorna o path da imagem.
	 *
	 * */

	public String imgPeca()
	{
		if(this.cor == 'p')
			return Consts.peaoP.getPath();
		else
			return Consts.peaoB.getPath();
	}

	/**
	 * 
	 *	Retorna o nome da peca. 
	 *	<!> DEBUG ONLY <!>
	 *
	 * */

	public String nomePeca()
	{
		return "Peao";
	}

	public void AtualizaMoves(Tabuleiro tab)
	{
		Vertical V = new Vertical(tab, this.v);
		Diagonal D = new Diagonal(tab, this.v);
		
		AllMoves.clear();
		comiveis.clear();
		
		ifEspecial(V, D, this.corP());
	}
}