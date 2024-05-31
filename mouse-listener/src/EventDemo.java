import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EventDemo 
{
	JFrame frame=new JFrame("Event Demo");
	JPanel panel=new JPanel();
	JLabel label=new JLabel("CETPA Infotech");
	public EventDemo()
	{
		frame.setSize(500,400);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		panel.add(label);
		label.addMouseListener(new LabelListener());
		frame.setVisible(true);
	}
	class LabelListener implements MouseListener
	{
		Font font;
		public void mouseEntered(MouseEvent e) 
		{
			font=label.getFont();
			label.setFont(new Font("arial",0,25));
		}
		public void mouseExited(MouseEvent e) 
		{
			label.setFont(font);
		}
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}
	public static void main(String[] args) 
	{
		new EventDemo();
	}
}
