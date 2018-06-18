package jogo_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerT implements ActionListener {
	
	String peaoPromo = null;
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		peaoPromo = e.getActionCommand();
	}
	
	public void refresh()
	{
		
	}
	
	public String getPromo()
	{
		return peaoPromo;
	}
}
