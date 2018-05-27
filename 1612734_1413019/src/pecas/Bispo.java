package pecas;

import java.util.ArrayList;
import java.util.function.Consumer;

import vetor.Vet;
import movimentos.Diagonal;

public class Bispo extends Peca{
	
	ArrayList<Vet> AllMoves = new ArrayList<Vet>();
	Diagonal D = new Diagonal();
	
	public Bispo(int x, int y, char cor)
	{
		super(x, y, cor);
		AllMoves = this.D.allMovDiag(this.v);
	}
	
    public Consumer<Vet> printMoves = (v) -> {
        System.out.print("(" +v.getX() + "," + v.getY() + ")" + "\t");
    };
	
	public void printAllMov()
	{
		this.AllMoves.forEach(printMoves);
	}
}