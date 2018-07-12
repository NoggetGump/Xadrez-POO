package tabuleiro;

import pecas.*;
import vetor.Vet;
import vetor.VetUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import jogo_Main.Facade;
import jogo_Main.Observador;


public class Tabuleiro
implements Observavel
{
	private static Tabuleiro tabuleiro = null;
	private ArrayList<Casa> tab = new ArrayList<>(64);
	private ArrayList<Peca> pecas = new ArrayList<>(32);
	private ArrayList<Peca> pecasB = new ArrayList<>(15);
	private ArrayList<Peca> pecasP = new ArrayList<>(15);
	private Rei ReiB = null;
	private Rei ReiP = null;
	private ArrayList<Observador> observadores = new ArrayList<>();

	/**
	 *	Adiciona uma peca a uma casa
	 * */
	public void addPeca(Peca p)
	{
		int indice = geraIndice(p.getX(), p.getY());
		pecas.add(p);
		tab.get(indice).setPeca(p);
		tab.get(indice).toogleO();
		if(p.corP())
			pecasP.add(p);
		else
			pecasB.add(p);
		if(p instanceof Rei)
			if(p.corP())
				ReiP = (Rei)p;
			else
				ReiB = (Rei)p;
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
				pecasP.add(temp);
			}
			if(i==1||i==6)
			{
				temp = new Cavalo(vet, 'p');
				pecas.add(temp);
				pecasP.add(temp);
			}
			if(i==2||i==5)
			{
				temp = new Bispo(vet, 'p');
				pecas.add(temp);
				pecasP.add(temp);
			}
			if(i==3)
			{
				temp = new Rainha(vet, 'p');
				pecas.add(temp);
				pecasP.add(temp);
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
			pecasP.add(temp);
			break;

		//pecas brancas
		case 6:
			temp = new Peao(vet, 'b');
			pecas.add(temp);
			pecasB.add(temp);
			break;
		case 7:
			if(i==0||i==7)
			{
				temp = new Torre(vet, 'b');
				pecas.add(temp);
				pecasB.add(temp);
			}
			if(i==1||i==6)
			{
				temp = new Cavalo(vet, 'b');
				pecas.add(temp);
				pecasB.add(temp);
			}
			if(i==2||i==5)
			{
				temp = new Bispo(vet, 'b');
				pecas.add(temp);
				pecasB.add(temp);
			}
			if(i==3)
			{
				temp = new Rainha(vet, 'b');
				pecas.add(temp);
				pecasB.add(temp);
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
	private Tabuleiro(boolean newGame)
	{
		if(newGame)
		{
			for(int j = 0 ; j <= Consts.xyFin; j++)
				for(int i = 0 ; i <= Consts.xyFin; i++)
					tab.add(new Casa(i, j, addInicial.apply(new Vet(i, j))));
			AtualizaMovPecas();
		}
		else
			for(int j = 0 ; j <= Consts.xyFin; j++)
				for(int i = 0 ; i <= Consts.xyFin; i++)
					tab.add(new Casa(i, j, null));
	}

	public void addObs(Observador obs)
	{
		observadores.add(obs);
	}

	/**
	 * Reseta o tabuleiro.
	 */
	public void resetaJogo(boolean newGame)
	{
		tab.clear();
		pecas.clear();
		notifyTds();
		ReiB = null;
		ReiP = null;
		if(newGame)
		{
			for(int j = 0 ; j <= Consts.xyFin; j++)
				for(int i = 0 ; i <= Consts.xyFin; i++)
					tab.add(new Casa(i, j, addInicial.apply(new Vet(i, j))));
			AtualizaMovPecas();
		}
		else
			for(int j = 0 ; j <= Consts.xyFin; j++)
				for(int i = 0 ; i <= Consts.xyFin; i++)
					tab.add(new Casa(i, j, null));
	}

	/**
	 *	Atualiza os movimentos das pecas.
	 * */
	public void AtualizaMovPecas()
	{
		for(Peca peca : pecas)
			peca.AtualizaMoves(this);
	}

	/**
	 * Funcao que gera um indice de casa
	 * dadas as coordenadas (x, y).
	 * */
	public static int geraIndice(int x, int y)
	{
		int indice = y* (Consts.xyFin + 1) + x;

		return indice;
	}

	/**
	 * Funcao que gera um indice de casa
	 * dado um Vet.
	 * */
	public static int geraIndice(Vet v)
	{
		int indice = v.getY()* (Consts.xyFin + 1) + v.getX();
		
		return indice;
	}

	/**
	 *	Pergunta se a casa na localizacao (x, y) esta ocupada.
	 * */
	public boolean perguntaCasaPeca(int x, int y)
	{
		int indice = geraIndice(x, y); // indice do ArrayList de casas (tab)

		if(tab.get(indice).getO())
				return true;

	 	return false;
	}

	/**
	 *	Pergunta se a casa na localizacao Vet(x, y) esta ocupada.
	 * */
	public boolean perguntaCasaPeca(Vet v)
	{
		int indice = geraIndice(v); // indice do ArrayList de casas (tab)

		if(tab.get(indice).getO())
				return true;

	 	return false;
	}

	/**
	 *	Pergunta se a casa na localizacao (indice) esta ocupada.
	 * */
	public boolean perguntaCasaPeca(int indice)
	{
		if(tab.get(indice).getO())
				return true;

	 	return false;
	}

	/**
	 *	Pergunta se duas pecas nas localizacoes (Vet a) e (Vet b) tem a mesma cor.
	 * */
	
	public boolean mesmaCor(Vet a, Vet b)
	{
		int indiceA = geraIndice(a);
		int indiceB = geraIndice(b);

		if(tab.get(indiceA).getPeca().getCor() == tab.get(indiceB).getPeca().getCor())
			return true;
					
		return false;
	}
	
	/**
	 *	Pergunta se duas pecas nas localizacoes (Vet a) e (Vet b) tem a mesma cor.
	 * */
	
	public boolean mesmaCor(Peca a, Peca b)
	{
		if(a.getCor() == b.getCor())
			return true;
					
		return false;
	}
	
	/**
	 *	Pergunta se a casa destino eh comivel por uma peca da casa origem.
	 * */

	public boolean perguntaComivel(Vet origem, Vet destino)
	{
		if(perguntaCasaPeca(destino))
		{
			if(!mesmaCor(origem, destino))
				return true;
		}

	 	return false;
	}

	/**
	 *	Geters
	 * */

	public static Tabuleiro getTabuleiro(boolean newGame)
	{
		if(tabuleiro == null)
			tabuleiro = new Tabuleiro(newGame);

		return tabuleiro;
	}

	public List<Peca> getPecas()
	{
		return Collections.unmodifiableList(pecas);
	}

	public Peca getPeca(int indice)
	{
		if(perguntaCasaPeca(indice))
			return tab.get(indice).getPeca();
		
		return null;
	}

    public Consumer<Casa> printCasas = (c) ->
    { //para testar se os movimentos possiveis estavam sendo inicializados corretamente
        System.out.print("(" +c.getX() + "," + c.getY() + ")" + "\t");
    };

	/**
	 * Printer das Casas em Tab DEBUG ONLY!
	 * */
	public void printTab()
	{
		this.tab.forEach(printCasas);
	}
	
	/**
	 * Facilita a concepção do método MovPoss
	 */
	private boolean reiMovPossAssist(Peca ReiX, Vet move)
	{
		for(Peca peca : pecas)
			if(!mesmaCor(ReiX,  peca)
			&& peca.movimentoValido(move.getX(),move.getY()))
				return false;
		
		return true;
	}

	/**
	 * Checa se o rei tem movimentos possiveis;
	 * Retorna true em caso positivo.
	 */
	private boolean reiMovPoss(Peca ReiX)
	{
		List<Vet> reiMoves = ReiX.getAllMoves();

		if(!reiMoves.isEmpty())
			for(Vet move : reiMoves)
				if(reiMovPossAssist(ReiX, move))
					return true;

		return false;
	}

	/**
	 * Checa se o rei pode comer a peça atacante
	 */
	private boolean reiTomadaPoss(Peca ReiX, Peca comivel)
	{
		int xOriginal = ReiX.getX();
		int yOriginal = ReiX.getY();
		int xAlvo = comivel.getX();
		int yAlvo = comivel.getY();
		int indiceOrigem = geraIndice(xOriginal, yOriginal);
		int indiceDestino = geraIndice(xAlvo, yAlvo);
		boolean ret = true;

		ReiX.setV(xAlvo, yAlvo);
		pecas.remove(comivel);
		tab.get(indiceDestino).setPeca(ReiX);
		tab.get(indiceOrigem).toogleO();
		tab.get(indiceOrigem).setPeca(null);
		this.AtualizaMovPecas();

		if(ReiX.corP())
		{
			for(Peca peca : pecasB)
				if(peca.checaCheque(new Vet(ReiX.getX(), ReiX.getY())))
					ret = false;
		}
		else
		{
			for(Peca peca : pecasP)
				if(peca.checaCheque(new Vet(ReiX.getX(), ReiX.getY())))
					ret = false;
		}
		
		ReiX.setV(xOriginal, yOriginal);
		pecas.add(comivel);
		tab.get(indiceDestino).setPeca(comivel);
		tab.get(indiceOrigem).toogleO();
		tab.get(indiceOrigem).setPeca(ReiX);
		this.AtualizaMovPecas();

		return ret;
	}

	/**
	 * Facilita a concepção do método "interceptaAtacante".
	 * */
	private boolean interceptaAtacanteAssist(Peca atacante, Peca defensora, Peca rei)
	{
		if(defensora instanceof Rei)
		{
			if(defensora.comidaValida(atacante.getX(), atacante.getY()))
				if(reiTomadaPoss(defensora, atacante))
					return true;
		}
		else
			for(Vet comivel : defensora.getComiveis())
				if(comivel.getX() == atacante.getX() && comivel.getY() == atacante.getY())
					return true;

		if(atacante instanceof Peao
		|| atacante instanceof Cavalo
		|| atacante instanceof Rei
		|| defensora instanceof Rei
		|| defensora.getAllMoves().isEmpty())
			return false;

		if(atacante.getX() == rei.getX())
		{
			if(atacante.getY() > rei.getY())
			{
				for(Vet movDefesa : defensora.getAllMoves())
				{
					if(movDefesa.getX() == atacante.getX()
					&& movDefesa.getY() > rei.getY()
					&& movDefesa.getY() < atacante.getY())
						return true;
				}
			}
			else
			{
				for(Vet movDefesa : defensora.getAllMoves())
				{
					if(movDefesa.getX() == atacante.getX()
					&& movDefesa.getY() < rei.getY()
					&& movDefesa.getY() > atacante.getY())
						return true;
				}
			}
		}
		else if(atacante.getX() > rei.getX())
		{
			if(atacante.getY() == rei.getY())
			{
				for(Vet movDefesa : defensora.getAllMoves())
				{
					if(movDefesa.getY() == atacante.getY()
					&& movDefesa.getX() > rei.getX()
					&& movDefesa.getX() < atacante.getX())
						return true;
				}
			}
			else if( atacante.getY() > rei.getY())
			{
				Vet temp = new Vet(rei.getX(), rei.getY());
				VetUtil.movePP(temp);
				for(Vet movDefesa : defensora.getAllMoves())
				{
					while(temp.getX()!= atacante.getX())
					{
						if(movDefesa.getX() == temp.getX()
						&& movDefesa.getY() == temp.getY())
							return true;
						VetUtil.movePP(temp);
					}
					temp.set(rei.getX(), rei.getY());
					VetUtil.movePP(temp);
				}
			}
			else
			{
				Vet temp = new Vet(rei.getX(), rei.getY());
				VetUtil.movePN(temp);
				for(Vet movDefesa : defensora.getAllMoves())
				{
					while(temp.getX()!= atacante.getX())
					{
						if(movDefesa.getX() == temp.getX()
						&& movDefesa.getY() == temp.getY())
							return true;
						VetUtil.movePN(temp);
					}
					temp.set(rei.getX(), rei.getY());
					VetUtil.movePN(temp);
				}
			}
		}
		else
		{
			if(atacante.getY() == rei.getY())
			{
				for(Vet moveDefesa : defensora.getAllMoves())
				{
					if(moveDefesa.getY() == atacante.getY()
					&& moveDefesa.getX() < rei.getX()
					&& moveDefesa.getX() > atacante.getX())
						return true;
				}
			}
			else if( atacante.getY() > rei.getY())
			{
				Vet temp = new Vet(rei.getX(), rei.getY());
				VetUtil.moveNP(temp);
				for(Vet movDefesa : defensora.getAllMoves())
				{
					while(temp.getX()!= atacante.getX())
					{
						if(movDefesa.getX() == temp.getX()
						&& movDefesa.getY() == temp.getY())
							return true;
						VetUtil.moveNP(temp);
					}
					temp.set(rei.getX(), rei.getY());
					VetUtil.moveNP(temp);
				}
			}
			else
			{
				Vet temp = new Vet(rei.getX(), rei.getY());
				VetUtil.moveNN(temp);
				for(Vet movDefesa : defensora.getAllMoves())
				{
					while(temp.getX()!= atacante.getX())
					{
						if(movDefesa.getX() == temp.getX()
						&& movDefesa.getY() == temp.getY())
							return true;
						VetUtil.moveNN(temp);
					}
					temp.set(rei.getX(), rei.getY());
					VetUtil.moveNN(temp);
				}
			}
		}

		return false;
	}
	
	/**
	 * Checa se a peca atacando o rei eh comivel
	 * ou se sua rota até o rei é interceptável. 
	 * */
	private boolean interceptaAtacante(Peca atacante)
	{
		if(atacante.corP())
		{
			for(Peca defensora : pecasB)
				if(interceptaAtacanteAssist(atacante, defensora, ReiB))
					return true;
		}
		else
		{
			for(Peca defensora : pecasP)
				if(interceptaAtacanteAssist(atacante, defensora, ReiP))
					return true;
		}
		return false;
	}

	/**
	 * Cuida da logica do Cheque-Mate,
	 * assim que o rei entra em estado de cheque.
	 * */
	private boolean chequeMate(Peca selecionada, Peca ReiX)
	{
		if(reiMovPoss(ReiX))
			return false;

		if(interceptaAtacante(selecionada))
			return false;

		return true;
	}
	
	/**
	 * Cuida da logica do Cheque a cada movimento ou tomada de Peca.
	 * */
	public int Cheque(Peca selecionada)
	{
		if(selecionada.corP())
		{
			for(Peca peca : pecasB)
				if(peca.checaCheque(new Vet(ReiP.getX(), ReiP.getY())))
				{
					System.out.println("Movimento Ilegal, Rei Preto seria alvo!");
					return Consts.movIlegal;
				}
			for(Peca peca : pecasP)
				if(peca.checaCheque(new Vet(ReiB.getX(), ReiB.getY())))
				{
					if(chequeMate(selecionada, ReiB))
					{
						return Consts.chequeMatePreto;
					}
					System.out.println("Pecas Brancas em Cheque.");
					return Consts.cheque;
				}
		}
		else 
		{
			for(Peca peca : pecasP)
				if(peca.checaCheque(new Vet(ReiB.getX(), ReiB.getY())))
				{
					System.out.println("Movimento Ilegal, Rei Branco seria alvo!");
					return Consts.movIlegal;
				}
			for(Peca peca : pecasB)
				if(peca.checaCheque(new Vet(ReiP.getX(), ReiP.getY())))
				{
					if(chequeMate(selecionada, ReiP))
					{
						return Consts.chequeMateBranco;
					}
					System.out.println("Pecas Pretas em Cheque.");
					return Consts.cheque;
				}
		}

		return Consts.movLegal;
	}

	/**
	 * 	Posiciona Peca na casa caso o movimento seja valido
	 * */

	public boolean movePeca (Peca selecionada, int x, int y, Facade facade)
	{
		int xOriginal = selecionada.getX();
		int yOriginal = selecionada.getY();
		int validadeMov;

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

				validadeMov = Cheque(selecionada);
				if(validadeMov == Consts.movIlegal)
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
				else
				{
					notifyTds();
					if(validadeMov == Consts.chequeMatePreto)
					{
						facade.chequeMate(Consts.preta);
						return false;
					}
					else if(validadeMov == Consts.chequeMateBranco)
					{
						facade.chequeMate(Consts.branca);
						return false;
					}
				}
				if(validadeMov != Consts.cheque
				&& empate())
				{
					facade.chequeMate(Consts.empate);
					return false;
				}

				System.out.println("\tVoce moveu " + selecionada.nome() + " para a casa ( " + x + " , " + y + " )");
				facade.promocao(selecionada);
				notifyTds();

				return true;
			}
		System.out.println("Movimento Ilegal! Selecione outra peca.");
		
		return false;
	}

	/**
	 * 	Come Peca caso seja possivel
	 * */

	public boolean comePeca(Peca selecionada, Peca alvo, Facade facade)
	{
		int xOriginal = selecionada.getX();
		int yOriginal = selecionada.getY();
		int xAlvo = alvo.getX();
		int yAlvo = alvo.getY();
		int validadeMov;

		if(selecionada.comidaValida(xAlvo, yAlvo))
		{
			int indiceOrigem = geraIndice(xOriginal, yOriginal);
			int indiceDestino = geraIndice(xAlvo, yAlvo);

			selecionada.setV(xAlvo, yAlvo);
			pecas.remove(alvo);
			if(alvo.corP())
				pecasP.remove(alvo);
			else
				pecasB.remove(alvo);
			tab.get(indiceDestino).setPeca(selecionada);
			tab.get(indiceOrigem).toogleO();
			tab.get(indiceOrigem).setPeca(null);
			this.AtualizaMovPecas();
			validadeMov = Cheque(selecionada);
			if(validadeMov == Consts.movIlegal)
			{
				selecionada.setV(xOriginal, yOriginal);
				pecas.add(alvo);
				if(alvo.corP())
					pecasP.add(alvo);
				else
					pecasB.add(alvo);
				tab.get(indiceDestino).setPeca(alvo);
				tab.get(indiceOrigem).toogleO();
				tab.get(indiceOrigem).setPeca(selecionada);
				this.AtualizaMovPecas();
				System.out.println("Movimento ilegal");

				return false;
			}
			else 
			{
				notifyTds();
				if(validadeMov == Consts.chequeMatePreto)
				{
					facade.chequeMate(Consts.preta);
					return false;
				}
				else if(validadeMov == Consts.chequeMateBranco)
				{
					facade.chequeMate(Consts.branca);
					return false;
				}
			}
			if(validadeMov != Consts.cheque
			&& empate())
			{
				facade.chequeMate(Consts.empate);
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
				if(this.roque(selecionada, alvo))
				{
					notifyTds();
					return true;
				}
		System.out.println("Movimento Ilegal! Selecione outra peca.");

		return false;
	}
	
	private boolean noMoves(ArrayList<Peca> pecasX)
	{
		for(Peca p : pecasX)
			if(!(p instanceof Rei))
				if(!p.getAllMoves().isEmpty())
					return false;
		
		return true;
	}

	private boolean empate() {
		if(noMoves(pecasB)
		&& !reiMovPoss(ReiB))
			return true;
		else if(noMoves(pecasP)
		&& !reiMovPoss(ReiP))
			return true;
		else 
			if(somaPontos(pecasB))
				return true;
		else
			if(somaPontos(pecasP))
				return true;
			
		return false;
	}

	private boolean somaPontos(ArrayList<Peca> pecasX) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 	Cuida da logica do roque.
	 * */

	public boolean roque(Peca rei, Peca torre)
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
			return true;
		}
		return false;
	}
	
	/**
	 * 	Efetua a promocao.
	 * */

	public void promovida(Peca peao, Peca promo)
	{
		int indice = (Consts.xyFin + 1)*peao.getY() + peao.getX();

		pecas.remove(peao);
		tab.get(indice).setPeca(promo);
		pecas.add(promo);
	}

	public void notifyTds()
	{
		System.out.println("notificacao");
		for(Observador obs : observadores)
			obs.notifyObs();
	}
}