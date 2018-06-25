 package jogo_GUI;


import java.awt.Graphics;

import javax.swing.JComponent;

import jogo_Main.Facade;

public class GUI_main extends JComponent{

	Facade facade;
	
	public GUI_main(Facade facade)
	{
		this.facade = facade;
	}

	@Override
	public void paint(Graphics g)
	{
		facade.paintAll(g, this);
	}
}