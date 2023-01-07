// design Customer details frame
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class CustomerDetails implements ActionListener
{
JFrame f;
JLabel l1;
JButton b1,b2,b3,b4;
Font f1,f2;

CustomerDetails()
{
f=new JFrame("Customer Details");
f.setSize(500,450);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



f1=new Font("Arial Black",Font.BOLD,16);
f2=new Font("Arial Black",Font.BOLD,20);


l1=new JLabel("WELCOME TO CUSTOMER DETAILS");
l1.setBounds(50,30,430,50);
l1.setFont(f2);
l1.setForeground(Color.RED);


b1=new JButton("New Customer");
b1.setBounds(50,130,210,30);
b1.setFont(f1);
b1.setForeground(Color.BLUE);
b1.addActionListener(this);

b2=new JButton("Update Customer");
b2.setBounds(50,210,210,30);
b2.setFont(f1);
b2.setForeground(Color.BLUE);
b2.addActionListener(this);


b3=new JButton("Delete Customer");
b3.setBounds(50,290,210,30);
b3.setFont(f1);;
b3.setForeground(Color.BLUE);
b3.addActionListener(this);


b4=new JButton("Back");
b4.setBounds(340,350,100,30);
b4.setFont(f1);
b4.setForeground(Color.RED);
b4.addActionListener(this);

f.add(l1);
f.add(b1);

f.add(b2);

f.add(b3);

f.add(b4);
f.setVisible(true);
}//ctor


public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
f.dispose();
Customer cs=new Customer();
}
else if(ae.getSource()==b2)
{
f.dispose();
UpdateCustomer ucs=new UpdateCustomer();
}

else if(ae.getSource()==b3)
{
f.dispose();
DeleteCustomer csd=new DeleteCustomer();
}

else if(ae.getSource()==b4)
{
f.dispose();
Main m=new Main();
}

}//event mathod

}

class CustomerDetailsDemo
{
public static void main(String s[])
{
CustomerDetails cds=new CustomerDetails();
}
}
