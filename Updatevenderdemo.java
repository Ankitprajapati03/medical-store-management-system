//Add  update vender
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Updatevender implements ActionListener,KeyListener
{
JFrame f;
JLabel l1,l2,l3,l4,l5;
JTextField t1,t2,t4,t5;
JTextArea t3;
JButton b1,b2,b3,b4;
Font f1;
Connection con;
PreparedStatement st;
ResultSet rs;
String id,nm,addr,eml, mob;

Updatevender()
{
f=new JFrame("Update Vendor");
f.setSize(580,630);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

f1=new Font("Arial",Font.BOLD,14);

l1=new JLabel("Vender Id");
l1.setBounds(50,50,150,30);
f.add(l1);
l1.setFont(f1);
l1.setForeground(Color.GREEN);

l2=new JLabel("Name");
l2.setBounds(50,130,150,30);
f.add(l2);
l2.setFont(f1);
l2.setForeground(Color.GREEN);

l3=new JLabel("Address");
l3.setBounds(50,210,150,30);
f.add(l3);
l3.setFont(f1);
l3.setForeground(Color.GREEN);

l4=new JLabel("Mobile Number");
l4.setBounds(50,360,150,30);
f.add(l4);
l4.setFont(f1);
l4.setForeground(Color.GREEN);

l5=new JLabel("Email Id");
l5.setBounds(50,440,150,30);
f.add(l5);
l5.setFont(f1);
l5.setForeground(Color.GREEN);

t1=new JTextField();
t1.setBounds(250,50,150,30);
f.add(t1);
t1.setFont(f1);

t2=new JTextField();
t2.setBounds(250,130,150,30);
f.add(t2);
t2.setFont(f1);
t2.addKeyListener(this);

t3=new JTextArea();
t3.setBounds(250,210,150,100);
f.add(t3);
t3.setFont(f1);

t4=new JTextField();
t4.setBounds(250,360,150,30);
f.add(t4);
t4.setFont(f1);
t4.addKeyListener(this);

t5=new JTextField();
t5.setBounds(250,440,150,30);
f.add(t5);
t5.setFont(f1);

b1=new JButton("Update");
b1.setBounds(60,510,90,30);
f.add(b1);
b1.setFont(f1);
b1.addActionListener(this);

b2=new JButton("Reset");
b2.setBounds(190,510,90,30);
f.add(b2);
b2.setFont(f1);
b2.addActionListener(this);

b3=new JButton("Back");
b3.setBounds(320,510,90,30);
f.add(b3);
b3.setFont(f1);
b3.addActionListener(this);

b4=new JButton("Search");
b4.setBounds(450,50,100,30);
f.add(b4);
b4.setFont(f1);
b4.addActionListener(this);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/medical","root","");
}
catch(Exception e)
{
System.out.print(e);
}
f.setVisible(true);
t1.requestFocus();
}// end of ctor


public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
id=t1.getText();
nm=t2.getText();
addr=t3.getText();
mob=t4.getText();
eml=t5.getText();
try
{
st=con.prepareStatement("Update vendor set name=?,address=?,mobile=?,email_id=? where vendor_id=?");
st.setString(1,nm);
st.setString(2,addr);
st.setString(3,mob);
st.setString(4,eml);
st.setString(5,id);
st.executeUpdate();
JOptionPane.showMessageDialog(f,"Successfully Updated");
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t1.requestFocus();
}
catch(Exception e)
{
System.out.print(e);
}
}
else if(ae.getSource()==b3)
{
f.dispose();
VendorDetails vd=new VendorDetails();
}

else if(ae.getSource()==b2)
{
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t1.requestFocus();
}
else if(ae.getSource()==b4)
{
id=t1.getText();
try
{
st=con.prepareStatement("select * from vendor where vendor_id=?");
st.setString(1,id);
rs=st.executeQuery();
if(rs.next())
{
nm=rs.getString(2);
addr=rs.getString(3);
mob=rs.getString(4);
eml=rs.getString(5);
t2.setText(nm);
t3.setText(addr);
t4.setText(mob);
t5.setText(eml);
}
else
{
JOptionPane.showMessageDialog(f,"Invalid vendor id");
}
}
catch(Exception e)
{
System.out.print(e);
}
}
}
public void keyPressed(KeyEvent ke)
{
}

public void keyReleased(KeyEvent ke)
{
}
public void keyTyped(KeyEvent ke)
{
if(ke.getSource()==t2)
{
char c=ke.getKeyChar();
if((c>='a' && c<='z') || (c>='A' && c<='Z'))
{
}
else
{
ke.consume();
}
}
else if(ke.getSource()==t4)
{
char c=ke.getKeyChar();
if(c>='0' && c<='9')
{
}
else 
{
ke.consume();
}
}// end of if else
}// end of keytype mathed

} // end of class

class Updatevenderdemo
{
public static void main(String[] s)
{
Updatevender v=new Updatevender();
}
}