package model;



public class Tournesol extends Plante{

	int cpt=0;

	public Tournesol(int li, int x, Environnement e) {
		super(li, x, 30, new GVieBasic(50),e,0,50);
	}


	@Override
	public void evolue() {
		cpt++;

		if (cpt%150==0){
			int random = (int)(Math.random() * (20-0)) + 0;
			this.getEnvironnement().addSoleil(new Soleil (this.getLigne(),(this.getX()+random), 30, new GVieBasic(1000), this.getEnvironnement(), 0));
		}
	}
}