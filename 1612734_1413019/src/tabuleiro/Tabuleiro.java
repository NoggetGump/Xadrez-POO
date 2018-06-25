package tabuleiro;

import pecas.*;
import vetor.Vet;

import java.io.File;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;

import jogo_Main.Facade;
import jogo_Main.Observador;


public class Tabuleiro 
implements Observavel
{
	private static Tabuleiro tabuleiro = null;
	private ArrayList<Casa> tab = new ArrayList<>();
	private ArrayList<Peca> pecas = new ArrayList<>();
	private Rei ReiB;
	private Rei ReiP;
	private ArrayList<Observador> observadores = new ArrayList<>();

	/**
	 * 
	 *	Adiciona uma peca a uma casa
	 * 
	 * */
	
	public void addPeca(Peca p)
	{
		int indice = 8*p.getY() + p.getX();
		pecas.add(p);
		tab.get(indice).setPeca(p);
		tab.get(indice).toogleO();
	}

	private Function<Vet, Peca> addInicial = vet ->
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
				temp = new Rainha(vet, 'p');
				pecas.add(temp);
			}
			if(i==4)
			{
				temp = new Rei(vet, 'p');
				pecas.add(temp);
				ReiP = (Rei) temp;
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
				temp = new Rainha(vet, 'b');
				pecas.add(temp);
			}
			if(i==4)
			{
				temp = new Rei(vet, 'b');
				pecas.add(temp);
				ReiB = (Rei) temp;
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

	private Tabuleiro(boolean n)
	{
		for(int j = 0 ; j <= Consts.xyFin; j++)
			for(int i = 0 ; i <= Consts.xyFin; i++)
				tab.add(new Casa(i, j, addInicial.apply(new Vet(i, j))));
	}

	private Tabuleiro()
	{}

	public void addObs(Observador obs)
	{
		observadores.add(obs);
	}
	/**
	 * 
	 *	Atualiza a construcao do Tabuleiro,
	 *	a atualizacao dos movimentos das
	 *	Pecas.
	 * 
	 * */

	public void AtualizaMovPecas()
	{
		for(Peca peca : pecas)
			peca.AtualizaMoves(this);
	}

	/**
	 * 
	 *	Geters
	 * 
	 * */

	public static Tabuleiro getTabuleiro(boolean i)
	{
		if(tabuleiro == null && i)
			tabuleiro = new Tabuleiro(true);
		else
			if(tabuleiro == null)
				tabuleiro = new Tabuleiro();

		return tabuleiro;
	}

	public ArrayList<Peca> getPecas()
	{
		return pecas;
	}

	public Peca getPeca(Vet v)
	{
		int indice = v.getY()* (Consts.xyFin + 1) + v.getX();

		return tab.get(indice).getPeca();
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
	 			System.out.println(peca.nome());
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
		if(perguntaCasaPeca(destino))
		{
		int indiceO = origem.getY()*8 + origem.getX(); // indice do ArrayList de casas (tab)
		int indiceD = destino.getY()*8 + destino.getX();
			if(tab.get(indiceO).getPeca().getCor() != tab.get(indiceD).getPeca().getCor())
				return true;
		}

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

	public int xeque(Peca selecionada)
	{
		if(selecionada.corP())
		{
			for(Peca peca : pecas)
				if(!peca.corP()
				&& peca.checaXeque(ReiP))
				{
					System.out.println("Movimento Ilegal, seu Rei está em cheque!");
					return Consts.movIlegal;
				}
				else
					if(peca.corP()
					&& peca.checaXeque(ReiB))
					{
						System.out.println("Pecas Brancas em Xeque");
						return Consts.xeque;
					}
		}
		else
			for(Peca peca : pecas)
				if(peca.corP()
				&& peca.checaXeque(ReiB))
				{
					System.out.println("Movimento Ilegal, seu Rei está em cheque!");
					return Consts.movIlegal;
				}
				else
					if(!peca.corP()
					&& peca.checaXeque(ReiP))
					{
						System.out.println("Pecas Pretas em Xeque");
						return Consts.xeque;
					}

		return Consts.movLegal;
	}

	/**
	 * 
	 * 	Posiciona Peca na casa
	 *  caso o movimento seja valido
	 * @return 
	 *
	 * */

	public boolean movePeca (Peca selecionada, int x, int y, Facade facade)
	{
		int xOriginal = selecionada.getX();
		int yOriginal = selecionada.getY();

		if(selecionada.movimentoValido(x, y))
			{
				int indiceDestino = (Consts.xyFin + 1)*y + x;
				int indiceOrigem = (Consts.xyFin + 1)*yOriginal + xOriginal;

				selecionada.setV(x, y);
				tab.get(indiceDestino).toogleO();
				tab.get(indiceDestino).setPeca(selecionada);
				tab.get(indiceOrigem).toogleO();
				tab.get(indiceOrigem).setPeca(null);
				this.AtualizaMovPecas();
				if(xeque(selecionada) == Consts.movIlegal)
				{
					selecionada.setV(xOriginal, yOriginal);
					tab.get(indiceDestino).toogleO();
					tab.get(indiceDestino).setPeca(null);
					tab.get(indiceOrigem).toogleO();
					tab.get(indiceOrigem).setPeca(selecionada);
					this.AtualizaMovPecas();
					System.out.println("\tMovimento ilegal! Selecione outra peca");

					return false;
				}
				System.out.println("\tVocÃª moveu " + selecionada.nome() + " para a casa ( " + x + " , " + y + " )");
				facade.promocao(selecionada);
				notifyTds();
				
				return true;
			}
		
		return false;
	}

	/**
	 * 
	 * 	Come Peca caso seja possivel
	 * @return 
	 * 
	 * */

	public boolean comePeca(Peca selecionada, Peca alvo, Facade facade)
	{
		int xOriginal = selecionada.getX();
		int yOriginal = selecionada.getY();
		int xAlvo = alvo.getX();
		int yAlvo = alvo.getY();

		if(selecionada.comidaValida(xAlvo, yAlvo))
		{
			int indiceOrigem = (Consts.xyFin + 1)*yOriginal + xOriginal;
			int indiceDestino = (Consts.xyFin + 1)*yAlvo + xAlvo;

			selecionada.setV(xAlvo, yAlvo);
			pecas.remove(alvo);
			tab.get(indiceDestino).setPeca(selecionada);
			tab.get(indiceOrigem).toogleO();
			tab.get(indiceOrigem).setPeca(null);
			this.AtualizaMovPecas();
			if(xeque(selecionada) == Consts.movIlegal)
			{
				selecionada.setV(xOriginal, yOriginal);
				pecas.add(alvo);
				tab.get(indiceDestino).setPeca(alvo);
				tab.get(indiceOrigem).toogleO();
				tab.get(indiceOrigem).setPeca(selecionada);
				this.AtualizaMovPecas();
				System.out.println("Movimento ilegal");

				return false;
			}
			System.out.println("\tVoce comeu o(a) " + alvo.nome() + " inimigo(a)!");
			alvo = null;
			notifyTds();
			facade.promocao(selecionada);
			notifyTds();
			
			return true;
		}
		else
			if(selecionada instanceof Rei)
			{
				this.roque(selecionada, alvo);
				notifyTds();
				return true;
			}
		
		return false;
	}

	public void roque(Peca rei, Peca torre)
	{
		if(rei.movimentoValido(torre.getX(), torre.getY()))
		{
			Vet addRei = new Vet(0, 0);
			Vet addTorre = new Vet(0, 0);
			int assist = ((Torre)torre).roqueAssist(addRei, addTorre);
			if(assist != Consts.movIlegal)
			{
				int indiceOrigemRei = (Consts.xyFin + 1)*rei.getY() + rei.getX();
				int indiceOrigemTorre = (Consts.xyFin + 1)*torre.getY() + torre.getX();
				int indiceDestinoRei = (Consts.xyFin + 1)*rei.getY() + rei.getX() + addRei.getX();
				int indiceDestinoTorre = (Consts.xyFin + 1)*rei.getY() + torre.getX() + addTorre.getX();

				tab.get(indiceOrigemRei).toogleO();
				tab.get(indiceOrigemTorre).toogleO();
				tab.get(indiceDestinoRei).toogleO();
				tab.get(indiceDestinoTorre).toogleO();
				tab.get(indiceDestinoRei).setPeca(rei);
				tab.get(indiceDestinoTorre).setPeca(torre);
				tab.get(indiceOrigemRei).setPeca(null);
				tab.get(indiceOrigemTorre).setPeca(null);
				rei.atualizaPos(addRei);
				torre.atualizaPos(addTorre);
				notifyTds();
			}
		}
	}

	public void promovida(Peca peao, Peca promo)
	{
		int indice = (Consts.xyFin + 1)*peao.getY() + peao.getX();

		pecas.remove(peao);
		tab.get(indice).setPeca(promo);
		pecas.add(promo);
		notifyTds();
	}

	public void notifyTds()
	{
		for(Observador obs : observadores)
			obs.notifyObs();
	}
}