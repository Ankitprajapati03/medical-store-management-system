// login page for medical store
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Login extends JFrame implements KeyListener,ActionListener
{
JFrame f;
JLabel l1,l2;
JTextField t1;
JPasswordField t2;
JButton b1,b2,b3,b4;
Font f1,f2;
Connection con;
PreparedStatement st;
ResultSet rs;
ImageIcon im;

Login()
{
f=new JFrame("Login screen");
f.setLayout(null);
f.setSize(480,400);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setResizable(false);
f.setLocation(400,100);
f1=new Font("Arial",Font.BOLD,14);
f2=new Font("Arial",Font.BOLD,16);

//set a image on this frame
im=new ImageIcon("everyday-basics-GJY1eAw6tn8-unsplash.jpg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,480,400);
f.add(bg);


l1=new JLabel("User Name");
l1.setBounds(50,50,100,30);
l1.setForeground(Color.RED);
bg.add(l1);
l1.setFont(f2);

l2=new JLabel("Password");
l2.setBounds(50,120,100,30);
l2.setForeground(Color.RED);
bg.add(l2);
l2.setFont(f2);

t1=new JTextField();
t1.setBounds(230,50,120,30);
t1.addKeyListener(this);
bg.add(t1);
t1.setFont(f1);
t1.setForeground(Color.RED);

t2=new JPasswordField();
t2.setBounds(230,120,120,30);
bg.add(t2);
t2.setFont(f1);
t2.setForeground(Color.RED);

b1=new JButton("Submit");
b1.setBounds(60,200,100,30);
bg.add(b1);
b1.setFont(f1);
b1.addActionListener(this);
b1.setForeground(Color.BLUE);

try 
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/medical","root","");
}
catch(Exception e)
{
System.out.print(e);
}


b2=new JButton("Reset");
b2.setBounds(280,200,100,30);
bg.add(b2);
b2.setFont(f1);
b2.addActionListener(this);
b2.setForeground(Color.BLUE);

b3=new JButton("Forgot Password");
b3.setBounds(60,260,170,30);
bg.add(b3);
b3.setFont(f1);
b3.setForeground(Color.BLUE);
b3.addActionListener(this);

b4=new JButton("Change Password");
b4.setBounds(270,260,170,30);
bg.add(b4);
b4.setFont(f1);
b4.addActionListener(this);
b4.setForeground(Color.BLUE);


f.setVisible(true);
}//end of ctor
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
String un,pswd;
un=t1.getText();
pswd=t2.getText();
try
{
st=con.prepareStatement("select * from login where username=? and password=?");
st.setString(1,un);
st.setString(2,pswd);
rs=st.executeQuery();
if(rs.next())
{
JOptionPane.showMessageDialog(f,"Login Successfully");
Main mn=new Main();
f.dispose();
}
else
{
JOptionPane.showMessageDialog(f,"invaid user name or password");
}
}
catch(Exception e)
{
System.out.print(e);
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
Forgot fp=new Forgot();
f.dispose();
}
else if(ae.getSource()==b4)
{
Changepassword cp=new Changepassword();
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
char c=ke.getKeyChar();
if((c>='a' && c<='z')||(c>='A' && c<='Z')||(c>='0' && c<='9'))
{
}
else 
{
ke.consume();
}//end of else
}//end of key mathod
}//end of class

class Logindemo
{
public static void main(String[] s)
{
Login l=new Login();
}
}