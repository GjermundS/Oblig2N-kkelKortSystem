package nøkkelKortSystem;

public abstract class Kort {

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
		return "Navn: " + getNavn() + "\nKortnummer: " + kortnummer + "\nSperret " + aksesskode + "\nPin: " + pin;
	}
	
	public abstract boolean sjekkPIN(int pin);
	
	public int getPin(){
		return this.pin;
	}
	
	public boolean getAksesskode(){
		return this.aksesskode;
	}
}