package pecas;

import java.util.ArrayList;
import java.util.function.Consumer;

import tabuleiro.Consts;
import tabuleiro.Tabuleiro;
import vetor.Vet;

public abstract class Peca{
	/**
	 * 
	 * 	Variaveis propositalmente sem modificador 
	 * 	para serem acessada somente dentro do mesmo pacote.
	 *
	 * */
	Vet v; //Vetor coordenada x e y.
	char cor; //Cor preta "p" ou branca "b".
	ArrayList<Vet> AllMoves = new ArrayList<Vet>(); //Lista com todos os movimentos de determinada peca
	ArrayList<Vet> comiveis = new ArrayList<Vet>(8); //LIsta com todas as coordenadas onde ha uma peca a ser comida

	/**
	 * 
	 *	Construtores de Peca.
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
		this.v = new Vet(p.getX(), p.getY());
		this.cor = p.cor;
	}
	
	public boolean equals(Peca p)
	{
		if(this != p)
			return true;
		
		return false;
	}

	/**
	 * 
	 * 	Getters e Setters de Peca.
	 *
	 */

	public char getCor()
	{
		return this.cor;
	}

	public int getX()
	{
		return this.v.getX();
	}

	public int getY()
	{
		return this.v.getY();
	}

	public Vet getV()
	{
		return this.v;
	}

	public void setV(int x, int y)
	{
		v.set(x, y);
	}
	
	public void setV(Vet v)
	{
		v.set(v.getX(), v.getY());
	}
	

	public void setX(int x)
	{
		this.v.setX(x);
	}


	public ArrayList<Vet> getAllMoves()
	{
		return this.AllMoves;
	}

	public ArrayList<Vet> getComiveis()
	{
		return comiveis;
	}

	public void atualizaPos(Vet vet)
	{
		this.v.set(vet.getX(), vet.getY());
	}

	/**
	 * 
	 * Retorna true se a cor for preta
	 *
	 */

	public boolean corP()
	{
		if(this.cor == 'p')
			return true;
		else
			return false;
	}

	/**
	 * 
	 * Retorna true se o movimento for possivel
	 *
	 */

	public boolean movimentoValido(int x, int y)
	{
		for(Vet move : this.AllMoves)
			if(x == move.getX() && y == move.getY())
				return true;

		return false;
	}

	/**
	 * 
	 * Retorna true se o movimento for possivel
	 *
	 */

	public boolean comidaValida(int x, int y)
	{
		for(Vet comida : this.comiveis)
			if(x == comida.getX() && y == comida.getY())
				return true;

		return false;
	}
	
	/**
	 * 
	 * 	Retorna se a peca selecionada obedece o
	 * 	seu respectivo turno
	 *
	 */
	
	public boolean turno(int t)
	{
		if(t%2 == 0 && cor == 'p')
			return true;
		else
			if(t%2 != 0 && cor == 'b')
				return true;
		
		return false;
	}

	/**
	 * 
	 * Printer dos movimentos de Peca. Somente para DEBUG ONLY!
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
	 * Converte as coordenadas X e Y 
	 *
	 */
	
	public int convCoorX()
	{ //converte as coordenadas cartesianas em coordenadas User Space
		return (this.getX() * Consts.tamC) + Consts.ajuste;
	}
	
	public int convCoorY()
	{ //converte as coordenadas cartesianas em coordenadas User Space
		return (this.getY() * Consts.tamC) + Consts.ajuste;
	}

	/** <!> A PARTIR DAQUI RESIDEM AS FUNCOES ABSTRATAS <!> 
	 * 
	 * 	Retorna o path correto para
	 *  a imagem da respectiva peca.
	 *
	 */

	abstract public String imgPeca();

	/**
	 * 
	 *	Teste para saber se o click do mouse
	 *	retorna a peca correta.
	 *
	 */

	abstract public String nomePeca();

	/**
	 *
	 * 	Importante <!>
	 *  AllMoves não precisa ser inicializada
	 *  na construcao do objeto Peca. AllMoves
	 *  deve ser inicializada quando o tabuleiro
	 *  estiver cheio de pecas, assim a função 
	 *  poderá lidar com o conflito de pecas.
	 *   
	 */

	public abstract void AtualizaMoves(Tabuleiro tab);
	
}