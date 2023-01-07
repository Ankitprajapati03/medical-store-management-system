// design a purchase screen for medicine
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;

class Purchase implements ActionListener,KeyListener
{
JFrame f;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
JComboBox cb1,cb2;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
JButton b1,b2,b3,b4,b5,b6,b7,b8;
Font f1;
JTable tb;
JScrollPane js;
DefaultTableModel model;
Connection con;
ResultSet rs;
PreparedStatement st;
String mnm,ctgry,mdate,edate,mrp,less,dis,nunit,vid,cmid,amt;
int r;

Purchase()
{
f=new JFrame("Purchase Medicine");
f.setSize(700,700);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


f1=new Font("Arial",Font.BOLD,14);

// Jtable
tb=new JTable();
model=new DefaultTableModel();
String heads[]={"vender_id","company_id","medicine","categary","menufacturing_date","expire_date","mrp","less","discount","number_of_unit","amount"};
model.setColumnIdentifiers(heads);
tb.setModel(model);
js=new JScrollPane(tb);
js.setBounds(30,430,630,170);
f.add(js);

b4=new JButton("Remove");
b4.setBounds(40,610,100,30);
f.add(b4);
b4.setFont(f1);
b4.setForeground(Color.BLUE);
b4.addActionListener(this);

b5=new JButton("Edit");
b5.setBounds(170,610,100,30);
f.add(b5);
b5.setFont(f1);
b5.addActionListener(this);
b5.setForeground(Color.BLUE);

b6=new JButton("Clear All");
b6.setBounds(300,610,150,30);
f.add(b6);
b6.setFont(f1);
b6.setForeground(Color.BLUE);
b6.addActionListener(this);


b7=new JButton("Purchase");
b7.setBounds(480,610,100,30);
f.add(b7);
b7.setFont(f1);
b7.setForeground(Color.BLUE);
b7.addActionListener(this);



l1=new JLabel("Vender ID");
l1.setBounds(30,30,150,30);
f.add(l1);
l1.setFont(f1);
l1.setForeground(Color.GREEN);

l2=new JLabel("Company ID");
l2.setBounds(30,100,150,30);
f.add(l2);
l2.setFont(f1);
l2.setForeground(Color.GREEN);


l3=new JLabel("Medicine");
l3.setBounds(30,170,150,30);
f.add(l3);
l3.setFont(f1);
l3.setForeground(Color.GREEN);


l4=new JLabel("Categery");
l4.setBounds(30,240,150,30);
f.add(l4);
l4.setFont(f1);
l4.setForeground(Color.GREEN);

l5=new JLabel("Menufacturing Date");
l5.setBounds(30,310,150,30);
f.add(l5);
l5.setFont(f1);
l5.setForeground(Color.GREEN);

l6=new JLabel("Expire Date");
l6.setBounds(400,30,150,30);
f.add(l6);
l6.setFont(f1);
l6.setForeground(Color.GREEN);


l7=new JLabel("MRP");
l7.setBounds(400,85,150,30);
f.add(l7);
l7.setFont(f1);
l7.setForeground(Color.GREEN);


l8=new JLabel("Less");
l8.setBounds(400,140,150,30);
f.add(l8);
l8.setFont(f1);
l8.setForeground(Color.GREEN);


l9=new JLabel("Discount");
l9.setBounds(400,195,150,30);
f.add(l9);
l9.setFont(f1);
l9.setForeground(Color.GREEN);


l10=new JLabel("NO.Of Units");
l10.setBounds(400,250,150,30);
f.add(l10);
l10.setFont(f1);
l10.setForeground(Color.GREEN);


l11=new JLabel("Amount");
l11.setBounds(400,300,150,30);
f.add(l11);
l11.setFont(f1);
l11.setForeground(Color.GREEN);

cb1=new JComboBox();
cb1.setBounds(230,30,100,30);
f.add(cb1);
cb1.setFont(f1);
cb1.setForeground(Color.GREEN);

cb2=new JComboBox();
cb2.setBounds(230,100,100,30);
f.add(cb2);
cb2.setFont(f1);
cb2.setForeground(Color.GREEN);

t1=new JTextField();
t1.setBounds(230,170,100,30);
f.add(t1);
t1.setFont(f1);
t1.setForeground(Color.BLUE);
t1.addKeyListener(this);


t2=new JTextField();
t2.setBounds(230,240,100,30);
f.add(t2);
t2.setFont(f1);
t2.setForeground(Color.BLUE);
t2.addKeyListener(this);

t3=new JTextField();
t3.setBounds(230,310,100,30);
f.add(t3);
t3.setFont(f1);
t3.setForeground(Color.BLUE);
t3.addKeyListener(this);

t4=new JTextField();
t4.setBounds(560,30,100,30);
f.add(t4);
t4.setFont(f1);
t4.setForeground(Color.BLUE);
t4.addKeyListener(this);

t5=new JTextField();
t5.setBounds(560,85,100,30);
f.add(t5);
t5.setFont(f1);
t5.setForeground(Color.BLUE);
t5.addKeyListener(this);

t6=new JTextField();
t6.setBounds(560,140,100,30);
f.add(t6);
t6.setFont(f1);
t6.setForeground(Color.BLUE);
t6.addKeyListener(this);

t7=new JTextField();
t7.setBounds(560,195,100,30);
f.add(t7);
t7.setFont(f1);
t7.setForeground(Color.BLUE);
t7.addKeyListener(this);

t8=new JTextField();
t8.setBounds(560,250,100,30);
f.add(t8);
t8.setFont(f1);
t8.setForeground(Color.BLUE);
t8.addKeyListener(this);

t9=new JTextField();
t9.setBounds(560,300,100,30);
f.add(t9);
t9.setFont(f1);
t9.setForeground(Color.BLUE);
t9.addKeyListener(this);


b8=new JButton("total");
b8.setBounds(570,335,70,20);
f.add(b8);
b8.setForeground(Color.BLUE);
b8.addActionListener(this);


b1=new JButton("ADD");
b1.setBounds(150,370,100,30);
f.add(b1);
b1.setFont(f1);
b1.setForeground(Color.BLUE);
b1.addActionListener(this);


b2=new JButton("Reset");
b2.setBounds(300,370,100,30);
f.add(b2);
b2.setFont(f1);
b2.setForeground(Color.BLUE);
b2.addActionListener(this);

b3=new JButton("Back");
b3.setBounds(450,370,100,30);
f.add(b3);
b3.setFont(f1);
b3.setForeground(Color.BLUE);
b3.addActionListener(this);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/medical","root","");
st=con.prepareStatement("select vendor_id from vendor");//for vender id show in combobox
rs=st.executeQuery();
while(rs.next())
{
cb1.addItem(rs.getString(1));
}
st=con.prepareStatement("select company_id from company");// for company id show in combobox
rs=st.executeQuery();
while(rs.next())
{
cb2.addItem(rs.getString(1));
}

}
catch(Exception ex)
{
System.out.print(ex);
}


f.setVisible(true);
t1.requestFocus();
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
vid=cb1.getSelectedItem().toString();
cmid=cb2.getSelectedItem().toString();
mnm=t1.getText();
ctgry=t2.getText();
mdate=t3.getText();
edate=t4.getText();
mrp=t5.getText();
less=t6.getText();
dis=t7.getText();
nunit=t8.getText();
amt=t9.getText();




try
/*{
st=con.prepareStatement("insert into Purchase values(?,?,?,?,?,?,?,?,?,?)");
st.setString(1,vid);
st.setString(2,cmid);
st.setString(3,mnm);
st.setString(4,ctgry);
st.setString(5,mdate);
st.setString(6,edate);
st.setString(7,mrp);
st.setString(8,less);
st.setString(9,dis);
st.setString(10,nunit);
 r=st.executeUpdate();
{
if(r>0)*/
{
JOptionPane.showMessageDialog(null,"Data stored successfully");
model.addRow(new Object[]{vid,cmid,mnm,ctgry,mdate,edate,mrp,less,dis,nunit,amt});
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
t9.setText("");
t1.requestFocus();
}
/*else
{
JOptionPane.showMessageDialog(null,"Error in storing Data");
}
}//try*/
catch(Exception ex)
{
System.out.print(ex);
}
}

else if(ae.getSource()==b6)
{
model.setRowCount(0);
}

else if(ae.getSource()==b8)
{
int tot=0,temp=0,temp1=0;

mrp=t5.getText();
less=t6.getText();
dis=t7.getText();
nunit=t8.getText();

temp=temp+Integer.parseInt(mrp);
temp=temp-Integer.parseInt(less);
temp1=temp*Integer.parseInt(nunit);
//temp1=temp1+temp;
temp1=(temp1*Integer.parseInt(dis))/100;
tot=tot+temp;
tot=tot*Integer.parseInt(nunit);
//tot=tot+tot;
tot=tot-temp1;
JOptionPane.showMessageDialog(null,"Total Amount is : " + tot);
amt=Integer.toString(tot);// convert integer into string
t9.setText(amt);
}

else if(ae.getSource()==b7)
{
int tot=0;
int rw=tb.getRowCount();

for(int i=0;i<rw;i++)
{
vid=(String) model.getValueAt(i,0);
cmid=(String) model.getValueAt(i,1);
mnm=(String) model.getValueAt(i,2);
ctgry=(String) model.getValueAt(i,3);
mdate=(String) model.getValueAt(i,4);
edate=(String) model.getValueAt(i,5);
mrp=(String) model.getValueAt(i,6);
less=(String) model.getValueAt(i,7);
dis=(String) model.getValueAt(i,8);
nunit=(String) model.getValueAt(i,9);
amt=(String) model.getValueAt(i,10);
tot=tot+Integer.parseInt(amt);
try
{
st=con.prepareStatement("insert into Purchase values(?,?,?,?,?,?,?,?,?,?,?)");
st.setString(1,vid);
st.setString(2,cmid);
st.setString(3,mnm);
st.setString(4,ctgry);
st.setString(5,mdate);
st.setString(6,edate);
st.setString(7,mrp);
st.setString(8,less);
st.setString(9,dis);
st.setString(10,nunit);
st.setString(11,amt);
int r=st.executeUpdate();
}//try
catch(Exception ex)
{
System.out.print(ex);
}//catch
}
JOptionPane.showMessageDialog(null,"Total Amount is : " + tot);
model.setRowCount(0);


}//else if

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
t9.setText("");
t1.requestFocus();
}

//b5
else if(ae.getSource()==b5)
{

int rm=tb.getSelectedRow();
if(rm>=0)
{
vid=(String) model.getValueAt(rm,0);
cmid=(String) model.getValueAt(rm,1);
mnm=(String) model.getValueAt(rm,2);
ctgry=(String) model.getValueAt(rm,3);
mdate=(String) model.getValueAt(rm,4);
edate=(String) model.getValueAt(rm,5);
mrp=(String) model.getValueAt(rm,6);
less=(String) model.getValueAt(rm,7);
dis=(String) model.getValueAt(rm,8);
nunit=(String) model.getValueAt(rm,9);
amt=(String) model.getValueAt(rm,10);

//t1.setText(vid);
//t2.setText(cmid);
t1.setText(mnm);
t2.setText(ctgry);
t3.setText(mdate);
t4.setText(edate);
t5.setText(mrp);
t6.setText(less);
t7.setText(dis);
t8.setText(nunit);
t9.setText(amt);

model.removeRow(rm);
}
else 
{
JOptionPane.showMessageDialog(f,"please select row---> ?");
}
}



else if(ae.getSource()==b3)
{
Main m=new Main();
f.dispose();
}


else if(ae.getSource()==b4)
{

int rm=tb.getSelectedRow();
if(rm>=0)
{
model.removeRow(rm);
}

else
{
JOptionPane.showMessageDialog(null,"Please select the row");
}
}

else if(ae.getSource()==b6)
{

}

}//action


public void keyPressed(KeyEvent ke)
{
}

public void keyReleased(KeyEvent ke)
{
}
public void keyTyped(KeyEvent ke)
{
if(ke.getSource()==t1)
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
else if(ke.getSource()==t2)
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
if(c>='0' && c<='9')
{
}
else 
{
ke.consume();
}
}

else if(ke.getSource()==t5)
{
char c=ke.getKeyChar();
if(c>='0' && c<='9')
{
}
else 
{
ke.consume();
}
}

else if(ke.getSource()==t6)
{
char c=ke.getKeyChar();
if(c>='0' && c<='9')
{
}
else 
{
ke.consume();
}
}

else if(ke.getSource()==t7)
{
char c=ke.getKeyChar();
if(c>='0' && c<='9')
{
}
else 
{
ke.consume();
}
}


else if(ke.getSource()==t8)
{
char c=ke.getKeyChar();
if(c>='0' && c<='9')
{
}
else 
{
ke.consume();
}
}


else if(ke.getSource()==t9)
{
char c=ke.getKeyChar();
if(c>='0' && c<='9')
{
}
else 
{
ke.consume();
}
}


}//end of keytyped mathed


}//class

class PurchaseDemo
{
public static void main(String s[])
{
Purchase p=new Purchase();
}
}