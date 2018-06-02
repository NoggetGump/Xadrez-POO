
package jogo_Main;

import jogo_GUI.GUI_main;
import pecas.*;

public class XadrezMain {

	public static void main(String[] args) 
	{
		Torre wt = new Torre(3,6,'b');
		GUI_main g = new GUI_main();
		g.inicializaTabuleiro();
		g.inicializaPeca(wt);
		
/*			JA TESTADO.
		Bispo wb = new Bispo(2,3,'b');
		Torre wt = new Torre(3,6,'b');
		Rei wk = new Rei(4,0, 'b');
		Rainha wq = new Rainha(3,0, 'b');
		Peao wp = new Peao(2, 1, 'b');
		Cavalo wh = new Cavalo(2, 0, 'b');

		System.out.println("White Bishop:");
		wb.printAllMov();
		System.out.println("\nWhite Tower:");
		wt.printAllMov();
		System.out.println("\nWite Queen:");
		wq.printAllMov();
		System.out.println("\nWhite King:");
		wk.printAllMov();
		System.out.println("\nWhite Horse");
		wh.printAllMov();
		System.out.println("\nWhite Pawn"); 
		wp.printAllMov();*/
	}
}