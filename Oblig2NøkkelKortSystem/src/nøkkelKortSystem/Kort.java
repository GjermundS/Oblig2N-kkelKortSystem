package nøkkelKortSystem;

public abstract class Kort implements Comparable<Kort>, Cloneable {

	private String navn;
	private int pin;
	private int kortnummer;
	private boolean aksesskode;
	private static int antallKort=0;
	
	Kort(String navn, int pin){
		this.navn=navn;
		this.pin=pin;
		this.kortnummer=antallKort+1;
		this.aksesskode= false;
		antallKort++;
	}
	
	public String getNavn(){
		return navn;
	}
	public void setNavn(String navn){
		this.navn=navn;
	}
	public boolean isSperret(){
		return this.aksesskode;
	}
	@Override
	public String toString(){
		return "\nNavn: " + getNavn() + "\nKortnummer: " + kortnummer + "\nSperret " + aksesskode + "\nPin: " + pin;
	}
	
	public abstract boolean sjekkPIN(int pin);
	
	public int getPin(){
		return this.pin;
	}
	
	public boolean getAksesskode(){
		return this.aksesskode;
	}
	
	public void setAksesskode(boolean aksesskode){
		this.aksesskode=aksesskode;
	}
	
	@Override
	public int compareTo(Kort a){
		String navn1 = this.navn;
		String navn2 = a.getNavn();
		
		int space1 = navn1.indexOf(' ');
		int space2 = navn2.indexOf(' ');
		
		String forNavn1 = navn1.substring(0, space1-1);
		String forNavn2 = navn2.substring(0, space2-1);
		
		String etterNavn1 = navn1.substring(space1+1, navn1.length());
		String etterNavn2 = navn2.substring(space2+1, navn2.length());
		
		if(etterNavn1.compareTo(etterNavn2)!=0)
			return etterNavn1.compareTo(etterNavn2);
		else 
			return forNavn1.compareTo(forNavn2);		
	}
	@Override
	public abstract Kort clone();
}
