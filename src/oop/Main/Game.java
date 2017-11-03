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
	public static Kocka kocka = new Kocka(25,100,"Ko�ka");
	
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
		System.out.println("Aktua�n� �rove� hladu je: "+plr.Hlad);
		if(plr.Hlad<=0)
		{
			System.out.println("M� hlad najez se");
			plr.Zivoty -= -(plr.Hlad-1);
			System.out.println("Um�r� na hlad !! Bylo ti ubr�no: "+(plr.Hlad-1)+"\n Aktu�ln� po�et �ivot� je: "+plr.Zivoty);
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
						System.out.println("Pes se trefil, bylo ti ubr�no "+((Enemy.Sila/2*Enemy.Lvl)/plr.Lvl)+" �ivot�");
						plr.Zivoty -= ((Enemy.Sila/2)*Enemy.Lvl)/(plr.Lvl*2);
						pes.xp += 10;
						Enemy.xp += 10;
						plr.xp += 3;
						pes.LvlUp();
						Enemy.LvlUp();
						plr.LvlUp();
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zb�v�: "+ (((plr.Lvl*100)/2) - plr.xp));
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
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zb�v�: "+ (((plr.Lvl*100)/2) - plr.xp));
					}
				}
				else if(Enemy == pes)
				{
					System.out.println("Pes zautoci znovu");
					if(i2 != 7)
					{
						System.out.println("Pes se trefil, bylo ti ubr�no "+((pes.Sila/2*pes.Lvl)/plr.Lvl)+" �ivot�");
						plr.Zivoty -= ((Enemy.Sila/2)*Enemy.Lvl)/(plr.Lvl*2);
						pes.xp += 10;
						Enemy.xp += 10;
						plr.xp += 3;
						pes.LvlUp();
						Enemy.LvlUp();
						plr.LvlUp();
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zb�v�: "+ (((plr.Lvl*100)/2) - plr.xp));
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
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zb�v�: "+ (((plr.Lvl*100)/2) - plr.xp));
					}
				}
				else if(Enemy == kocka)
				{
					System.out.println("Kocka zautocila znovu");
					if(i2 != 7)
					{
						System.out.println("Kocka se trefila, bylo ti ubr�no "+((Enemy.Sila/2*Enemy.Lvl)/plr.Lvl)+" �ivot�");
						plr.Zivoty -= ((Enemy.Sila/2)*Enemy.Lvl)/(plr.Lvl*2);
						kocka.xp += 10;
						Enemy.xp += 10;
						plr.xp += 3;
						kocka.LvlUp();
						Enemy.LvlUp();
						plr.LvlUp();
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zb�v�: "+ (((plr.Lvl*100)/2) - plr.xp));
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
						System.out.println("Kocka se trefila, bylo ti ubr�no "+((Enemy.Sila/2*Enemy.Lvl)/plr.Lvl)+" �ivot�");
						plr.Zivoty -= ((Enemy.Sila/2)*Enemy.Lvl)/(plr.Lvl*2);
						kocka.xp += 10;
						Enemy.xp += 10;
						plr.xp += 3;
						kocka.LvlUp();
						Enemy.LvlUp();
						plr.LvlUp();
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zb�v�: "+ (((plr.Lvl*100)/2) - plr.xp));
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
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zb�v�: "+ (((plr.Lvl*100)/2) - plr.xp));
					}
				}else if(Enemy == pes)
				{
					System.out.println("Pes zautoci znovu");
					if(i2 == 7)
					{
						System.out.println("Pes se trefil bylo ti ubr�no "+((pes.Sila/2*pes.Lvl)/plr.Lvl)+" �ivot�");
						plr.Zivoty -= ((Enemy.Sila/2)*Enemy.Lvl)/(plr.Lvl*2);
						pes.xp += 10;
						Enemy.xp += 10;
						plr.xp += 3;
						pes.LvlUp();
						Enemy.LvlUp();
						plr.LvlUp();
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zb�v�: "+ (((plr.Lvl*100)/2) - plr.xp));
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
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zb�v�: "+ (((plr.Lvl*100)/2) - plr.xp));
					}
				}
				else if(Enemy == kocka)
				{
					System.out.println("Kocka zautocila znovu");
					if(i2 == 7)
					{
						System.out.println("Kocka se trefila bylo ti ubr�no "+((Enemy.Sila/2*Enemy.Lvl)/plr.Lvl)+" �ivot�");
						plr.Zivoty -= ((Enemy.Sila/2)*Enemy.Lvl)/(plr.Lvl*2);
						kocka.xp += 10;
						Enemy.xp += 10;
						plr.xp += 3;
						kocka.LvlUp();
						Enemy.LvlUp();
						plr.LvlUp();
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zb�v�: "+ (((plr.Lvl*100)/2) - plr.xp));
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
						System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zb�v�: "+ (((plr.Lvl*100)/2) - plr.xp));
				}
			}}
		}
	}
	public static void conIn()
	{
		Scanner scn = new Scanner(System.in);
		System.out.print("Napi� help pro zobrazen� v�c� co m��e� ud�lat: ");
		String vstup = scn.next();
		if(vstup.equals("help"))
		{
			System.out.println("Pro �tok napis: Zautoc");
			System.out.println("Pro Najed�n� se napis: Jez");
			System.out.println("Pro vypit� lektvaru napis: Lektvar");
			System.out.println("Pro dal�� kolo napi�: Dalsi");
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
			System.out.println("P�eskakuji kolo! ");
		}
		else if(vstup.equals("Lektvar"))
		{
			lektvar();
		}
		else
		{
			System.out.println("Zadal jsi neplatn� p��kaz");
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
			System.out.println("N�m� z �eho se najezt");
		}
	}
	public static void Zautoc()
	{
		if(Enemy != null)
		{
			System.out.println("M� tyto zbran�: ");
			int i = 0;
			if(plr.inv[0] == null && plr.inv[1] == null && plr.inv[2] == null && plr.inv[3] == null && plr.inv[4] == null)
			{
				System.out.println("V invent��i nem� nic :(");
				naselItem();
			}
			else
			{
				while(i<5)
				{
					if(plr.inv[i] != null)
					{
						System.out.println("Na pozici "+i+" m�: "+plr.inv[i].Name);
					}
					i++;
				}
				System.out.print("Zvol item v invent��i kter�m chce� �to�it (pozici v invent��i)");
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
							System.out.println("Nep��tel byl zabit");
							plr.xp += 10*Enemy.Lvl;
							Enemy = null;
							plr.LvlUp();
							System.out.println("Aktualni lvl: " + plr.Lvl + " Do dalsi levlu zb�v�: "+ (((plr.Lvl*100)/2) - plr.xp));
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
					System.out.println("Na t�to pozici nen� ��dn� item :(");
					conIn();
				}
			}
		}
		else
		{
			System.out.println("Nem��e� �to�it do ni�eho");
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
					System.out.println("Na�el jsi jabko");
					plr.inv[appel.id] = appel;
				}
			}else if(rndss == 1)
			{
				if(plr.inv[woodenSword.id] != woodenSword)
				{
					System.out.println("Na�el jsi D�ev�n� me�");
					plr.inv[woodenSword.id] = woodenSword;
				}
			}else if(rndss == 2)
			{
				if(plr.inv[stoneSword.id] != stoneSword)
				{
					System.out.println("Na�el jsi Kamen� me�");
					plr.inv[stoneSword.id] = stoneSword;
				}
			}else if(rndss == 3)
			{
				if(plr.inv[ironSword.id] != ironSword)
				{
					System.out.println("Na�el jsi �elezn� me�");
					plr.inv[ironSword.id] = ironSword;
				}
			}else if(rndss == 4)
			{
				if(plr.inv[diamondSword.id] != diamondSword)
				{
					System.out.println("Na�el jsi Diamantov� me�");
					plr.inv[diamondSword.id] = diamondSword;
				}
			}else if(rndss == 5)
			{
				if(plr.inv[potion.id] != potion)
				{
					System.out.println("Na�el jsi lektvar");
					plr.inv[potion.id] = potion;
				}
			}
		}
	}
	public static void lektvar()
	{
		plr.Zivoty += 10;
		plr.inv[potion.id] = null;
		System.out.println("Aktua�n� �rove� �ivot� je: "+plr.Zivoty);
	}
	
	public static void bylHracZabit()
	{
		if(plr.Zivoty <=0)
		{
			System.out.println("Um�el jsi\n Po zm��knut� jak�koliv kl�vesy se hra ukon��");
			Scanner scn = new Scanner(System.in);
			scn.next();
			System.exit(0);
		}
	}

}