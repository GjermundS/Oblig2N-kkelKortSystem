package n�kkelKortSystem;
import java.util.*;

public class Gjest extends Kort {
	
	private GregorianCalendar utG�r;
	
	Gjest(String navn){
		super(navn, 9999);
		utG�r = new GregorianCalendar();
		utG�r.add(utG�r.DAY_OF_MONTH,7); 
	}
	@Override
	public boolean sjekkPIN(int pin) {
		if(getAksesskode()==false)
			if(sjekkDato())
				if(getPin()==pin)
					return true;
		return false;
	}
	
	public boolean sjekkDato(){
		GregorianCalendar date = new GregorianCalendar();
		System.out.println(date.compareTo(this.utG�r));
		if(date.compareTo(this.utG�r)==-1)
			return true;
		else
			return false;
	}
}