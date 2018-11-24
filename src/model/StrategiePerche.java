package model;

public class StrategiePerche implements StrategieDeplacement {

	private boolean possedeSonAccesoire;
	private StrategieDeplacement SD;

	public StrategiePerche(){
		this.possedeSonAccesoire=true;
		this.SD=new StrategieLineaire();
	}

	public void perdAccessoire(){
		this.possedeSonAccesoire=false;
		System.out.println("Je perds ma perche");
	}

	public boolean possedeSonAccessoire(){
		return this.possedeSonAccesoire;
	}

	public Perso faitDeplacer(PersoMobile pm) {

		Perso retour = null;
		retour = this.SD.faitDeplacer(pm);

		if(retour instanceof Plante && this.possedeSonAccesoire) {
			this.perdAccessoire();
			pm.setX(pm.getX()-retour.getLargeur()*3);
		}
		return retour;
	}
}
