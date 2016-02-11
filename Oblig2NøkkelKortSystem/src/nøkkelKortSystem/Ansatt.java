package nøkkelKortSystem;
import java.util.*;

public class Ansatt extends Kort {

	public Ansatt(String navn, int pin) {
		super(navn, pin);
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
}