import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 { 
     
     static int getMin(int a[],int i,int j){
         
         int min=Integer.MAX_VALUE;
         
         for(;i<=j;i++)
         min=Math.min(min,a[i]);
         
         return min;
     }
     
     static int min(int a[][],int n){
     
     int dp[][]=new int[n][3];
     
     for(int i=0;i<=2;i++)
     dp[0][i]=a[0][i];
     
     for(int i=1;i<n;i++){
         
         for(int j=0;j<3;j++){
             
             dp[i][j]=Math.min(getMin(dp[i-1],0,j-1),getMin(dp[i-1],j+1,2))+a[i][j];
         }
     }
     
     int max=Integer.MAX_VALUE;
     
     for(int i=0;i<3;i++)
     max=Math.min(max,dp[n-1][i]);
     
     return max;
     
 }
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
           int n=s.nextInt();
            
            int a[][]=new int[n][3];
            
            for(int i=0;i<n;i++){
                
                for(int j=0;j<3;j++)
                a[i][j]=s.nextInt();
            }
            
            System.out.println(min(a,n));
           
        
        }
	  
	  
	 }
}
