package jogo_Main;

import jogo_GUI.GUI_main;
import tabuleiro.Tabuleiro;

public class XadrezMain {

	public static void main(String[] args)
	{
		Tabuleiro tab = new Tabuleiro();
		GUI_main g = new GUI_main();
		g.inicializaJogo(tab);
		//g.msgXequeMate();
	}
}
