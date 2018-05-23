package pecas;

public class Bispo extends Peca 
{
	public Bispo(int x, int y, char cor)
	{
		super(x, y, cor);
	}
	
	public int[][] movimentoValido(int[] v)
	{
		int [] Temp = new int[2];
		Temp[0] = v[0];
		Temp[1] = v[1];
		int [][]AllMoves = new int[13][2];
		
		for(int i = 0; true; i++)
		{
			Temp[0]++;
			Temp[1]++;
			if(Temp[0] >= 8 ||Temp[1] >=8)
				break;
			AllMoves[i][0] = Temp[0];
			AllMoves[i][1] = Temp[1];
		}
		
		Temp[0] = v[0];
		Temp[1] = v[1];
		
		for(int i = 0; true ; i++)
		{
			Temp[0]++;
			Temp[1]++;
			if(Temp[0] <= -1 ||Temp[1] >= 8)
				break;
			AllMoves[i][0] = Temp[0];
			AllMoves[i][1] = Temp[1];
		}
		
		Temp[0] = v[0];
		Temp[1] = v[1];
		
		for(int i = 0; true ; i++)
		{
			Temp[0]++;
			Temp[1]++;
			if(Temp[0] >= 8 ||Temp[1] <= -1)
				break;
			AllMoves[i][0] = Temp[0];
			AllMoves[i][1] = Temp[1];
		}
		
		Temp[0] = v[0];
		Temp[1] = v[1];
		
		for(int i = 0; true ; i++)
		{
			Temp[0]++;
			Temp[1]++;
			if(Temp[0] <= -1 ||Temp[1] <= -1)
				break;
			AllMoves[i][0] = Temp[0];
			AllMoves[i][1] = Temp[1];
		}
			
		return AllMoves;
	}

}