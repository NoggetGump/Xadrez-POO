package jogo_GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFileChooser;

import tabuleiro.*;
import vetor.Vet;
import pecas.*;

public class GUI_main extends JComponent{

	GUI_janela j;
	GUI_OptionPane op = new GUI_OptionPane();
	JFileChooser fc = new JFileChooser();
	Arquivo f = new Arquivo();
	private static final int tamY = 2 * Consts.tamC;
	private static final int tamTab = 8 * Consts.tamC;
	private static Tabuleiro tab;
	private static Peca p = null;
	
	public GUI_janela getJanela()
	{
		return j;
	}

	private void paintPecas(Graphics2D g2)
	{
		for(Peca peca : tab.getPecas())
		{
				g2.drawImage(Toolkit.getDefaultToolkit().getImage(peca.imgPeca()), peca.cnvrtCooX(), peca.cnvrtCooY(), this);
			    g2.finalize();
		}
	}

    private void highlightPeca(Graphics2D g2)
    {
    	if(p!=null)
    	{
	    	g2.setColor(new Color(255, 255, 0, 80));
	    	g2.draw(new Rectangle2D.Double(p.getX() * Consts.tamC, p.getY() * Consts.tamC, Consts.tamC, Consts.tamC));
			g2.fill(new Rectangle2D.Double(p.getX() * Consts.tamC, p.getY() * Consts.tamC, Consts.tamC, Consts.tamC));
			g2.setColor(new Color(0, 125, 125, 125));
			for(Vet move : p.getAllMoves())
			{
				g2.draw(new Rectangle2D.Double(move.getX() * Consts.tamC, move.getY() * Consts.tamC, Consts.tamC, Consts.tamC));
				g2.fill(new Rectangle2D.Double(move.getX() * Consts.tamC, move.getY() * Consts.tamC, Consts.tamC, Consts.tamC));
			}
			g2.setColor(new Color(125, 0, 0, 125));
			for(Vet come : p.getComiveis())
			{
				g2.draw(new Rectangle2D.Double(come.getX() * Consts.tamC, come.getY() * Consts.tamC, Consts.tamC, Consts.tamC));
				g2.fill(new Rectangle2D.Double(come.getX() * Consts.tamC, come.getY() * Consts.tamC, Consts.tamC, Consts.tamC));
			}
		    g2.finalize();
    	}
    }

    @Override
    public void paint(Graphics g)
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
	    paintPecas(g2);
	    highlightPeca(g2);
	}

    public void inicializaTabuleiro(Tabuleiro tab)
	{
		GUI_main.tab = tab;
		j = new GUI_janela(this, tab);
	}
    
    /**
     * 
     * 	Inicializa jogo com JOptionPane
     * 	Para carregar jogo salvo
     * 	ou Iniciar novo jogo
     * 
     * */
	public void inicializaJogo(Tabuleiro tab)
	{
		switch(op.loadGame())
		{
			case 0: // Load Game
			{
				fc.setCurrentDirectory(new java.io.File("saves"));
				fc.setDialogTitle("Carregar jogo - ESCOLHA O ARQUIVO DE SALVAMENTO");
				
				int returnval = fc.showOpenDialog(getParent());
				if(returnval == JFileChooser.APPROVE_OPTION)
				{
				    tab.clear();
					tab.carregaPartida(fc.getSelectedFile() + "");
					
					GUI_main.tab = tab;
					j = new GUI_janela(this, tab);
					
				}
				else
				{
					System.out.println("Carregamento de jogo cancelado pelo usuário");
					this.inicializaJogo(tab);
				}
				
				break;
			}
			case 1: // New Game
			{
				inicializaTabuleiro(tab);
				
				break;
			}
			default: // Close app
			{
				System.out.println("Aplicação Encerrada!");
				
				break;
			}
		}
		
	}

	public void selecPeca(Peca p)
	{
		System.out.println("\tVocê selecionou " + p.nome());
		tab.AtualizaMovPeca(p);
		GUI_main.p = p;
		repaint();
	}

	public boolean movPeca(Peca selecionada, int x, int y)
	{
		if(tab.movePeca(selecionada, x, y))
		{
			GUI_main.p = null;
			repaint();
			System.out.println("\tVocê moveu " + selecionada.nome() + " para a casa ( " + x + " , " + y + " )");
			tab.promocao(selecionada, this);
			return true;
		}
		System.out.println("\tMovimento ilegal! Selecione outra peça");
		GUI_main.p = null;
		repaint();		// Se movimento for ilegal os movimentos possiveis são apagados e a peca é deselecionada

		return false;
	}

	public boolean comePecaOuRoque(Peca selecionada, Peca alvo)
	{
		if(tab.comePeca(selecionada, alvo))
		{
			System.out.println("\tVocê comeu o(a) " + alvo.nome() + " inimigo(a)!");
			GUI_main.p = null;
			repaint();
			tab.promocao(selecionada, this);

			return true;
		}
		else
			if(selecionada instanceof Rei
			&& tab.roque(selecionada, alvo))
			{
				GUI_main.p = null;
				repaint();
				return true;
			}

		System.out.println("Movimento ilegal");
		repaint();

		return false;
	}
	
	public void msgXequeMate()
	{
		op.gameOver('p');
		
	}
}
