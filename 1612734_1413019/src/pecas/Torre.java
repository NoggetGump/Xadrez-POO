package pecas;

import movimentos.Vertical;
import movimentos.Horizontal;

public class Torre extends Peca
{
	/**
	 * 
	 */
	Vertical V = new Vertical();
	Horizontal H = new Horizontal();
	
	public Torre(int x, int y, char cor)
	{
		super(x, y, cor);
		H.allHorMov(this.v, AllMoves);
		V.allVerMov(this.v, AllMoves);
	}

	public String imgPeca()
	{	    
		String currPath = System.getProperty("user.dir");
		return currPath+"\\Assets\\Torre_B.png";
	}
}
