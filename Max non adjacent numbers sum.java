/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    
    static int maxSum(int a[],int n){
        
        int incl=a[0];
        int excl=0;
        
        for(int i=1;i<n;i++){
            
            int temp=incl;
            incl=Math.max(a[i]+excl,incl);
            excl=temp;
            
        }
        
        return incl;
    }
	public static void main (String[] args) {
		
		int a[]={4,99,0,0,1};
		
		System.out.println(maxSum(a,a.length));
	}
}
