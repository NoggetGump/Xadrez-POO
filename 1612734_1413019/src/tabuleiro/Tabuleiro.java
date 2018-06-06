package tabuleiro;

import pecas.*;
import vetor.Vet;

import java.io.File;
import java.util.ArrayList;
import java.util.function.Function;

public class Tabuleiro 
{
	private ArrayList<Casa> tab = new ArrayList<Casa>();
	private ArrayList<Peca> pecas = new ArrayList<Peca>();
	private Peca pecaSelec;

	/**
	 * 
	 *	Adiciona uma peca a uma casa
	 * 
	 * */

	private Function<Vet, Peca> addPeca = vet ->
	{
		int i = vet.getX();
		int j = vet.getY();
		Peca temp = null;

		switch(j)
		{//pecas pretas
		case 0:
			if(i==0||i==7)
			{
				temp = new Torre(vet, 'p');
				pecas.add(temp);
			}
			if(i==1||i==6)
			{
				temp = new Cavalo(vet, 'p');
				pecas.add(temp);
			}
			if(i==2||i==5)
			{
				temp = new Bispo(vet, 'p');
				pecas.add(temp);
			}
			if(i==3)
			{
				temp = new Rei(vet, 'p');
				pecas.add(temp);
			}
			if(i==4)
			{
				temp = new Rainha(vet, 'p');
				pecas.add(temp);
			}
			break;

		case 1:
			temp = new Peao(vet, 'p');
			pecas.add(temp);
			break;

		//pecas brancas
		case 6:
			temp = new Peao(vet, 'b');
			pecas.add(temp);
			break;

		case 7:
			if(i==0||i==7)
			{
				temp = new Torre(vet, 'b');
				pecas.add(temp);
			}
			if(i==1||i==6)
			{
				temp = new Cavalo(vet, 'b');
				pecas.add(temp);
			}
			if(i==2||i==5)
			{
				temp = new Bispo(vet, 'b');
				pecas.add(temp);
			}
			if(i==3)
			{
				temp = new Rei(vet, 'b');
				pecas.add(temp);
			}
			if(i==4)
			{
				temp = new Rainha(vet, 'b');
				pecas.add(temp);
			}
			break;
		}

		return temp;
	};

	/**
	 * 
	 *	Construtor Tabuleiro
	 * 
	 * */

	public Tabuleiro()
	{
		for(int j = 0 ; j <= Consts.xyFin; j++)
			for(int i = 0 ; i <= Consts.xyFin; i++)
				tab.add(new Casa(i, j, addPeca.apply(new Vet(i, j))));
	}
	
	public Tabuleiro(File x)
	{
	
	}

	/**
	 * 
	 *	Geters
	 * 
	 * */

	public Peca buscaPeca(int x, int y)
	{
	 	for(Peca peca : pecas)
	 	{
	 		if(peca.getX() == x && peca.getY() == y)
	 		{
	 			System.out.println(peca.nomePeca());
	 			return peca;
	 		}
	 	}
	 	System.out.println("Nao ha peca nesta casa");
	 	return null;
	}

	public ArrayList<Peca> getPecas()
	{
		return pecas;
	}

	/**
	 * 
	 * 	Posiciona Peca na casa 
	 *  caso a casa esteja vazia
	 *  
	 *  AE: Casa c que se deseja posicionar a peca
	 *  	Peca p que se deseja movimentar
	 * 
	 * */

	public void movePeca (Casa c_destino, Casa c_origem)
	{
		if(c_destino.getO() == false && c_origem.getO() == true)
		{
			c_origem.getPeca().atualizaVet(c_destino.getVet()); //Atualiza o Vetor da Peca
			c_destino.setPeca(c_origem.getPeca()); // Move Peca para a Casa Destino
			c_origem.setPeca(null); //Retira a Peca da Origem
			c_destino.toogleO(); // Casa Destino passa a estar Ocupada
			c_origem.toogleO(); // Casa Origem agora esta Vazia
		}
		else
		{
			if(c_origem.getO())
				System.out.println("Selecione uma casa com peça");
			else
				System.out.println("Casa Destino ocupada! Tente posicionar peca em uma casa valida vazia!");
		}
	}
}