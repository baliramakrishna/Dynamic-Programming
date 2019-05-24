/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    
    static int palandrome(String s,int n){
        
        if(n==1)
        return 1;
        
        if(n==2){
            if(s.charAt(0)==s.charAt(1))
            return 2;
            else
            return 1;
            
        }
        else{
            
            if(s.charAt(0)==s.charAt(n-1)){
                
                int k=palandrome(s.substring(1,n-1),n-2);
                
                if(k==n-2)
                return n;
                else
                return Math.max(palandrome(s.substring(0,n-1),n-1),palandrome(s.substring(1),n-1));
                
            }
            else
            return Math.max(palandrome(s.substring(0,n-1),n-1),palandrome(s.substring(1),n-1));
        }
        
    }
    
	public static void main (String[] args) {
		
		String s="abadba";
		System.out.println(palandrome(s,s.length()));
		
	}
}
