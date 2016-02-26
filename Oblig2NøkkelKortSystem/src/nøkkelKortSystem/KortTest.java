package nøkkelKortSystem;

import java.util.ArrayList;
public class KortTest {
    public static void main(String[] args) {
        
        ArrayList<Kort> reg = new ArrayList<Kort>();
        
        Kort k1 = new Ansatt("Ole Olsen", 1234, 400);
        Kort k2 = new Gjest("Marit Olsen");
        reg.add(k1);
        reg.add(k2);
        for (int i=0; i<reg.size(); i++) {
            Kort kort = (Kort)reg.get(i);
            System.out.print(kort);
            System.out.println("\nTest av kort: med kode 1234 er" + (kort.sjekkPIN(1234) ?  " gyldig" :  " ugyldig" ) );
            System.out.println("\nTest av kort: med kode 9999 er" + (kort.sjekkPIN(9999) ?  " gyldig" :  " ugyldig" ) );
        }
        Ansatt a1 = new Ansatt("en to", 1234, 450);
        System.out.println(a1.beregnBonus() + " " + a1.beregnKreditt());
        
        Kort k3 = new Ansatt("Per Persen", 1234, 400);
        Kort k4 = new Gjest("Pette Dass");
        Kort k5 = new Ansatt("Jane Jannesen", 1234, 400);
        Kort k6 = new Gjest("Fnavn Enavn");
        Kort k7 = k5.clone();
        reg.add(k3);
        reg.add(k4);
        reg.add(k5);
        reg.add(k6);
        reg.add(k7);
        for(int i=0; i<reg.size(); i++)
        	System.out.println(reg.get(i));
        System.out.println("\nSORTER");
        reg.sort(null);
        for(int i=0; i<reg.size(); i++){
        	System.out.println(reg.get(i));
        }
    }
}
