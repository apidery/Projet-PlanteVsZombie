package model;

public class Patate extends Plante {

	public Patate(int li, int x, Environnement e) {
		super(li, x, 30, new GVieBasic(1000), e, 1000, 100);
		//         largeur                    degat
	}

	@Override
	public void evolue() {
		if(this.getgVie().getPv()<1000){
			for (Perso p : this.getEnvironnement().getLignePersos(this.getLigne())) {
				if((p instanceof Zombie) && ( p.getX()-((Zombie)p).getVitesse()<=this.getX()+this.getLargeur())) {
					p.getgVie().meurt();
					break;
				}
			}
		}
	}

	public boolean aExplose(){
		return this.getgVie().getPv() == 1000;
	}

}
