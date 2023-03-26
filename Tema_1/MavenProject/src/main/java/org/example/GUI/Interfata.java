package org.example.GUI;
import org.example.Data.Polynom;
import org.example.Logic.Operatie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfata extends JFrame implements ActionListener {
    Polynom result;
    Polynom polynomFirst;
    Polynom polynomLast;

    Polynom[] result1;

    public Interfata() throws FontFormatException {



        JFrame frameCalculculator= new JFrame("Calculator de polinoame");
        frameCalculculator.getContentPane().setBackground(Color.BLACK);
        frameCalculculator.setBounds(400,50,450,600);
        frameCalculculator.setLayout(null);

        JTextField polynomA= new JTextField();
        polynomA.setBounds(120,30,300,35);
        polynomA.setFont(new Font("A", Font.BOLD, 20));
        polynomA.addActionListener(this);
        frameCalculculator.add(polynomA);


        JLabel polynom1= new JLabel("Polynom 1:");
        polynom1.setBounds(10,30,300,35);
        polynom1.setFont(new Font("A",Font.ITALIC,20));
        polynom1.setForeground(Color.WHITE);
        frameCalculculator.add(polynom1);


        JTextField polynomB= new JTextField();
        polynomB.setBounds(120,100,300,35);
        polynomB.setFont(new Font("A", Font.BOLD, 20));
        polynomB.addActionListener(this);
        frameCalculculator.add(polynomB);


        JLabel polynom2= new JLabel("Polynom 2:");
        polynom2.setBounds(10,100,300,35);
        polynom2.setFont(new Font("A",Font.ITALIC,20));
        polynom2.setForeground(Color.WHITE);
        frameCalculculator.add(polynom2);

        JButton add= new JButton("add");
        add.setBounds(10,200,200,50);
        add.setFont(new Font("A",Font.ITALIC,20));
        add.setBackground(new Color(0,0,0));
        add.setForeground(Color.WHITE);
        frameCalculculator.add(add);

        JButton sub= new JButton("substract");
        sub.setBounds(210,200,200,50);
        sub.setFont(new Font("A",Font.ITALIC,20));
        sub.setBackground(new Color(0,0,0));
        sub.setForeground(Color.WHITE);
        frameCalculculator.add(sub);

        JButton multiply= new JButton("multiplicate");
        multiply.setBounds(10,250,200,50);
        multiply.setFont(new Font("A",Font.ITALIC,20));
        multiply.setBackground(new Color(0,0,0));
        multiply.setForeground(Color.WHITE);
        frameCalculculator.add(multiply);

        JButton divide= new JButton("divide");
        divide.setBounds(210,250,200,50);
        divide.setFont(new Font("A",Font.ITALIC,20));
        divide.setBackground(new Color(0,0,0));
        divide.setForeground(Color.WHITE);
        frameCalculculator.add(divide);

        JButton integrare= new JButton("integration");
        integrare.setBounds(10,300,200,50);
        integrare.setFont(new Font("A",Font.ITALIC,20));
        integrare.setBackground(new Color(0,0,0));
        integrare.setForeground(Color.WHITE);
        frameCalculculator.add(integrare);

        JButton derivare= new JButton("derivation");
        derivare.setBounds(210,300,200,50);
        derivare.setFont(new Font("A",Font.ITALIC,20));
        derivare.setBackground(new Color(0,0,0));
        derivare.setForeground(Color.WHITE);
        frameCalculculator.add(derivare);

        JButton equal= new JButton("=");
        equal.setBounds(10,360,150,50);
        equal.setFont(new Font("A",Font.ITALIC,40));
        equal.setBackground(new Color(233,0,0));
        equal.setForeground(Color.BLACK);
        frameCalculculator.add(equal);

        JButton clear= new JButton("clear");
        clear.setBounds(260,360,150,50);
        clear.setFont(new Font("A",Font.ITALIC,25));
        clear.setBackground(new Color(0,255,51));
        clear.setForeground(Color.BLACK);
        frameCalculculator.add(clear);


        JTextField polynomR= new JTextField();
        polynomR.setBounds(120,450,300,35);
        polynomR.setFont(new Font("A", Font.BOLD, 20));
        polynomR.addActionListener(this);
        polynomR.setForeground(Color.GREEN);
        frameCalculculator.add(polynomR);


        //polynomR.setText(polynomA.getText());

        JLabel polynom3= new JLabel("Result:");
        polynom3.setBounds(10,450,300,35);
        polynom3.setFont(new Font("A",Font.ITALIC,30));
        polynom3.setForeground(Color.WHITE);
        frameCalculculator.add(polynom3);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                polynomFirst= new Polynom(polynomA.getText());
                polynomLast= new Polynom(polynomB.getText());
                if(polynomFirst.polynom.isEmpty() || polynomLast.polynom.isEmpty())
                    polynomR.setText("Polynom invalid");
                else{
                Operatie o= new Operatie();
                result=o.add(polynomFirst,polynomLast);
            }}
        });
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                polynomFirst= new Polynom(polynomA.getText());
                polynomLast= new Polynom(polynomB.getText());
                if(polynomFirst.polynom.isEmpty() || polynomLast.polynom.isEmpty())
                    polynomR.setText("Polynom invalid");
                else
                {
                Operatie o= new Operatie();
                result=o.sub(polynomFirst,polynomLast);
            }}
        });
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                polynomFirst= new Polynom(polynomA.getText());
                polynomLast= new Polynom(polynomB.getText());
                if(polynomFirst.polynom.isEmpty() || polynomLast.polynom.isEmpty())
                    polynomR.setText("Polynom invalid");
                else
                {Operatie o= new Operatie();
                result=o.multiplicate(polynomFirst,polynomLast);
               }

            }
        });
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                polynomFirst= new Polynom(polynomA.getText());
                polynomLast= new Polynom(polynomB.getText());
                if(polynomFirst.polynom.isEmpty() || polynomLast.polynom.isEmpty())
                    polynomR.setText("Polynom invalid");
                else {
                Operatie o= new Operatie();
               result1=o.divide(polynomFirst,polynomLast);}
               if(result1[1].polynom.isEmpty())
                   polynomR.setText("Q: "+result1[0].toString()+ " R: 0");
                   else
                      polynomR.setText("Q: "+result1[0].toString()+ " R:"+result1[1].toString());
            }
        });
        derivare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                polynomFirst= new Polynom(polynomA.getText());
                if(polynomFirst.polynom.isEmpty())
                    polynomR.setText("Polynom invalid");
                else
                {
                Operatie o= new Operatie();
                result=o.derivation(polynomFirst);
            }}
        });
        integrare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                polynomFirst= new Polynom(polynomA.getText());
                if(polynomFirst.polynom.isEmpty())
                    polynomR.setText("Polynom invalid");
                else{
                Operatie o= new Operatie();
                result=o.integral(polynomFirst);
            }}
        });

        equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    if (result.polynom.isEmpty())
                        polynomR.setText("0");
                    else
                        polynomR.setText(result.toString());
                }

        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                polynomR.setText("");
                polynomA.setText("");
                polynomB.setText("");

            }
        });




        polynomA.setVisible(true);
        frameCalculculator.setVisible(true);
        frameCalculculator.setDefaultCloseOperation(EXIT_ON_CLOSE);



    }
    @Override
    public void actionPerformed(ActionEvent e) {


    }

    public static void main(String[] args) throws FontFormatException {
        new Interfata();
    }
}
