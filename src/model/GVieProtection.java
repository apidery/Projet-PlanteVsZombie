package model;

public abstract class GVieProtection implements GestionnaireVie {

	private int pvArmure;
	private GestionnaireVie gVieBase;

	public GVieProtection(int armure, GestionnaireVie gVie) {
		this.pvArmure = armure;
		this.gVieBase = gVie;
	}

	public boolean estMort() {
		return this.gVieBase.estMort();
	}

	public void meurt() {
		this.gVieBase.meurt();
	}

	public GestionnaireVie getGVie(){
		return this.gVieBase;
	}

	public int getPv(){
		return this.pvArmure;
	}

	public void setPv(int newPv){
		this.pvArmure=newPv;
	}
	public abstract void recoitDegat(int degats,Perso personnage);
	abstract public boolean efficaceContre(Perso personnage);
}
