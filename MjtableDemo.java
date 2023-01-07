// design a screen for all All medicine
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.event.*;

 class Mjtable implements ActionListener
{
JFrame f;
JButton b1;
JTable tb;
DefaultTableModel model;
JScrollPane js;
ResultSet rs;
Statement st;
Connection con;

Mjtable()
{

f=new JFrame("All Medicine");
f.setSize(900,450);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


tb=new JTable();
model=new DefaultTableModel();
String heads[]={"m_id","m_name","c_name","MRP","unit_price","type","menufacturing_date","expire_date"};
model.setColumnIdentifiers(heads);
tb.setModel(model);
js=new JScrollPane(tb);
js.setBounds(30,30,800,250);//Jtable
f.add(js);


b1=new JButton("Back");
b1.setBounds(728,300,100,30);
//b1.setFont(f1);
f.add(b1);
//b1.setForeground(Color.BLUE);
b1.addActionListener(this);


try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/medical","root","");
st=con.createStatement();

String ss="select * from medicine";
System.out.println("query:"+ss);
 rs=st.executeQuery(ss);
while(rs.next())
{
String s1=rs.getString("m_id");

String s2=rs.getString("m_name");
String s3=rs.getString("c_name");
String s4=rs.getString("MRP");
String s5=rs.getString("unit_price");
String s6=rs.getString("type");
String s7=rs.getString("menufacturing_date");
String s8=rs.getString("expire_date");

model.addRow(new Object[]{s1,s2,s3,s4,s5,s6,s7,s8});


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
class MjtableDemo
{
public static void main(String s[])
{

Mjtable mj=new Mjtable();
}}