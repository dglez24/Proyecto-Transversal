package persistencias;

public class Navarra {
	private String nom;
	private int numHabitantes;
	private int rengo1_9,rango10_17,rango18_25,rango26_40,rango41_65,rango66;
	public Navarra(String nom, int numHabitantes, int rengo1_9, int rango10_17, int rango18_25, int rango26_40,
			int rango41_65, int rango66) {
		super();
		this.nom = nom;
		this.numHabitantes = numHabitantes;
		this.rengo1_9 = rengo1_9;
		this.rango10_17 = rango10_17;
		this.rango18_25 = rango18_25;
		this.rango26_40 = rango26_40;
		this.rango41_65 = rango41_65;
		this.rango66 = rango66;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNumHabitantes() {
		return numHabitantes;
	}
	public void setNumHabitantes(int numHabitantes) {
		this.numHabitantes = numHabitantes;
	}
	public int getRengo1_9() {
		return rengo1_9;
	}
	public void setRengo1_9(int rengo1_9) {
		this.rengo1_9 = rengo1_9;
	}
	public int getRango10_17() {
		return rango10_17;
	}
	public void setRango10_17(int rango10_17) {
		this.rango10_17 = rango10_17;
	}
	public int getRango18_25() {
		return rango18_25;
	}
	public void setRango18_25(int rango18_25) {
		this.rango18_25 = rango18_25;
	}
	public int getRango26_40() {
		return rango26_40;
	}
	public void setRango26_40(int rango26_40) {
		this.rango26_40 = rango26_40;
	}
	public int getRango41_65() {
		return rango41_65;
	}
	public void setRango41_65(int rango41_65) {
		this.rango41_65 = rango41_65;
	}
	public int getRango66() {
		return rango66;
	}
	public void setRango66(int rango66) {
		this.rango66 = rango66;
	}
	
}
