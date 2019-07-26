/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    
    static int max(int a[],int n){
        
        int max=0;
        int l=0;
        int r=n-1;
        
        while(l<r){
            
            max=Math.max(max,(Math.min(a[l],a[r]))*(r-l));
            
            if(a[l]<a[r])
            l++;
            else
            r--;
        }
        
        return max;
    }
	public static void main (String[] args) {
		
		int a[]={1,5,4,3};
		System.out.println(max(a,a.length));
	}
}
