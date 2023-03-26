package org.example;

import org.example.Data.Polynom;
import org.example.Logic.Operatie;

public class Main {
    public static void main(String[] args) {
      String p1="0";
      String p2="3x^2";
      Polynom pp=new Polynom(p2);
      //System.out.println(pp.polynom);


      Polynom pp1= new Polynom(p1);
      Operatie o= new Operatie();
      Polynom[] pp2=o.divide(pp,pp1);
      //Polynom pp2=o.divide(new Polynom("x^3-2x^2+6x^1-5x^0"), new Polynom("x^2-x^0"));
      System.out.println(pp1.polynom);




    }
}