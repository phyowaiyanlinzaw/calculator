package com.oldstuffs.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator implements ActionListener {
    JFrame f;
    JButton b1, b2, b3, b4, b5;
    JLabel l1, l2, l4, l5, l6;
    JTextField tf1, tf2;
    JMenuBar mb;
    JMenu m1,m2,m3;
    JMenuItem mi1,mi2,mi3,mi4,mi5,mi6;

    calculator() {
       f = new JFrame("Calculator");

       mb = new JMenuBar();
       m1 = new JMenu("File");
       m2 = new JMenu("Edit");
       m3 = new JMenu("View");
       mi1 = new JMenuItem("File1");
       mi2 = new JMenuItem("File2");
       mi3 = new JMenuItem("Edit1");
       mi4 = new JMenuItem("Edit2");
       mi5 = new JMenuItem("View1");
       mi6 = new JMenuItem("View2");

       m1.add(mi1);m1.add(mi2);
       m2.add(mi3);m2.add(mi4);
       m3.add(mi5);m3.add(mi6);
       mb.add(m1);mb.add(m2);mb.add(m3);

       l1 = new JLabel("First Number ");
       l1.setBounds(90,50,200,30);
       l1.setFont(new Font("Times News Roman", Font.BOLD, 16));
       l2 = new JLabel("Second Number ");
       l2.setBounds(90,130,200,30);
       l2.setFont(new Font("Times News Roman", Font.BOLD, 16));

       l4 = new JLabel();

       l5 = new JLabel(" : ");
       l5.setBounds(260,42,50,50);
       l6 = new JLabel(" : ");
       l6.setBounds(260,122,50,50);

       tf1 = new JTextField();
       tf1.setBounds(320,48,230,40);
       tf2 = new JTextField();
       tf2.setBounds(320,128,230,40);

       b1 = new JButton("+");
       b1.setBounds(60,220,50,50);
       b1.setFocusable(false);
       b1.setBorder(BorderFactory.createEtchedBorder());
       b1.addActionListener(this);

       b2 = new JButton("-");
       b2.setBounds(170,220,50,50);
       b2.setFocusable(false);
       b2.setBorder(BorderFactory.createEtchedBorder());
       b2.addActionListener(this);

       b3 = new JButton("*");
       b3.setBounds(280,220,50,50);
       b3.setFocusable(false);
       b3.setBorder(BorderFactory.createEtchedBorder());
       b3.addActionListener(this);

       b4 = new JButton("/");
       b4.setBounds(390,220,50,50);
       b4.setFocusable(false);
       b4.setBorder(BorderFactory.createEtchedBorder());
       b4.addActionListener(this);

       b5 = new JButton("%");
       b5.setBounds(500,220,50,50);
       b5.setFocusable(false);
       b5.setBorder(BorderFactory.createEtchedBorder());
       b5.addActionListener(this);

       f.setJMenuBar(mb);
       f.add(l1);f.add(l5);f.add(l2);f.add(l6);
       f.add(tf1);f.add(tf2);f.add(l4);
       f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);
       f.setSize(600,400);
       f.setLayout(null);
       f.setVisible(true);
       f.setLocationRelativeTo(null);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double firstNum = Double.valueOf(tf1.getText());
        double secondNum = Double.valueOf(tf2.getText());
        double result = 0;

        try{
            if(e.getSource()==b1){
                result = firstNum + secondNum ;
            }
            else if(e.getSource()==b2){
                result = firstNum - secondNum ;
            }
            else if(e.getSource()==b3){
                result = firstNum * secondNum ;
            }
            else if(e.getSource()==b4){
                result = firstNum / secondNum ;
            }
            else if(e.getSource()==b5){
                result = firstNum % secondNum ;
            }
            String finalResult = String.valueOf(result);
            if (result==Double.POSITIVE_INFINITY || result==Double.NEGATIVE_INFINITY){
                throw new ArithmeticException();
            }
                        JOptionPane.showOptionDialog(f, finalResult,"Result", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);

        }
        catch (ArithmeticException a){
            JOptionPane.showMessageDialog(f,"Can't Divide by Zero!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}