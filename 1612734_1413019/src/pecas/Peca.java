package pecas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import tabuleiro.Consts;
import tabuleiro.Tabuleiro;
import vetor.Vet;

public abstract class Peca{
	/**
	 * 	Variaveis propositalmente sem modificador 
	 * 	para serem acessada somente dentro do mesmo pacote.
	 * */

	Vet v; //Vetor coordenada x e y.
	char cor; //Cor preta "p" ou branca "b".
	ArrayList<Vet> AllMoves = new ArrayList<Vet>(); //Lista com todos os movimentos de determinada peca
	ArrayList<Vet> comiveis = new ArrayList<Vet>(8); //LIsta com todas as coordenadas onde ha uma peca a ser comida
	public float valor;
	/**
	 *	Construtores de Peca.
	 * */

	public Peca(int x, int y, char cor, float valor)
	{
		this.v = new Vet(x,y);
		this.cor = cor;
		this.valor = valor;
	}

	public Peca(Vet v, char cor, float valor)
	{
		this.v = new Vet(v);
		this.cor = cor;
		this.valor = valor;
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
	 * 	Compara as coordenadas da peça com a de um Vet qualquer.
	 */
	public boolean comparaCoor(Vet b)
	{
		if(this.getX() == b.getX() && this.getY() == b.getY())
			return true;

		return false;
	}

	/**
	 * 	Getters e Setters de Peca.
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

	public void setCor(char cor)
	{
		this.cor = cor;
	}

	public List<Vet> getAllMoves()
	{
		return Collections.unmodifiableList(AllMoves);
	}

	public List<Vet> getComiveis()
	{
		return Collections.unmodifiableList(comiveis);
	}

	public void atualizaPos(Vet vet)
	{
		this.v.add(vet);
	}

	/**
	 * Retorna true se a cor for preta
	 */

	public boolean corP()
	{
		if(this.cor == 'p')
			return true;
		else
			return false;
	}

	/**
	 * Retorna true se o movimento for possivel
	 */

	public boolean movimentoValido(int x, int y)
	{
		for(Vet move : this.AllMoves)
			if(x == move.getX() && y == move.getY())
				return true;

		return false;
	}

	/**
	 * Retorna true se o movimento for possivel
	 */

	public boolean comidaValida(int x, int y)
	{
		for(Vet comida : this.comiveis)
			if(x == comida.getX() && y == comida.getY())
				return true;

		return false;
	}

	/**
	 * 	Retorna se a peca selecionada obedece o
	 * 	seu respectivo turno
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
	 * Printer dos movimentos de Peca. Somente para DEBUG ONLY!
	 */

    private Consumer<Vet> printMoves = (v) -> 
    { //para testar se os movimentos possiveis estavam sendo inicializados corretamente
        System.out.print("(" +v.getX() + "," + v.getY() + ")" + "\t");
    };

	public void printAllMov()
	{
		this.AllMoves.forEach(printMoves);
	}

	/**
	 * Checa se a casa do rei, ou possivel movimento do rei
	 * estah sendo ameacado. Retorna True em caso positivo.
	 */

	public boolean checaCheque(Vet reiPos)
	{
		for(Vet v : comiveis)
			if(v.equals(reiPos))
				return true;

		return false;
	}

	/** 
	 * 	Retorna a string do nome da peça + sua pocição no tabuleiro
	 * */
	
	public String printSave()
	{
		return this.nome() + " " + this.cor + " " + Integer.toString(this.getX()) + " " + Integer.toString(this.getY()) + " ";
	}
	
	/**
	 * Converte as coordenadas X e Y 
	 */
	
	public int cnvrtCooX()
	{ //converte as coordenadas cartesianas em coordenadas User Space
		return (this.getX() * Consts.tamC) + Consts.ajuste;
	}
	
	public int cnvrtCooY()
	{ //converte as coordenadas cartesianas em coordenadas User Space
		return (this.getY() * Consts.tamC) + Consts.ajuste;
	}
	
	//<!> A PARTIR DAQUI RESIDEM AS FUNCOES ABSTRATAS <!>

	/**
	 * 	Retorna o path correto para
	 *  a imagem da respectiva peca.
	 */

	abstract public String imgPeca();

	/**
	 *	Teste para saber se o click do mouse
	 *	retorna a peca correta.
	 */

	abstract public String nome();

	/**
	 * 	<!> Importante <!>
	 *  AtualizaMoves nao eh chama na construcao
	 *  do objeto Peca. AllMoves deve ser chamada
	 *  quando o tabuleiro estiver cheio de pecas,
	 *  assim a funcao poderah lidar com o conflito
	 *  de pecas.
	 */

	public abstract void AtualizaMoves(Tabuleiro tab);
}