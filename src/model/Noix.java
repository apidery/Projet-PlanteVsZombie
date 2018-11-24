package model;

public class Noix extends Plante{


	public Noix(int li, int x, Environnement e) {
		super(li, x, 30, new GVieBasic(500), e, 0, 50);
		//         largeur                    degat
	}

	@Override
	public void evolue() {

	}
}
