package model;

public abstract class Plante extends Perso{

	private int prix;

	public Plante(int li, int x, int la, GestionnaireVie GV, Environnement e,int degat, int prix) {
		super(li, x, la, GV, e, degat);
		this.prix = prix;
	}

	public int getPrix() {
		return this.prix;
	}

	@Override
	public boolean estObstaclePour(Perso p) {
		return (p instanceof Zombie);
	}
}
