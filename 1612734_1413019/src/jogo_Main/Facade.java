package jogo_Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.util.List;

import javax.swing.JFileChooser;

import jogo_GUI.GUI_OptionPane;
import jogo_GUI.GUI_PromoMenu;
import jogo_GUI.GUI_main;

import pecas.*;
import tabuleiro.*;
import vetor.Vet;

public class Facade implements Observador{

	private static final int tamY = 2 * Consts.tamC;
	private static final int tamTab = 8 * Consts.tamC;
	private static Tabuleiro tab = null;
	private static GUI_main gm = null;
	private Arquivo arquivo = null;
	private Peca selecionada = null;
	private Integer turno = 1;
	GUI_OptionPane op = new GUI_OptionPane();
	JFileChooser fc = new JFileChooser();

	public Facade()
	{
		inicializaJogo();
	}

	 /**
     * 	Inicializa jogo com JOptionPane para carregar jogo salvo
     * 	ou Iniciar novo jogo.
     * */
	private void newGame()
	{
		tab = Tabuleiro.getTabuleiro(true);
		tab.addObs(this);
		Facade.gm = new GUI_main(this);
		arquivo = new Arquivo(this);
	}

	 /**
     * 	Inicializa jogo com JOptionPane para carregar jogo salvo
     * 	ou Iniciar novo jogo.
     * */
	private void inicializaJogo()
	{
		switch(op.loadGame())
		{
			case 0: // Load Game
			{
				tab = Tabuleiro.getTabuleiro(false);
				tab.addObs(this);
				Facade.gm = new GUI_main(this);
				arquivo = new Arquivo(this);
				fc.setCurrentDirectory(new java.io.File("saves"));
				fc.setDialogTitle("Carregar jogo - ESCOLHA O ARQUIVO DE SALVAMENTO");
				if(fc.showOpenDialog(gm.getJanela().getParent()) == JFileChooser.APPROVE_OPTION)
				{
					arquivo.carregaPartida(fc.getSelectedFile() + "");
					gm.repaint();
					tab.AtualizaMovPecas();
					System.out.println("<< Turno " + turno + ">>");
				}
				else
				{
					System.out.println("Carregamento de jogo cancelado pelo usuario");
					gm.getJanela().dispatchEvent(new WindowEvent(gm.getJanela(), WindowEvent.WINDOW_CLOSING));
				}
				break;
			}
			case 1:
			{
				newGame();
				System.out.println("<< Turno 1 >>");
				break;
			}
			default:
			{
				System.out.println("Aplicacao Encerrada!");
				break;
			}
		}
	}

	/**
	 * Reseta o jogo.
	 */
	private void resetaJogoTab()
	{
		turno = 1;
		arquivo = new Arquivo(this);
		selecionada = null;
		switch(op.loadGame())
		{
			case 0: // Load Game
			{
				tab.resetaJogo(false);
				fc.setCurrentDirectory(new java.io.File("saves"));
				fc.setDialogTitle("Carregar jogo - ESCOLHA O ARQUIVO DE SALVAMENTO");
				if(fc.showOpenDialog(gm.getJanela().getParent()) == JFileChooser.APPROVE_OPTION)
				{
					arquivo.carregaPartida(fc.getSelectedFile() + "");
					tab.AtualizaMovPecas();
				}
				else
				{
					System.out.println("Carregamento de jogo cancelado pelo usuario");
					gm.getJanela().dispatchEvent(new WindowEvent(gm.getJanela(), WindowEvent.WINDOW_CLOSING));
				}
				break;
			}
			case 1:
			{
				tab.resetaJogo(true);
				break;
			}
			default:
			{
				System.out.println("Aplicacao Encerrada!");
				break;
			}
		}
		gm.repaint();
	}

	/**
	 * Geters
	 */
	public GUI_main getGM()
	{
		return gm;
	}

	public Integer getTurno()
	{
		return this.turno;
	}
	
	/**
	 * Seters
	 */
	public void setTurno(Integer turno)
	{
		this.turno = turno;
	}

	/**
	 * Desenha as pecas no tabuleiro.
	 */
	private void paintPecas(Graphics2D g2, ImageObserver io)
	{
		for(Peca peca : tab.getPecas())
		{
				g2.drawImage(Toolkit.getDefaultToolkit().getImage(peca.imgPeca()), peca.cnvrtCooX(), peca.cnvrtCooY(), io);
			    g2.finalize();
		}
	}

	/**
	 * Marca as casas para salientar: peca selecionada do turno
	 * e movimentos possiveis, incluindo movimentos de tomada de peca.
	 */
    private void highlightPeca(Graphics2D g2)
    {
    	if(selecionada!=null)
    	{
	    	g2.setColor(new Color(255, 255, 0, 80));
	    	g2.draw(new Rectangle2D.Double(selecionada.getX() * Consts.tamC, selecionada.getY() * Consts.tamC, Consts.tamC, Consts.tamC));
			g2.fill(new Rectangle2D.Double(selecionada.getX() * Consts.tamC, selecionada.getY() * Consts.tamC, Consts.tamC, Consts.tamC));
			g2.setColor(new Color(0, 125, 125, 125));
			for(Vet move : selecionada.getAllMoves())
			{
				g2.draw(new Rectangle2D.Double(move.getX() * Consts.tamC, move.getY() * Consts.tamC, Consts.tamC, Consts.tamC));
				g2.fill(new Rectangle2D.Double(move.getX() * Consts.tamC, move.getY() * Consts.tamC, Consts.tamC, Consts.tamC));
			}
			g2.setColor(new Color(125, 0, 0, 125));
			for(Vet come : selecionada.getComiveis())
			{
				g2.draw(new Rectangle2D.Double(come.getX() * Consts.tamC, come.getY() * Consts.tamC, Consts.tamC, Consts.tamC));
				g2.fill(new Rectangle2D.Double(come.getX() * Consts.tamC, come.getY() * Consts.tamC, Consts.tamC, Consts.tamC));
			}
		    g2.finalize();
    	}
    }

	/**
	 * Desenha tudo que o jogo contem. Chamada pela GUI_main.
	 */
    public void paintAll(Graphics g, ImageObserver io)
	{
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setPaint(Color.black);
	    int x = 0, y = 0;

	    while(y<tamTab)
	    {
	    	if(y%tamY == 0)
	    	{
		    	g2.draw(new Rectangle2D.Double(x, y, Consts.tamC, Consts.tamC));
		    	x = x + Consts.tamC;
		    	g2.draw(new Rectangle2D.Double(x, y, Consts.tamC, Consts.tamC));
		    	g2.fill(new Rectangle2D.Double(x, y, Consts.tamC, Consts.tamC));
		    	x = x + Consts.tamC;
	    	}
	    	else
	    	{
	    		g2.draw(new Rectangle2D.Double(x, y, Consts.tamC, Consts.tamC));
		    	g2.fill(new Rectangle2D.Double(x, y, Consts.tamC, Consts.tamC));
		    	x = x + Consts.tamC;
		    	g2.draw(new Rectangle2D.Double(x, y, Consts.tamC, Consts.tamC));
		    	x = x + Consts.tamC;
	    	}
	    	if(x == tamTab)
	    	{
	    		y = y + Consts.tamC;
	    		x = 0;
	    	}
	    }
	    paintPecas(g2, io);
	    highlightPeca(g2);
	}

	/**
	 * Chama a possivel movimentacao de pecas no controlador Tabuleiro(observado).
	 */
	public void movPeca(Peca selecionada, int x, int y)
	{
		if(tab.movePeca(selecionada, x, y, this))
		{
			turno++;
			System.out.println("\r\n<< Turno " + turno + " >>\r\n");
		}
		else
		{
			selecionada = null;
			gm.repaint();
		}
	}

	/**
	 * Chama a tomada de peca no controlador Tabuleiro(observado).
	 */
	public void comePecaOuRoque(Peca selecionada, Peca alvo)
	{
		if(tab.comePeca(selecionada, alvo, this))
		{
			turno++;
			System.out.println("\r\n<< Turno " + turno + " >>\r\n");
		}
		else
		{
			selecionada = null;
			gm.repaint();
		}
	}

	/**
	 * Cuida da logica da promocao, e chama a criacao de um menu
	 * com o objetivo do usuario escolher para qual peca o peao sera promovido.
	 */
	public void promocao(Peca peao)
	{
		if(peao instanceof Peao)
		{
			GUI_PromoMenu menu = new GUI_PromoMenu(peao, this);
			if(peao.corP())
			{
				if(peao.getY() == Consts.xyFin)
				{
					menu.addButton("Torre", Consts.torreP.getPath());
					menu.addButton("Cavalo", Consts.cavaloP.getPath());
					menu.addButton("Bispo", Consts.bispoP.getPath());
					menu.addButton("Rainha", Consts.rainhaP.getPath());
					menu.showMenu();
				}
			}
			else
				if(peao.getY() == Consts.xyIni)
				{
					menu.addButton("Torre", Consts.torreB.getPath());
					menu.addButton("Cavalo", Consts.cavaloB.getPath());
					menu.addButton("Bispo", Consts.bispoB.getPath());
					menu.addButton("Rainha", Consts.rainhaB.getPath());
					menu.showMenu();
				}
		}
	}

	/**
	 * Chama a promocao de peao
	 * no controlador Tabuleiro(observado).
	 */
	public void promove(Peca peao, Peca promo)
	{
		tab.promovida(peao, promo);
	}

	/**
	 * Encerra o jogo (Game Over).
	 * Cria um novo jogo, caso o usuario deseje.
	 */
	public void chequeMate(char cor)
	{
		if(GUI_OptionPane.gameOver(cor) == 0)
			resetaJogoTab();
		else
		{
			System.out.println("Aplicacao Encerrada!");
			gm.getJanela().dispatchEvent(new WindowEvent(gm.getJanela(), WindowEvent.WINDOW_CLOSING));
		}
	}

	/**
	 * Cuida da logica da janela assim que a mesma dispara um evento de clique
	 * do botao esquerdo do mouse.
	 */
	public void logicaJanelaE(int x, int y, Peca temp){
		if(temp != selecionada
		&& selecionada != null)
		{
			if(temp == null)
				this.movPeca(selecionada, x, y);
			else
				this.comePecaOuRoque(selecionada, temp);
		selecionada = null;
		}
		else
			if(temp != null
			&& temp.turno(turno)) // Se houver peca na Casa clicada e se o turno do jogador for respeitado
			{
				selecionada = temp;
				System.out.println("\tVoce selecionou " + selecionada.nome());
				gm.repaint();
			}
	}

	/**
	 * Cuida da logica da janela assim que a mesma dispara um evento de clique
	 * do do botao direito do mouse.
	 */
	public void logicaJanelaD()
	{
		System.out.println("Salvar jogo?");
		
		fc.setApproveButtonText("Save");
		fc.setApproveButtonMnemonic('S');
		int returnval = fc.showOpenDialog(gm.getJanela().getParent());
		if(returnval == JFileChooser.APPROVE_OPTION)
		{
			arquivo.salvaPartida(fc.getSelectedFile() + ".txt");
		}
		else
		{
			System.out.println("Salvamento de jogo cancelado pelo usu�rio");
		}
	}

	/**
	 * Funcao do observador, que assim que notificado,
	 * emite o sinal para GUI_main redesenhar o tabuleiro.
	 */
		public void notifyObs()
	{
		gm.repaint();
	}

	/**
	 * Chama getPeca, dada uma coordenada (x, y).
	 * Evita a passagem por referencia do Tabuleiro.
	 */
	public Peca buscaPecaTab(int x, int y)
	{
		return tab.getPeca(Tabuleiro.geraIndice(x, y));
	}

	/**
	 * Chama a addPeca de Tabuleiro, dado um objeto peca ja criado.
	 * Evita a passagem por referencia do Tabuleiro.
	 */
	public void addPecaTab(Peca peca)
	{
		tab.addPeca(peca);
	}

	/**
	 * Chama a addPeca de Tabuleiro, dado um objeto peca ja criado.
	 * Evita a passagem por referencia do Tabuleiro.
	 */
	public List<Peca> getPecasTab()
	{
		return tab.getPecas();
	}
}