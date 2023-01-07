// design a screen for all Customer
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.event.*;

 class Cujtable implements ActionListener
{
JFrame f;
JButton b1;
JTable tb;
DefaultTableModel model;
JScrollPane js;
ResultSet rs;
Statement st;
Connection con;

Cujtable()
{

f=new JFrame("All Customer");
f.setSize(650,450);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


tb=new JTable();
model=new DefaultTableModel();
String heads[]={"cs_id","cs_name","mobile_number","disease"};
model.setColumnIdentifiers(heads);
tb.setModel(model);
js=new JScrollPane(tb);
js.setBounds(30,30,550,250);//Jtable
f.add(js);


b1=new JButton("Back");
b1.setBounds(480,300,100,30);
//b1.setFont(f1);
f.add(b1);
//b1.setForeground(Color.BLUE);
b1.addActionListener(this);


try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/medical","root","");
st=con.createStatement();

String ss="select * from customer";
System.out.println("query:"+ss);
 rs=st.executeQuery(ss);
while(rs.next())
{
String s1=rs.getString("cs_id");

String s2=rs.getString("cs_name");
String s3=rs.getString("mobile_number");
String s4=rs.getString("disease");


model.addRow(new Object[]{s1,s2,s3,s4});


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
class CujtableDemo
{
public static void main(String s[])
{

Cujtable mj=new Cujtable();
}}