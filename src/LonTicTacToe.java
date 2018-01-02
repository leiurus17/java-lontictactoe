/**

	Lon TicTacToe Version 1.0
	
	A simple Tic Tac Toe game created in Java.


**/

import java.awt. *;
import java.awt.event.*;
import javax.swing.*;

public class LonTicTacToe
{

	//Declaring of the components.

	JFrame frame; //The frame that holds the panel and the menu. This is the application's window.
	
	JMenuBar menuBar; //The JMenuBar.
	
	JMenu menuHelp, menuScore,submenu; //The items on the JMenuBar.
	
	JMenuItem menuItemAbout, menuItemScore; //The items of inside the Menu on the JMenuBar i.e. The second level items.
	
	LonTicTacToePanel insidePanel1 = new LonTicTacToePanel(); //Calling of the panel to be used inside the JFrame.
	
	
	public LonTicTacToe()
	{
	
		menuBar = new JMenuBar(); //Created an instance of the JMenu
		
		
		//Items of JMenu
		menuScore = new JMenu("Score");
		menuScore.setMnemonic(KeyEvent.VK_C);
		menuScore.getAccessibleContext().setAccessibleDescription("");
		
		menuHelp = new JMenu("Help");
		menuHelp.setMnemonic(KeyEvent.VK_H);
		menuHelp.getAccessibleContext().setAccessibleDescription("");
		
		//Putting the items inside the JMenu
		menuBar.add(menuScore);
		menuBar.add(menuHelp);
		
		
		//Item.
		menuItemScore = new JMenuItem("View Scores",KeyEvent.VK_W);
		menuItemScore.getAccessibleContext().setAccessibleDescription("");
		
		//Putting the item inside the JMenuItem.
		menuScore.add(menuItemScore);
		
		
		//Item.
		menuItemAbout = new JMenuItem("About",KeyEvent.VK_T);
		menuItemAbout.getAccessibleContext().setAccessibleDescription("");
		
		//Putting the item inside the JMenuItem.
		menuHelp.add(menuItemAbout);
		
		
		//Placing an ActionListener so that we can get the click event and do something when the user do clicks the items.
		menuItemScore.addActionListener(new MenuActionListener());
		menuItemAbout.addActionListener(new MenuActionListener());
		
		
		//Setting up the frame.
		frame = new JFrame("Lon TicTacToe Version 1.0");
		frame.setSize(490,490);
		
		//Setting the dimension for the panel.
		insidePanel1.setPreferredSize(new Dimension(490,490));
	
	
		//Finishing the frame and putting the panel inside the frame.
		frame.add(insidePanel1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		
		//This adds the JMenu to the JFrame
		frame.setJMenuBar(menuBar);
		
		//Packing the frame so that it is okay when viewed.
		frame.pack();
		//Just making the frame visible.
		frame.setVisible(true);
	
	
	}
	
	//Here is where we do the ActionListener
	class MenuActionListener implements ActionListener {
	
	//This gets the action and then from that action, we can decide what to do.
	public void actionPerformed(ActionEvent e) {
    
	//If the user clicks the "About."
	if (e.getSource() == menuItemAbout)
		{
		
			//Then it will show the JOptionPane for some information.
			JOptionPane.showMessageDialog(frame, "Lon TicTacToe\nCreated by: Marlon Monzon\nCredits to: Justine Afable (Thanks!)\nVersion 1.0\nDate: 4/22/2011\nThis program is created for and inspired by B.","About",JOptionPane.INFORMATION_MESSAGE);
		}
	
	//If the user clicks the "View Scores."
	if (e.getSource() == menuItemScore)
		{
			//Then it will show the JOptionPane for some information.
			JOptionPane.showMessageDialog(frame, "Testing","Scores",JOptionPane.INFORMATION_MESSAGE);
	        }
  }
}
	//This is the main
	public static void main(String[] args)
	{
	
		//Create new instance of this class
		new LonTicTacToe();
	
	}


}
