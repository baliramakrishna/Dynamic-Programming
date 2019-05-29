/*package whatever //do not write package name here */

import java.io.*;

class PalandromePartition{
    
    static int minimumPartition(String s){
        
        if(isPalandrome(s))
        return 0;
        
        int n=s.length();
        
        int a[][]=new int[n][n];
        
        for(int l=1;l<=n;l++){
            
            for(int i=0;i<=n-l;i++){
                
                int j=i+l-1;
                
                if(i==j)
                a[i][j]=0;
                else{
                    
                    if(isPalandrome(s.substring(i,j+1)))
                    a[i][j]=0;
                    else{
                        
                        int min=Integer.MAX_VALUE;
                        for(int k=i;k<j;k++)
                         min=Math.min(min,1+a[i][k]+a[k+1][j]); 
                         
                         a[i][j]=min;
                        
                    }
                    
                }
                
                
            }
            
            
        }
        
        return a[0][n-1];
        
    }
    
    static boolean isPalandrome(String s){
        
        StringBuffer s1=new StringBuffer(s);
        s1.reverse();
        String s2=new String(s1);
        
        if(s2.equals(s))
        return true;
        else
        return false;
    } 
    
	public static void main (String[] args) {
	
	String s="abcbz";
	System.out.println(minimumPartition(s));
	
	}
}
