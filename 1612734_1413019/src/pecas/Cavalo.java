package pecas;

import java.util.ArrayList;

import movimentos.Lmove;

public class Cavalo extends Peca
{
	public Cavalo(int x, int y, char cor)
	{
		super(x, y, cor);
	}
	
	public ArrayList<int[]> movimentoValido(int[] v)
	{
		ArrayList<int[]> AllMoves = new ArrayList<int[]>();	// Todos os movimentos validos para esse tipo de peça
		
		AllMoves = Lmove.movL(v);
		
		return AllMoves;
	}
}
