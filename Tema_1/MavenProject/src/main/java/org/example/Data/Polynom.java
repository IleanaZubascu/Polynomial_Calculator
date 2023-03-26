package org.example.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynom {
    public HashMap<Integer, Double> polynom= new HashMap<Integer,Double>();
    public Polynom(String p) {
        String[] monoms=p.split("(?=[+-])");
        for (String a : monoms)
        {
            String firstNumber = "";
            String lastNumber="";
            for(int i=0;i<a.length();i++)
            {
                if(a.charAt(i)=='x')
                {
                    lastNumber=a.substring(i+2);
                    i=a.length()+1;
                    if(firstNumber.length()==0 || firstNumber.equals("+") || firstNumber.equals("-"))
                        firstNumber+="1";
                }
                else firstNumber = firstNumber + a.charAt(i);

            }
            //System.out.println("coeficient="+firstNumber+" power= "+lastNumber);
            if(firstNumber!="" && lastNumber!="")
            {Double coeficient=Double.parseDouble(firstNumber);
            Integer power= Integer.parseInt(lastNumber);
            this.polynom.put(power,coeficient);}
            //System.out.println("coeficient="+coeficient+" power= "+power);
        }
    }
    public Polynom()
    {

    }

    public String toString()
    {

        StringBuilder sb= new StringBuilder();
        for (Map.Entry<Integer, Double> entry : this.polynom.entrySet()) {
            int exponent = entry.getKey();
            Double coefficient = entry.getValue();
            if (coefficient != 0) {
                if (coefficient > 0 && sb.length() > 0) {
                    sb.append("+");
                }
                if (coefficient != 1 && coefficient != -1 || exponent == 0) {
                    sb.append(coefficient);
                } else if (coefficient == -1) {
                    sb.append("-");
                }
                sb.append("x^").append(exponent);

            }
        }
        String result=sb.toString();
        if(result.length()==0)
            result="0.0x^0";
        return result;

    }



}


