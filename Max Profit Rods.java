/*package whatever //do not write package name here */

import java.io.*;

class MaxProfit{
    
    static int profit(int rods[],int price[],int len){
        
        int n=rods.length;
        
        int p[][]=new int[n+1][len+1];
        
        for(int i=1;i<=n;i++){
            
            for(int j=1;j<=len;j++){
                
                if(rods[i-1]>j)
                p[i][j]=p[i-1][j];
                else
                p[i][j]=Math.max(p[i-1][j],price[i-1]+p[i][j-rods[i-1]]);
                
               
                
            }
          
        }
        
        return p[n][len];
    }
    
	public static void main (String[] args) {
		
		int rods[]={1,2,3,4};
		int price[]={2,5,7,8};
		int len=5;
		System.out.println(profit(rods,price,len));
	}
}
