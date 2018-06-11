package pecas;

import java.util.ArrayList;
import java.util.function.Consumer;

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
	boolean viva = true; //Consts.y para peca viva e Consts.x para peca comida.
	ArrayList<Vet> AllMoves = new ArrayList<Vet>(); //Lista com todos os movimentos de determinada peca

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
		this.v = new Vet(p.getVet());
		this.cor = p.cor;
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

	public boolean getViva() 
	{
		return viva;
	}

	public Vet getVet()
	{
		return v;
	}

	public int getX()
	{
		return this.v.getX();
	}

	public int getY()
	{
		return this.v.getY();
	}
	
	public void setV(int x, int y)
	{
		v.set(x, y);
	}

	public ArrayList<Vet> getAllMoves()
	{
		return this.AllMoves;
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
	
	public boolean jogadaValida(int x, int y)
	{
		for(Vet move : this.AllMoves)
			if(x == move.getX() && y == move.getY())
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
			if(!(t%2 == 0) && cor == 'b')
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
	 *	Atualiza os movimentos (AllMoves) da peca.
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