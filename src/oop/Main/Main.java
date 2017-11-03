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
		System.out.print("Zadej Jméno hráèe: ");
		Scanner scn = new Scanner(System.in);
		Game.plr = new Player(scn.next());
		Game.plr.Lvl = 1;
		while(true){
			System.out.print("Vyber si: \n 1. Singlplayer \n 2. Multiplayer \n Zadej výbìr: ");
			vyber = scn.nextInt();
			switch (vyber) {
			case 1:
				while(true)
				{
					Game.game();
				}
			case 2:
				System.out.println("Multiplayer není iplementován!");
			default:
				if(vyber > 2)
					System.out.println("Chyba: Neplatný výbìr! \n"
							+ "Skus to znova");
				break;
				}
		
		}
	}

}
