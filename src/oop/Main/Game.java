package oop.Main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import oop.Item.Appel;
import oop.Item.DiamondSword;
import oop.Item.IronSword;
import oop.Item.Potion;
import oop.Item.StoneSword;
import oop.Item.WoodenSword;
import oop.Zvirata.Kocka;
import oop.Zvirata.Pes;
import oop.Zvirata.Player;
import oop.Zvirata.Zvire;
import oop.network.Client;
import oop.network.Server;

/**
 * Main game core
 * @author vojta
 *
 */
public class Game {
	public static Zvire Enemy;
	public static int selectedPosition;
	public static Appel appel = new Appel();
	public static Potion potion = new Potion();
	public static WoodenSword woodenSword = new WoodenSword(); 
	public static StoneSword stoneSword = new StoneSword();
	public static IronSword ironSword = new IronSword();
	public static DiamondSword diamondSword = new DiamondSword();
	
	
	public static Pes pes = new Pes(30, 100, 1,"Pes");
	public static Kocka kocka = new Kocka(25,100,"Koèka");
	
	public static ArrayList<Player> plrList = new ArrayList<Player>();
	public static void game()
	{
		
		bylHracZabit();
		jidlo();
		pes.Stekni();
		zvireZautocilo();
		conIn(0);
	}
	public static void multiplayer(String type)
	{
		switch (type) {
		case "Local":
			bylHracZabit();
			jidlo();
			pes.Stekni();
			zvireZautocilo();
				if(plrList.size() == 2){
					conIn(0);
					conIn(1);
				}
				else
				{
					conIn(0);
				}
			
			break;
		case "TCP/IPc":
			
			Client client = new Client("localhost", 8123);
			System.out.println(client.getDataFromServer());
			client.sendDataToServer(36985);
			
			break;
		case "TCP/IPs":
			Server server = new Server(8123);
			server.brodcast(0123);
			System.out.println(server.getDataFromClient());
			
			break;
		}
	}
	private static void jidlo()
	{
		for (Player plr : plrList) {
			
		
		plr.Hlad -= 1;
		System.out.println("Aktuaåní úroveò hladu hráèe "+plr.name+" je: "+plr.Hlad);
		if(plr.Hlad<=0)
		{
			System.out.println("Máš hlad najez se");
			plr.Zivoty -= -(plr.Hlad-1);
			System.out.println("Umíráš na hlad !! Bylo ti ubráno: "+(plr.Hlad-1)+"\n Aktuální poèet životù je: "+plr.Zivoty);
		}
		}
	}
	private static void zvireZautocilo() // random player id
	{
		Random rnd = new Random();
		int i =rnd.nextInt(2);
		int i2 = rnd.nextInt(7);
		int i3 = rnd.nextInt(plrList.size());
		Player plr = plrList.get(i3);
		if(i == 1)
		{
			if(i2 == 3)
			{
				if(Enemy == null){
					Enemy = pes;
					System.out.println("Pes zautocil na hráèe "+plr.name+" !");
					if(i2 != 7)
					{
						System.out.println("Pes se trefil, bylo ti ubráno "+((Enemy.Sila/2*Enemy.Lvl)/plr.Lvl)+" životù");
						plr.Zivoty -= ((Enemy.Sila/2)*Enemy.Lvl)/(plr.Lvl*2);
						pes.xp += 10;
						Enemy.xp += 10;
						plr.xp += 3;
						pes.LvlUp();
						Enemy.LvlUp();
						plr.LvlUp();
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zbývá: "+ (((plr.Lvl*100)/2) - plr.xp));
					}
					else
					{
						System.out.println("Pes se netrefil");
						pes.xp += 3;
						Enemy.xp += 3;
						plr.xp += 5;
						pes.LvlUp();
						Enemy.LvlUp();
						plr.LvlUp();
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zbývá: "+ (((plr.Lvl*100)/2) - plr.xp));
					}
				}
				else if(Enemy == pes)
				{
					System.out.println("Pes zautoci znovu na hrace "+plr.name);
					if(i2 != 7)
					{
						System.out.println("Pes se trefil, bylo ti ubráno "+((pes.Sila/2*pes.Lvl)/plr.Lvl)+" životù");
						plr.Zivoty -= ((Enemy.Sila/2)*Enemy.Lvl)/(plr.Lvl*2);
						pes.xp += 10;
						Enemy.xp += 10;
						plr.xp += 3;
						pes.LvlUp();
						Enemy.LvlUp();
						plr.LvlUp();
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zbývá: "+ (((plr.Lvl*100)/2) - plr.xp));
					}
					else
					{
						System.out.println("Pes se netrefil");
						pes.xp += 3;
						Enemy.xp += 3;
						plr.xp += 5;
						pes.LvlUp();
						Enemy.LvlUp();
						plr.LvlUp();
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zbývá: "+ (((plr.Lvl*100)/2) - plr.xp));
					}
				}
				else if(Enemy == kocka) // ?????
				{
					System.out.println("Kocka zautocila znovu na hrace "+plr.name);
					if(i2 != 7)
					{
						System.out.println("Kocka se trefila, bylo ti ubráno "+((Enemy.Sila/2*Enemy.Lvl)/plr.Lvl)+" životù");
						plr.Zivoty -= ((Enemy.Sila/2)*Enemy.Lvl)/(plr.Lvl*2);
						kocka.xp += 10;
						Enemy.xp += 10;
						plr.xp += 3;
						kocka.LvlUp();
						Enemy.LvlUp();
						plr.LvlUp();
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zbývá: "+ (((plr.Lvl*100)/2) - plr.xp));
					}
					else
					{
						System.out.println("Kocka se netrefila");
						kocka.xp += 3;
						Enemy.xp += 3;
						plr.xp += 5;
						kocka.LvlUp();
						Enemy.LvlUp();
						plr.LvlUp();
				}}
			}
		}else if(i == 0)
		{
			if(i2 == 3)
			{
				if(Enemy == null){
					Enemy = kocka;
					System.out.println("Kocka zautocila na hráèe "+plr.name+" !");
					if(i2 != 7)
					{
						System.out.println("Kocka se trefila, bylo ti ubráno "+((Enemy.Sila/2*Enemy.Lvl)/plr.Lvl)+" životù");
						plr.Zivoty -= ((Enemy.Sila/2)*Enemy.Lvl)/(plr.Lvl*2);
						kocka.xp += 10;
						Enemy.xp += 10;
						plr.xp += 3;
						kocka.LvlUp();
						Enemy.LvlUp();
						plr.LvlUp();
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zbývá: "+ (((plr.Lvl*100)/2) - plr.xp));
					}
					else
					{
						System.out.println("Kocka se netrefila ");
						kocka.xp += 3;
						Enemy.xp += 3;
						plr.xp += 5;
						kocka.LvlUp();
						Enemy.LvlUp();
						plr.LvlUp();
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zbývá: "+ (((plr.Lvl*100)/2) - plr.xp));
					}
				}else if(Enemy == pes)
				{
					System.out.println("Pes zautoci znovu na hráèe"+plr.name);
					if(i2 == 7)
					{
						System.out.println("Pes se trefil bylo ti ubráno "+((pes.Sila/2*pes.Lvl)/plr.Lvl)+" životù");
						plr.Zivoty -= ((Enemy.Sila/2)*Enemy.Lvl)/(plr.Lvl*2);
						pes.xp += 10;
						Enemy.xp += 10;
						plr.xp += 3;
						pes.LvlUp();
						Enemy.LvlUp();
						plr.LvlUp();
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zbývá: "+ (((plr.Lvl*100)/2) - plr.xp));
					}
					else
					{
						System.out.println("Pes se netrefil");
						pes.xp += 3;
						Enemy.xp += 3;
						plr.xp += 5;
						pes.LvlUp();
						Enemy.LvlUp();
						plr.LvlUp();
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zbývá: "+ (((plr.Lvl*100)/2) - plr.xp));
					}
				}
				else if(Enemy == kocka)
				{
					System.out.println("Kocka zautocila znovu na hráèe"+plr.name);
					if(i2 == 7)
					{
						System.out.println("Kocka se trefila bylo ti ubráno "+((Enemy.Sila/2*Enemy.Lvl)/plr.Lvl)+" životù");
						plr.Zivoty -= ((Enemy.Sila/2)*Enemy.Lvl)/(plr.Lvl*2);
						kocka.xp += 10;
						Enemy.xp += 10;
						plr.xp += 3;
						kocka.LvlUp();
						Enemy.LvlUp();
						plr.LvlUp();
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zbývá: "+ (((plr.Lvl*100)/2) - plr.xp));
					}
					else
					{
						System.out.println("Kocka se netrefila");
						kocka.xp += 3;
						Enemy.xp += 3;
						plr.xp += 5;
						kocka.LvlUp();
						Enemy.LvlUp();
						plr.LvlUp();
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zbývá: "+ (((plr.Lvl*100)/2) - plr.xp));
				}
			}}
		}
		plrList.set(i3, plr);
	}
	public static void conIn(int playerID)
	{
		Player plr = plrList.get(playerID);
		Scanner scn = new Scanner(System.in);
		System.out.print(plr.name + ": Napiš help pro zobrazení vìcí co mùžeš udìlat: ");
		String vstup = scn.nextLine();
		scn.reset();
		if(vstup.equals("help"))
		{
			System.out.println("Pro útok napis: Zautoc");
			System.out.println("Pro Najedìní se napis: Jez");
			System.out.println("Pro vypití lektvaru napis: Lektvar");
			System.out.println("Pro další kolo napiš: Dalsi");
			conIn(playerID);
		}
		else if(vstup.equals("Zautoc"))
		{
			Zautoc(playerID);
		}
		else if(vstup.equals("Jez"))
		{
			eat(playerID);
		}
		else if(vstup.equals("Dalsi"))
		{
			naselItem(playerID);
			System.out.println("Pøeskakuji kolo! ");
		}
		else if(vstup.equals("Lektvar"))
		{
			lektvar(playerID);
		}
		else
		{
			System.out.println("Zadal jsi neplatný pøíkaz");
			conIn(playerID);
		}
	}
	public static void eat(int playerID)
	{
		Player plr = plrList.get(playerID);
		if(plr.inv[appel.id] == appel)
		{
		plr.Hlad+= 10;
		plr.inv[appel.id] = null;
		}
		else
		{
			System.out.println("Námáš z èeho se najezt");
		}
		plrList.set(playerID, plr);
	}
	public static void Zautoc(int playerID)
	{
		Player plr = plrList.get(playerID);
		if(Enemy != null)
		{
			System.out.println("Máš tyto zbranì: ");
			int i = 0;
			if(plr.inv[0] == null && plr.inv[1] == null && plr.inv[2] == null && plr.inv[3] == null && plr.inv[4] == null)
			{
				System.out.println("V inventáøi nemáš nic :(");
				naselItem(playerID);
			}
			else
			{
				while(i<5)
				{
					if(plr.inv[i] != null)
					{
						System.out.println("Na pozici "+i+" máš: "+plr.inv[i].Name);
					}
					i++;
				}
				System.out.print("Zvol item v inventáøi kterím chceš útoèit (pozici v inventáøi)");
				try
				{
					Scanner scn = new Scanner(System.in);
					selectedPosition = scn.nextInt();
				}catch (Exception e) {
					System.out.println("Zadal jsi neplatnou volbu. Zkus to znova!");
					Zautoc(playerID);
				}
				if(plr.inv[selectedPosition] != null)
				{
					Random rnd = new Random();
					int rnds = rnd.nextInt(3);
					if(rnds == 0 || rnds == 1 || rnds == 2)
					{
					Enemy.byloZasazeno(plr.inv[selectedPosition].sila * ((plr.Lvl+1)/2),playerID);
						if(Enemy.Zivoty <= 0)
						{
							System.out.println("Nepøítel byl zabit");
							plr.xp += 10*Enemy.Lvl;
							Enemy = null;
							plr.LvlUp();
							System.out.println("Aktualni lvl hráèe "+ plr.name +" je: " + plr.Lvl + " Do dalsi levlu zbývá: "+ (((plr.Lvl*100)/2) - plr.xp));
							naselItem(playerID);
							kocka.Zivoty = 25;
							pes.Zivoty = 30;
						}
					}
					else
					{
						System.out.println("Netrefil ses :(");
					}
				}
				else
				{
					System.out.println("Na této pozici není žádný item :(");
					conIn(playerID);
				}
			}
		}
		else
		{
			System.out.println("Nemùžeš útoèit do nièeho");
			naselItem(playerID);
		}
		plrList.set(playerID, plr);
		
	}
	public static void naselItem(int playerID)
	{
		Player plr = plrList.get(playerID);
		Random rnd = new Random();
		int rnds = rnd.nextInt(100);
		if(rnds < (90)/plrList.size())
		{
			int rndss = rnd.nextInt(6);
			if(rndss == 0)
			{
				if(plr.inv[appel.id] != appel)
				{
					System.out.println("Hráè "+plr.name+" našel jabko");
					plr.inv[appel.id] = appel;
				}
			}else if(rndss == 1)
			{
				if(plr.inv[woodenSword.id] != woodenSword)
				{
					System.out.println("Hráè "+plr.name+" našel Døevìný meè");
					plr.inv[woodenSword.id] = woodenSword;
				}
			}else if(rndss == 2)
			{
				if(plr.inv[stoneSword.id] != stoneSword)
				{
					System.out.println("Hráè "+plr.name+" našel Kamený meè");
					plr.inv[stoneSword.id] = stoneSword;
				}
			}else if(rndss == 3)
			{
				if(plr.inv[ironSword.id] != ironSword)
				{
					System.out.println("Hráè "+plr.name+" našel Železný meè");
					plr.inv[ironSword.id] = ironSword;
				}
			}else if(rndss == 4)
			{
				if(plr.inv[diamondSword.id] != diamondSword)
				{
					System.out.println("Hráè "+plr.name+" našel Diamantový meè");
					plr.inv[diamondSword.id] = diamondSword;
				}
			}else if(rndss == 5)
			{
				if(plr.inv[potion.id] != potion)
				{
					System.out.println("Hráè "+plr.name+" našel lektvar");
					plr.inv[potion.id] = potion;
				}
			}
		}
		plrList.set(playerID, plr);
	}
	public static void lektvar(int playerID)
	{
		Player plr = plrList.get(playerID);
		plr.Zivoty += 10;
		plr.inv[potion.id] = null;
		System.out.println("Aktuaåní úroveò životù hráèe "+plr.name+" je: "+plr.Zivoty);
		plrList.set(playerID, plr);
	}
	
	public static void bylHracZabit()
	{
		
		if(plrList.get(0).Zivoty <=0 && plrList.size() == 1)
		{
			System.out.println("Umøel jsi\n Po zmáèknutí jakékoliv klávesy se hra ukonèí");
			Scanner scn = new Scanner(System.in);
			scn.next();
			scn.close();
			System.exit(0);
		}else
		{
			for (Player plr : plrList) {
				if(plr.Zivoty <= 0)
				{
					System.out.println("Hráè " + plr.name + "umøel");
					plrList.remove(plr);
				}
			}
			
		}
	}
}