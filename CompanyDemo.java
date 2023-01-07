// add new company
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Company implements KeyListener,ActionListener
{
JFrame f;
JLabel l1,l2,l3;
JTextField t1,t2;
JTextArea t3;
JButton b1,b2,b3;
Font f1;
Connection con;
PreparedStatement st;
ResultSet rs;
String id,nm,addr;

Company()
{
f=new JFrame("Add New Company");
f.setSize(500,480);
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
t1.setBounds(280,50,150,30);
t1.setFont(f1);
f.add(t1);
t1.setEditable(false);

t2=new JTextField();
t2.setBounds(280,130,150,30);
t2.setFont(f1);
f.add(t2);
t2.addKeyListener(this);

t3=new JTextArea();
t3.setBounds(280,210,150,100);
t3.setFont(f1);
f.add(t3);

b1=new JButton("Submit");
b1.setBounds(60,360,100,30);
b1.setFont(f1);
f.add(b1);
b1.setForeground(Color.BLUE);
b1.addActionListener(this);


b2=new JButton("Reset");
b2.setBounds(200,360,100,30);
b2.setFont(f1);
f.add(b2);
b2.setForeground(Color.BLUE);
b2.addActionListener(this);

b3=new JButton("Back");
b3.setBounds(340,360,100,30);
b3.setFont(f1);
f.add(b3);
b3.setForeground(Color.BLUE);
b3.addActionListener(this);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/medical","root","");
st=con.prepareStatement("select max(company_id) from company");
rs=st.executeQuery();
if(rs.next())
{
id=rs.getString(1);
id=id.substring(1);
int rn=Integer.parseInt(id)+1;
id="c"+String.valueOf(rn);
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
addr=t3.getText();
try
{
st=con.prepareStatement("insert into company values(?,?,?)");
st.setString(1,id);
st.setString(2,nm);
st.setString(3,addr);
st.executeUpdate();
JOptionPane.showMessageDialog(f,"Successfully Store Data");
id=id.substring(1);
int rn=Integer.parseInt(id)+1;
id="c"+String.valueOf(rn);
t1.setText(id);
t2.setText("");
t3.setText("");
t2.requestFocus();
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

else if(ae.getSource()==b2)
{
t2.setText("");
t3.setText("");
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

class CompanyDemo
{
public static void main(String[] s)
{
Company c=new Company();
}
}