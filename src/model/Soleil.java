package model;

public class Soleil extends Perso{

	private boolean estRecupere;
	private int gain;
	private int cpt=0;

	public Soleil(int li, int x, int la, GestionnaireVie GVieBasic, Environnement e, int degat) {
		super(li, x, la, GVieBasic, e, degat);
		this.estRecupere = false;
		this.gain = 25;
	}

	@Override
	public boolean estObstaclePour(Perso p) {
		return false;
	}

	public int getXSoleil(){
		return this.getX();
	}

	public void setRecupere(){
		this.estRecupere = true;
	}

	public boolean getEstRecupere(){
		return this.estRecupere;
	}

	public int getGain(){
		return this.gain;
	}

	@Override
	public void evolue() {
		cpt++;
		if(cpt%250==0){
			this.setRecupere();
		}

	}
}
