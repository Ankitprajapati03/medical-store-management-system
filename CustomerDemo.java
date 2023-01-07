//design a screen for customer
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Customer implements ActionListener,KeyListener
{
JFrame f;
JLabel l1,l2,l3,l4;
JTextField t1,t2,t3,t4;
JButton b1,b2,b3;
Font f1;
Connection con;
PreparedStatement st;
ResultSet rs;
String id,nm,dises,mob;


Customer()
{
f=new JFrame("New Customer");
f.setSize(500,550);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


f1=new Font("Arial",Font.BOLD,14);

l1=new JLabel("Customer ID");
l1.setBounds(50,50,150,30);
f.add(l1);
l1.setForeground(Color.GREEN);
l1.setFont(f1);

l2=new JLabel("Customer name");
l2.setBounds(50,130,150,30);
f.add(l2);
l2.setFont(f1);
l2.setForeground(Color.GREEN);

l3=new JLabel("Mobile number");
l3.setBounds(50,210,150,30);
f.add(l3);
l3.setFont(f1);
l3.setForeground(Color.GREEN);

l4=new JLabel("Disease");
l4.setBounds(50,290,150,30);
f.add(l4);
l4.setForeground(Color.GREEN);
l4.setFont(f1);


t1=new JTextField();
t1.setBounds(250,50,150,30);
f.add(t1);
t1.setForeground(Color.BLUE);
t1.setFont(f1);
t1.setEditable(false);


t2=new JTextField();
t2.setBounds(250,130,150,30);
f.add(t2);
t2.setForeground(Color.BLUE);
t2.setFont(f1);
t2.addKeyListener(this);

t3=new JTextField();
t3.setBounds(250,210,150,30);
f.add(t3);
t3.setForeground(Color.BLUE);
t3.setFont(f1);
t3.addKeyListener(this);

t4=new JTextField();
t4.setBounds(250,290,150,30);
f.add(t4);
t4.setForeground(Color.BLUE);
t4.setFont(f1);
t4.addKeyListener(this);

b1=new JButton("Submit");
b1.setBounds(60,370,100,30);
f.add(b1);
b1.setForeground(Color.BLUE);
b1.setFont(f1);
b1.addActionListener(this);


b2=new JButton("Reset");
b2.setBounds(200,370,100,30);
f.add(b2);
b2.setForeground(Color.BLUE);
b2.setFont(f1);
b2.addActionListener(this);


b3=new JButton("Back");
b3.setBounds(340,370,100,30);
f.add(b3);
b3.setForeground(Color.BLUE);
b3.setFont(f1);
b3.addActionListener(this);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/medical","root","");
st=con.prepareStatement("select max(cs_id) from Customer");
rs=st.executeQuery();
if(rs.next())
{
id=rs.getString(1);
id=id.substring(2);
int rn=Integer.parseInt(id)+1;
id="cs"+String.valueOf(rn);
t1.setText(id);
}
}
catch(Exception e)
{
System.out.print(e);
}
t2.requestFocus();
f.setVisible(true);
}// end of ctor

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
id=t1.getText();
nm=t2.getText();
mob=t3.getText();
dises=t4.getText();
try
{
st=con.prepareStatement("insert into Customer values(?,?,?,?)");
st.setString(1,id);
st.setString(2,nm);
st.setString(3,mob);
st.setString(4,dises);
st.executeUpdate();
JOptionPane.showMessageDialog(f,"Successfully added");
id=id.substring(2);
int rn=Integer.parseInt(id)+1;
id="cs"+String.valueOf(rn);
t1.setText(id);
t2.setText("");
t3.setText("");
t4.setText("");
t2.requestFocus();
}
catch(Exception e)
{
System.out.print(e);
}
}


else if(ae.getSource()==b3)
{
CustomerDetails csd=new CustomerDetails();
f.dispose();
}
else if(ae.getSource()==b2)
{
t2.setText("");
t3.setText("");
t4.setText("");
t2.requestFocus();
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
}}
else if(ke.getSource()==t3)
{
char c=ke.getKeyChar();
if(c>='0' && c<='9')
{
}
else 
{
ke.consume();
}}
else if(ke.getSource()==t4)
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
}
}// end of class
class CustomerDemo
{
public static void main(String s[])
{
Customer c=new Customer();
}
} 