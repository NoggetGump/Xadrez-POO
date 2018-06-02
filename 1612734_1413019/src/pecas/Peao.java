package pecas;

import movimentos.Vertical;
import vetor.Vet;

public class Peao extends Peca{
	
	Vertical V = new Vertical();
	
	public Peao(int x, int y, char cor)
	{
		super(x, y, cor);
		Vet Temp = new Vet(v);

		V.addIfTrue(new Vet(Temp), Temp, AllMoves, true);
	}
	
	public String imgPeca()
	{
		String currPath = System.getProperty("user.dir");
		return currPath+"\\Assets\\Peao_B.png";
	}
}
