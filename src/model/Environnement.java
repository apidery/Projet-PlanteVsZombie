package model;

import java.util.ArrayList;

public class Environnement {

	private ArrayList<ArrayList<Perso>> lesPersos;
	private ArrayList<Soleil> lesSoleils;
	private int largeurJardin;
	private int nbLignes;

	public Environnement(int largeur, int lignes){
		lesPersos = new ArrayList<ArrayList<Perso>>();
		this.nbLignes=lignes;
		for (int i=0; i<lignes ; i++) {
			lesPersos.add(new ArrayList<Perso>());
		}
		lesSoleils = new ArrayList<Soleil>();
		this.largeurJardin=largeur;
	}

	public void evolue(){
		for(int i=0;i<this.lesPersos.size();i++){
			for(int j=0;j<this.lesPersos.get(i).size();j++){
				this.lesPersos.get(i).get(j).evolue();
			}
		}
		
		for (Soleil s : lesSoleils){
			s.evolue();
		}
	}

	public int getLargeurJardin() {
		return this.largeurJardin;
	}

	public int nbreLigne() {
		return this.nbLignes;
	}

	public ArrayList<Perso> getLignePersos(int i) {
		return lesPersos.get(i);
	}

	public ArrayList<Soleil> getSoleils() {
		return lesSoleils;
	}

	/*
	public void addSoleil(int nbLignes, int x, int largeur, ) {
		lesSoleils.add(new Soleil(nbLignes, x, largeur, null, null))
	}*/

	public void addPerso(Perso perso) {
		int ligne = perso.getLigne();
		lesPersos.get(ligne).add(perso);
	}

	public void supprimer(int i, int j) {


				this.lesPersos.get(i).remove(j);

	}

	public void addSoleil(Soleil soleil) {
		lesSoleils.add(soleil);
	}
	public void delSoleil(Soleil s){
		lesSoleils.remove(s);
	}

	public boolean soleilIsEmpty(){
		return lesSoleils.isEmpty();
	}



}
