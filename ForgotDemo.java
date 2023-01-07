// for forgote password
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

class Forgot implements ActionListener
{
JFrame f;
JLabel l1;
JTextField t1;
JTextArea a;
JButton b1,b2,b3;
Connection con;
PreparedStatement st;
ResultSet rs;
Forgot()
{
f=new JFrame("Forgot Password");
f.setSize(420,300);
f.setLayout(null);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

l1=new JLabel("User Name");
l1.setBounds(40,30,100,30);
f.add(l1);


t1=new JTextField();
t1.setBounds(230,30,120,30);
f.add(t1);

b1=new JButton("Show Password");
b1.setBounds(40,100,150,30);
f.add(b1);
b1.addActionListener(this);

b2=new JButton("Reset");
b2.setBounds(240,100,100,30);
f.add(b2);
b2.addActionListener(this);

b3=new JButton("Back");
b3.setBounds(240,200,100,30);
f.add(b3);
b3.addActionListener(this);

a=new JTextArea();
a.setBounds(40,160,150,80);
f.add(a);

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

}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
String nm,pswd;
nm=t1.getText();
try
{
st=con.prepareStatement("select * from login where username=?");
st.setString(1,nm);
rs=st.executeQuery();
if(rs.next())
{
JOptionPane.showMessageDialog(f,"click on OK");
pswd=rs.getString(2);
a.setText(pswd);
}
else
{
JOptionPane.showMessageDialog(f,"Invalid username");
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
t1.requestFocus();
}
else if(ae.getSource()==b3)
{
f.dispose();
Login l=new Login();
}
}//ctor
}//forgot class

class ForgotDemo
{
public static void main(String[] s)
{
Forgot f=new Forgot();
}
}