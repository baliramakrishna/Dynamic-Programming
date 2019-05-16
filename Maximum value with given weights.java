/*package whatever //do not write package name here */

import java.io.*;

class MaxValue{
    
    static int maxValue(int wt[],int v[],int n,int tw){
        
        int a[][]=new int[n][tw+1];
        for(int i=0;i<n;i++){
            
            for(int j=0;j<tw+1;j++){
                
                if(i>0 && j<wt[i])
                a[i][j]=a[i-1][j];
                else if(i>0 && j>=wt[i])
                     a[i][j]=Math.max(a[i-1][j],v[i]+a[i-1][j-wt[i]]);
                else{
                    if(wt[i]<=j)
                    a[i][j]=v[i];
                    else
                    a[i][j]=0;
                }         
                
            }
        }
        
        return a[n-1][tw];
    }
	public static void main (String[] args) {
	   
	   int wt[]={1,3,4,5};
	   int v[]={1,4,5,7};
	   
	   System.out.println(maxValue(wt,v,wt.length,7));
	   
	}
}
