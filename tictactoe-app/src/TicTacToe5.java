import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TicTacToe5 
{
	JFrame frame=new JFrame("Tic Tac Toe");
	JPanel[] pa=new JPanel[3];
	JLabel label=new JLabel("First player turn...");
	JButton[] bt=new JButton[9];
	JButton reset=new JButton("RESET");
	JButton exit=new JButton("EXIT");
	ImageIcon icon1=new ImageIcon(getClass().getResource("images/user1.png"));
	ImageIcon icon2=new ImageIcon(getClass().getResource("images/user2.png"));
	int player=1,count=0;
	boolean winnerFound=false;
	public TicTacToe5()
	{
		frame.setSize(500,620);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.black);
		frame.setLayout(null);
		addPanels();
		frame.setVisible(true);
	}
	private void addPanels()
	{
		for(int i=0;i<3;i++)
		{
			pa[i]=new JPanel();
			frame.add(pa[i]);
		}
		pa[0].setBounds(50,20,400,40);
		pa[0].setBackground(Color.cyan);
		pa[1].setBounds(50,90,400,400);
		pa[2].setBounds(50,520,400,40);
		pa[2].setOpaque(false);
		addLabel();
		addTicButtons();
		addResetAndExitButton();
	}
	private void addLabel()
	{
		pa[0].add(label);
		label.setFont(new Font("elephant",0,25));
		label.setForeground(Color.blue);
	}
	private void addTicButtons()
	{
		pa[1].setLayout(new GridLayout(3,3));
		TicListener listener=new TicListener();
		for(int i=0;i<9;i++)
		{
			bt[i]=new JButton();
			bt[i].addActionListener(listener);
			bt[i].setBackground(Color.yellow);
			pa[1].add(bt[i]);
		}
	}
	private void addResetAndExitButton()
	{
		pa[2].add(reset);
		pa[2].add(exit);
		Font font=new Font("arial",1,18);
		reset.setFont(font);
		exit.setFont(font);
		reset.setEnabled(false);
		exit.setForeground(Color.red);
	}
	class TicListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt) 
		{
			JButton bb=(JButton)evt.getSource();
			if(bb.getIcon()!=null)
			{
				JOptionPane.showMessageDialog(frame,"Wrong clicked");
				return;
			}
			if(player==1)
			{
				bb.setIcon(icon1);
				label.setText("Second player turn...");
				label.setForeground(Color.white);
				pa[0].setBackground(Color.blue);
				player=2;
			}
			else if(player==2)
			{
				bb.setIcon(icon2);
				label.setText("First player turn...");
				label.setForeground(Color.blue);
				pa[0].setBackground(Color.cyan);
				player=1;
			}
			findWinner();
			count++;
			if(count==9 && !winnerFound)
			{
				gameOver();
				JOptionPane.showMessageDialog(frame,"No one is winner");
			}
		}//end of actionPerfomed method
		private void findWinner()
		{
			//Rowwise finding winner
			if(bt[0].getIcon()==icon1 && bt[1].getIcon()==icon1 && bt[2].getIcon()==icon1)
				announceWinner(0,1,2);
			else if(bt[0].getIcon()==icon2 && bt[1].getIcon()==icon2 && bt[2].getIcon()==icon2)
				announceWinner(0,1,2);
			else if(bt[3].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[5].getIcon()==icon1)
				announceWinner(3,4,5);
			else if(bt[3].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[5].getIcon()==icon2)
				announceWinner(3,4,5);
			else if(bt[6].getIcon()==icon1 && bt[7].getIcon()==icon1 && bt[8].getIcon()==icon1)
				announceWinner(6,7,8);
			else if(bt[6].getIcon()==icon2 && bt[7].getIcon()==icon2 && bt[8].getIcon()==icon2)
				announceWinner(6,7,8);
			
			//Columnwise finding winner
			if(bt[0].getIcon()==icon1 && bt[3].getIcon()==icon1 && bt[6].getIcon()==icon1)
				announceWinner(0,3,6);
			else if(bt[0].getIcon()==icon2 && bt[3].getIcon()==icon2 && bt[6].getIcon()==icon2)
				announceWinner(0,3,6);
			else if(bt[1].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[7].getIcon()==icon1)
				announceWinner(1,4,7);
			else if(bt[1].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[7].getIcon()==icon2)
				announceWinner(1,4,7);
			else if(bt[2].getIcon()==icon1 && bt[5].getIcon()==icon1 && bt[8].getIcon()==icon1)
				announceWinner(2,5,8);
			else if(bt[2].getIcon()==icon2 && bt[5].getIcon()==icon2 && bt[8].getIcon()==icon2)
				announceWinner(2,5,8);
			
			//Diagonal wise finding winner
			else if(bt[0].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[8].getIcon()==icon1)
				announceWinner(0,4,8);
			else if(bt[0].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[8].getIcon()==icon2)
				announceWinner(0,4,8);
			else if(bt[2].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[6].getIcon()==icon1)
				announceWinner(2,4,6);
			else if(bt[2].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[6].getIcon()==icon2)
				announceWinner(2,4,6);
			
			
		}//End of findWinner() method
		private void announceWinner(int i,int j,int k)
		{
			winnerFound=true;
			bt[i].setBackground(Color.green);
			bt[j].setBackground(Color.green);
			bt[k].setBackground(Color.green);
			gameOver();
			if(player==2)
				JOptionPane.showMessageDialog(frame,"First player has won");
			else if(player==1)
				JOptionPane.showMessageDialog(frame,"Second player has won");
			for(int c=0;c<9;c++)
			{
				bt[c].setEnabled(false);
			}
		}
		private void gameOver()
		{
			label.setText("GAME IS OVER...");
			label.setForeground(Color.white);
			pa[0].setBackground(Color.red);
			reset.setEnabled(true);
		}
	}//end of TicListener class
	public static void main(String[] args) 
	{
		new TicTacToe5();
	}
}//End of ticTacToe class
