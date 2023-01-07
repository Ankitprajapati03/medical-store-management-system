// update company details
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class UpdateCompany implements KeyListener,ActionListener
{
JFrame f;
JLabel l1,l2,l3;
JTextField t1,t2;
JTextArea t3;
JButton b1,b2,b3,b4;
Font f1;
Connection con;
PreparedStatement st;
ResultSet rs;
String id,nm,addr;

UpdateCompany()
{
f=new JFrame("Update Company Details");
f.setSize(530,480);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

f1=new Font("Arial Black",Font.BOLD,16);

l1=new JLabel("Company Id");
l1.setBounds(50,50,150,30);
f.add(l1);
l1.setFont(f1);
l1.setForeground(Color.GREEN);


l2=new JLabel("Name");
l2.setBounds(50,130,100,30);
l2.setFont(f1);
f.add(l2);
l2.setForeground(Color.GREEN);

l3=new JLabel("Address");
l3.setBounds(50,210,100,30);
f.add(l3);
l3.setFont(f1);
l3.setForeground(Color.GREEN);

t1=new JTextField();
t1.setBounds(250,50,100,30);
t1.setFont(f1);
f.add(t1);

t2=new JTextField();
t2.setBounds(250,130,100,30);
t2.setFont(f1);
f.add(t2);
t2.addKeyListener(this);

t3=new JTextArea();
t3.setBounds(250,210,100,100);
t3.setFont(f1);
f.add(t3);

b1=new JButton("Update");
b1.setBounds(50,360,130,30);
b1.setFont(f1);
f.add(b1);
b1.setForeground(Color.BLUE);
b1.addActionListener(this);


b2=new JButton("Reset");
b2.setBounds(220,360,100,30);
b2.setFont(f1);
f.add(b2);
b2.setForeground(Color.BLUE);
b2.addActionListener(this);

b3=new JButton("Back");
b3.setBounds(370,360,100,30);
b3.setFont(f1);
f.add(b3);
b3.setForeground(Color.BLUE);
b3.addActionListener(this);

b4=new JButton("Search");
b4.setBounds(390,50,100,30);
b4.setFont(f1);
f.add(b4);
b4.setForeground(Color.BLUE);
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
t2.requestFocus();
f.setVisible(true);
}// end of ctor

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
id=t1.getText();
nm=t2.getText();
addr=t3.getText();
try
{
st=con.prepareStatement("Update company set name=?,address=? where company_id=?");
st.setString(1,nm);
st.setString(2,addr);
st.setString(3,id);
st.executeUpdate();
JOptionPane.showMessageDialog(f,"Successfully Updated");
t1.setText("");
t2.setText("");
t3.setText("");
t1.requestFocus();
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
t3.setText("");
t1.requestFocus();
}

else if(ae.getSource()==b4)
{
id=t1.getText();
try
{
st=con.prepareStatement("select * from company where company_id=?");
st.setString(1,id);
rs=st.executeQuery();
if(rs.next())
{
nm=rs.getString(2);
addr=rs.getString(3);
t2.setText(nm);
t3.setText(addr);
}
else
{
JOptionPane.showMessageDialog(f,"Invalid Company id");
}
}
catch(Exception e)
{
System.out.print(e);
}
}
else if(ae.getSource()==b3)
{
CompanyDetails cd=new CompanyDetails();
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
if((c>='a' && c<='z') || (c>='A' && c<='Z'))
{
}
else
{
ke.consume();
}
}//end of keytyped mathed
}// end of class

class UpdateCompanyDemo
{
public static void main(String[] s)
{
UpdateCompany cu=new UpdateCompany();
}
}