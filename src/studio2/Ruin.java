package studio2;

import java.util.Scanner;
import java.util.Random;

public class Ruin {

	public static void main(String[] args) 
	{
		Random rn = new Random();
		Scanner in = new Scanner(System.in);
		System.out.println("How much money are you starting with?");
		int startAmount = in.nextInt();
		System.out.println("What is your probability of winning?");
		double winChance = in.nextDouble();
		winChance = winChance * 100;
		System.out.println("What is today's win limit?");
		int winLimit = in.nextInt(); 
		System.out.println("How many days would you like to play?");
		int totalSimulations = in.nextInt();
		int numberofDays = 0;
		int totalRuins = 0;
		int totalWins = 0; 
		double expectedRuin = 0;
		
		while (numberofDays < totalSimulations)
			
		{
			int numberofplays = 0;
			int currentAmount = startAmount;
		while (currentAmount > 0 && currentAmount < winLimit)
		{
			
			int x = rn.nextInt(100) + 1;
			if (x <= winChance)
			{
				currentAmount ++;
			}
			else
			{
				currentAmount --;
			}
			numberofplays ++;
		
		} 
		numberofDays ++;
		
		System.out.print("Simulation " + numberofDays + ": " + numberofplays);
		if (currentAmount == winLimit)
		{
			System.out.println(" Success");
			totalWins ++;
		}
		else 
		{	
			System.out.println(" Ruin");
			totalRuins ++;
		}
		}
		double ruinRate = (totalRuins * 1.0)/(totalRuins + totalWins);
		if (winChance == 0.5)
		{
			expectedRuin = 1 - (startAmount/(winLimit * 1.0));
		}
		else
		{
			double a = (1 - winChance)/(winChance * 1.0);
			expectedRuin = (Math.pow(a, startAmount)-Math.pow(a, winLimit))/(1.0 - (Math.pow(a, (winLimit*1.0))));
		}
		System.out.println("Losses: " + totalRuins);
		System.out.println(Math.round(expectedRuin * 100.00)/100.00);
		System.out.println(Math.round(ruinRate * 100.00)/100.00);
		}

	}

