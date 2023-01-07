// design main frame
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Main implements ActionListener
{
JFrame f;
JLabel l1;
JButton b1,b2,b3,b4,b5,b6,b7,b8;
Font f1,f2;
ImageIcon im;

Main()
{
f=new JFrame("MEDICAL STORE");
f.setSize(600,470);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//set a image on this frame
im=new ImageIcon("national-cancer-institute-v7ibB19EUbQ-unsplash.jpg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,600,470);
f.add(bg);


f1=new Font("Arial Black",Font.BOLD,16);
f2=new Font("Arial Black",Font.BOLD,24);


l1=new JLabel("WELCOME TO MEDICAL STROE");
l1.setBounds(80,30,450,50);
l1.setFont(f2);
bg.add(l1);
l1.setForeground(Color.RED);



b1=new JButton("Vendor Details");
b1.setBounds(50,130,210,30);
b1.setFont(f1);
bg.add(b1);
b1.setForeground(Color.BLUE);
b1.addActionListener(this);


b2=new JButton("Company Details");
b2.setBounds(50,210,210,30);
b2.setFont(f1);
bg.add(b2);
b2.setForeground(Color.BLUE);
b2.addActionListener(this);


b3=new JButton("Medicine Details");
b3.setBounds(50,290,210,30);
b3.setFont(f1);
bg.add(b3);
b3.setForeground(Color.BLUE);
b3.addActionListener(this);


b4=new JButton("Customer Details");
b4.setBounds(330,130,210,30);
b4.setFont(f1);
bg.add(b4);
b4.setForeground(Color.BLUE);
b4.addActionListener(this);


b5=new JButton("Purchase");
b5.setBounds(330,210,210,30);
b5.setFont(f1);
bg.add(b5);
b5.setForeground(Color.BLUE);
b5.addActionListener(this);



b6=new JButton("Sale");
b6.setBounds(330,290,210,30);
b6.setFont(f1);
bg.add(b6);
b6.setForeground(Color.BLUE);
b6.addActionListener(this);


b7=new JButton("LOG OUT");
b7.setBounds(410,380,150,30);
b7.setFont(f1);
bg.add(b7);
b7.setForeground(Color.RED);
b7.addActionListener(this);


b8=new JButton("Rport");
b8.setBounds(240,380,100,30);
b8.setFont(f1);
bg.add(b8);
b8.setForeground(Color.RED);
b8.addActionListener(this);

f.setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
f.dispose();
VendorDetails vd=new VendorDetails();
}
else if(ae.getSource()==b2)
{
f.dispose();
CompanyDetails cm=new CompanyDetails();
}

else if(ae.getSource()==b3)
{
f.dispose();
MedicineDetails md=new MedicineDetails();
}

else if(ae.getSource()==b4)
{
f.dispose();
CustomerDetails cds=new CustomerDetails();
}

else if(ae.getSource()==b5)
{
f.dispose();
Purchase p=new Purchase();
}

else if(ae.getSource()==b6)
{
f.dispose();
Sale sl=new Sale();
}


else if(ae.getSource()==b7)
{
JOptionPane.showMessageDialog(f,"if you logout your account then click on OK");
f.dispose();
Login l=new Login();
}


else if(ae.getSource()==b8)
{
f.dispose();
Report rb=new Report();
}


}

}//end of main class
class MainDemo
{
public static void main(String[] s)
{
Main mn=new Main();
}
}