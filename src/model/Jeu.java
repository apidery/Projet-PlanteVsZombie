package model;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Jeu {

	private int nbTour;
	private ArrayList<Zombie> reservoirZombie;
	private IntegerProperty cagnote= new SimpleIntegerProperty();
	private Environnement environnement;
	int nbZombies;
	int zombiesMorts = 0;
	boolean perdu = false;

	public Jeu(int li, int la) {
		this.nbTour = 0;
		this.reservoirZombie = new ArrayList<Zombie>();
		this.cagnote.setValue(1000);
		this.environnement = new Environnement(li, la);
	}

	public int getNbTour() {
		return this.nbTour;
	}

	public IntegerProperty getCagnote() {

		return cagnote;
	}

	public int getNbZombies() {
		return this.reservoirZombie.size();
	}

	public void initialisation() {
		reservoirZombie.add(new ZombieDeBase(4, 900, environnement,100));
        reservoirZombie.add(new ZombieMagicien(2, 900, environnement,100));
        reservoirZombie.add(new ZombieMagicien(0, 900, environnement,300));

        nbZombies=reservoirZombie.size();
	}

	public Environnement getEnvironnement() {

		return this.environnement;
	}

	 public boolean gagne() {

	    	if((reservoirZombie.isEmpty() && nbZombies == zombiesMorts)) {
	    		return true;
	    	}
	    	else {
	    		return false;
	    	}
	    }

	    public boolean perdu() {

	    		return this.perdu;
	   	}


	public void unTour() {
		environnement.evolue();

		for (int i=0; i<reservoirZombie.size(); i++){
            if (reservoirZombie.get(i).getTiming()==nbTour){
                environnement.addPerso(reservoirZombie.get(i));
                reservoirZombie.remove(i);
            }
        }

		for (int i =0; i < 6; i++) {
			for (int j=0; j<environnement.getLignePersos(i).size(); j++) {
				if (environnement.getLignePersos(i).get(j).getgVie().estMort()) {

					if(environnement.getLignePersos(i).get(j) instanceof Zombie) {
                        zombiesMorts++;
                    }
					else{
						int x = EnsCase.tradCase(EnsCase.getCaseX(environnement.getLignePersos(i).get(j).getX()));
						int y = environnement.getLignePersos(i).get(j).getLigne();
						EnsCase.setCaseFalse(x, y);
					}

					environnement.supprimer(i, j);

				}
			}

		}
		for (Soleil s: environnement.getSoleils()){
			if (s.getEstRecupere()){
				s.getEnvironnement().delSoleil(s);
				break;
			}
		}

		nbTour++;

		for (int i =0; i < 6; i++) {
	         for (int j=0; j<environnement.getLignePersos(i).size(); j++) {
	            if(environnement.getLignePersos(i).get(j).getX()<0){
	            	perdu = true;
	            }
	           }
	      }

	}

	public void setCagnote(int gain){
		int currentValue = this.cagnote.getValue();
		this.cagnote.setValue(currentValue + gain);
	}




}
