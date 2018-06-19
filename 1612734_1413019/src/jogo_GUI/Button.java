package jogo_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import pecas.Bispo;
import pecas.Cavalo;
import pecas.Peca;
import pecas.Rainha;
import pecas.Torre;
import vetor.Vet;

public class Button extends JPanel
		implements ActionListener
{
    private JMenuItem button;
	private HashMap<String, Integer> promoMap;
	private Peca superPeca;
	
    public Button(String imgPath, String title, Vet vet)
    {
    	ImageIcon buttonIcon = new ImageIcon(imgPath);

    	button = new JMenuItem(title, buttonIcon);
    	button.setActionCommand("enable");
    	button.addActionListener(this);
    	
    	promoMap = new HashMap<String, Integer>();
    	
    	promoMap.put("Torre", 1);
    	promoMap.put("Cavalo", 2);
    	promoMap.put("Bispo", 3);
    	promoMap.put("Rainha", 4);
    }

    public void actionPerformed(ActionEvent e) 
    {

    }
}
