import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EventDemo 
{
	JFrame frame=new JFrame("Event Demo");
	JPanel panel=new JPanel();
	JButton button1=new JButton("Red Background");
	JButton button2=new JButton("Green Background");
	public EventDemo()
	{
		frame.setSize(500,400);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		panel.setBackground(Color.yellow);
		panel.add(button1);
		panel.add(button2);
		//Giving object of RedListener to the button1
		button1.addActionListener(new RedListener());
		//Giving object of GreenListener to the button2
		button2.addActionListener(new GreenListener());
		frame.setVisible(true);
	}
	//Creating listener for button button1
	class RedListener implements ActionListener
	{
		//This method will be called by button1 on click
		//In this method object of ActionEvent class be passed
		public void actionPerformed(ActionEvent evt)
		{
			panel.setBackground(Color.red);
		}
	}
	//Creating listener for button button2
	class GreenListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			panel.setBackground(Color.green);
		}
	}
	public static void main(String[] args) 
	{
		new EventDemo();
	}
}
