import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EventDemo 
{
	JFrame frame=new JFrame("Event Demo");
	JPanel panel=new JPanel();
	JButton button1=new JButton("Red Background");
	JButton button2=new JButton("Green Background");
	JButton button3=new JButton("Blue Background");
	public EventDemo()
	{
		frame.setSize(500,400);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		panel.setBackground(Color.yellow);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		ColorListener listener=new ColorListener();
		button1.addActionListener(listener);
		button2.addActionListener(listener);
		button3.addActionListener(listener);
		frame.setVisible(true);
	}
	class ColorListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			JButton source=(JButton)evt.getSource();
			//Variable source will be created
			//getSource() method of ActionEvent class will be called
			//Value returned by getSource() method will be converted into JButton type
			//Converted value will be assigned to the variable source
			
			if(source==button1)
				panel.setBackground(Color.red);
			else if(source==button2)
				panel.setBackground(Color.green);
			else if(source==button3)
				panel.setBackground(Color.blue);
		}
	}
	public static void main(String[] args) 
	{
		new EventDemo();
	}
}
