package movimentos;

import pecas.*;

import java.util.Scanner;

public class PromocaoPeao {
	
	public static Peca Promove(Peca superPeca)
	{
		System.out.println("Digite para qual peca deseja promover o superPeca:");
		System.out.println("-1:Torre");
		System.out.println("-2:Cavalo");
		System.out.println("-3:Bispo");
		System.out.println("-4:Rainha");
		Scanner input = new Scanner(System.in);
		Integer promo = input.nextInt();			
		System.out.println(promo.toString());

		int x = superPeca.getX();
		int y = superPeca.getY();
		char cor = superPeca.getCor();
		superPeca = null;

			switch(promo)
			{
				case 1:
					superPeca = new Torre(x, y, cor);
					
					break;
				case 2:
					superPeca = new Cavalo(x, y, cor);
					
					break;
				
				case 3:
					superPeca = new Bispo(x, y, cor);
					
					break;					
				case 4:
					superPeca = new Rainha(x, y, cor);
					
					break;
					
				default:
					break;						
			}
		input.close();
		
		return superPeca;
	}
}