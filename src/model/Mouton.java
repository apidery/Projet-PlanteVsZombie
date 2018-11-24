package model;

public class Mouton extends PersoMobile{


	public Mouton(int li, int x, Environnement e){
		super(li,x,30,new GVieBasic(1),e,0,-1,new StrategieLineaire(),"droite");
	}
	@Override
	public void evolue() {

		this.getDeplacement().faitDeplacer(this);
		if(this.getX()>900){
			this.getgVie().meurt();
		}
	}

	@Override
	public boolean estObstaclePour(Perso p) {
		return false;
	}

}
