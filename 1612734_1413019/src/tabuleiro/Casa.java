package tabuleiro;

import vetor.Vet;
import pecas.*;

public class Casa {

	private Vet v;
	private Peca peca;
	private boolean casaOcupada = false;
	
	/**
	 * 
	 *	Construtor Casa
	 * 
	 * */
	public Casa(final int x, final int y, Peca p)
	{
		this.v = new Vet(x,y);
		peca = p;
		if(p!=null)
		{
			casaOcupada = true;
		}
	}
	/**
	 * 
	 *  Getters e Setters Casa
	 * 
	 * */
	public int getX(Casa c)
	{
		return c.v.getX();
	}
	
	public int getY(Casa c) 
	{
		return c.v.getY();
	}
	
	/**
	 * 
	 *   Retorna uma peça dada uma casa do tabuleiro
	 *   
	 *   AE: Casa c
	 *   AS: Peça posicionada na casa
	 *   	 ou null se casa estiver vazia
	 * 
	 * */
	public Peca getPecaNaCasa(Casa c)
	{
		if(casaOcupada == true)
		{
			return c.peca;
		}
		else
		{
			System.out.println("Casa Vazia");
			return null;
		}
	}
	
	/**
	 * 
	 *  (Essa função pode mudar de classe)
	 * 	Posiciona Peça na casa 
	 *  caso a casa esteja vazia
	 *  
	 *  AE: Casa c que se deseja posicionar a peça
	 *  	Peça p que se deseja movimentar
	 * 
	 * */
	public void posicionaPeca (Casa c_destino, Casa c_origem, Peca p)
	{
		if(c_destino.casaOcupada == false)
		{
			c_destino.peca = p; // Move peça p para a casa destino
			/*p.v*/
			c_destino.casaOcupada = true; // Casa destino passa estar ocupada
			c_origem.peca = null; // Casa origem não possui mais peça
			c_origem.casaOcupada = false; // Casa origem agora está vazia
		}
		else
		{
			System.out.println("Casa ocupada! Tente posicionar peça em uma casa válida vazia!");
		}
	}
	
	public void printCasa(Casa c)
	{
		if(c.casaOcupada = false)
		{
			System.out.print("-");
		}
	}
}
