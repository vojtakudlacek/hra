package oop.Main;

import java.util.Scanner;

import oop.Zvirata.Player;

/**
 * Game init
 * @author vojta
 *
 */
public class Main {

	public static void main(String[] args)
	{
		int vyber;
		
		Scanner scn = new Scanner(System.in);
		
		while(true){
			System.out.print("Vyber si: \n 1. Singlplayer \n 2. Multiplayer \n Zadej v�b�r: ");
			vyber = scn.nextInt();
			switch (vyber) {
			case 1:
				System.out.print("Zadej Jm�no hr��e: ");
				Game.plrList.add(new Player(scn.nextLine()));
				while(true)
				{
					Game.game();
				}
			case 2:
				System.out.print("Vyber si: \n 1. Lok�ln� \n 2. TCP/IP Server \n 3. TCP/IP Clinet \n Vyber si: ");
				int vyberMP = scn.nextInt();
				switch (vyberMP)
				{
					case(1):
						scn.nextLine();
						System.out.print("Zadej Jm�no 1. hr��e: ");
						Game.plrList.add(new Player(scn.nextLine()));
						System.out.println("");
						System.out.print("Zadej Jm�no 2. hr��e: ");
						Game.plrList.add(new Player(scn.nextLine()));
						while(true){
							Game.multiplayer("Local");
						}
					case(2):
						System.out.print("Zadej Jm�no hr��e: ");
						Game.plrList.add(new Player(scn.nextLine()));
						
						Game.multiplayer("TCP/IPs");
						break;
					case(3):
						System.out.print("Zadej Jm�no hr��e: ");
						Game.plrList.add(new Player(scn.nextLine()));
						Game.multiplayer("TCP/IPc");
						break;
					default:
						if(vyber > 3)
							System.out.println("Chyba: Neplatn� v�b�r! \n"
									+ "Zkus to znova");
						break;
				}
				break;
				//System.out.println("Multiplayer nen� iplementov�n!");
			default:
				if(vyber > 2)
					System.out.println("Chyba: Neplatn� v�b�r! \n"
							+ "Zkus to znova");
				break;
				}
			scn.close();
		
		}
	}

}
