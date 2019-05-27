/*package whatever //do not write package name here */

import java.io.*;

class ShortestString{
    
    static String shortestString(String a,String b ){
        
        int m=a.length();
        int n=b.length();
        
        int d[][]=new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            
            for(int j=0;j<=n;j++){
                
                
                if(i==0)
                d[i][j]=j;
                
                 else if(j==0)
                d[i][j]=i;
                
                else{
                if(a.charAt(i-1)==b.charAt(j-1))
                d[i][j]=1+d[i-1][j-1];
                else
                d[i][j]=1+Math.min(d[i-1][j],d[i][j-1]);
                }
            }
            
            
        }
        
        int i=m,j=n;
        String res="";
        while(i>0 && j>0){
            
            
            if(a.charAt(i-1)==b.charAt(j-1)){
                
                res=a.charAt(i-1)+res;
                i--;
                j--;
            }
            else if(d[i][j-1]>d[i-1][j]){
             res=a.charAt(i-1)+res;
             i--;
            }
            else{
                
                res=b.charAt(j-1)+res;
                j--;
            }
            
        }
        
        while(i>0){
            res=a.charAt(i-1)+res;
            i--;
        }
        
        while(j>0){
            
            res=b.charAt(j-1)+res;
            j--;
        }
        
        return res;
    }
	public static void main (String[] args) {
		
		
		String s1="geek";
		String s2="code";
		
		System.out.println(shortestString(s1,s2));
	}
}
