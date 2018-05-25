package pecas;

import java.util.ArrayList;
import tabuleiro.Consts;

/* Retorna todos os movimentos, dado que o usuário
 * tenha chamado a função correta e tenha passado
 * seu sentido e direção da maneira correta - int
 * r (diagonal) ou int a (vert/horizontal).******/

class Movimentos {

	static void addIfNotNull(ArrayList<int[]> to, int[] from) // autoexplicativo
	{
		if (from != null)
			to.add(from);
	}

	static void addAllIfNotNull(ArrayList<int[]> to, ArrayList<int[]> from) // autoexplicativo
	{
		if (from != null)
			to.addAll(from);
	}

	static ArrayList<int[]> allMovDiag(int[] v) {
		int[] Temp = new int[2];
		Temp[Consts.x] = v[Consts.x];
		Temp[Consts.y] = v[Consts.y];
		ArrayList<int[]> AllMoves = new ArrayList<int[]>(); // TODOS os movimentos validos.

		while (Temp[Consts.x] < Consts.xyFin && Temp[Consts.y] < Consts.xyFin) {
			Temp[Consts.x]++;
			Temp[Consts.y]++;
			addIfNotNull(AllMoves, Temp);
		}
		Temp[Consts.x] = v[Consts.x];
		Temp[Consts.y] = v[Consts.y];

		while (Temp[Consts.x] > Consts.xyIni && Temp[Consts.y] < Consts.xyFin) {
			Temp[Consts.x]--;
			Temp[Consts.y]++;
			addIfNotNull(AllMoves, Temp);
		}
		Temp[Consts.x] = v[Consts.x];
		Temp[Consts.y] = v[Consts.y];

		while (Temp[Consts.x] > Consts.xyIni && Temp[Consts.y] > Consts.xyIni) {
			Temp[Consts.x]--;
			Temp[Consts.y]--;
			addIfNotNull(AllMoves, Temp);
		}
		Temp[Consts.x] = v[Consts.x];
		Temp[Consts.y] = v[Consts.y];

		while (Temp[Consts.x] < Consts.xyFin || Temp[Consts.y] > Consts.xyIni) {
			Temp[Consts.x]++;
			Temp[Consts.y]--;
			addIfNotNull(AllMoves, Temp);
		}
		Temp[Consts.x] = v[Consts.x];
		Temp[Consts.y] = v[Consts.y];

		if (AllMoves.isEmpty())
			return null;
		else

			return AllMoves;
	}

	static ArrayList<int[]> movDiag(int r, int[] v) // MOVIMENTO DIAGONAL EM UMA DIREÇÃO E SENTIDO
	{
		int[] Temp = new int[2];
		Temp[Consts.x] = v[Consts.x];
		Temp[Consts.y] = v[Consts.y];
		ArrayList<int[]> AllMoves = new ArrayList<int[]>(); // Todos os movimentos validos para a direção e sentido
															// requisitados

		switch (r) {
		case Consts.y: // Região Consts.y dos eixos cartesianos
			while (Temp[Consts.x] < Consts.xyFin && Temp[Consts.y] < Consts.xyFin) {

				Temp[Consts.x]++;
				Temp[Consts.y]++;
				AllMoves.add(Temp);
			}
			break;

		case 2: // Região 2 dos eixos cartesianos
			while (Temp[Consts.x] > Consts.xyIni && Temp[Consts.y] < Consts.xyFin) {
				Temp[Consts.x]--;
				Temp[Consts.y]++;
				AllMoves.add(Temp);
			}
			break;

		case 3: // Região 3 dos eixos cartesianos
			while (Temp[Consts.x] > Consts.xyIni && Temp[Consts.y] > Consts.xyIni) {
				Temp[Consts.x]--;
				Temp[Consts.y]--;
				AllMoves.add(Temp);
				break;
			}
			break;

		case 4: // Região 4 dos eixos cartesianos
			while (Temp[Consts.x] < Consts.xyFin || Temp[Consts.y] > Consts.xyIni) {
				Temp[Consts.x]++;
				Temp[Consts.y]--;
				AllMoves.add(Temp);
				break;
			}
			break;
		}
		if (AllMoves.isEmpty())
			return null;
		else
			return AllMoves;
	}

	private static int[] LmovBasiCase(int[] v, boolean r, boolean xM, boolean yM) // xM = true se espelhado em X,
	{ // yM = true se espelhado em Y
		int[] Temp = new int[2]; // r=false:x+2,y+Consts.y;r=true: x+Consts.y,y+2
		Temp[Consts.x] = v[Consts.x];
		Temp[Consts.y] = v[Consts.y];

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

	static ArrayList<int[]> movL(int[] v) { // MOVIMENTO EM "L" - CAVALO
		int[] Temp = new int[2];
		Temp[Consts.x] = v[Consts.x];
		Temp[Consts.y] = v[Consts.y];
		ArrayList<int[]> AllMoves = new ArrayList<int[]>(); // Todos os movimentos validos de um cavalo

		addIfNotNull(AllMoves, LmovBasiCase(v, false, false, false));
		addIfNotNull(AllMoves, LmovBasiCase(v, false, true, false));
		addIfNotNull(AllMoves, LmovBasiCase(v, false, false, true));
		addIfNotNull(AllMoves, LmovBasiCase(v, false, true, true));
		addIfNotNull(AllMoves, LmovBasiCase(v, true, false, false));
		addIfNotNull(AllMoves, LmovBasiCase(v, true, true, false));
		addIfNotNull(AllMoves, LmovBasiCase(v, true, false, true));
		addIfNotNull(AllMoves, LmovBasiCase(v, true, true, true));

		return AllMoves;
	}

	static int[] vertUnitMov(int[] v)
	{
		if(v[])
		return null;
	}
}
