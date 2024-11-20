package Bank.Managment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login ,sign,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("Automated Teller Machine");
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,38));
        cardno.setBounds(120,150,200,40);
        add(cardno);
        cardTextField = new JTextField();
        cardTextField.setBounds(320,159,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,38));
        pin.setBounds(120,220,400,40);
        add( pin);
        pinTextField = new JPasswordField();
        pinTextField.setBounds(320,229,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        login =new JButton ("SIGN IN");
        login.setBounds(320,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        clear =new JButton ("Clear");
        clear.setBounds(470,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        sign =new JButton ("Sign Up");
        sign.setBounds(320,350,250,30);
        sign.setBackground(Color.BLACK);
        sign.setForeground(Color.white);
        sign.addActionListener(this);
        add(sign);
        getContentPane().setBackground(Color.white);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);

    }
    public  void actionPerformed(ActionEvent ac){
        if(ac.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");

        }
        else   if(ac.getSource()== sign){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
        else   if(ac.getSource()== login){
            Conn conn=new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query ="select * from login where cardnumber ='"+cardnumber+"' and pinnumber='"+pinnumber+"'";
            try{
             ResultSet rs= conn.s.executeQuery(query);
             if(rs.next()){
                 setVisible(false);
                 new Transactions(pinnumber).setVisible(true);}
                 else{
                     JOptionPane.showMessageDialog(null,"Incorrect card number or pin");
                 }
             }

            catch (Exception e){
                System.out.println(e);
            }

        }
    }
    public static void main(String args[])
    {
        new Login();
    }
}
