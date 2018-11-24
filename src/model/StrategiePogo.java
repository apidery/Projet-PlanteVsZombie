package model;

public class StrategiePogo implements StrategieDeplacement {

	private StrategieDeplacement SD;

	public StrategiePogo(){
		this.SD=new StrategieLineaire();
	}

	public Perso faitDeplacer(PersoMobile pm) {

		Perso retour = null;
		retour = this.SD.faitDeplacer(pm);

		if(retour != null && retour.estObstaclePour(pm) && !(retour instanceof Noix)) {
			System.out.println("test");
			pm.setX(pm.getX()-retour.getLargeur()*3);
		}
		return retour;
	}
}
