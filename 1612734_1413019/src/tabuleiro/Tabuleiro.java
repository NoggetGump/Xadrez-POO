package tabuleiro;

import java.awt.*;
import javax.swing.*;
import java.awt.Graphics2D;

public class Tabuleiro extends JComponent{
	
	private Casa casa[][] = new Casa[8][8]();
	
	
	public void desenhaRetangulo(Graphics g) 
    {

		Graphics2D retangulo = (Graphics2D) g;
        super.paintComponent(g);
        retangulo.setColor(Color.black);   
        retangulo.drawRect(10,10,100,100);

    }
	
}
