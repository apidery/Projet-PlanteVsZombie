package model;

public class ZombieDeBase extends Zombie{


	public ZombieDeBase(int li, int x, Environnement e,int timing) {
		super(li, x, 50, new GVieBasic(50), e, 5, 3, new StrategieLineaire(), timing);

	}
}
