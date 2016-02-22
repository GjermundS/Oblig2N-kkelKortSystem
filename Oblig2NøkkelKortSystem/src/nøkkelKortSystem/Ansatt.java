package nøkkelKortSystem;
import java.util.*;

public class Ansatt extends Kort implements Konstanter {
	java.util.GregorianCalendar ansettelsesDato;
	double timelønn;

	public Ansatt(String navn, int pin, int timelønn) {
		super(navn, pin);
		ansettelsesDato = new java.util.GregorianCalendar();
		this.timelønn = timelønn;
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
		return (this.timelønn*5);
	}

	@Override
	public double beregnBonus() {
		return (årAnsatt()*15);
	}
	public int årAnsatt() {
		java.util.GregorianCalendar dagensDato = new java.util.GregorianCalendar();
		int[] ansatt = {this.ansettelsesDato.YEAR,this.ansettelsesDato.MONTH,this.ansettelsesDato.DATE};
		int[] nå = {dagensDato.YEAR, dagensDato.MONTH, dagensDato.DATE};
		int år = nå[0]-ansatt[0];
		if(år>0){
			if(nå[1]>ansatt[1]){
				if(nå[2]>ansatt[2])
					return år;
			}
			else 
				return år-1;
		}
		return 0;
	}
}