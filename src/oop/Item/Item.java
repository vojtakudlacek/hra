package oop.Item;


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
	public int getItemNumberCode() 
	{
		int code = Integer.parseInt(String.valueOf(id));
		return code;
	}
}
