package oop.Main;

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
	
	public static Player plr;
	public static void game()
	{
		bylHracZabit();
		jidlo();
		pes.Stekni();
		zvireZautocilo();
		conIn();
	}
	private static void jidlo()
	{
		plr.Hlad -= 1;
		System.out.println("Aktuaåní úroveò hladu je: "+plr.Hlad);
		if(plr.Hlad<=0)
		{
			System.out.println("Máš hlad najez se");
			plr.Zivoty -= -(plr.Hlad-1);
			System.out.println("Umíráš na hlad !! Bylo ti ubráno: "+(plr.Hlad-1)+"\n Aktuální poèet životù je: "+plr.Zivoty);
		}
	}
	private static void zvireZautocilo()
	{
		Random rnd = new Random();
		int i =rnd.nextInt(2);
		int i2 = rnd.nextInt(7);
		if(i == 1)
		{
			if(i2 == 3)
			{
				if(Enemy == null){
					Enemy = pes;
					System.out.println("Pes zautocil !");
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
					System.out.println("Pes zautoci znovu");
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
				else if(Enemy == kocka)
				{
					System.out.println("Kocka zautocila znovu");
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
					System.out.println("Kocka zautocila !");
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
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zbývá: "+ (((plr.Lvl*100)/2) - plr.xp));
					}
				}else if(Enemy == pes)
				{
					System.out.println("Pes zautoci znovu");
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
					System.out.println("Kocka zautocila znovu");
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
	}
	public static void conIn()
	{
		Scanner scn = new Scanner(System.in);
		System.out.print("Napiš help pro zobrazení vìcí co mùžeš udìlat: ");
		String vstup = scn.next();
		if(vstup.equals("help"))
		{
			System.out.println("Pro útok napis: Zautoc");
			System.out.println("Pro Najedìní se napis: Jez");
			System.out.println("Pro vypití lektvaru napis: Lektvar");
			System.out.println("Pro další kolo napiš: Dalsi");
			conIn();
		}
		else if(vstup.equals("Zautoc"))
		{
			Zautoc();
		}
		else if(vstup.equals("Jez"))
		{
			eat();
		}
		else if(vstup.equals("Dalsi"))
		{
			naselItem();
			System.out.println("Pøeskakuji kolo! ");
		}
		else if(vstup.equals("Lektvar"))
		{
			lektvar();
		}
		else
		{
			System.out.println("Zadal jsi neplatný pøíkaz");
			conIn();
		}
	}
	public static void eat()
	{
		if(plr.inv[appel.id] == appel)
		{
		plr.Hlad+= 10;
		plr.inv[appel.id] = null;
		}
		else
		{
			System.out.println("Námáš z èeho se najezt");
		}
	}
	public static void Zautoc()
	{
		if(Enemy != null)
		{
			System.out.println("Máš tyto zbranì: ");
			int i = 0;
			if(plr.inv[0] == null && plr.inv[1] == null && plr.inv[2] == null && plr.inv[3] == null && plr.inv[4] == null)
			{
				System.out.println("V inventáøi nemáš nic :(");
				naselItem();
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
					Zautoc();
				}
				if(plr.inv[selectedPosition] != null)
				{
					Random rnd = new Random();
					int rnds = rnd.nextInt(3);
					if(rnds == 0 || rnds == 1 || rnds == 2)
					{
					Enemy.byloZasazeno(plr.inv[selectedPosition].sila * ((plr.Lvl+1)/2));
						if(Enemy.Zivoty <= 0)
						{
							System.out.println("Nepøítel byl zabit");
							plr.xp += 10*Enemy.Lvl;
							Enemy = null;
							plr.LvlUp();
							System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zbývá: "+ (((plr.Lvl*100)/2) - plr.xp));
							naselItem();
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
					conIn();
				}
			}
		}
		else
		{
			System.out.println("Nemùžeš útoèit do nièeho");
			naselItem();
		}
	}
	public static void naselItem()
	{
		Random rnd = new Random();
		int rnds = rnd.nextInt(100);
		if(rnds < 90)
		{
			int rndss = rnd.nextInt(6);
			if(rndss == 0)
			{
				if(plr.inv[appel.id] != appel)
				{
					System.out.println("Našel jsi jabko");
					plr.inv[appel.id] = appel;
				}
			}else if(rndss == 1)
			{
				if(plr.inv[woodenSword.id] != woodenSword)
				{
					System.out.println("Našel jsi Døevìný meè");
					plr.inv[woodenSword.id] = woodenSword;
				}
			}else if(rndss == 2)
			{
				if(plr.inv[stoneSword.id] != stoneSword)
				{
					System.out.println("Našel jsi Kamený meè");
					plr.inv[stoneSword.id] = stoneSword;
				}
			}else if(rndss == 3)
			{
				if(plr.inv[ironSword.id] != ironSword)
				{
					System.out.println("Našel jsi Železný meè");
					plr.inv[ironSword.id] = ironSword;
				}
			}else if(rndss == 4)
			{
				if(plr.inv[diamondSword.id] != diamondSword)
				{
					System.out.println("Našel jsi Diamantový meè");
					plr.inv[diamondSword.id] = diamondSword;
				}
			}else if(rndss == 5)
			{
				if(plr.inv[potion.id] != potion)
				{
					System.out.println("Našel jsi lektvar");
					plr.inv[potion.id] = potion;
				}
			}
		}
	}
	public static void lektvar()
	{
		plr.Zivoty += 10;
		plr.inv[potion.id] = null;
		System.out.println("Aktuaåní úroveò životù je: "+plr.Zivoty);
	}
	
	public static void bylHracZabit()
	{
		if(plr.Zivoty <=0)
		{
			System.out.println("Umøel jsi\n Po zmáèknutí jakékoliv klávesy se hra ukonèí");
			Scanner scn = new Scanner(System.in);
			scn.next();
			System.exit(0);
		}
	}

}