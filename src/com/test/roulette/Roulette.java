package com.test.roulette;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Roulette {
	
	public static void main(String[] args)
	   {
			ReadFileForPlayers();
		  Random generator = new Random(); //random number generated
		   int rouletteNum; //Winning Number
		   int x = 20; // wait 20 seconds at most
		   Scanner scanner = new Scanner(System.in); // Read the console inputs
		   String[] tokens = null; //Collect the tokens
		   ArrayList<String> myBets = new ArrayList<String>(); //Store the tokens
		   ArrayList<Outcome> outcome = new ArrayList<Outcome>(); //Stire the Outcomes
		   
		   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		   long startTime = System.currentTimeMillis();
		   try {
				   while ((System.currentTimeMillis() - startTime) < x * 1000 && !in.ready()) 
				   {
					  tokens =  scanner.nextLine().split("\\s"); 				 
					  myBets.add(Arrays.toString(tokens));
					  System.out.println(Arrays.toString(tokens));				  
				   }
		   }catch(Exception e) { e.printStackTrace();   }
		   
		   rouletteNum = generator.nextInt(37); System.out.println("WINNING No. - - ->" + rouletteNum);//Winning Number
		   
		   //Iterate thru the Array to collect the tokens, comma separted
		   for(String str: myBets) {	
			   if(str.length() < 3) break;
			   String bets = str.substring(1, str.length()-1); //Remove the [ ]
			   //System.out.println("YOU PLACED YOUR BETS as - - ->" + bets);
			   int iamt =0;
			   //Collect the token (Name, Bet and amount)
			   StringTokenizer stok = new StringTokenizer(bets, ",");
			   String strName = stok.nextToken(); //Name
			   String strBetValue = stok.nextToken(); //Bet
			   String strAmount = stok.nextToken();//Amount 
			   iamt = Integer.parseInt(strAmount.trim());
			   
			   boolean value = strBetValue.matches("[a-zA-Z ]*\\d+.*");
			   //System.out.println("Is NUMERIC - - - " +value);
			   int ibetNum =0;
			   Outcome out = new Outcome(); //Outcome of each bet, comand line input
			   out.setStrPlayerName(strName);
			   out.setStrBet(strBetValue);
			   if(value) { // If for the numeric bet
				   ibetNum = Integer.parseInt(strBetValue.trim());
				   if (ibetNum == rouletteNum) {
					   out.setStrResult("WIN");
					   out.setStrWinnings(iamt*36);
					   System.out.println("WOWW YOU WIN");
				   }else {
					   out.setStrResult("LOSE");
					   out.setStrWinnings(0);
				   }
			    }else {    //if(strBetValue.contentEquals(new StringBuffer("ODD")))
			    	//else for EVEN-ODD bets
			    	if (rouletteNum % 2 != 0) // Roullette Num is ODD
			    	{	
			    		if(strBetValue.trim().equals("ODD"))
			    		{
			    			System.out.println("*****Player bet ODD Number---");
			    			out.setStrResult("WIN");
							out.setStrWinnings(iamt*2);
			    		}else {
			    			out.setStrResult("LOSE");
							out.setStrWinnings(0);
			    		}
			    		//if(strBetValue.contentEquals(new StringBuffer("ODD")))			    		
			    	}else { // Roullette Num is EVEN
			    		System.out.println("EVEN or ODD??? ELSE  " + strBetValue);
			    		if(strBetValue.trim().equals("EVEN"))
			    		{
			    			System.out.println("*****Player bet EVEN Number---");
			    			out.setStrResult("WIN");
							out.setStrWinnings(iamt*2);
			    		}else {
			    			out.setStrResult("LOSE");
							out.setStrWinnings(0);
			    		}
			    	}
			    }
			   
			   outcome.add(out);
			   //System.out.println(" Player : "+ strName + " Placed bet on : " +strBetValue+ " for Amount : "+strAmount);
			   
		   }//End For Bets
		   
		   //OUTPUT to console 
		   System.out.println("Player   "+  " Bet  "+ " Outcome  "+ "  Winnings ");
		   System.out.println("------------------------------------------- ");
		   //Iterate thru the OUTCOMES
		   for(Outcome out: outcome) {
			   
			   System.out.println(out.getStrPlayerName()+ "   " +out.getStrBet()+ "    " +out.getStrResult()+ "       " +out.getStrWinnings());
			   
		   }		   
		   
	   }//Main End
	
	   public static void ReadFileForPlayers() {
		   
		   BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader("players.txt"));
				String line = reader.readLine();
				while (line != null) {
					System.out.println(line);
					// read next line
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
       }
	   
	   public static void WriteFileForPlayers() {
		   
	   }

}
