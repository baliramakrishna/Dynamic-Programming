/**
 
 * Given a total and coins of certain denominations find number of ways total
 * can be formed from coins assuming infinity supply of coins
 *
 * References:
 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 */
 
 /*package whatever //do not write package name here */

import java.io.*;

class TotalWays{
    
    static int totalways(int coins[],int total){
        
        if(total==0)
        return 0;
        
        int t[][]=new int[coins.length+1][total+1];
        
        for(int i=0;i<=coins.length;i++)
        t[i][0]=1;
        
        for(int i=1;i<=coins.length;i++){
            
            for(int j=1;j<=total;j++){
                

                if(j>=coins[i-1])
                t[i][j]=t[i-1][j]+t[i][j-coins[i-1]];
                else
                 t[i][j]=t[i-1][j];
            }
        }
       
       return t[coins.length][total]; 
        
    }
	public static void main (String[] args) {
	 
	  int total = 5;
      int coins[] = {1,2,3};
      System.out.println("No of ways "+totalways(coins,total));
	 
	 
	}
}
