package model;

public class Casque extends GVieProtection{

	public Casque(GVieBasic gVie){
		super(30, gVie);
	}


	public boolean casqueCasser(){
		return this.getPv()<=0;
	}

	@Override
	public void recoitDegat(int degats,Perso personnage) {
		if(this.efficaceContre(personnage)){
			this.getGVie().recoitDegat(degats,personnage);
		}else{
			if(this.getPv()>0){
				if(this.getPv()-degats>=0){
					this.setPv(this.getPv() - degats);
				}else{
					int reste = degats-this.getPv();
					this.getGVie().recoitDegat(degats+reste,personnage);
				}
			}
		}

	}

	@Override
	public boolean efficaceContre(Perso personnage) {
		boolean efficace=false;
		if(personnage instanceof Projectile){
			efficace=true;
		}
		return efficace;
	}


}
