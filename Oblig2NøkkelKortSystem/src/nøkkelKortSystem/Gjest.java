package nøkkelKortSystem;
import java.util.*;

public class Gjest extends Kort {
	
	private GregorianCalendar utGår;
	
	Gjest(String navn){
		super(navn, 9999);
		utGår = new GregorianCalendar();
		utGår.add(utGår.DAY_OF_MONTH,7); 
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
		System.out.println(date.compareTo(this.utGår));
		if(date.compareTo(this.utGår)==-1)
			return true;
		else
			return false;
	}
}