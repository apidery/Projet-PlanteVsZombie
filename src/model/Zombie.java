package model;

public abstract class Zombie extends PersoMobile {

	private int timing;
	private boolean estGlace;
	private int cptGlace=0;

	public Zombie(int li, int x, int la, GestionnaireVie GV, Environnement e, int degat, int v, StrategieDeplacement SD,int timing) {
		super(li, x, la, GV, e, degat, v, SD, "gauche");
		this.timing=timing;
		this.estGlace=false;
	}

	@Override
	public boolean estObstaclePour(Perso p) {

		return (p instanceof Projectile || p instanceof Zombie);
	}

	public void evolue() {
			Perso persoBloquant;
			persoBloquant = getDeplacement().faitDeplacer(this);
			if (persoBloquant != null) {
				if (persoBloquant instanceof Projectile) {
					this.getgVie().recoitDegat(persoBloquant.getDegatCauses(),persoBloquant);
				}
				persoBloquant.getgVie().recoitDegat(this.getDegatCauses(),persoBloquant);
			}
			if(cptGlace==2){
				this.estGlace=true;
			}
	}

	public int getTiming(){
		return this.timing;
	}

	public boolean getEtat(){
		return this.estGlace;
	}

	public void incrementeCpt(){
		this.cptGlace++;
	}
}
