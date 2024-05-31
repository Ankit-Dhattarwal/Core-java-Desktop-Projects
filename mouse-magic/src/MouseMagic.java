import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class MouseMagic 
{
	JFrame frame=new JFrame("Mouse Magic");
	JLabel label=new JLabel("TOUCH ME TO SEE MAGIC");
	int x=200,y=100;
	Random ra=new Random();
	boolean move=true;
	public MouseMagic()
	{
		frame.setSize(1300,650);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		label.setFont(new Font("arial",0,20));
		label.setBounds(x,y,300,35);
		frame.add(label);
		label.addMouseListener(new LabelListener());
		frame.addKeyListener(new StopListener());
		frame.setVisible(true);
	}
	class LabelListener implements MouseListener
	{
		public void mouseEntered(MouseEvent e) 
		{
			if(move)
			{
				x=ra.nextInt(1000);
				y=ra.nextInt(550);
				label.setLocation(x,y);
			}
			move=true;
		}
		public void mouseExited(MouseEvent e) {} 
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}
	class StopListener implements KeyListener
	{
		public void keyPressed(KeyEvent e) 
		{
			move=false;
		}
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
	}
	public static void main(String[] args) 
	{
		new MouseMagic();
	}
}
