
*given infinite supply of coins,find out minimum no of coins required to form total*

/*package whatever //do not write package name here */

import java.util.*;

class   MinCoins{
    
    static HashMap<Integer,Integer> h=new HashMap<>();
    static int minCoins(int total,int coins[]){
        
        //if total=0 ,no of coins required =0
        if(total==0)
        return 0;
        
        // if total is present in hashtable return min coins in hashtable corresponding to total
        if(h.containsKey(total))
        return h.get(total);
        
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<coins.length;i++){
            
            //if coin value is greater than total move on
            if(coins[i]>total)
            continue;
            
            else
            min=Math.min(min,1+minCoins(total-coins[i],coins));
            
        }
        
        h.put(total,min);
        return min;
        
    }
	public static void main (String[] args) {
	  
	  int coins[]={1,2,3};
	  int total=5;
	  System.out.println("minimum no of coins "+ minCoins(total,coins));
	  
	}
}
