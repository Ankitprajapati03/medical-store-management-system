// change password 
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class Changepassword implements KeyListener,ActionListener
{
JFrame f;
JLabel l1,l2,l3,l4;
JTextField t1;
JPasswordField t2,t3,t4;
JButton b1,b2,b3;
Font f1;
Connection con;
PreparedStatement st;
ResultSet rs;
ImageIcon im;

Changepassword()
{
f=new JFrame("Change Password");
f.setSize(450,500);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//set a image on this frame
im=new ImageIcon("fingerprint-ga61578140_1920.jpg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,450,500);
f.add(bg);



f1=new Font("Arial",Font.BOLD,14);

l1=new JLabel("User Name");
l1.setBounds(50,50,150,30);
bg.add(l1);
l1.setFont(f1);
l1.setForeground(Color.RED);

l2=new JLabel("Old Password");
l2.setBounds(50,130,150,30);
bg.add(l2);
l2.setFont(f1);
l2.setForeground(Color.RED);

l3=new JLabel("New Password");
l3.setBounds(50,210,150,30);
bg.add(l3);
l3.setFont(f1);
l3.setForeground(Color.RED);

l4=new JLabel("Confirm Password");
l4.setBounds(50,290,150,30);
bg.add(l4);
l4.setFont(f1);
l4.setForeground(Color.RED);


t1=new JTextField();
t1.setBounds(250,50,150,30);
t1.addKeyListener(this);
bg.add(t1);
t1.setFont(f1);
t1.setForeground(Color.RED);

t2=new JPasswordField();
t2.setBounds(250,130,150,30);
bg.add(t2);
t2.setFont(f1);
t2.setForeground(Color.RED);

t3=new JPasswordField();
t3.setBounds(250,210,150,30);
bg.add(t3);
t3.setFont(f1);
t3.setForeground(Color.RED);

t4=new JPasswordField();
t4.setBounds(250,290,150,30);
bg.add(t4);
t4.setFont(f1);
t4.setForeground(Color.RED);

b1=new JButton("Change");
b1.setBounds(60,370,100,30);
bg.add(b1);
b1.setFont(f1);
b1.addActionListener(this);
b1.setForeground(Color.BLUE);

b2=new JButton("Reset");
b2.setBounds(190,370,100,30);
bg.add(b2);
b2.setFont(f1);
b2.addActionListener(this);
b2.setForeground(Color.BLUE);


b3=new JButton("Back");
b3.setBounds(320,370,100,30);
bg.add(b3);
b3.setFont(f1);
b3.addActionListener(this);
b3.setForeground(Color.BLUE);

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
}// end of ctor

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
String un,opswd,npswd,cpswd;
un=t1.getText();
opswd=t2.getText();
npswd=t3.getText();
cpswd=t4.getText();
if(npswd.equals(cpswd))
{
try
{
st=con.prepareStatement("select * from login where username=? and password=?");
st.setString(1,un);
st.setString(2,opswd);
rs=st.executeQuery();
if(rs.next())
{
st=con.prepareStatement("update login set password=? where username=?");
st.setString(1,npswd);
st.setString(2,un);
st.executeUpdate();
JOptionPane.showMessageDialog(f,"Password Changed Successfully");
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t1.requestFocus();
}
else
{
JOptionPane.showMessageDialog(f,"invalid user name/Password");
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
}
}
catch(Exception e)
{
System.out.print(e);
}
}
else
{
JOptionPane.showMessageDialog(f,"New Password and Confirm Passwrod did not Match");
}
}
else if(ae.getSource()==b2)
{
t1.setText("");
t2.setText("");
t1.requestFocus();
}
else if(ae.getSource()==b3)
{
Login l=new Login();
f.dispose();
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
char ch=ke.getKeyChar();
if((ch>='a' && ch<='z')||(ch>='A' && ch<='Z')||(ch>='0' && ch<='9'))
{
}
else{
ke.consume();
}
}
}
class Changepassworddemo
{
public static void main(String s[])
{
Changepassword cp=new Changepassword();
}
}