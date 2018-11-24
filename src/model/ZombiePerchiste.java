package model;

public class ZombiePerchiste extends Zombie {

	public ZombiePerchiste(int li, int x,Environnement e,int timing) {
		super(li, x, 50, new GVieBasic(50), e, 10, 4 ,new StrategiePerche(),timing);
		//          largeur                 degat,vitesse
	}
}
