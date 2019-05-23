/*package whatever //do not write package name here */

import java.io.*;

class Bitonic{
    
    static int sequence(int a[],int n){
        
       int r[]=new int[n];
       int l[]=new int[n];
       
       for(int i=0;i<n;i++){
           r[i]=1;
           l[i]=1;
       }
       
       for(int i=1;i<n;i++){
           
           for(int j=0;j<i;j++){
               
               if(a[i]>a[j])
               l[i]=Math.max(l[i],l[j]+1);
           }
           
       }
       
    
       
        for(int i=n-2;i>=0;i--){
           
           for(int j=n-1;i<j;j--){
               
               if(a[i]>a[j])
               r[i]=Math.max(l[i],l[j]+1);
           }
           
       }
        
        
        int max=0;
        for(int i=0;i<n;i++){
            
            l[i]+=r[i];
            if(max<l[i])
            max=l[i];
        }
       return max-1; 
        
    }
	public static void main (String[] args) {
	 
	 int a[]={2,-1,4,3,5,-1,3,2};
	 System.out.println(sequence(a,a.length));
	}
}
