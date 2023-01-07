// Delete medicin details
import javax.swing.*;
import java .awt.*;
import java.awt.event.*;
import java.sql.*;

class DeleteMedicine implements ActionListener,KeyListener
{
JFrame f;
JLabel l1,l2,l3,l4,l5,l6,l7,l8;
JTextField t1,t2,t3,t4,t5,t6,t7,t8;
JButton b1,b2,b3,b4;
Font f1;
Connection con;
PreparedStatement st;
ResultSet rs;
String id,mn,cn,mrp,up,typ,sdate,edate; 


DeleteMedicine()
{
f=new JFrame("Delete Medicine Details");
f.setSize(570,720);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

f1=new Font("Arial",Font.BOLD,14);

l1=new JLabel("Medicine ID");
l1.setBounds(50,50,150,30);
l1.setFont(f1);
f.add(l1);
l1.setForeground(Color.BLUE);

l2=new JLabel("Medicine name");
l2.setBounds(50,120,150,30);
l2.setFont(f1);
f.add(l2);
l2.setForeground(Color.BLUE);

l3=new JLabel("Company name");
l3.setBounds(50,190,150,30);
l3.setFont(f1);
f.add(l3);
l3.setForeground(Color.BLUE);

l4=new JLabel("M.R.P.");
l4.setBounds(50,260,150,30);
l4.setFont(f1);
f.add(l4);
l4.setForeground(Color.BLUE);

l5=new JLabel("Unit Price");
l5.setBounds(50,330,150,30);
l5.setFont(f1);
f.add(l5);
l5.setForeground(Color.BLUE);

l6=new JLabel("Type");
l6.setBounds(50,400,150,30);
l6.setFont(f1);
f.add(l6);
l6.setForeground(Color.BLUE);

l7=new JLabel("Menufacturing Date");
l7.setBounds(50,470,150,30);
l7.setFont(f1);
f.add(l7);
l7.setForeground(Color.BLUE);

l8=new JLabel("Expire Date");
l8.setBounds(50,540,150,30);
l8.setFont(f1);
f.add(l8);
l8.setForeground(Color.BLUE);

t1=new JTextField();
t1.setBounds(260,50,150,30);
t1.setFont(f1);
f.add(t1);

t2=new JTextField();
t2.setBounds(260,120,150,30);
t2.setFont(f1);
f.add(t2);
t2.addKeyListener(this);

t3=new JTextField();
t3.setBounds(260,190,150,30);
t3.setFont(f1);
f.add(t3);
t3.addKeyListener(this);

t4=new JTextField();
t4.setBounds(260,260,150,30);
t4.setFont(f1);
f.add(t4);
t4.addKeyListener(this);

t5=new JTextField();
t5.setBounds(260,330,150,30);
t5.setFont(f1);
f.add(t5);
t5.addKeyListener(this);

t6=new JTextField();
t6.setBounds(260,400,150,30);
t6.setFont(f1);
f.add(t6);
t6.addKeyListener(this);

t7=new JTextField();
t7.setBounds(260,470,150,30);
t7.setFont(f1);
f.add(t7);
t7.addKeyListener(this);

t8=new JTextField();
t8.setBounds(260,540,150,30);
t8.setFont(f1);
f.add(t8);
t8.addKeyListener(this);

b1=new JButton("Delete");
b1.setBounds(60,620,100,30);
b1.setFont(f1);
f.add(b1);
b1.setForeground(Color.GREEN);
b1.addActionListener(this);


b2=new JButton("Reset");
b2.setBounds(200,620,100,30);
b2.setFont(f1);
f.add(b2);
b2.setForeground(Color.GREEN);
b2.addActionListener(this);


b3=new JButton("Back");
b3.setBounds(340,620,100,30);
b3.setFont(f1);
f.add(b3);
b3.setForeground(Color.GREEN);
b3.addActionListener(this);



b4=new JButton("Search");
b4.setBounds(440,50,100,30);
b4.setFont(f1);
f.add(b4);
b4.setForeground(Color.GREEN);
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
}// end of ctor

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
id=t1.getText();
mn=t2.getText();
cn=t3.getText();
mrp=t4.getText();
up=t5.getText();
typ=t6.getText();
sdate=t7.getText();
edate=t8.getText();
try
{
st=con.prepareStatement("delete from medicine where m_id=?");
st.setString(1,id);
st.executeUpdate();
JOptionPane.showMessageDialog(f,"Successfully Deleted");
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
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
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
t1.requestFocus();
}
else if(ae.getSource()==b3)
{
MedicineDetails md=new MedicineDetails();
f.dispose();
}

else if(ae.getSource()==b4)
{
id=t1.getText();
try
{
st=con.prepareStatement("select * from medicine where m_id=?");
st.setString(1,id);
rs=st.executeQuery();
if(rs.next())
{
mn=rs.getString(2);
cn=rs.getString(3);
mrp=rs.getString(4);
up=rs.getString(5);
typ=rs.getString(6);
sdate=rs.getString(7);
edate=rs.getString(8);
t2.setText(mn);
t3.setText(cn);
t4.setText(mrp);
t5.setText(up);
t6.setText(typ);
t7.setText(sdate);
t8.setText(edate);
}
else{
JOptionPane.showMessageDialog(f,"Invalid M_id");
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
}}

else if(ke.getSource()==t3)
{
char c=ke.getKeyChar();
if((c>='a' && c<='z') || (c>='A' && c<='Z'))
{
}
else
{
ke.consume();
}}

else if(ke.getSource()==t4)
{
char c=ke.getKeyChar();
if(c>='0' && c<='9') 
{
}
else
{
ke.consume();
}}

else if(ke.getSource()==t5)
{
char c=ke.getKeyChar();
if(c>='0' && c<='9') 
{
}
else
{
ke.consume();
}}

else if(ke.getSource()==t6)
{
char c=ke.getKeyChar();
if((c>='a' && c<='z') || (c>='A' && c<='Z'))
{
}
else
{
ke.consume();
}}

else if(ke.getSource()==t7)
{
char c=ke.getKeyChar();
if(c>='0' && c<='9') 
{
}
else
{
ke.consume();
}}

else if(ke.getSource()==t8)
{
char c=ke.getKeyChar();
if(c>='0' && c<='9')
{
}
else
{
ke.consume();
}}
}



}// end of class 
class DeleteMedicineDemo
{
public static void main(String[] s)
{
DeleteMedicine dm=new DeleteMedicine();
}
}