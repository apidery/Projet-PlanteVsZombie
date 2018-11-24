package model;

public class ZombieCasque extends Zombie{

	public ZombieCasque(int li, int x, Environnement e, int timing) {
		super(li, x, 50, new Casque(new GVieBasic(100)), e, 10, 3, new StrategieLineaire(), timing);

	}

}
