package pecas;

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

	private void ifEspecial(Vertical V, boolean p)
	{
		Vet Temp = new Vet(v);
		int casaEspecialP = 1;
		int casaEspecialB = 6;

		if(p)
			if(Temp.getY() == casaEspecialP)
			{
				V.addIfTrue(new Vet(Temp), Temp, AllMoves, true);
				V.addIfTrue(new Vet(Temp), Temp, AllMoves, true);
			}
			else
			{	V.addIfTrue(new Vet(Temp), Temp, AllMoves, true);}
		else
			if(Temp.getY() == casaEspecialB)
			{
				V.addIfTrue(new Vet(Temp), Temp, AllMoves, false);
				V.addIfTrue(new Vet(Temp), Temp, AllMoves, false);
			}
			else
			{	V.addIfTrue(new Vet(Temp), Temp, AllMoves, false);}
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
		Vertical V = new Vertical(tab);

		ifEspecial(V, this.corP());
	}
	
	/*public boolean isPromoteble ()
	{
		if(this.corP() == true) // Se peca é preta
		{
			if(this.getY() == 7) // Se pocicao da peca preta for a ultima linha do tabuleiro
			{
				return true; // E promovivel
			}
		}
		if(this.corP() == false) // Se peca é branca
		{
			if(this.getY() == 0) // Se poisao da peca branca for a a primeira linha do tabuleiro
			{
				return true; // E promovivel
			}
		}
		
		return false;
	}*/
	
	
}
