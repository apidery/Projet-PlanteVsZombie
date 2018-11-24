package model;

public class PistoSnowPea extends PistoPois{

	private int cpt=0;

	public PistoSnowPea(int li, int x, Environnement e) {
		super(li, x, e, 300);
	}

	@Override
	public void evolue() {
		if(cpt%100==0) {
			this.getEnvironnement().getLignePersos(this.getLigne()).add(new SnowPea(this.getLigne(), this.getX()+30, this.getEnvironnement()));
		}
		cpt ++;
	}


}
