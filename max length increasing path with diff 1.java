/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
    
    static int row[]={0,0,1,-1};
    static int col[]={1,-1,0,0};
    static int max(int i,int j,int mat[][],int dp[][],int n,int m){
        
        if(dp[i][j]!=-1)
        return dp[i][j];
        
        int max=1;
        for(int k=0;k<4;k++){
            
            int x=i+row[k];
            int y=j+col[k];
            
            if(x>=0 && y>=0 && x<n&& y<m && mat[i][j]+1==mat[x][y])
            max=Math.max(max,1+max(x,y,mat,dp,n,m));
        }
        
     dp[i][j]=max;
     return max;
        
    }
	public static void main (String[] args) {
		
		 int mat[][] = { { 11, 10, 9 }, 
                        { 5, 3, 8 }, 
                        { 4, 6, 7 } }; 
		
		int n=mat.length;
		int m=mat[0].length;
	 int dp[][]=new int[n][m];
	 
	 for(int i=0;i<n;i++)
	 Arrays.fill(dp[i],-1);
	 int max=0;
	 for(int i=0;i<n;i++){
	     
	     for(int j=0;j<m;j++){
	         
	         if(dp[i][j]==-1)
	         dp[i][j]=max(i,j,mat,dp,n,m);
	         
	         max=Math.max(max,dp[i][j]);
	     }
	 }
	 
	 System.out.println(max);
		
	}
}
