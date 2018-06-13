package tabuleiro;

import pecas.*;
import vetor.Vet;

import java.io.File;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;

public class Tabuleiro 
{
	private ArrayList<Casa> tab = new ArrayList<Casa>();
	private ArrayList<Peca> pecas = new ArrayList<Peca>();

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
		this.AtualizaMovPecas();
	}

	public Tabuleiro(File x)
	{

	}

	/**
	 * 
	 *	Após a construcao do Tabuleiro,
	 *	a atualizacao dos movimentos das
	 *	Pecas.
	 * 
	 * */

	public void AtualizaMovPecas()
	{
		for(Peca peca : pecas)
		{
			peca.AtualizaMoves(this);
		}
	}

	/**
	 * 
	 *	Geters
	 * 
	 * */

	public ArrayList<Peca> getPecas()
	{
		return pecas;
	}

	/**
	 * 
	 *	Buscas
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

	/**
	 * 
	 *	Pergunta se a casa na localizacao Vet v
	 *	esta ocupada.
	 * 
	 * */

	public boolean perguntaCasaPeca(Vet v)
	{
		int indice = v.getY()*8 + v.getX(); // indice do ArrayList de casas (tab)
		
		if(tab.get(indice).getO())
				return true;

	 	return false;
	}

	public boolean perguntaComivel(Vet origem, Vet destino)
	{
		int indiceO = origem.getY()*8 + origem.getX(); // indice do ArrayList de casas (tab)
		int indiceD = destino.getY()*8 + destino.getX();

		if(perguntaCasaPeca(destino))
			if(tab.get(indiceO).getPeca().getCor() != tab.get(indiceD).getPeca().getCor())
				return true;

	 	return false;
	}

	/**
	 * 
	 * Printer das Casas em Tab DEBUG ONLY!
	 *
	 * */

    public Consumer<Casa> printCasas = (c) ->
    { //para testar se os movimentos possiveis estavam sendo inicializados corretamente
        System.out.print("(" +c.getX() + "," + c.getY() + ")" + "\t");
    };

	public void printTab()
	{
		this.tab.forEach(printCasas);
	}

	/**
	 * 
	 * 	Posiciona Peca na casa
	 *  caso a casa esteja vazia
	 * 
	 * */

	public boolean movePeca (Peca selecionada, int x, int y)
	{
		if(selecionada.movimentoValido(x, y))
		{
			int indiceDestino = 8*y + x;
			int indiceOrigem = 8*selecionada.getY() + selecionada.getX();

			selecionada.setV(x, y);
			tab.get(indiceDestino).toogleO();
			tab.get(indiceDestino).setPeca(selecionada);
			tab.get(indiceOrigem).toogleO();
			tab.get(indiceOrigem).setPeca(null);
			return true;
		}

		return false;
	}

	/**
	 * 
	 * 	Posiciona Peca na casa
	 *  caso a casa esteja vazia
	 * 
	 * */

	public boolean comePeca(Peca selecionada, Peca comida)
	{
		if(selecionada.comidaValida(comida.getX(), comida.getY()))
		{
			int indiceOrigem = (Consts.xyFin + 1)*selecionada.getY() + selecionada.getX();
			int indiceDestino = (Consts.xyFin + 1)*comida.getY() + comida.getX();

			selecionada.setV(comida.getX(), comida.getY());
			pecas.remove(comida);
			tab.get(indiceDestino).setPeca(selecionada);
			tab.get(indiceOrigem).toogleO();
			tab.get(indiceOrigem).setPeca(null);
			comida = null;

			return true;
		}

		return false;
	}
	
	public boolean promocao(Peca peao)
	{
	if(peao.corP())
	{
		if(peao.getY() == Consts.xyFin)
		{
			pecas.remove(peao);
			pecas.add(movimentos.PromocaoPeao.Promove(peao));
			return true;
		}
	}
	else
	{
		if(peao.getY() == Consts.xyIni)
		{
			pecas.remove(peao);
			pecas.add(movimentos.PromocaoPeao.Promove(peao));
			return true;
		}
	}
	
	return false;
	}
}