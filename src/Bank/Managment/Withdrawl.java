package Bank.Managment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
public class Withdrawl extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdraw, back;
    String pinnumber;

    Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 850);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        withdraw = new JButton("withdraw");
        withdraw.setBounds(355, 440, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355, 480, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {
            String number =amount.getText();
            int u=Integer.parseInt(number);
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"please enter the amount you want to withdraw");
            }
            else{
                try{

                    Conn conn = new Conn();
                    String fetchAmountQuery = "SELECT amount FROM bank WHERE pin = '" + pinnumber + "'";
                    ResultSet rs = conn.s.executeQuery(fetchAmountQuery);
                    int currentAmount = 0;

                    if (rs.next()) {
                        currentAmount = rs.getInt("amount");
                    }
                    if(currentAmount>=u){
                    String query = "UPDATE bank SET amount = amount-'"+u+"' WHERE pin = '"+pinnumber+"'";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null , "Rs "+number+" withdrawd successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);}
                    else {
                        JOptionPane.showMessageDialog(null, "Insufficient funds");
                    }
                }
                catch (Exception e){
                    System.out.println(e);
                }


            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}