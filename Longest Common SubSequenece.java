/*package whatever //do not write package name here */

import java.util.*;

class LongestCommonSubSequenece {
    
    static int longestLength(char x[],char y[],int m,int n){
        
        int a[][]=new int[m+1][n+1];
        
        for(int i=0;i<m+1;i++)
        a[i][0]=0;
        
        for(int j=0;j<n+1;j++)
        a[0][j]=0;
        
        for(int i=1;i<m+1;i++){
            
            for(int j=1;j<n+1;j++){
                
                if(x[i-1]==y[j-1])
                a[i][j]=a[i-1][j-1]+1;
                else
                a[i][j]=Math.max(a[i][j-1],a[i-1][j]);
            }
        }
        
        return a[m][n];
    }
	public static void main (String[] args) {
	String s1 = "ABCDGH"; 
    String s2 = "AEDFHR"; 
    char[] X=s1.toCharArray(); 
    char[] Y=s2.toCharArray(); 
    int m = X.length; 
    int n = Y.length; 
    
    System.out.println(longestLength(X,Y,m,n));
	}
}
