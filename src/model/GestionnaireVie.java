package model;
public interface GestionnaireVie {

	public boolean estMort();
	public void meurt();
	public void recoitDegat(int degats,Perso personnage);
	public int getPv();

}
