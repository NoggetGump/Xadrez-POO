package pecas;

import java.util.ArrayList;

public class Bispo extends Peca 
{
	public Bispo(int x, int y, char cor)
	{
		super(x, y, cor);
	}
	
	public ArrayList<int[]> movimentoValido(int[] v)
	{
		ArrayList<int[]> AllMoves = new ArrayList<int[]>();	// Todos os movimentos validos para esse tipo de peça
		
		AllMoves = Movimentos.allMovDiag(v);
		
		return AllMoves;
	}
}