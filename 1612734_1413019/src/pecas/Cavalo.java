package pecas;

import movimentos.Lmove;

public class Cavalo extends Peca{
	Lmove lmove = new Lmove();
	
	public Cavalo(int x, int y, char cor)
	{
		super(x, y, cor);
		lmove.Lmoves(v, AllMoves);
	}
}