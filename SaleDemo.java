// design a screen for sales medicine
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.event.*;

class Sale implements ActionListener,KeyListener
{
	JFrame f;
	Font f1;
	JLabel l1,l2,l3,l4,l5,l6;
    
	JTextField t1,t2,t3,t4,t5,t6;
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	JTable tb;
	DefaultTableModel model;
	JScrollPane js;
	Connection con;
	ResultSet rs;
	PreparedStatement st;
	String medi,mrp,dis,price,unit,amount;

Sale()
{
f=new JFrame("Sale medicine");
f.setSize(700,700);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// f.setBackground(Color.RED);

f1=new Font("Arial",Font.BOLD,14);

tb=new JTable();
model=new DefaultTableModel();
String heads[]={"Medicine","MRP","discount","Price_per_unit","Number_Of_unit","Amount"};
model.setColumnIdentifiers(heads);
tb.setModel(model);
js=new JScrollPane(tb);
js.setBounds(50,320,600,250);//Jtable
f.add(js);

l1=new JLabel("Medicine");
l1.setBounds(30,30,150,30);
f.add(l1);
l1.setFont(f1);
l1.setForeground(Color.RED);


l2=new JLabel("MRP");
l2.setBounds(30,100,150,30);
f.add(l2);
l2.setFont(f1);
l2.setForeground(Color.RED);

l3=new JLabel("Discount");
l3.setBounds(30,170,150,30);
f.add(l3);
l3.setFont(f1);
l3.setForeground(Color.RED);

l4=new JLabel("Price per Unit");
l4.setBounds(370,30,150,30);
f.add(l4);
l4.setFont(f1);
l4.setForeground(Color.RED);

l5=new JLabel("N0.of Units");
l5.setBounds(370,100,150,30);
f.add(l5);
l5.setFont(f1);
l5.setForeground(Color.RED);

l6=new JLabel("Amount");
l6.setBounds(370,170,150,30);
f.add(l6);
l6.setFont(f1);
l6.setForeground(Color.RED);

t1=new JTextField();
t1.setBounds(220,30,100,30);
t1.setFont(f1);
f.add(t1);
t1.setForeground(Color.BLUE);
t1.addKeyListener(this);

t2=new JTextField();
t2.setBounds(220,100,100,30);
t2.setFont(f1);
f.add(t2);
t2.setForeground(Color.BLUE);
t2.addKeyListener(this);


t3=new JTextField();
t3.setBounds(220,170,100,30);
t3.setFont(f1);
f.add(t3);
t3.setForeground(Color.BLUE);
t3.addKeyListener(this);


t4=new JTextField();
t4.setBounds(560,30,100,30);
t4.setFont(f1);
f.add(t4);
t4.setForeground(Color.BLUE);
t4.addKeyListener(this);


t5=new JTextField();
t5.setBounds(560,100,100,30);
t5.setFont(f1);
f.add(t5);
t5.setForeground(Color.BLUE);
t5.addKeyListener(this);


t6=new JTextField();
t6.setBounds(560,170,100,30);
t6.setFont(f1);
f.add(t6);
t6.addKeyListener(this);
t6.setForeground(Color.BLUE);

b8=new JButton("Total");
b8.setBounds(575,215,70,20);
f.add(b8);
b8.setForeground(Color.BLUE);
b8.addActionListener(this);


b1=new JButton("ADD");
b1.setBounds(100,240,100,30);
b1.setFont(f1);
f.add(b1);
b1.setForeground(Color.BLUE);
b1.addActionListener(this);

b2=new JButton("Reset");
b2.setBounds(240,240,100,30);
b2.setFont(f1);
f.add(b2);
b2.setForeground(Color.BLUE);
b2.addActionListener(this);

b3=new JButton("Back");
b3.setBounds(380,240,100,30);
b3.setFont(f1);
f.add(b3);
b3.setForeground(Color.BLUE);
b3.addActionListener(this);

b4=new JButton("Remove");
b4.setBounds(60,600,100,30);
b4.setFont(f1);
f.add(b4);
b4.setForeground(Color.BLUE);
b4.addActionListener(this);

b5=new JButton("Edit");
b5.setBounds(190,600,100,30);
b5.setFont(f1);
f.add(b5);
b5.addActionListener(this);
b5.setForeground(Color.BLUE);


b6=new JButton("Cancel All");
b6.setBounds(310,600,150,30);
b6.setFont(f1);
f.add(b6);
b6.setForeground(Color.BLUE);
b6.addActionListener(this);

b7=new JButton("Bill");
b7.setBounds(510,600,100,30);
b7.setFont(f1);
f.add(b7);
b7.setForeground(Color.BLUE);
b7.addActionListener(this);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/medical","root","");
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
medi=t1.getText();
mrp=t2.getText();
dis=t3.getText();
price=t4.getText();
unit=t5.getText();
amount=t6.getText();


try
{
/*st=con.prepareStatement("insert into Sale values(?,?,?,?,?,?)");
st.setString(1,medi);
st.setString(2,mrp);
st.setString(3,dis);
st.setString(4,price);
st.setString(5,unit);
st.setString(6,amount);
int r=st.executeUpdate();
if(r>0)
{*/
JOptionPane.showMessageDialog(null,"Data stored successfully");
model.addRow(new Object[]{medi,mrp,dis,price,unit,amount});
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t1.requestFocus();
/*else
{
JOptionPane.showMessageDialog(null,"Error in storing Data");
}*/
}//try
catch(Exception ex)
{
System.out.print(ex);
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
t1.requestFocus();
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
}//b4

//b5
else if(ae.getSource()==b5)
{
	int rm=tb.getSelectedRow();




medi=(String) model.getValueAt(rm,0);
mrp=(String) model.getValueAt(rm,1);
dis=(String) model.getValueAt(rm,2);
price=(String) model.getValueAt(rm,3);
unit=(String) model.getValueAt(rm,4);
amount=(String) model.getValueAt(rm,5);

t1.setText(medi);
t2.setText(mrp);
t3.setText(dis);
t4.setText(price);
t5.setText(unit);
t6.setText(amount);

model.removeRow(rm);


}


else if(ae.getSource()==b8)                                   
{
int tot=0,temp=0;

dis=t3.getText();
price=t4.getText();
unit=t5.getText();

temp=temp+Integer.parseInt(price);
temp=temp*Integer.parseInt(unit);
temp=(temp*Integer.parseInt(dis))/100;
tot=tot+Integer.parseInt(price);
tot=tot*Integer.parseInt(unit);
tot=tot-temp;

JOptionPane.showMessageDialog(null,"Total Amount is : " + tot);
amount=Integer.toString(tot);// convert integer into string
t6.setText(amount);

}
else if(ae.getSource()==b7)                                   
{
int tot=0;
int rw=tb.getRowCount();
for(int i=0;i<rw;i++)
{
medi=(String) model.getValueAt(i,0);
mrp=(String) model.getValueAt(i,1);
dis=(String) model.getValueAt(i,2);
price=(String) model.getValueAt(i,3);
unit=(String) model.getValueAt(i,4);
amount=(String) model.getValueAt(i,5);
tot=tot+Integer.parseInt(amount);
try
{
st=con.prepareStatement("insert into sale values(?,?,?,?,?,?)");
st.setString(1,medi);
st.setString(2,mrp);
st.setString(3,dis);
st.setString(4,price);
st.setString(5,unit);
st.setString(6,amount);
int r=st.executeUpdate();
}
catch(Exception ex)
{
System.out.print(ex);
}//catch
}
JOptionPane.showMessageDialog(null,"Total Amount is : " + tot);
model.setRowCount(0);
}//else if

else if(ae.getSource()==b6)
{
model.setRowCount(0);
}



}//action method


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
if(c>='0' && c<='9')
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
}//end of keytyped mathed

}//End of class

class SaleDemo
{
public static void main(String s[])
{
Sale sal=new Sale();
}
}