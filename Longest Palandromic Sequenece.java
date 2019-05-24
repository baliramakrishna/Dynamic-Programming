/*package whatever //do not write package name here */

import java.io.*;

class LongestPalandrome{
    
    static String palandrome(String s,int n){
        
        int a[][]=new int[n][n];
        
        for(int l=1;l<=n;l++){
            
            for(int i=0;i<=n-l;i++){
                
                int j=i+l-1;
                
                if(l==1)
                a[i][j]=1;
                
                else if(s.charAt(i)==s.charAt(j))
                a[i][j]=2+a[i+1][j-1];
                else
                a[i][j]=Math.max(a[i][j-1],a[i+1][j]);
            }
            
        }
        
        return sequenece(a,s,n);
    }
    
    static String sequenece(int a[][],String s,int n){
        
        if(a[0][n-1]==1)
        return ""+s.charAt(n-1);
        else{
            
            String s1="";
            String s2="";
            int i=0,j=n-1;
            while(a[i][j]!=0){
                
                if(a[i][j]==a[i][j-1])
                 j--;
                 else if(a[i][j]==a[i+1][j])
                  i++;
                  else{
                      
                      s1+=s.charAt(i);
                      s2+=s.charAt(j);
                      i++;
                      j--;
                  }
            }
             
            if(a[0][n-1]%2==1){
                
             s2=s2.substring(1);
                
            }
             return s1+s2;
        }
        
       
    }
	public static void main (String[] args) {
		
		String s="agbdba";
		int n=s.length();
		System.out.println(palandrome(s,n));
	}
}
