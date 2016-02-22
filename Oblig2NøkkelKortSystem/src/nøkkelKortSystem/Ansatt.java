package n�kkelKortSystem;
import java.util.*;

public class Ansatt extends Kort implements Konstanter {
	java.util.GregorianCalendar ansettelsesDato;
	double timel�nn;

	public Ansatt(String navn, int pin, int timel�nn) {
		super(navn, pin);
		ansettelsesDato = new java.util.GregorianCalendar();
		this.timel�nn = timel�nn;
	}

	@Override
	public boolean sjekkPIN(int pin) {
		if(erKontortid()==true)
			return true;
		else
			if(getPin()==pin)
				return true;
		return false;
	}
	public boolean erKontortid(){
		GregorianCalendar date = new GregorianCalendar();
		if(date.HOUR_OF_DAY > 17 && date.HOUR_OF_DAY < 7)
			return true;
		return false;
	}

	@Override
	public void settFornavn(String name) {
		String fultNavn=getNavn();
		int space = fultNavn.indexOf(' ');
		String etterNavn=fultNavn.substring(space+1,fultNavn.length()-1);
		fultNavn= name + " " + etterNavn;
		setNavn(fultNavn);
	}

	@Override
	public String hentFornavn() {
		String fultNavn=getNavn();
		int space = fultNavn.indexOf(' ');
		String forNavn = fultNavn.substring(0,space-1);
		return forNavn;
	}

	@Override
	public void settEtternavn(String name) {
		String fultNavn=getNavn();
		int space = fultNavn.indexOf(' ');
		String forNavn=fultNavn.substring(0,space-1);
		fultNavn=forNavn + " " + name;
		setNavn(fultNavn);
	}

	@Override
	public String hentEtternavn() {
		String fultNavn=getNavn();
		int space = fultNavn.indexOf(' ');
		String etterNavn = fultNavn.substring(space+1,fultNavn.length()-1);
		return etterNavn;
	}

	@Override
	public void settFulltNavn(String name) {
		setNavn(name);
		
	}

	@Override
	public String hentFulltNavn() {
		String navn = getNavn();
		return navn;
	}

	@Override
	public double beregnKreditt() {
		return (this.timel�nn*5);
	}

	@Override
	public double beregnBonus() {
		return (�rAnsatt()*15);
	}
	public int �rAnsatt() {
		java.util.GregorianCalendar dagensDato = new java.util.GregorianCalendar();
		int[] ansatt = {this.ansettelsesDato.YEAR,this.ansettelsesDato.MONTH,this.ansettelsesDato.DATE};
		int[] n� = {dagensDato.YEAR, dagensDato.MONTH, dagensDato.DATE};
		int �r = n�[0]-ansatt[0];
		if(�r>0){
			if(n�[1]>ansatt[1]){
				if(n�[2]>ansatt[2])
					return �r;
			}
			else 
				return �r-1;
		}
		return 0;
	}
}