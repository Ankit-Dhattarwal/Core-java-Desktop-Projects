import javax.swing.*;
import java.awt.*;
public class Calculator 
{
	JFrame frame=new JFrame("Calculator");
	JTextField tb=new JTextField("0"); 
	JPanel pa=new JPanel();
	JButton[] bt=new JButton[20];
	public Calculator()
	{
		frame.setSize(400,450);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(3);
		frame.setLayout(null);
		addTextBox();
		frame.setVisible(true);
	}
	private void addTextBox()
	{
		tb.setBounds(20,20,360,40);
		frame.add(tb); 
		tb.setHorizontalAlignment(4);
		tb.setFont(new Font("arial",0,20));
		tb.setEditable(false);
		tb.setBackground(Color.white);
		tb.setBorder(BorderFactory.createLineBorder(Color.black,1));
		addPanel();
	}
	private void addPanel()
	{
		pa.setBounds(20,90,360,300);
		//pa.setBackground(Color.cyan);
		frame.add(pa);
		addButtons();
	}
	private void addButtons()
	{
		pa.setLayout(new GridLayout(5,4,5,5));
		Font fo=new Font("arial",0,20);
		String[] str= {"Back","CE","C","%","7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
		for(int i=0;i<20;i++)
		{
			bt[i]=new JButton(str[i]);
			bt[i].setFont(fo);
			if(i==3 || i==7 || i==11 || i==15 || i==19)
				bt[i].setForeground(Color.red);
			else
				bt[i].setForeground(Color.blue);
			pa.add(bt[i]);
		}
		bt[17].setFont(new Font("arial",1,25));
	}
	public static void main(String[] args) 
	{
		new Calculator();
	}
}
