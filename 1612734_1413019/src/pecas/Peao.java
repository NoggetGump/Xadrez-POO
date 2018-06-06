package pecas;

import movimentos.Vertical;
import tabuleiro.Consts;
import vetor.Vet;

public class Peao extends Peca{
	
	Vertical V = new Vertical();
	
	/**
	 * 
	 *	Construtores de Peca
	 *
	 * */
	
	public Peao(int x, int y, char cor)
	{
		super(x, y, cor);
		Vet Temp = new Vet(v);

		V.addIfTrue(new Vet(Temp), Temp, AllMoves, true);
	}
	
	public Peao(Vet v, char cor)
	{
		super(v, cor);
		Vet Temp = new Vet(this.v);

		V.addIfTrue(new Vet(Temp), Temp, AllMoves, true);
	}
	
	/**
	 * 
	 *	Retorna o path da imagem
	 *
	 * */
	
	public String imgPeca()
	{
		if(this.cor == 'p')
			return Consts.peaoP.getPath();
		else
			return Consts.peaoB.getPath();
	}
	
	public String nomePeca()
	{
		return "Peao";
	}
}