package model;

public class StrategieLineaire implements StrategieDeplacement{

    @Override
    public Perso faitDeplacer(PersoMobile pm) {


        Perso retour = null;
        boolean stop = false;

            for (Perso p : pm.getEnvironnement().getLignePersos(pm.getLigne())) {

            	if (p.estObstaclePour(pm))  {

            		 if (pm.getDirection().equals("gauche")) {

		                    if (((p.getX()+ p.getLargeur() <= pm.getX()) && (p.getX() + p.getLargeur() >= pm.getX() - pm.getVitesse()))) {

		                        retour = p;
		                        stop=true;
		                    }
            		 }
		             else if (pm.getDirection().equals("droite")) {

		            	 	if (((pm.getX()+ pm.getLargeur() <= p.getX()) && (p.getX() <= pm.getX() + pm.getLargeur() - pm.getVitesse())) || p.getX() < pm.getX()) {

		            		 	retour = p;
		                        stop=true;
		                  }
		             }
		         }
            }

            if (!stop) {
                pm.setX(pm.getX()-pm.getVitesse());
            }

            return retour;
    }


 }
