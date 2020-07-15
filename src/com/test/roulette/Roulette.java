package com.test.roulette;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Roulette {
	
	public static void main(String[] args)
	   {
		  Random generator = new Random(); //random number generated
		   int rouletteNum; //Winning Number
		   int x = 20; // wait 20 seconds at most
		   Scanner scanner = new Scanner(System.in); // Read the console inputs
		   String[] tokens = null; //Collect the tokens
		   ArrayList<String> myBets = new ArrayList<String>(); //Store the tokens
		   
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
		   
		   
		   
		   
	   }

}
