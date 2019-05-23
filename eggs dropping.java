/*package whatever //do not write package name here */

import java.io.*;

class   EggDropping {
    
    static int minAttempts(int floors,int eggs){
        
        int a[][]=new int[eggs+1][floors+1];
        
        for(int i=0; i <= floors; i++){
            a[1][i] = i;
        }
        
        for(int i=2;i<=eggs;i++){
            
            for(int j=1;j<=floors;j++){
                
                if(i>j)
                a[i][j]=a[i-1][j];
                else{
                int min=Integer.MAX_VALUE;
                 for(int k=1;k<=j;k++){
                     
                     min=Math.min(min,Math.max(a[i-1][k-1],a[i][j-k]));
                     
                     
                 }
            a[i][j]=1+min;
                }
            }
        }
        
        return a[eggs][floors];
    }
    
	public static void main (String[] args) {
	
	int floors=6;
	int eggs=2;
	 System.out.println(minAttempts(floors,eggs));
	
	}
}
