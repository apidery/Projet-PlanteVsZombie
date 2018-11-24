package model;
public class GVieBasic implements GestionnaireVie {

	private int pv;

	public GVieBasic(int pvBasic) {
		this.pv = pvBasic;
	}

	public boolean estMort() {
		return this.pv<=0;
	}

	public void meurt() {
		this.pv=0;

	}

	public int getPv(){
		return this.pv;
	}
	public void recoitDegat(int degats,Perso personnage) {
		this.pv = this.pv - degats;
	}
}
