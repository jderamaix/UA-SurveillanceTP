package UASurveillanceIHM;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * 
 * @author thibaut
 * MenuBar hérité de JMenuBar permettant de dire au jeu ce que l'on veut faire
 */

public class MenuBar extends JMenuBar {
	
	private static final long serialVersionUID = 7325618304237937679L;
	//private JMenu mnuName1...;
	private JMenu mnuHelp;
	//private JMenuItem mniItem1...;
	private JMenuItem mniAbout;
	/* icones des menus */
	//private ImageIcon icoItem1...;
	private MenuBarMethod mbm;
	
	public MenuBar(){
		super();
		mbm = new MenuBarMethod();
		initUI();
	}
	
	public void initUI(){		 
		mnuHelp = new JMenu("?");
		
		mniAbout = new JMenuItem("About");
		mniAbout.addActionListener(mbm);
		mniAbout.setActionCommand("about");
		
		mnuHelp.add(mniAbout);
		
		add(mnuHelp);
	}
}