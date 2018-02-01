package oop.Zvirata;

import oop.Item.Item;

public class Player extends Zvire {

	/**
	 * This is you
	 */
	public Item[] inv =new Item[6];
	public Player(String name) {
		super(100, 50, 1, name,0);
	}
}
