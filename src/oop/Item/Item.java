package oop.Item;

import oop.Zvirata.Player;

public class Item {
	/**
	 * Item obj. template
	 */
	public int id;
	public float sila;
	public String Name;
	public Item(int inid,float insila,String inName)
	{
		id = inid;
		sila = insila;
		Name = inName;
	}
}
