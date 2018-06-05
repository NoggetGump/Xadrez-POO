package pecas;

import java.util.ArrayList;
import java.util.function.Consumer;

import vetor.Vet;

public abstract class Peca{
	/**
	 * 
	 * 	Variaveis propositalmente sem modificador 
	 * 	para serem acessada somente dentro do mesmo pacote
	 *
	 * */
	Vet v; //Vetor coordenada x e y.
	char cor; //Cor preta "p" ou branca "b".
	boolean viva = true; //Consts.y para peca viva e Consts.x para peca comida.
	ArrayList<Vet> AllMoves = new ArrayList<Vet>(); //Lista com todos os movimentos poss�veis.

	/**
	 * 
	 *	Construtores de Peca
	 *
	 * */
	
	public Peca(int x, int y, char cor)
	{
		this.v = new Vet(x,y);
		this.cor = cor;
	}
	
	public Peca(Vet v, char cor)
	{
		this.v = new Vet(v);
		this.cor = cor;
	}
	
	public Peca(Peca p)
	{
		this.v = new Vet(p.getVet());
		this.cor = p.cor;
	}
	/**
	 * 
	 * 	Getters e Setters de Peca
	 *
	 */

	public char getCor()
	{
		return this.cor;
	}
	
	public boolean getViva() 
	{
		return viva;
	}
	
	public Vet getVet()
	{
		return v;
	}
	
	/**
	 * 
	 * Printer dos movimentos de Peca
	 *
	 */

    public Consumer<Vet> printMoves = (v) -> 
    { //para testar se os movimentos possiveis estavam sendo inicializados corretamente
        System.out.print("(" +v.getX() + "," + v.getY() + ")" + "\t");
    };

	public void printAllMov()
	{
		this.AllMoves.forEach(printMoves);
	}
	
	/**
	 * 
	 *	Recebe as coordenadas cartesianas
	 *	e retorna as coordenadas User Space
	 *
	 */
	
	public int convCoorX()
	{ //converte as coordenadas cartesianas em coordenada User Space
		int coordenadaX = (this.v.getX() * 75) + 5;
		return coordenadaX;
	}
	
	public int convCoorY()
	{ //converte as coordenadas cartesianas em coordenada User Space
		int coordenadaY =  (this.v.getY() * 75) + 5;
		return coordenadaY;
	}
	
	/**
	 * 
	 * 	Retorna o path correto para
	 *  a imagem da respectiva peca
	 *
	 */
	
	abstract public String imgPeca();
}