// design Medicine details frame
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MedicineDetails implements ActionListener
{
JFrame f;
JLabel l1;
JButton b1,b2,b3,b4;
Font f1,f2;
ImageIcon im;

MedicineDetails()
{
f=new JFrame("Medicine Details");
f.setSize(500,450);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


im=new ImageIcon("istockphoto-1297157103-1024x1024.jpg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,500,450);
f.add(bg);


f1=new Font("Arial Black",Font.BOLD,16);
f2=new Font("Arial Black",Font.BOLD,20);


l1=new JLabel("WELCOME TO MEDICINE DETAILS");
l1.setBounds(60,30,400,50);
l1.setFont(f2);
l1.setForeground(Color.RED);


b1=new JButton("New Medicine");
b1.setBounds(50,130,210,30);
b1.setFont(f1);
b1.setForeground(Color.BLUE);
b1.addActionListener(this);


b2=new JButton("Update Medicine");
b2.setBounds(50,210,210,30);
b2.setFont(f1);
b2.setForeground(Color.BLUE);
b2.addActionListener(this);

b3=new JButton("Remove Medicine");
b3.setBounds(50,290,210,30);
b3.setFont(f1);;
b3.setForeground(Color.BLUE);
b3.addActionListener(this);

b4=new JButton("Back");
b4.setBounds(340,350,100,30);
b4.setFont(f1);
b4.setForeground(Color.RED);
b4.addActionListener(this);

bg.add(l1);
bg.add(b1);

bg.add(b2);
bg.add(b3);
bg.add(b4);
f.setVisible(true);
}//ctor

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
f.dispose();
Medicine m=new Medicine();
}
else if(ae.getSource()==b2)
{
f.dispose();
UpdateMedicine um=new UpdateMedicine();
}

else if(ae.getSource()==b3)
{
f.dispose();
DeleteMedicine md=new DeleteMedicine();
}

else if(ae.getSource()==b4)
{
f.dispose();
Main m=new Main();
}

}//event mathod

}// class

class MedicineDetailsDemo
{
public static void main(String s[])
{
MedicineDetails md=new MedicineDetails();
}
}
