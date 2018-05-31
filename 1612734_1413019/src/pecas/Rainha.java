package pecas;

import movimentos.Diagonal;
import movimentos.Horizontal;
import movimentos.Vertical;

public class Rainha extends Peca
{
	Vertical V = new Vertical();
	Horizontal H = new Horizontal();
	Diagonal D = new Diagonal();
	
	public Rainha(int x, int y, char cor)
	{
		super(x, y, cor);		
		H.allHorMov(this.v, AllMoves);
		V.allVerMov(this.v, AllMoves);
		D.allMovDiag(this.v, this.AllMoves);
	}
}
