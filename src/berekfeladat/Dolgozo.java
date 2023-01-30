package berekfeladat;

public class Dolgozo {

	private String dolgozoNeve;
	private String dolgozoNeme;
	private String reszleg;
	private int belepesEve;
	private int ber;

	public Dolgozo(String dolgozoNeve, String dolgozoNeme, String reszleg, int belepesEve, int ber) {
		this.dolgozoNeve = dolgozoNeve;
		this.dolgozoNeme = dolgozoNeme;
		this.reszleg = reszleg;
		this.belepesEve = belepesEve;
		this.ber = ber;
	}

	public String getDolgozoNeve() {
		return dolgozoNeve;
	}

	public void setDolgozoNeve(String dolgozoNeve) {
		this.dolgozoNeve = dolgozoNeve;
	}

	public String getDolgozoNeme() {
		return dolgozoNeme;
	}

	public void setDolgozoNeme(String dolgozoNeme) {
		this.dolgozoNeme = dolgozoNeme;
	}

	public String getReszleg() {
		return reszleg;
	}

	public void setReszleg(String reszleg) {
		this.reszleg = reszleg;
	}

	public int getBelepesEve() {
		return belepesEve;
	}

	public void setBelepesEve(int belepesEve) {
		this.belepesEve = belepesEve;
	}

	public int getBer() {
		return ber;
	}

	public void setBer(int ber) {
		this.ber = ber;
	}

	@Override
	public String toString() {
		return "Név: " + this.dolgozoNeve + ", neme: " + this.dolgozoNeme + ", részleg: " + this.reszleg
				+ ", belépés éve: " + this.belepesEve + ", bér: " + this.ber + "Ft";
	}

}
