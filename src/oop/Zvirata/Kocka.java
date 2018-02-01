package oop.Zvirata;

public class Kocka extends Zvire{
	/**
	 * It's extends Zvire
	 * It's a enemy with streanght 5
	 * @param z - Zivoty
	 * @param h - Hlad
	 * @param name
	 */
	public Kocka(int z, int h,int Lvl,String name) {
		super(z, h,Lvl,name,5,2);
	}
}
