package jogo_Main;

import pecas.*;

public class XadrezMain {
	public static void main(String[] args) 
	{	
		Bispo wb = new Bispo(2,3,'b');
		Torre wt = new Torre(3,6,'b');
		wb.printAllMov();
		System.out.println();
		wt.printAllMov();
	}
}