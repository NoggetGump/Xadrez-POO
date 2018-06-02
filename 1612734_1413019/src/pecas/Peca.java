package pecas;

import java.util.ArrayList;
import java.util.function.Consumer;

import vetor.Vet;

public abstract class Peca{
	/*Variaveis propositalmente sem modificador 
	* para serem acessada somente dentro do mesmo pacote*/
	Vet v; //Vetor coordenada x e y.
	char cor; //Cor preta "p" ou branca "b".
	boolean vivo = true; //Consts.y para peca viva e Consts.x para peca comida.
	ArrayList<Vet> AllMoves = new ArrayList<Vet>(); //Lista com todos os movimentos possíveis.

	public Peca(int x, int y, char cor)
	{
		this.v = new Vet(x,y);
		this.cor = cor;
	}
	
	public Peca(Peca p)
	{
		this.v = new Vet(p.v.getX(), p.v.getY());
		this.cor = p.cor;
	}

	public char getCor()
	{
		return this.cor;
	}

    public Consumer<Vet> printMoves = (v) -> 
    { //para testar se os movimentos possiveis estavam sendo inicializados corretamente
        System.out.print("(" +v.getX() + "," + v.getY() + ")" + "\t");
    };

	public void printAllMov()
	{
		this.AllMoves.forEach(printMoves);
	}
	
	public int convCoorX()
	{ //converte as coordenadas cartesianas em coordenada User Space
		int coordenadaX = this.v.getX() * 100 + 18;
		return coordenadaX;
	}
	
	public int convCoorY()
	{ //converte as coordenadas cartesianas em coordenada User Space
		int coordenadaY =  this.v.getY() * 100 + 15;
		return coordenadaY;
	}
	
	abstract public String imgPeca();
}
