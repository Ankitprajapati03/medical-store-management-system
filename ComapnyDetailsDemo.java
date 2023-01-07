// design Company details frame
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class CompanyDetails
{
JFrame f;
JLabel l1;
JButton b1,b2,b3,b4;
Font f1,f2;

CompanyDetails()
{
f=new JFrame("Company Details");
f.setSize(500,450);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



f1=new Font("Arial Black",Font.BOLD,16);
f2=new Font("Arial Black",Font.BOLD,20);


l1=new JLabel("WELCOME TO Company DETAILS");
l1.setBounds(60,30,400,50);
l1.setFont(f2);
l1.setForeground(Color.RED);


b1=new JButton("New Company");
b1.setBounds(50,130,210,30);
b1.setFont(f1);
b1.setForeground(Color.BLUE);


b2=new JButton("Update Company");
b2.setBounds(50,210,210,30);
b2.setFont(f1);
b2.setForeground(Color.BLUE);


b3=new JButton("Delete Company");
b3.setBounds(50,290,210,30);
b3.setFont(f1);;
b3.setForeground(Color.BLUE);



b4=new JButton("Back");
b4.setBounds(340,350,100,30);
b4.setFont(f1);
b4.setForeground(Color.RED);

f.add(l1);
f.add(b1);

f.add(b2);

f.add(b3);

f.add(b4);
f.setVisible(true);
}
}

class CompanyDetailsDemo
{
public static void main(String s[])
{
CompanyDetails vd=new CompanyDetails();
}
}
