import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class NumberToWords implements ActionListener
{
	JFrame f;
	JButton b;
	JTextField tf;
	JTextArea ta;
	JLabel l1,l2;
	NumberToWords(String s)
	{
		f=new JFrame(s);
		b=new JButton("Click");
		tf=new JTextField();
		ta=new JTextArea();
		l1=new JLabel("Enter Number");
		l2=new JLabel("Number in words");
		l1.setBounds(10,20,100,30);
		l2.setBounds(10,100,100,30);
		f.add(b);
		f.add(tf);
		f.add(ta);
		f.add(l1);
		f.add(l2);
		tf.setBounds(10,50,350,30);
		ta.setBounds(10,130,350,70);
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);
		b.setBounds(130,270,100,40);
		b.setForeground(Color.RED);
		b.addActionListener(this);
		
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(800,50,400,400);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		String tx=tf.getText();
		int n=Integer.parseInt(tx);
		String word;
		if(n<1000000000&&n>0)
		{
			word=convert(n);
		}
		else if(n==0)
			word="zero";
		else
			word="invalid";
		
		ta.setText(word);
	}
	String fun(int n)
	{
		String str="";
		String[] units={"","One ","Two ","Three ","Four ","Five ","Six ",
						 "Seven ","Eight ","Nine ","Ten ","Eleven ","Twelve ",
						 "Thirteen ","Fourteen ","Fifteen ","Sixteen ","Seventeen "
		                 ,"Eighteen ","Nineteen "};
		String[] tens={""," ","Twenty ","Thirty ","Fourty ","Fifty ","Sixty ",
		                    "Seventy ","Eighty ","Ninety "};
						 
		if(n<20)
		{
			str=units[n];
		}
        else if(n>=20 && n<100)
		{
			str=tens[n/10]+units[n%10];
		}
     return str;		
	}
	String convert(int num)
	{
		String ss="";
		if(num<100)
			ss=fun(num);
		else if(num>=100 &&num<1000)
		{
			ss=fun(num/100)+"hundred "+convert(num%100);
		}
		else if(num>=1000&&num<100000)
		{
			ss=fun(num/1000)+"thousand "+convert(num%1000);
		}
		else if(num>=100000&&num<10000000)
		{
			ss=fun(num/100000)+"lakh "+convert(num%100000);
		}
		else if(num>=10000000&&num<1000000000)
		{
			ss=fun(num/10000000)+"crore "+convert(num%10000000);
		}
		return ss;
	}
	
	public static void main(String...s)
	{
		new NumberToWords("Convert Number into Words");
	}
}
	