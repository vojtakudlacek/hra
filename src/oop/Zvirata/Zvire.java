package oop.Zvirata;

import oop.Main.Game;

public class Zvire {
	/**
	 * This is themplate for all entities
	 */
	public float Zivoty;
	public int Hlad;
	public int Lvl;
	public int xp;
	public int Sila;
	public String name;
	
	public Zvire(int z,String nm)
	{
		Zivoty = z;
		Hlad = 100;
		Lvl = 1;
		name = nm;
	}
	public Zvire(int z,int h,String nm)
	{
		Zivoty = z;
		Hlad = h;
		Lvl = 1;
		name = nm;
	}
	public Zvire(int z,int h,int l,String nm){
		Zivoty = z;
		Hlad = h;
		Lvl = l;
		name = nm;
	}
	public Zvire(int z,int h,int l,String nm,int s)
	{
		Zivoty = z;
		Hlad = h;
		Lvl = l;
		name = nm;
		Sila = s;
	}
	public void LvlUp()
	{
		if(xp >= (Lvl*100)/2)
		{
			Lvl++;
			System.out.println(name+" dostal lvl up");
		}
	}
	public void byloZasazeno(float Silou){
		try{
		this.Zivoty -= ((Silou/2)/Lvl)*(Game.plr.Lvl+1);
		System.out.println(name+" "+Zivoty);
		}catch (Exception e) {
			System.out.println("Levl can´t be 0, setting lvl to 1");
			Lvl = 1;
			byloZasazeno(Silou);
		}
	}
}
