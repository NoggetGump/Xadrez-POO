 package jogo_GUI;

import java.awt.Graphics;

import javax.swing.JComponent;

import jogo_Main.Facade;

@SuppressWarnings("serial")
public class GUI_main extends JComponent{

	Facade facade = null;
	GUI_janela j = null;

	public GUI_main(Facade facade)
	{
		this.facade = facade;
		j = new GUI_janela(facade, this);
	}

	@Override
	public void paint(Graphics g)
	{
		facade.paintAll(g, this);
	}

	public GUI_janela getJanela() {
		return j;
	}
}