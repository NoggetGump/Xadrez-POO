package pecas;

import movimentos.Vertical;
import movimentos.Horizontal;

public class Torre extends Peca
{
	Vertical V = new Vertical();
	Horizontal H = new Horizontal();
	
	public Torre(int x, int y, char cor)
	{
		super(x, y, cor);
		H.allHorMov(this.v, AllMoves);
		V.allVerMov(this.v, AllMoves);
	}
}

package pecas;

public class Torre extends Peca
{
	public Torre(int x, int y, char cor)
	{
		super(x, y, cor);
	}
	
	/**
	 * 
	 * 		Calcula todos os movimentos poss�veis da Torre dada sua posi��o
	 * 
	 * 		AE: Vetor (x,y) da posi��o atual da Torre
	 * 		AS: Array com todas posi��es finais poss�veis para a pe�a
	 * 
	 * */
	public int[][] movimentosPossiveis (int [] v)
	{
		int [][]AllMoves = new int [14][2];
		int i, j = 0;
		int limite_superior = 8 - v[0];
		int limite_inferior = v[0] - 1;
		int limite_direito = 8 - v[1];
		int limite_esquerdo = v[1] - 1;
		
		for(i = limite_superior ; i > 0 ; i--) // Calcula todos os movimentos poss�veis cima
		{
			AllMoves[j][0] = v[0];
			AllMoves[j][1] = v[1] + limite_superior;
			j++;
		}
		for(i = limite_inferior ; i > 0 ; i--) // Calcula todos os movimentos poss�veis para baixo
		{
			AllMoves[j][0] = v[0];
			AllMoves[j][1] = v[1] + limite_inferior;
			j++;
		}
		for(i = limite_direito ; i > 0 ; i--) // Calcula todos os movimentos poss�veis para a direita
		{
			AllMoves[j][1] = v[1];
			AllMoves[j][0] = v[0] + limite_direito;
			j++;
		}
		for(i = limite_esquerdo ; i > 0 ; i--) // Calcula todos os movimentos poss�veis para a esquerda
		{
			AllMoves[j][1] = v[1];
			AllMoves[j][0] = v[0] + limite_esquerdo;
			j++;
		}
		
		return AllMoves;
	}
}