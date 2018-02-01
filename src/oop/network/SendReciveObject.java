package oop.network;

import java.awt.Point;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import oop.Item.Appel;
import oop.Item.DiamondSword;
import oop.Item.IronSword;
import oop.Item.Item;
import oop.Item.Potion;
import oop.Item.StoneSword;
import oop.Item.WoodenSword;
import oop.Zvirata.Kocka;
import oop.Zvirata.Pes;
import oop.Zvirata.Player;
import oop.Zvirata.Zvire;

public class SendReciveObject {
	
	public static final String splitNumber = "20052000";
	public static int sendItem(Item item) 
	{
		return  Integer.parseInt("2" +  splitNumber + String.valueOf(item.id) +  splitNumber +String.valueOf(item.sila));	
	}
	 // splitnumber: 20052000
	public static int sendZvire(Zvire zvire) 
	{
		try {
			return Integer.parseInt("3" + splitNumber + String.valueOf(zvire.id) + splitNumber + String.valueOf(zvire.Hlad) + splitNumber 
					+ String.valueOf(zvire.Lvl) +  splitNumber + String.valueOf(zvire.xp) +  splitNumber +String.valueOf(zvire.Zivoty) 
					+  splitNumber + String.valueOf(zvire.name.getBytes("US-ASCII")));
		} catch (NumberFormatException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return -1;
		}	
	}
	
	public static Object reciveObject(int recivedData) 
	{
		int typeOfEntity = Integer.parseInt(String.valueOf((String.valueOf(recivedData).toCharArray()[0])));
		
		String splitedtData[] = String.valueOf(recivedData).split(splitNumber);
		ArrayList<Integer> splitedDataInt = new ArrayList<Integer>();
		for (int i = 0; i < splitedtData.length; i++) {
			splitedDataInt.add(Integer.parseInt(splitedtData[i]));
		}
		int id = splitedDataInt.get(1);
		
		switch(typeOfEntity) 
		{
			case(2):
				int sila = splitedDataInt.get(2);
				switch(id)
				{
				case(0):
					return new WoodenSword();
				case(1):
					return new StoneSword();
				case(2):
					return new IronSword();
				case(3):
					return new DiamondSword();
				case(4):
					return new Appel();
				case(5):
					return new Potion();
				default:
					return null;
				}
			case(3):
				int name = splitedDataInt.get(6);
				int hlad = splitedDataInt.get(2);
				int lvl = splitedDataInt.get(3);
				int xp = splitedDataInt.get(4);
				int hp = splitedDataInt.get(5);
				switch(id)
				{
				case(0):
					return new Player(String.valueOf(name));
				case(1):
					return new Pes(hp, hlad, lvl, String.valueOf(name));
				case(2):
					return new Kocka(hp, hlad, lvl, String.valueOf(name));
				default:
					return null;
				}
			default:
				return null;
		}
	}
}
