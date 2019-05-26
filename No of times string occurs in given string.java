/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    
    static int count(String a,String b){
        
        int n=a.length();
        int m=b.length();
        
        int p[][]=new int[n+1][m+1];
        
        for(int i=0;i<=n;i++)
        p[i][0]=1;
        
        for(int i=1;i<=n;i++){
            
            
            for(int j=1;j<=m;j++){
                
                if(a.charAt(i-1) == b.charAt(j-1))
                p[i][j]=p[i-1][j-1]+p[i-1][j];
                else
                p[i][j]=p[i-1][j];
                
            }
        }
        
        return p[n][m];
        
    }
	public static void main (String[] args) {
		
		System.out.println(count("geeksforgeeks","gks"));
	}
}
