import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {  
     
     static int maxProfit(int a[],int n,int k){
         
         
         int dp[][]=new int[k+1][n];
         
         for(int i=1;i<=k;i++){
             int diff=-a[0];
             for(int j=1;j<n;j++){
                 
                 dp[i][j]=Math.max(dp[i][j-1],diff+a[j]);
                 diff=Math.max(diff,dp[i-1][j]-a[j]);
             }
         }
         
         return dp[k][n-1];
     }
     
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
           int k=s.nextInt();
           int n=s.nextInt();
           int a[]=new int[n];
           
           for(int i=0;i<n;i++)
           a[i]=s.nextInt();
           
           System.out.println(maxProfit(a,n,k));
        
        }
	  
	  
	 }
}
