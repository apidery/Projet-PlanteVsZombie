package model;

public class ZombiePogo extends Zombie{

	public ZombiePogo(int li, int x, Environnement e, int timing) {
		super(li, x, 50, new GVieBasic(900), e, 10, 1, new StrategiePogo(), timing);
	}

}
