package oop.Zvirata;

import oop.Main.Game;

public class Zvire {
	/**
	 * This is template for all entities
	 */
	public float Zivoty;
	public int Hlad;
	public int Lvl;
	public int xp;
	public int Sila;
	public String name;
	public int id;
	
	public Zvire(int z,String nm,int id)
	{
		Zivoty = z;
		Hlad = 100;
		Lvl = 1;
		name = nm;
		this.id = id;
	}
	public Zvire(int z,int h,String nm,int id)
	{
		Zivoty = z;
		Hlad = h;
		Lvl = 1;
		name = nm; 
		this.id = id;
	}
	public Zvire(int z,int h,int l,String nm,int id){
		Zivoty = z;
		Hlad = h;
		Lvl = l;
		name = nm;
		this.id = id;
	}
	public Zvire(int z,int h,int l,String nm,int s, int id)
	{
		Zivoty = z;
		Hlad = h;
		Lvl = l;
		name = nm;
		Sila = s;
		this.id = id;
	}
	public void LvlUp()
	{
		if(xp >= (Lvl*100)/2)
		{
			Lvl++;
			System.out.println(name+" dostal lvl up");
		}
	}
	public void byloZasazeno(float Silou,int playerID){
		Player plr = Game.plrList.get(playerID);
		try{
		this.Zivoty -= ((Silou/2)/Lvl)*(plr.Lvl+1);
		System.out.println(name+" "+Zivoty);
		}catch (Exception e) {
			System.out.println("Levl can�t be 0, setting lvl to 1");
			Lvl = 1;
			byloZasazeno(Silou,playerID);
		}
	}
}