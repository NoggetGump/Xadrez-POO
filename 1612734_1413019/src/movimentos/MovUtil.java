package movimentos;

import java.util.ArrayList;
import tabuleiro.Consts;

public class MovUtil{

	static void addINN(ArrayList<int[]> to, int[] from) // ADD IF NOT NULL
	{
		if (from != null)
			to.add(from);
	}

	static void addAllINN(ArrayList<int[]> to, ArrayList<int[]> from) // ADD ALL IF NOT NULL
	{
		if (from != null)
			to.addAll(from);
	}

	static int[] cpyArray(int[] v)
	{
		int[] Temp = new int[2];
		Temp[Consts.x] = v[Consts.x];
		Temp[Consts.y] = v[Consts.y];
		return Temp;
	}
	
	static void cpyArray(int[] v, int[] b)
	{
		b[Consts.x] = v[Consts.x];
		b[Consts.y] = v[Consts.y];
	}
	
	static void movePP(int[] v)
	{
		v[Consts.x]++;
		v[Consts.y]++;
	}
	
	static void moveNP(int[] v)
	{
		v[Consts.x]--;
		v[Consts.y]++;
	}
	
	static void moveNN(int[] v)
	{
		v[Consts.x]--;
		v[Consts.y]--;
	}
	
	static void movePN(int[] v)
	{
		v[Consts.x]++;
		v[Consts.y]--;
	}
}