package model;

public class Pois extends Projectile {

	public Pois(int li, int x, Environnement e) {
		super(li, x, 10, new GVieBasic(1), e, 10, -5, new StrategieLineaire());
		//         largeur                 degat,vitesse
	}

	@Override
	public void evolue() {


		Perso persoBloquant;
		persoBloquant = getDeplacement().faitDeplacer(this);

		if (persoBloquant != null) {

			persoBloquant.getgVie().recoitDegat(this.getDegatCauses(),persoBloquant);
			this.getgVie().meurt();

		}

		if (this.getX()>900) {
			this.getgVie().meurt();
		}

	}

	@Override
	public boolean estObstaclePour(Perso p) {

		return false;
	}


}
