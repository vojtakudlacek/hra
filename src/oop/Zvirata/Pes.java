package oop.Zvirata;

import java.util.Random;

public class Pes extends Zvire{
	/**
	 * This is enemy who can st�kat and have 10 of strenght
	 */
	public boolean umiStekat = true;
	public Pes(int z, int h, int l,String name) {
		super(z, h, l,name,10,1);
	}
	public void Stekni()
	{
		if(umiStekat){
			Random rnd = new Random();
			if(rnd.nextInt(10)==2){
			System.out.println("Pes steknul");
			}
		}
	}
}
