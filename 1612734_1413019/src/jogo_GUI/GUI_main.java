package jogo_GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import pecas.*;

public class GUI_main extends JComponent{

	private final int tam = 100;
	private final int tamTab = 8 * tam;
	private static Peca peca;

	public void paintPeca(Peca t, Graphics2D g2) 
	{
	    g2.drawImage(Toolkit.getDefaultToolkit().getImage(t.imgPeca()), t.convCoorX(), t.convCoorY(), this);
	    g2.finalize();
	}

	public void paint(Graphics g)
	{
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setPaint(Color.black);

	    int x = 0, y = 0;
	    
	    while(y<tamTab)
	    {
	    	if(y%200 == 0) 
	    	{
	    	g2.draw(new Rectangle2D.Double(x, y, tam, tam));
	    	x = x + tam;
	    	g2.fill(new Rectangle2D.Double(x, y, tam, tam));
	    	x = x + tam;
	    	}
	    	else
	    	{
		    	g2.fill(new Rectangle2D.Double(x, y, tam, tam));
		    	x = x + tam;
		    	g2.draw(new Rectangle2D.Double(x, y, tam, tam));
		    	x = x + tam;
	    	}
	    	if(x == tamTab)
	    	{
	    		y = y + tam;
	    		x = 0;
	    	}
	    }

	    x = 14;
	    y = 19;

	    paintPeca(peca, g2);
	    //System.out.println("Chega aqui");
	} 
	
	public void inicializaTabuleiro()
	{	
		GUI_janela j = new GUI_janela();
	}
	
	public void inicializaPeca(Peca p)
	{
		peca = p;
	}
	
}
