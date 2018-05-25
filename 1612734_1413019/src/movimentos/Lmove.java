package movimentos;

import java.util.ArrayList;
import tabuleiro.Consts;

public class Lmove {

	public static int[] basicL(int[] v, boolean r, boolean xM, boolean yM) // r=false:x+2,y+1;r=true: x+1,y+2
	{																	   // xM = true, espelhado em y
		int[] Temp = MovUtil.cpyArray(v); 						 		   // yM = true, espelhado em x

		if (r) {
			if (xM)
				Temp[Consts.x]--;
			else
				Temp[Consts.x]++;
			if (yM)
				Temp[Consts.y] -= 2;
			else
				Temp[Consts.y] += 2;
		}

		else {
			if (xM)
				Temp[Consts.x] -= 2;
			else
				Temp[Consts.x] += 2;
			if (yM)
				Temp[Consts.y]--;
			else
				Temp[Consts.y]++;
		}

		if (Temp[Consts.x] > Consts.xyFin || Temp[Consts.y] > Consts.xyFin || Temp[Consts.x] < Consts.xyIni || Temp[Consts.y] < Consts.xyIni)
			return null;

		return Temp;
	}

	public static ArrayList<int[]> movL(int[] v) { 			// MOVIMENTO EM "L" - CAVALO

		ArrayList<int[]> AllMoves = new ArrayList<int[]>(); // Todos os movimentos validos de um cavalo

		MovUtil.addINN(AllMoves,basicL(v, false, false, false));
		MovUtil.addINN(AllMoves,basicL(v, false, true, false));
		MovUtil.addINN(AllMoves,basicL(v, false, false, true));
		MovUtil.addINN(AllMoves,basicL(v, false, true, true));
		MovUtil.addINN(AllMoves,basicL(v, true, false, false));
		MovUtil.addINN(AllMoves,basicL(v, true, true, false));
		MovUtil.addINN(AllMoves,basicL(v, true, false, true));
		MovUtil.addINN(AllMoves,basicL(v, true, true, true));

		return AllMoves;
	}
}
