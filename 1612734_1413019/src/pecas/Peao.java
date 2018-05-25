package pecas;

import java.util.ArrayList;

import tabuleiro.Consts;

public class Peao extends Peca
{
	public Peao(int x, int y, char cor)
	{
		super(x, y, cor);
	}
	
	public ArrayList<int[]> movimentoValido(int[] v)
	{
		ArrayList<int[]> AllMoves = new ArrayList<int[]>(1);
		if(v[Consts.y] < Consts.xyFin)
			v[Consts.y]++;
		else 
			return null;
		
		return AllMoves;		
	}
}
