import java.util.Scanner;

//Harsh Patel
//Multi Deck Blackjack
public class BlackJack {

	public static void main(String[] args)
	{
		boolean playAgain = true;
		int handSize = 2;
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Blackjack! ");
	do {
			
			deal();
			System.out.println("Your hand is: " + playerHand[0] + " and a " + playerHand[1] + "\nWhich has a value of: " + playerVal);
			if(playerVal == 21)
			{
				System.out.println("You Won with a BlackJack! ");
			}
		else
		{ 	System.out.println("Would you like to hit? Type 'Yes' or 'No' ");
			String willHit = scan.nextLine();
			HitLoop:
			while(willHit.toLowerCase().equals("yes"))
			{
				hit();
				willHit = "";
				System.out.print("\nYou received a: " + playerHand[handSize++]);
				if(playerVal > 21)
				{
					System.out.println("\nYou busted with " + playerVal +"!");
					break HitLoop;
				}
				else if(playerVal < 21)
				{
					System.out.println("\nYou are up to "+playerVal +"\nWould you like to hit again? Type 'Yes' or 'No' ");
					willHit = scan.nextLine();
				}
			}
			System.out.println("The dealer had: ");
			for(int j = 0; j < dealerHand.length && dealerHand[j]!=null; j++)
			{
				System.out.print(dealerHand[j] +", ");
			}
			
			System.out.println("For a total of: " + dealerVal);
			if(dealerVal > 21)
			{
				System.out.println("The dealer busts. You Win!");
			}
			else if(playerVal> dealerVal && playerVal <= 21)
			{
				System.out.println("Congratulations You Win!");
			}
			else if(playerVal==dealerVal)
			{
				System.out.println("You tied!");
			}
			else
			{
				System.out.println("The dealer won!");
			}
		}
			reset();
			System.out.println("To play again. Type 'play'");
			if(scan.nextLine().equals("play")) playAgain = true;
			else
				playAgain = false;
	} while (playAgain);
		
	}
	
	
	
	public static String[] suits = {"CLUBS", "HEARTS", "SPADES", "DIAMONDS"};
	public static String[] card = {"2","3","4","5","6","7","8","9","10", "JACK", "QUEEN", "KING", "ACE"};
	public static String[] playerHand = new String[14];
	public static String[] dealerHand = new String[14];
	public static int dealerVal = 0;
	public static int playerVal= 0;
	private static int cards = 0;
	private static boolean highAce = false;;
	
	public static void deal()
	{
		
		playerHand[0] = card[(int) Math.floor((Math.random()*12)+ 1)]+" of " + suits[(int) Math.floor((Math.random()*3)+ 1) ];
		cards = cards + 1;
		if(playerHand[0].charAt(0) == '1') playerVal+=10;
		else if(playerHand[0].charAt(0) == 'J') playerVal+=10;
		else if(playerHand[0].charAt(0) == 'Q') playerVal+=10;
		else if(playerHand[0].charAt(0) == 'K') playerVal+=10;
		else if(playerHand[0].charAt(0) == 'A')
		{ 
			highAce = true;
			playerVal+=11;
		}
		else
		{
			String s = playerHand[0].charAt(0) + "";
			playerVal+= Integer.parseInt(s);
			
		}
		playerHand[1] = card[(int) Math.floor((Math.random()*12)+ 1)]+" of " + suits[(int) Math.floor((Math.random()*3)+ 1) ];
		cards = cards + 1;
		if(playerHand[1].charAt(0) == '1') playerVal+=10;
		else if(playerHand[1].charAt(0) == 'J') playerVal+=10;
		else if(playerHand[1].charAt(0) == 'Q') playerVal+=10;
		else if(playerHand[1].charAt(0) == 'K') playerVal+=10;
		else if(playerHand[1].charAt(0) == 'A')
		{ 
			
			if(highAce)
				playerVal+=1;
			else
				playerVal+=11;
		}
		else
		{
			String s = playerHand[1].charAt(0) + "";
			playerVal+= Integer.parseInt(s);
			
		}
		
		for(int i = 0; dealerVal < 17; i++)
		{
			int cardVal = 0;
			dealerHand[i] = card[(int) Math.floor((Math.random()*12)+ 1)]+" of " + suits[(int) Math.floor((Math.random()*3)+ 1) ];
			if(dealerHand[i].charAt(0) == '1') dealerVal+=10;
			else if(dealerHand[i].charAt(0) == 'J') dealerVal+=10;
			else if(dealerHand[i].charAt(0) == 'Q') dealerVal+=10;
			else if(dealerHand[i].charAt(0) == 'K') dealerVal+=10;
			else if(dealerHand[i].charAt(0) == 'A')
			{ 
				if(i == 0)
					dealerVal+=11;
				else
					dealerVal+=1;
			}
			else
			{
				String s = dealerHand[i].charAt(0) + "";
				cardVal = Integer.parseInt(s);
				dealerVal+=cardVal;
			}
			
			
		}
		
	}
	
	public static void hit()
	{
		playerHand[cards] = card[(int) Math.floor((Math.random()*12)+ 1)]+" of " + suits[(int) Math.floor((Math.random()*3)+ 1) ];
		if(playerHand[cards].charAt(0) == '1') playerVal+=10;
		else if(playerHand[cards].charAt(0) == 'J') playerVal+=10;
		else if(playerHand[cards].charAt(0) == 'Q') playerVal+=10;
		else if(playerHand[cards].charAt(0) == 'K') playerVal+=10;
		else if(playerHand[cards].charAt(0) == 'A')
		{ 
	
			if(highAce || 11 + playerVal > 21)
				playerVal+=1;
			else
				playerVal+=11;
		}
		else
		{
			String s = playerHand[cards].charAt(0) + "";
			playerVal+= Integer.parseInt(s);
			
		}
		
		if(highAce && playerVal >21)
		{
			playerVal-=10;
		}
		cards = cards + 1;
	}
	public static void reset()
	{
		playerHand = new String[14];
		dealerHand = new String[14];
		dealerVal = 0;
		playerVal = 0;
		cards = 0;
	}
	

	
	
}

