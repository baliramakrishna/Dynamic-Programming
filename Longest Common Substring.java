/*package whatever //do not write package name here */

import java.io.*;

class CommonSubString{
    
    static int longestCommonSubString(String s1,String s2){
        
        int n1=s1.length();
        int n2=s2.length();
        
        int a[][]=new int[n1+1][n2+1];
        
        for(int i=1;i<=n1;i++){
            
            for(int j=1;j<=n2;j++){
                
                if(i>j)
                a[i][j]=a[i-1][j];
                if(s1.charAt(i-1)==s2.charAt(j-1))
                a[i][j]=a[i-1][j-1]+1;
                
                
            }
            
        }
        
        int max=0;
        for(int i=1;i<=n1;i++){
            
            for(int j=1;j<=n2;j++){
               
               if(a[i][j]>max)
               max=a[i][j];
               
            }
            
        }
        return max;
    } 
    
	public static void main (String[] args) {
		
		String s1="abcdaf";
		String s2="zbcdf";
		
		if(s1.length()>s2.length())
			System.out.println(longestCommonSubString(s2,s1));
		else
		System.out.println(longestCommonSubString(s1,s2));
	}
}
