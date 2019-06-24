import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {  
     static int count(int a[],int n,int k){
         
        boolean dp[][]=new  boolean[n][n];
        
        int count=0;
        for(int i=0;i<n;i++){
        if(a[i]>k){
        dp[i][i]=true;
        count++;
        }
        }
        
        for(int l=2;l<=n;l++){
            
            for(int i=0;i<=n-l;i++){
                int j=i+l-1;
                
                if(dp[i][i]|| dp[i+1][j]){
                    dp[i][j]=true;
                    count++;
                }
                
            }
            
        }
         
         return count;
     }
     
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
           int n=s.nextInt();
           int k=s.nextInt();
           int a[]=new int[n];
           
           for(int i=0;i<n;i++)
           a[i]=s.nextInt();
           
           System.out.println(count(a,n,k));
        
        }
	  
	  
	 }
}
