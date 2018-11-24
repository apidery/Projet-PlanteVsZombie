package model;

public abstract class PistoPois extends Plante{

	public PistoPois(int li, int x, Environnement e, int prix) {
		super(li, x, 30, new GVieBasic(100), e, 10, prix);
		//         largeur                     degat
 	}

	@Override
	public abstract void evolue();

}
