package model;

import java.util.ArrayList;

public class ZombieMagicien extends Zombie{

	int nbPlante=0;
	int compteurSkill;
	boolean auMoinsUnePlante = false;

	public ZombieMagicien(int li, int x, Environnement e,int timing) {
		super(li, x, 50, new GVieBasic(20), e, 1, 1, new StrategieLineaire(), timing);
		this.compteurSkill=200;
	}

	public void evolue(){

		this.compteurSkill++;

		if(compteurSkill%300==0){
			this.transforme();
		}

		Perso persoBloquant;
		persoBloquant = getDeplacement().faitDeplacer(this);
		if (persoBloquant != null) {
			if (persoBloquant instanceof Projectile) {
				this.getgVie().recoitDegat(persoBloquant.getDegatCauses(),persoBloquant);
			}
			persoBloquant.getgVie().recoitDegat(this.getDegatCauses(),persoBloquant);
		}
	}

	public void transforme(){

		for (int i =0; i <6 ; i++) {
			for (Perso p : this.getEnvironnement().getLignePersos(i)){
				if (p instanceof Plante) {
					auMoinsUnePlante = true;
				}
			}
		}


		if (auMoinsUnePlante==true) {


			ArrayList <Perso> plantes = new ArrayList();

			int randomLigne=0;

			while (nbPlante ==0) {

				randomLigne = (int)((Math.random())*(5));
				for (Perso p : this.getEnvironnement().getLignePersos(randomLigne)){
					if(p instanceof Plante) {
						nbPlante ++;
						plantes.add(p);
					}
				}

			}

			int randomPlante = (int)((Math.random())*(nbPlante));

			Perso p = plantes.get(randomPlante);


			Mouton mouton = new Mouton(randomLigne,p.getX(),p.getEnvironnement());
			p.getgVie().meurt();
			nbPlante=0;
			auMoinsUnePlante=false;
			this.getEnvironnement().addPerso(mouton);
		}


	}
}
