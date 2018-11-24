package model;


public abstract class Projectile extends PersoMobile{

	public Projectile(int li, int x, int la, GestionnaireVie GV, Environnement e, int degat,int v, StrategieDeplacement SD) {
		super(li, x, la, GV, e, degat, v, SD, "droite");
	}

	@Override
	public boolean estObstaclePour(Perso p){
		return false;
	}
}
