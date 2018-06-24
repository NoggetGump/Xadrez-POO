package jogo_GUI;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;

public class GUI_FileChooser {
	
	JFileChooser fc = new JFileChooser();
	
	public GUI_FileChooser(String msg)
	{
		fc.setCurrentDirectory(new java.io.File("saves"));
		fc.setDialogTitle(msg);
	}

	public int showChooser()
	{
		int val = fc.showOpenDialog(null);
		
		return val;
	}
	
	public File getFile()
	{
		return fc.getSelectedFile();
	}
}
