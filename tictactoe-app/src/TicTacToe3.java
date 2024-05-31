import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TicTacToe3 
{
	JFrame frame=new JFrame("Tic Tac Toe");
	JPanel[] pa=new JPanel[3];
	JLabel label=new JLabel("First player turn...");
	JButton[] bt=new JButton[9];
	JButton reset=new JButton("RESET");
	JButton exit=new JButton("EXIT");
	ImageIcon icon1=new ImageIcon(getClass().getResource("images/user1.png"));
	ImageIcon icon2=new ImageIcon(getClass().getResource("images/user2.png"));
	int player=1;
	public TicTacToe3()
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
		}//end of actionPerfomed method
		private void findWinner()
		{
			if(bt[0].getIcon()==icon1 && bt[1].getIcon()==icon1 && bt[2].getIcon()==icon1)
			{
				bt[0].setBackground(Color.green);
				bt[1].setBackground(Color.green);
				bt[2].setBackground(Color.green);
				label.setText("GAME IS OVER...");
				label.setForeground(Color.white);
				pa[0].setBackground(Color.red);
				JOptionPane.showMessageDialog(frame,"First player has won");
			}
			if(bt[0].getIcon()==icon2 && bt[1].getIcon()==icon2 && bt[2].getIcon()==icon2)
			{
				bt[0].setBackground(Color.green);
				bt[1].setBackground(Color.green);
				bt[2].setBackground(Color.green);
				label.setText("GAME IS OVER...");
				label.setForeground(Color.white);
				pa[0].setBackground(Color.red);
				JOptionPane.showMessageDialog(frame,"Second player has won");
			}
			if(bt[3].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[5].getIcon()==icon1)
			{
				bt[3].setBackground(Color.green);
				bt[4].setBackground(Color.green);
				bt[5].setBackground(Color.green);
				label.setText("GAME IS OVER...");
				label.setForeground(Color.white);
				pa[0].setBackground(Color.red);
				JOptionPane.showMessageDialog(frame,"First player has won");
			}
			if(bt[3].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[5].getIcon()==icon2)
			{
				bt[3].setBackground(Color.green);
				bt[4].setBackground(Color.green);
				bt[5].setBackground(Color.green);
				label.setText("GAME IS OVER...");
				label.setForeground(Color.white);
				pa[0].setBackground(Color.red);
				JOptionPane.showMessageDialog(frame,"Second player has won");
			}
		}
	}//end of TicListener class
	public static void main(String[] args) 
	{
		new TicTacToe3();
	}
}//End of ticTacToe class
