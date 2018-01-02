/**

	Lon TicTacToe Version 1.0
	
	A simple Tic Tac Toe game created in Java.


**/

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class LonTicTacToePanel extends JPanel implements MouseListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Setting up the images.
	ImageIcon bilog = new ImageIcon(this.getClass().getResource("/images/ow.jpg"));
	ImageIcon ekis = new ImageIcon(this.getClass().getResource("/images/eks.jpg"));
	
	ImageIcon bilogWin = new ImageIcon(this.getClass().getResource("/images/ow_raw.jpg"));
	ImageIcon ekisWin = new ImageIcon(this.getClass().getResource("/images/eks_raw.jpg"));
	
	
	//This variable determines the current number of turns in the game.
	int x = 2;
	
	
	
		//Setting up the JLabels. They are our tiles.
		JLabel labelPosition1 = new JLabel(); 
		JLabel labelPosition2 = new JLabel(); 
		JLabel labelPosition3 = new JLabel(); 
		JLabel labelPosition4 = new JLabel(); 
		JLabel labelPosition5 = new JLabel(); 
		JLabel labelPosition6 = new JLabel(); 
		JLabel labelPosition7 = new JLabel(); 
		JLabel labelPosition8 = new JLabel(); 
		JLabel labelPosition9 = new JLabel();

		
	//Here I am just painting the Tic Tac Toe lines.
	public void paint(Graphics g)
	{
		
			Graphics2D g2 = (Graphics2D)g;
		
			super.paint(g2);
			
			
			//***Body of the Tic Tac Toe ***//
			
			
			//Outer box.
			Rectangle2D body = new Rectangle2D.Double(20,20,450,450);
			g2.setColor(Color.black);
			g2.setStroke(new BasicStroke(10));
			g2.draw(body);
			
			//Two upper bars.
			g2.setColor(Color.black);
			g2.setStroke(new BasicStroke(10));
			g2.drawLine(170,20,170,470);
			
			g2.setColor(Color.black);
			g2.setStroke(new BasicStroke(10));
			g2.drawLine(320,20,320,470);
			
			//Two horizontal bars.
			g2.setColor(Color.black);
			g2.setStroke(new BasicStroke(10));
			g2.drawLine(20,170,470,170);
			
			g2.setColor(Color.black);
			g2.setStroke(new BasicStroke(10));
			g2.drawLine(20,320,470,320);
			
		
	}
	
	
	public LonTicTacToePanel()
	{
	
		/*
	
		Position 1 (25,25,140,140)
		Position 2 (175,25,140,140)
		Position 3 (325,25,140,140)
		Position 4 (25,175,140,140)
		Position 5 (175,175,140,140)
		Position 6 (325,175,140,140)
		Position 7 (225,325,140,140)
		Position 8 (175,325,140,140)
		Position 9 (325,325,140,140)
	
		*/
		
		setLayout(null); //Needs for the absolute positioning to work.
		
		

		// Add mouseListener.
		labelPosition1.addMouseListener(this);
		labelPosition2.addMouseListener(this);
		labelPosition3.addMouseListener(this);
		labelPosition4.addMouseListener(this);
		labelPosition5.addMouseListener(this);
		labelPosition6.addMouseListener(this);
		labelPosition7.addMouseListener(this);
		labelPosition8.addMouseListener(this);
		labelPosition9.addMouseListener(this);
		
		
		 //Image cannot directly be added use this. Needs setLayout(null); first.
		
		labelPosition1.setBounds(25,25,140,140); //.setBounds() Used to absolute position a component.
		labelPosition2.setBounds(175,25,140,140);
		labelPosition3.setBounds(325,25,140,140);
		labelPosition4.setBounds(25,175,140,140);
		labelPosition5.setBounds(175,175,140,140);
		labelPosition6.setBounds(325,175,140,140);
		labelPosition7.setBounds(25,325,140,140);
		labelPosition8.setBounds(175,325,140,140);
		labelPosition9.setBounds(325,325,140,140);
		
		//Adding the labels inside the panel.
		add(labelPosition1);
		add(labelPosition2);
		add(labelPosition3);
		add(labelPosition4);
		add(labelPosition5);
		add(labelPosition6);
		add(labelPosition7);
		add(labelPosition8);
		add(labelPosition9);
	}

	
	//Thanks to Justine for fixing / doing this part.
	@Override
	public void mouseClicked(MouseEvent evt)
	{
		
		
		Object o; //Create an object to get the labels.
		
		//If the user clicks a label.
		if ((o = evt.getSource()) instanceof JLabel)
		{
		
			//Then get that label and pass it into tmp.
			JLabel tmp = (JLabel) o;

			//If tmp has no name or has already had a name of 'ekis' (Why?) and the current turn is even.
			//I know now why. 8:43PM June 4, 2012
			if ((tmp.getName()==null || tmp.getName()=="ekis") && x%2==0)
			{
			
				//Then set that label into a circle.
				tmp.setName("bilog");
				tmp.setIcon(bilog);
				
				x++; //Increment the moves so the next move is odd so that the next image to be placed is the X.
				
				//This makes the clicked label unclickable.
				tmp.removeMouseListener(this);
				
				
			}
			else
			{
				tmp.setName("ekis");
				tmp.setIcon(ekis);
				x++;
				tmp.removeMouseListener(this);
			}
		}
		
		System.out.println(x);
		
				//Winner on top row
		
				if ((labelPosition1.getName()=="ekis") && (labelPosition2.getName()=="ekis") && (labelPosition3.getName()=="ekis"))
				{
				labelPosition1.setIcon(ekisWin);
				labelPosition2.setIcon(ekisWin);
				labelPosition3.setIcon(ekisWin);
				
				JOptionPane.showMessageDialog(this, "Winner is X!","X Won!",JOptionPane.INFORMATION_MESSAGE);
				
		
				restartRound(); //Reset the tiles.
		
				
				}
				
				else if ((labelPosition1.getName()=="bilog") && (labelPosition2.getName()=="bilog") && (labelPosition3.getName()=="bilog"))
				{
				
				labelPosition1.setIcon(bilogWin);
				labelPosition2.setIcon(bilogWin);
				labelPosition3.setIcon(bilogWin);
				
				JOptionPane.showMessageDialog(this, "Winner is O!","O Won!",JOptionPane.INFORMATION_MESSAGE);
				
		
				restartRound();
				
				}
				
				//End of Winner on top row
				
				//Winner of middle row
				
				else if ((labelPosition4.getName()=="ekis") && (labelPosition5.getName()=="ekis") && (labelPosition6.getName()=="ekis"))
				{
				labelPosition4.setIcon(ekisWin);
				labelPosition5.setIcon(ekisWin);
				labelPosition6.setIcon(ekisWin);
				
				JOptionPane.showMessageDialog(this, "Winner is X!","X Won!",JOptionPane.INFORMATION_MESSAGE);
				
		
				restartRound();
		
				
				}
				
				else if ((labelPosition4.getName()=="bilog") && (labelPosition5.getName()=="bilog") && (labelPosition6.getName()=="bilog"))
				{
				
				labelPosition4.setIcon(bilogWin);
				labelPosition5.setIcon(bilogWin);
				labelPosition6.setIcon(bilogWin);
				
				JOptionPane.showMessageDialog(this, "Winner is O!","O Won!",JOptionPane.INFORMATION_MESSAGE);
				
		
				restartRound();
				
				}
				
				//End of Winnder of middle row
				
				//Winner of bottom row
				
				else if ((labelPosition7.getName()=="ekis") && (labelPosition8.getName()=="ekis") && (labelPosition9.getName()=="ekis"))
				{
				labelPosition7.setIcon(ekisWin);
				labelPosition8.setIcon(ekisWin);
				labelPosition9.setIcon(ekisWin);
				
				JOptionPane.showMessageDialog(this, "Winner is X!","X Won!",JOptionPane.INFORMATION_MESSAGE);
				
		
				restartRound();
		
				
				}
				
				else if ((labelPosition7.getName()=="bilog") && (labelPosition8.getName()=="bilog") && (labelPosition9.getName()=="bilog"))
				{
				
				labelPosition7.setIcon(bilogWin);
				labelPosition8.setIcon(bilogWin);
				labelPosition9.setIcon(bilogWin);
				
				JOptionPane.showMessageDialog(this, "Winner is O!","O Won!",JOptionPane.INFORMATION_MESSAGE);
				
		
				restartRound();
				
				}
				
				//End of Winnder of bottom row
				
				
				///////////////////////////////
				
				//Winner on 1st column
		
				else if ((labelPosition1.getName()=="ekis") && (labelPosition4.getName()=="ekis") && (labelPosition7.getName()=="ekis"))
				{
				labelPosition1.setIcon(ekisWin);
				labelPosition4.setIcon(ekisWin);
				labelPosition7.setIcon(ekisWin);
				
				JOptionPane.showMessageDialog(this, "Winner is X!","X Won!",JOptionPane.INFORMATION_MESSAGE);
				
		
				restartRound();
		
				
				}
				
				else if ((labelPosition1.getName()=="bilog") && (labelPosition4.getName()=="bilog") && (labelPosition7.getName()=="bilog"))
				{
				
				labelPosition1.setIcon(bilogWin);
				labelPosition4.setIcon(bilogWin);
				labelPosition7.setIcon(bilogWin);
				
				JOptionPane.showMessageDialog(this, "Winner is O!","O Won!",JOptionPane.INFORMATION_MESSAGE);
				
		
				restartRound();
				
				}
				
				//End of Winner on 1st column
				
				//Winner of middle column
				
				else if ((labelPosition2.getName()=="ekis") && (labelPosition5.getName()=="ekis") && (labelPosition8.getName()=="ekis"))
				{
				labelPosition2.setIcon(ekisWin);
				labelPosition5.setIcon(ekisWin);
				labelPosition8.setIcon(ekisWin);
				
				JOptionPane.showMessageDialog(this, "Winner is X!","X Won!",JOptionPane.INFORMATION_MESSAGE);
				
		
				restartRound();
		
				
				}
				
				else if ((labelPosition2.getName()=="bilog") && (labelPosition5.getName()=="bilog") && (labelPosition8.getName()=="bilog"))
				{
				
				labelPosition2.setIcon(bilogWin);
				labelPosition5.setIcon(bilogWin);
				labelPosition8.setIcon(bilogWin);
				
				JOptionPane.showMessageDialog(this, "Winner is O!","O Won!",JOptionPane.INFORMATION_MESSAGE);
				
		
				restartRound();
				
				}
				
				//End of Winnder of middle column
				
				//Winner of last column
				
				else if ((labelPosition3.getName()=="ekis") && (labelPosition6.getName()=="ekis") && (labelPosition9.getName()=="ekis"))
				{
				labelPosition3.setIcon(ekisWin);
				labelPosition6.setIcon(ekisWin);
				labelPosition9.setIcon(ekisWin);
				
				JOptionPane.showMessageDialog(this, "Winner is X!","X Won!",JOptionPane.INFORMATION_MESSAGE);
				
		
				restartRound();
		
				
				}
				
				else if ((labelPosition3.getName()=="bilog") && (labelPosition6.getName()=="bilog") && (labelPosition9.getName()=="bilog"))
				{
				
				labelPosition3.setIcon(bilogWin);
				labelPosition6.setIcon(bilogWin);
				labelPosition9.setIcon(bilogWin);
				
				JOptionPane.showMessageDialog(this, "Winner is O!","O Won!",JOptionPane.INFORMATION_MESSAGE);
				
		
				restartRound();
				
				}
				
				//End of Winnder of last column
				
				///////////////////////////////
				
				//Winner on left diagonal
		
				else if ((labelPosition1.getName()=="ekis") && (labelPosition5.getName()=="ekis") && (labelPosition9.getName()=="ekis"))
				{
				labelPosition1.setIcon(ekisWin);
				labelPosition5.setIcon(ekisWin);
				labelPosition9.setIcon(ekisWin);
				
				JOptionPane.showMessageDialog(this, "Winner is X!","X Won!",JOptionPane.INFORMATION_MESSAGE);
				
		
				restartRound();
		
				
				}
				
				else if ((labelPosition1.getName()=="bilog") && (labelPosition5.getName()=="bilog") && (labelPosition9.getName()=="bilog"))
				{
				
				labelPosition1.setIcon(bilogWin);
				labelPosition5.setIcon(bilogWin);
				labelPosition9.setIcon(bilogWin);
				
				JOptionPane.showMessageDialog(this, "Winner is O!","O Won!",JOptionPane.INFORMATION_MESSAGE);
				
		
				restartRound();
				
				}
				
				//End of Winner on left diagonal
				
				//Winner of middle right diagonal
				
				else if ((labelPosition3.getName()=="ekis") && (labelPosition5.getName()=="ekis") && (labelPosition7.getName()=="ekis"))
				{
				labelPosition3.setIcon(ekisWin);
				labelPosition5.setIcon(ekisWin);
				labelPosition7.setIcon(ekisWin);
				
				JOptionPane.showMessageDialog(this, "Winner is X!","X Won!",JOptionPane.INFORMATION_MESSAGE);
				
		
				restartRound();
		
				
				}
				
				else if ((labelPosition3.getName()=="bilog") && (labelPosition5.getName()=="bilog") && (labelPosition7.getName()=="bilog"))
				{
				
				labelPosition3.setIcon(bilogWin);
				labelPosition5.setIcon(bilogWin);
				labelPosition7.setIcon(bilogWin);
				
				JOptionPane.showMessageDialog(this, "Winner is O!","O Won!",JOptionPane.INFORMATION_MESSAGE);
				
		
				restartRound();
				
				}
				
				//End of Winnder of right diagonal
				
				//Draw
		
				else if (
				((labelPosition1.getName()=="ekis") || (labelPosition1.getName()=="bilog")) && 
				((labelPosition2.getName()=="ekis") || (labelPosition2.getName()=="bilog")) &&
				((labelPosition3.getName()=="ekis") || (labelPosition3.getName()=="bilog")) &&
				((labelPosition4.getName()=="ekis") || (labelPosition4.getName()=="bilog")) &&
				((labelPosition5.getName()=="ekis") || (labelPosition5.getName()=="bilog")) &&
				((labelPosition6.getName()=="ekis") || (labelPosition6.getName()=="bilog")) &&
				((labelPosition7.getName()=="ekis") || (labelPosition7.getName()=="bilog")) &&
				((labelPosition8.getName()=="ekis") || (labelPosition8.getName()=="bilog")) &&
				((labelPosition9.getName()=="ekis") || (labelPosition9.getName()=="bilog"))
				)
				{
				
				JOptionPane.showMessageDialog(this, "No winner!","Draw!",JOptionPane.INFORMATION_MESSAGE);
				
		
				restartRound();
		
				
				}
				
				
				
		
	}
	
	//Setting up the tiles in the event of a win or a draw.
	public void restartRound()
	{
		x = 2;
		
		//Resetting the labels
		
		labelPosition1.removeMouseListener(this);
		labelPosition2.removeMouseListener(this);
		labelPosition3.removeMouseListener(this);
		labelPosition4.removeMouseListener(this);
		labelPosition5.removeMouseListener(this);
		labelPosition6.removeMouseListener(this);
		labelPosition7.removeMouseListener(this);
		labelPosition8.removeMouseListener(this);
		labelPosition9.removeMouseListener(this);
		
		labelPosition1.setName(null);
		labelPosition2.setName(null);
		labelPosition3.setName(null);
		labelPosition4.setName(null);
		labelPosition5.setName(null);
		labelPosition6.setName(null);
		labelPosition7.setName(null);
		labelPosition8.setName(null);
		labelPosition9.setName(null);
		
		labelPosition1.setIcon(null);
		labelPosition2.setIcon(null);
		labelPosition3.setIcon(null);
		labelPosition4.setIcon(null);
		labelPosition5.setIcon(null);
		labelPosition6.setIcon(null);
		labelPosition7.setIcon(null);
		labelPosition8.setIcon(null);
		labelPosition9.setIcon(null);
	
		labelPosition1.addMouseListener(this);
		labelPosition2.addMouseListener(this);
		labelPosition3.addMouseListener(this);
		labelPosition4.addMouseListener(this);
		labelPosition5.addMouseListener(this);
		labelPosition6.addMouseListener(this);
		labelPosition7.addMouseListener(this);
		labelPosition8.addMouseListener(this);
		labelPosition9.addMouseListener(this);
		
		this.repaint(); //Repaint the panel.
	}
	
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}