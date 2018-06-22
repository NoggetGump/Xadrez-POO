package jogo_GUI;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import pecas.Bispo;
import pecas.Cavalo;
import pecas.Peca;
import pecas.Rainha;
import pecas.Torre;
import tabuleiro.Tabuleiro;

public class GUI_PromoMenu implements ActionListener
{
	private JPopupMenu popup = new JPopupMenu();
    private JMenuItem button;
	private HashMap<String, Integer> promoMap;
	private Peca peao;
	private Peca promo = null;
	private Tabuleiro tab;
	private GUI_main gm;

    public GUI_PromoMenu(Peca peao, Tabuleiro tab, GUI_main gm)
    {
    	popup = new JPopupMenu("Menu de Promocao");
    	promoMap = new HashMap<String, Integer>();
    	this.peao = peao;
    	this.tab = tab;
    	this.gm = gm;

    	promoMap.put("Torre", 1);
    	promoMap.put("Cavalo", 2);
    	promoMap.put("Bispo", 3);
    	promoMap.put("Rainha", 4);
    }

    public void addButton(String title, String imgPath)
    {
    	ImageIcon buttonIcon = new ImageIcon(
    			Toolkit.getDefaultToolkit().getImage(imgPath));
    	button = new JMenuItem(title, buttonIcon);
    	button.setActionCommand(title);
    	button.addActionListener(this);
    	popup.add(button);
    }

    public void actionPerformed(ActionEvent e) 
    {
    	System.out.println(e.getActionCommand());
		switch(promoMap.get(e.getActionCommand()))
		{
			case 1:
				promo = new Torre(peao.getX(), peao.getY(), peao.getCor());

				break;
			case 2:
				promo = new Cavalo(peao.getX(), peao.getY(), peao.getCor());

				break;

			case 3:
				promo = new Bispo(peao.getX(), peao.getY(), peao.getCor());

				break;					
			case 4:
				promo = new Rainha(peao.getX(), peao.getY(), peao.getCor());

				break;

			default:
				break;
		}

		tab.promovida(peao, promo, gm);
    }

    public void showMenu()
    {
    	popup.show(gm.getJanela(), peao.cnvrtCooX(), peao.cnvrtCooY());
    }

}