package vetor;

import java.util.ArrayList;

public class VetUtil{

	public static  void addINN(ArrayList<Vet> to, Vet from) // ADD IF NOT NULL
	{
		if (from != null)
			to.add(from);
	}

	public static void addAllINN(ArrayList<Vet> to, ArrayList<Vet> from) // ADD ALL IF NOT NULL
	{
		if (from != null)
			to.addAll(from);
	}

	public static void movePP(Vet v){
		v.add(1, 1);
	}
	
	public static void moveNP(Vet v){
		v.add(-1, 1);
	}
	
	public static  void moveNN(Vet v){
		v.add(-1, -1);
	}
	
	public static void movePN(Vet v)
	{
		v.add(1, -1);
	}

	public static Vet cpyV(Vet v) {
		Vet Temp = new Vet();
		Temp.cpyVet(v);
		return Temp;
	}
	
}