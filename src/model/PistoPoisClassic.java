package model;

public class PistoPoisClassic extends PistoPois{

	int cpt=0;

	public PistoPoisClassic(int li, int x, Environnement e) {
		super(li, x, e, 100);
 	}

	@Override
	public void evolue() {
		if(cpt%40==0) {
			this.getEnvironnement().getLignePersos(this.getLigne()).add(new Pois(this.getLigne(), this.getX()+30, this.getEnvironnement()));
		}
		cpt ++;
	}

}
