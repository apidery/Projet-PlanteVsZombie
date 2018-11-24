package model;

public abstract class PersoMobile extends Perso {

	private int vitesse;
	private StrategieDeplacement deplacement;
	private String direction;

	public PersoMobile (int li, int x, int la, GestionnaireVie GV, Environnement e, int degat, int v, StrategieDeplacement SD, String direction) {

		super(li, x, la, GV, e, degat);
		this.vitesse = v;
		this.deplacement = SD;
		this.direction = direction;
	}

	public String getDirection() {
		return direction;
	}

	public int getVitesse() {
		return vitesse;
	}

	public StrategieDeplacement getDeplacement()  {
		return this.deplacement;
	}

	public void setPosition(int i) {

		this.setX(i);

	}

	public void setVitesse(int newVitesse){
		this.vitesse=newVitesse;
	}

	public void ralentir() {

	}

	public void changeDirection() {

	}
}
