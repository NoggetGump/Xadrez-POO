package jogo_Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;

import jogo_GUI.GUI_OptionPane;
import jogo_GUI.GUI_PromoMenu;
import jogo_GUI.GUI_janela;
import jogo_GUI.GUI_main;

import pecas.*;
import tabuleiro.*;
import vetor.Vet;

public class Facade implements Observador{
	private static final int tamY = 2 * Consts.tamC;
	private static final int tamTab = 8 * Consts.tamC;

	private static Tabuleiro tab = null;
	private static GUI_main gm = null;
	private static GUI_janela j = null;
	GUI_OptionPane op = new GUI_OptionPane();
	JFileChooser fc = new JFileChooser();
	private Scanner sc;

	private Peca selecionada = null;
	private int turnos = 1;

	public Facade()
	{
		inicializaJogo();
	}
	  /**
     * 
     * 	Inicializa jogo com JOptionPane
     * 	Para carregar jogo salvo
     * 	ou Iniciar novo jogo
     * 
     * */
	public void inicializaJogo()
	{
		switch(op.loadGame())
		{
			case 0: // Load Game
			{
				Facade.gm = new GUI_main(this); // Inicializa tabuleiro na formcao inicial
				tab = Tabuleiro.getTabuleiro(false);
				j = new GUI_janela(tab, gm, this);
				tab.addObs(this);
				
				fc.setCurrentDirectory(new java.io.File("saves"));
				fc.setDialogTitle("Carregar jogo - ESCOLHA O ARQUIVO DE SALVAMENTO");
				int returnval = fc.showOpenDialog(j.getParent()); // Abre caixa de mensagem

				if(returnval == JFileChooser.APPROVE_OPTION) // Se apertar abrir
				{
					this.carregaPartida(fc.getSelectedFile() + ""); //Chama o metodo carregar partida. Parametro = path do arquivo escolhido
					tab.AtualizaMovPecas(); // Inicializa tabuleiro nas formção inicial	
				}
				else
				{
					System.out.println("Carregamento de jogo cancelado pelo usuário");
					tab.AtualizaMovPecas(); // Inicializa tabuleiro na formção inicial
					;
				}
				break;
			}
			case 1:
			{				Facade.gm = new GUI_main(this); // Inicializa tabuleiro nas formção inicial
				tab = Tabuleiro.getTabuleiro(true);
				j = new GUI_janela(tab, gm, this);
				tab.addObs(this);
				tab.AtualizaMovPecas();

				break;
			}
			default: // Close app - Fecha a caixa de dialogo caso aperte o X da janela
			{
				System.out.println("Aplicação Encerrada!");
				
				break;
			}
		}
	}

	public GUI_janela getJanela()
	{
		return j;
	}

	private void paintPecas(Graphics2D g2, ImageObserver io)
	{
		for(Peca peca : tab.getPecas())
		{
				g2.drawImage(Toolkit.getDefaultToolkit().getImage(peca.imgPeca()), peca.cnvrtCooX(), peca.cnvrtCooY(), io);
			    g2.finalize();
		}
	}

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

	public void movPeca(Peca selecionada, int x, int y)
	{
		if(tab.movePeca(selecionada, x, y, this))
		{
			turnos++;
			System.out.println("\r\n<< Turno " + turnos + " >>\r\n");
		}
	}

	public void comePecaOuRoque(Peca selecionada, Peca alvo)
	{
		if(tab.comePeca(selecionada, alvo, this))
		{
			turnos++;
			System.out.println("\r\n<< Turno " + turnos + " >>\r\n");
		}
	}
	
	public void promocao(Peca peao)
	{
		if(peao instanceof Peao)
		{
			GUI_PromoMenu menu = new GUI_PromoMenu(peao, tab, this);
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
			&& temp.turno(turnos)) // Se houver peca na Casa clicada e se o turno do jogador for respeitado
			{
				selecionada = temp;
				System.out.println("\tVoce selecionou " + selecionada.nome());
				gm.repaint();
			}
	}
	
	
	public void logicaJanelaD()
	{
		System.out.println("Salvar jogo?");
		
		int returnval = fc.showOpenDialog(j.getParent()); // Abre caixa de mensagem se mouse 2 for clicado
		if(returnval == JFileChooser.APPROVE_OPTION) // Se apertar abrir
		{
			Facade.salvaPartida(fc.getSelectedFile() + ".txt"); // salva partida no path escolhido ao apertar abrir
		}
		else // Se não fecha a caixa de mensagem e cancela o salvamento
		{
			System.out.println("Salvamento de jogo cancelado pelo usuário");
		}
	}
	private static void salvaPartida(String arq)
	{
		String texto = ""; // Conteudo que sera escrito no arquivo de salvamento

		for(Peca peca : tab.getPecas())
		{
			texto += peca.printSave() + "\r\n"; // Concatena o conteudo lido a medida que percorre ArrayList pecas
		}
		
        if(writeFile(arq, texto)) // Escreve no arquivo
            System.out.println("Jogo Salvo!");
        else
            System.out.println("Erro ao salvar o arquivo!");
	}
	
	public void carregaPartida(String arq)
	{
		openFile(arq);
		readFile(tab);
	}
	
	/**
	 * 
	 * 	Lê o arquivo e retorna o conteudo
	 * 
	 * */
	public void openFile(String path)
	{
		try {
			sc = new Scanner(new File(path));
			
		}
		catch(Exception e){
			System.out.println("Erro! Arquivo não encontrado!");
		}
	}
	
	public void readFile(Tabuleiro tab)
	{
		
		while(sc.hasNext())
		{	
			Peca temp = null;
			
			String peca = sc.next();
			String c = sc.next();
			char cor = c.charAt(0);
			int x = Integer.parseInt(sc.next());
			int y = Integer.parseInt(sc.next());

			temp = cnvrtPeca(peca, x, y, cor);
			temp.setCor(cor);

		}
		sc.close();
	}
	
	public Peca cnvrtPeca (String nomePeca, int x, int y, char cor)
	{
		Peca temp = null;
		Vet v = new Vet(x, y);
		
		switch(nomePeca)
		{
		case "Bispo":
		{
			temp = new Bispo(v, cor);
			tab.addPeca(temp);
			
			break;
		}
		case "Cavalo":
		{
			temp = new Cavalo(v, cor);
			tab.addPeca(temp);
			
			break;
		}
		case "Peao":
		{
			temp = new Peao(v, cor);
			tab.addPeca(temp);
			
			break;
		}
		case "Rainha":
		{
			temp = new Rainha(v, cor);
			tab.addPeca(temp);
			
			break;
		}
		case "Rei":
		{
			temp = new Rei(v, cor);
			tab.addPeca(temp);
			
			break;
		}
		case "Torre":
		{
			temp = new Torre(v, cor);
			tab.addPeca(temp);
			
			break;
		}
		default:
		{
			break;
		}
		}
		
		System.out.println(temp.nome() + " " + temp.getCor() + " " + temp.getX() + " " + temp.getY()); // printa peca criada
		
		return temp;
}
	
	public static boolean writeFile(String path,String text){
   	
       try {
       	
           FileWriter arq = new FileWriter(path);
           PrintWriter gravarArq = new PrintWriter(arq);
           gravarArq.println(text);
           gravarArq.close();
           return true;
           
       }catch(IOException e){
           System.out.println(e.getMessage());
           return false;
       }
	}

		public void notifyObs()
	{
		gm.repaint();
	}
	
	public Tabuleiro getTab() {
		return tab;
	}
}