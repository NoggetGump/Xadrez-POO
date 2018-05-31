package pecas;

import movimentos.Diagonal;

public class Bispo extends Peca
{
	Diagonal D = new Diagonal();
	
	public Bispo(int x, int y, char cor)
	{
		super(x, y, cor);
		D.allMovDiag(this.v, this.AllMoves);
	}
}
