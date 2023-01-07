// design a screen for stock for medicine in my medical store
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.event.*;

 class Stockjtable implements ActionListener
{
JFrame f;
JButton b1;
JTable tb;
DefaultTableModel model;
JScrollPane js;
ResultSet rs;
Statement st;
Connection con;


Stockjtable()
{

f=new JFrame("Stock");
f.setSize(1200,600);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


tb=new JTable();
model=new DefaultTableModel();
String heads[]={"vender_id","company_id","medicine","categery","menufacturing_date","expire_date","mrp","less","discount","number_of_unit","amount"};
model.setColumnIdentifiers(heads);
tb.setModel(model);
js=new JScrollPane(tb);
js.setBounds(30,30,1120,350);//Jtable
f.add(js);


b1=new JButton("Back");
b1.setBounds(1050,460,100,30);
//b1.setFont(f1);
f.add(b1);
//b1.setForeground(Color.BLUE);
b1.addActionListener(this);


try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/medical","root","");
st=con.createStatement();

String ss="select * from purchase";
System.out.println("query:"+ss);
 rs=st.executeQuery(ss);
while(rs.next())
{
String s1=rs.getString("vender_id");

String s2=rs.getString("company_id");
String s3=rs.getString("medicine");
String s4=rs.getString("categery");
String s5=rs.getString("menufacturing_date");
String s6=rs.getString("expire_date");
String s7=rs.getString("mrp");
String s8=rs.getString("less");

String s9=rs.getString("discount");
String s10=rs.getString("number_of_unit");
String s11=rs.getString("amount");

model.addRow(new Object[]{s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11});


}
con.close();
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
f.dispose();
Report r=new Report();
}
}

}
class StockjtableDemo
{
public static void main(String s[])
{

Stockjtable vj=new Stockjtable();
}}