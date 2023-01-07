// design a screen for all vendor medicine
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
// import java.sql.*;
import java.awt.event.*;

 class Cjtable //implements ActionListener
{
JFrame f;
JButton b1;
JTable tb;
DefaultTableModel model;
JScrollPane js;

Cjtable()
{

f=new JFrame("All Companies");
f.setSize(650,450);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


tb=new JTable();
model=new DefaultTableModel();
String heads[]={"company_id","name","address"};
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
//b1.addActionListener(this);


f.setVisible(true);
}

// public void actionPerformed(ActionEvent ae)
// {

// if(ae.getSource()==b1)
// {
// f.dispose();
// Report r=new Report();
// }
// }

}
class CjtableDemo
{
public static void main(String s[])
{
Cjtable cj=new Cjtable();
}

}