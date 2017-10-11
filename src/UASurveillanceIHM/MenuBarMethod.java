package UASurveillanceIHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * 
 * @author thibaut
 * Contient les actions à réaliser en fonction des clics sur la MenuBar
 */
public class MenuBarMethod implements ActionListener {
	
	public MenuBarMethod(){
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("about")){
			String credits = "<html>UA-Surveillance v0.1 !<br>Dev - ..." +
            		"<br>Icons - ..." +
            		"<br>Database - MariaDB</html>";
			JOptionPane.showMessageDialog(null, credits, "About", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}