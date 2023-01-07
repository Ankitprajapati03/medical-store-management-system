// design all information  frame
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Report implements ActionListener
{
JFrame f;
JLabel l1;
JButton b1,b2,b3,b4,b5,b6;
Font f1,f2;


Report()
{


//set a image on this frame
// im=new ImageIcon("everyday-basics-GJY1eAw6tn8-unsplash.jpg");
// JLabel bg=new JLabel("",im,JLabel.CENTER);
// bg.setBounds(0,0,500,450);
// f.add(bg);



f=new JFrame("REPORT");
f.setSize(500,500);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



f1=new Font("Arial Black",Font.BOLD,16);
f2=new Font("Arial Black",Font.BOLD,20);


l1=new JLabel("WELCOME TO REPORT");
l1.setBounds(50,30,430,50);
l1.setFont(f2);
l1.setForeground(Color.RED);


b1=new JButton("All Vendors");
b1.setBounds(50,120,210,30);
b1.setFont(f1);
b1.setForeground(Color.BLUE);
b1.addActionListener(this);

b2=new JButton("All Companies");
b2.setBounds(50,190,210,30);
b2.setFont(f1);
b2.setForeground(Color.BLUE);
b2.addActionListener(this);


b3=new JButton("All Medicines");
b3.setBounds(50,260,210,30);
b3.setFont(f1);;
b3.setForeground(Color.BLUE);
b3.addActionListener(this);

b4=new JButton("All Customers");
b4.setBounds(50,330,210,30);
b4.setFont(f1);;
b4.setForeground(Color.BLUE);
b4.addActionListener(this);


b5=new JButton("Back");
b5.setBounds(340,400,100,30);
b5.setFont(f1);
b5.setForeground(Color.RED);
b5.addActionListener(this);

b6=new JButton("Medicine Stock");
b6.setBounds(50,400,210,30);
b6.setFont(f1);
b6.setForeground(Color.BLUE);
b6.addActionListener(this);

f.add(l1);
f.add(b1);

f.add(b2);

f.add(b3);

f.add(b4);
f.add(b5);
f.add(b6);
f.setVisible(true);
}//ctor

public void actionPerformed(ActionEvent ae)
{

 if(ae.getSource()==b5)
{
f.dispose();
Main m=new Main();
}

else if(ae.getSource()==b4)
{
f.dispose();
Cujtable mj=new Cujtable();
}

else if(ae.getSource()==b2)
{
f.dispose();
Cjtable cj=new Cjtable();
}


else if(ae.getSource()==b3)
{
f.dispose();
Mjtable mj=new Mjtable();
}


else if(ae.getSource()==b6)
{
f.dispose();

Stockjtable vj=new Stockjtable();
}


 else if(ae.getSource()==b1)
{
f.dispose();
Vjtable vj=new Vjtable();
}

}//event mathod


}

class ReportDemo
{
public static void main(String s[])
{
Report rp=new Report();
}
}
