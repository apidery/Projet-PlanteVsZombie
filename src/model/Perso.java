package model;

public abstract class Perso {

	private Environnement environnement;
	private int ligne;
	private int x;
	private int largeur;
	private int degatsCauses;
	private GestionnaireVie gVie;

	public Perso (int li, int x, int la, GestionnaireVie GV, Environnement e, int degat) {
		this.ligne = li;
		this.x = x;
		this.largeur = la;
		this.gVie = GV;
		this.environnement = e;
		this.degatsCauses = degat;
	}

	public abstract void evolue();
	public abstract boolean estObstaclePour(Perso p);


	public int getLargeur() {
		return this.largeur;
	}

	public int getLigne() {
		return this.ligne;
	}

	public int getX () {
		return this.x;
	}

	public void setX(int i) {
		this.x = i;
	}

	public void setLigne(int i) {
		this.ligne = i;
	}

	public int getDegatCauses () {
		return this.degatsCauses;
	}

	public GestionnaireVie getgVie () {
		return this.gVie;
	}

	public Environnement getEnvironnement () {
		return this.environnement;
	}

	public void setEnvironnement (Environnement e) {
		this.environnement = e;
	}


}