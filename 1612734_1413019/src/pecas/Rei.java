package pecas;

public class Rei extends Peca
{
	public Rei(int x, int y, char cor)
	{
		super(x, y, cor);
	}
	
	public int[][] movimentosPossiveis (int [] v)
	{
		int [][]AllMoves = new int [8][2];
		int j = 0;

		AllMoves[0][0] = v[0] + 1;
		AllMoves[0][1] = v[1];

		AllMoves[1][];


		return AllMoves;
	}
}
