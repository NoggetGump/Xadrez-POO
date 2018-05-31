package pecas;

import java.util.ArrayList;
import java.util.function.Consumer;
import vetor.Vet;

public class Peca{
	/*Variaveis propositalmente sem modificador 
	* para serem acessada somente dentro do mesmo pacote*/
	Vet v;					//Vetor coordenada x e y.
	char cor;				//Cor preta "p" ou branca "b".
	boolean vivo = true;	//Consts.y para peca viva e Consts.x para peca comida.
	ArrayList<Vet> AllMoves = new ArrayList<Vet>();

	public Peca(int x, int y, char cor) {
		this.v = new Vet(x,y);
		this.cor = cor;
	}

	public char getCor() {
		return this.cor;
	}
    public Consumer<Vet> printMoves = (v) -> {
        System.out.print("(" +v.getX() + "," + v.getY() + ")" + "\t");
    };
	
	public void printAllMov()
	{
		this.AllMoves.forEach(printMoves);
	}
}
=======
package pecas;

import java.util.ArrayList;

public abstract class Peca {
	/*Variaveis propositalmente sem modificador 
	* para serem acessada somente dentro do mesmo pacote*/
	int v[] = new int[2];	//Vetor coordenada x e y.
	char cor;				//Cor preta "p" ou branca "b".
	boolean vivo;			//1 para peça viva e 0 para peça comida.

	public Peca(int x, int y, char cor) {
		this.v[0] = x;
		this.v[1] = y;
		this.cor = cor;
	}

	public int getX() {
		return v[0];
	}

	public void setX(int x) {
		this.v[0] = x;
	}

	public int getY() {
		return v[1];
	}

	public void setY(int y) {
		this.v[1] = y;
	}

	public void setv(int x, int y) {
		this.v[0] = x;
		this.v[1] = y;
	}

	public char getCor() 
	{
		return this.cor;
	}

	public abstract ArrayList<int[]> movimentoValido(int[] v);
}
