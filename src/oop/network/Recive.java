package oop.network;

import java.util.ArrayList;

import oop.Main.Game;

public abstract class Recive {
	
	/**
	 * 
	 * @param RecivedAction
	 * @return
	 */
	public static void ReciveAction(int RecivedAction) 
	{
		String[] splitedData = String.valueOf(RecivedAction).split("20052000");
		
		switch(splitedData[0]) 
		{
		case "1":
			break;
		case "2":
			switch (splitedData[1]) {
			case "1":
				Game.Zautoc(0);
				break;
			case "2":
				Game.eat(0);
				break;
			case "3":
				Game.next(0);
				break;
			case "4":
				Game.lektvar(0);
				break;

			default:
				break;	
			}
			break;
		}
		
	}

}
