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
