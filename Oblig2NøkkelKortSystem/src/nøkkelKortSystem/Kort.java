package nøkkelKortSystem;

public abstract class Kort {

	private String fNavn;
	private String eNavn;
	private int pin;
	private int kortnummer;
	private boolean aksesskode;
	
	Kort(String fNavn, String eNavn, int pin){
		this.fNavn=fNavn;
		this.eNavn=eNavn;
		this.pin=pin;
		this.kortnummer=(int)(Math.random()*1000);
		this.aksesskode= false;
	}
	
	public String getNavn(){
		return fNavn + " " + eNavn;
	}
	public boolean isSperret(){
		return this.aksesskode;
	}
	@Override
	public String toString(){
		return "Navn: " + getNavn() + "\nKortnummer: " + kortnummer + "\nSperret" + aksesskode + "\nPin: " + pin;
	}
	
	public abstract boolean sjekkPIN(int pin);
}