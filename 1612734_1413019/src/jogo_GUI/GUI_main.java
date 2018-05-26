package jogo_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JApplet;
import javax.swing.JFrame;

import tabuleiro.Consts;

public class GUI_main extends JApplet 
{
	private static final long serialVersionUID = 9113343285574283276L; // Ignora isso
	
	private final int tam = 100;
	
	public void paint(Graphics g) 
	{
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setPaint(Color.black);
	   
	    int i;
	    
	    int x = 0;
	    int y = 100;
	    
	    for(i = Consts.xyIni ; i < Consts.xyFin ; i++)
	    {
	    	g2.draw(new Rectangle2D.Double(x, y*0, tam, tam));
		    x = x + tam;
		    g2.fill(new Rectangle2D.Double(x, y*0, tam, tam));
		    x = x + tam;
	    }
	    x = 0;
	    for(i = Consts.xyIni ; i < Consts.xyFin ; i++)
	    {	
	    	g2.fill(new Rectangle2D.Double(x, y*1, tam, tam));
		    x = x + tam;
		    g2.draw(new Rectangle2D.Double(x, y*1, tam, tam));
		    x = x + tam;
	    }
	    x = 0;
	    for(i = Consts.xyIni ; i < Consts.xyFin ; i++)
	    {
	    	g2.draw(new Rectangle2D.Double(x, y*2, tam, tam));
		    x = x + tam;
		    g2.fill(new Rectangle2D.Double(x, y*2, tam, tam));
		    x = x + tam;
	    }
	    x = 0;
	    for(i = Consts.xyIni ; i < Consts.xyFin ; i++)
	    {	
	    	g2.fill(new Rectangle2D.Double(x, y*3, tam, tam));
		    x = x + tam;
		    g2.draw(new Rectangle2D.Double(x, y*3, tam, tam));
		    x = x + tam;
	    }
	    x = 0;
	    for(i = Consts.xyIni ; i < Consts.xyFin ; i++)
	    {
	    	g2.draw(new Rectangle2D.Double(x, y*4, tam, tam));
		    x = x + tam;
		    g2.fill(new Rectangle2D.Double(x, y*4, tam, tam));
		    x = x + tam;
	    }
	    x = 0;
	    for(i = Consts.xyIni ; i < Consts.xyFin ; i++)
	    {	
	    	g2.fill(new Rectangle2D.Double(x, y*5, tam, tam));
		    x = x + tam;
		    g2.draw(new Rectangle2D.Double(x, y*5, tam, tam));
		    x = x + tam;
	    }
	    x = 0;
	    for(i = Consts.xyIni ; i < Consts.xyFin ; i++)
	    {
	    	g2.draw(new Rectangle2D.Double(x, y*6, tam, tam));
		    x = x + tam;
		    g2.fill(new Rectangle2D.Double(x, y*6, tam, tam));
		    x = x + tam;
	    }
	    x = 0;
	    for(i = Consts.xyIni ; i < Consts.xyFin ; i++)
	    {	
	    	g2.fill(new Rectangle2D.Double(x, y*7, tam, tam));
		    x = x + tam;
		    g2.draw(new Rectangle2D.Double(x, y*7, tam, tam));
		    x = x + tam;
	    }
	    x = 0;
	            
	}

	public void inicializaGUI() {
	    
		JFrame f = new JFrame("Xadrez");
	    JApplet applet = new GUI_main();
	    f.getContentPane().add("Center", applet);
	    f.pack();
	    f.setSize(new Dimension(816, 839)); // Define tamanho da janela (816px , 839px)
	    f.setLocationRelativeTo(null); // Inicializa janela no meio da tela
	    f.setLayout(null); // Gerenciador de Layout: null
	    f.setResizable(false); // Set janela não redimencionável
	    f.setVisible(true);
	}
}
