package jogo_GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GUI_janela extends JFrame {

		public GUI_janela()
		{
			addMouseListener(new MouseAdapter() 
			{
				public void mouseClicked(MouseEvent e)
				{
					int x = (e.getX()-4)/100;
					int y = (e.getY()-26)/100;
					System.out.println("Coordenada clicada: ( " + x + " , " + y + " )");
				}
			});
			
			ImageIcon img = new ImageIcon("Assets\\Chess_Icon2.png");
			this.setIconImage(img.getImage());
			this.setTitle("Xadrez");
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setSize(816, 839);
		    getContentPane().add(new GUI_main());
		    setLocationRelativeTo(null);
		    setResizable(false);
		    setVisible(true);
			System.out.println("Janela inicializada com sucesso!");
			
		}
}
