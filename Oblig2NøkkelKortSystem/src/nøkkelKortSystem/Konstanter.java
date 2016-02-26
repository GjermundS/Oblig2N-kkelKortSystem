package nøkkelKortSystem;

public interface Konstanter {
	
	public abstract void settFornavn(String name);
	public abstract String hentFornavn();
	public abstract void settEtternavn(String name);
	public abstract String hentEtternavn();
	public abstract void settFulltNavn(String name);
	public abstract String hentFulltNavn();
	public abstract double beregnKreditt();
	public abstract double beregnBonus();
}
