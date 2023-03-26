package org.example.Logic;

import org.example.Data.Polynom;

import java.util.*;

import org.example.Data.Polynom;

import static java.lang.Math.max;

public class Operatie {
    public Operatie() {
    }

    public Polynom add(Polynom a, Polynom b) {

        Polynom result = new Polynom();
        for (Map.Entry<Integer, Double> entryA : a.polynom.entrySet()) {
            result.polynom.put(entryA.getKey(), entryA.getValue());
        }

        for (Map.Entry<Integer, Double> entryB : b.polynom.entrySet()) {
            if (result.polynom.containsKey(entryB.getKey())) {
                Double s=entryB.getValue() + result.polynom.get(entryB.getKey());
                s=Math.round(s*100.)/100.0;
                if(s.compareTo(0.0)==0)
                  result.polynom.remove(entryB.getKey());
                else
                    result.polynom.replace(entryB.getKey(),s);

            } else
                result.polynom.put(entryB.getKey(), entryB.getValue());


        }

        return result;
    }

    public Polynom sub(Polynom a, Polynom b) {
        Polynom result = new Polynom();
        for (Map.Entry<Integer, Double> entryA : a.polynom.entrySet()) {
            result.polynom.put(entryA.getKey(), entryA.getValue());
        }

        for (Map.Entry<Integer, Double> entryB : b.polynom.entrySet()) {
            if (result.polynom.containsKey(entryB.getKey())) {
                Double s = result.polynom.get(entryB.getKey()) - entryB.getValue();
                s = Math.round(s * 100) / 100.0;
                if(s.compareTo(0.0)==0)
                  result.polynom.remove(entryB.getKey());
                else
                    result.polynom.replace(entryB.getKey(),s);
            } else
                result.polynom.put(entryB.getKey(), -entryB.getValue());


        }

        return result;
    }

    public Polynom derivation(Polynom a) {
        Polynom result = new Polynom();
        for (Map.Entry<Integer, Double> entryA : a.polynom.entrySet()) {
            result.polynom.put(entryA.getKey() - 1, entryA.getValue() * entryA.getKey());
        }

        return result;
    }

    public Polynom integral(Polynom a) {
        Polynom result = new Polynom();
        for (Map.Entry<Integer, Double> entryA : a.polynom.entrySet()) {
            Double s = entryA.getValue() / (entryA.getKey() + 1);
            s = Math.round(s * 100) / 100.0;
            result.polynom.put(entryA.getKey() + 1, s);
        }

        return result;
    }

    public Polynom multiplicate(Polynom a, Polynom b) {
        Polynom result = new Polynom();
        a.polynom.forEach((keyA, valueA) ->
        {
            b.polynom.forEach((keyB, valueB) ->
            {
                Integer keyResult = keyA + keyB;
                Double valueResult = valueA * valueB;
                if (result.polynom.containsKey(keyResult)) {
                    result.polynom.put(keyResult, result.polynom.get(keyResult) + valueResult);
                }
                else
                    result.polynom.put(keyResult,valueResult);


            });
        });

        return result;

    }
    static Integer degree(Polynom a)
    {
        Integer max=0;
        for(Map.Entry<Integer,Double>entryA:a.polynom.entrySet())
        {
            max=entryA.getKey();
        }
        return max;
    }
    static Polynom lead(Polynom r,Polynom d)
    {
        Polynom t= new Polynom();
        Integer key=degree(r)-degree(d);
        Double value=r.polynom.get(degree(r))/d.polynom.get(degree(d));
        value=Math.round(value*100)/100.0;
        t.polynom.put(key,value);
        return t;
    }
    public Polynom[] divide(Polynom n, Polynom d)
    {
        Polynom q=new Polynom();
        Polynom r=n;
        if(!d.polynom.isEmpty())
        {
        while(r.polynom.size()!=0 && degree(r)>=degree(d))
        {
            Polynom t=lead(r,d);
            q=add(q,t);
            r=sub(r,multiplicate(t,d));

        }}
        Polynom[] result={q,r};

        return result;
    }
}
