package model;

public class SnowPea extends Projectile{

	public SnowPea(int li, int x, Environnement e) {
		super(li, x, 10, new GVieBasic(1), e, 2, -5, new StrategieLineaire());

	}

	@Override
	public void evolue() {
		Perso persoBloquant;
		persoBloquant = getDeplacement().faitDeplacer(this);

		if (persoBloquant != null) {
			int newVitesse=((PersoMobile)persoBloquant).getVitesse();
			if(newVitesse>1){
				newVitesse=((PersoMobile)persoBloquant).getVitesse()-1;
				((PersoMobile)persoBloquant).setVitesse(newVitesse);
				((Zombie)persoBloquant).incrementeCpt();
			}
			persoBloquant.getgVie().recoitDegat(this.getDegatCauses(),persoBloquant);
			this.getgVie().meurt();

		}

		if (this.getX()>900) {
			this.getgVie().meurt();
		}

	}

}
