/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    
    static int minimumCost(int v[],int f[]){
        
        int n=v.length;
        int a[][]=new int[n][n];
        
        for(int l=1;l<=n;l++){
            
            for(int i=0;i<=n-l;i++){
                
                int j=i+l-1;
                int sum=0;
                
                if(l==1){
                a[i][j]=f[i];
                continue;
                }
                
                for(int k=i;k<=j;k++)
                   sum+=f[k]; 
                 
                 int min=Integer.MAX_VALUE; 
                 
                 for(int k=i;k<=j;k++){
                     
                     if(k==i)
                      min=Math.min(min,a[k+1][j]);
                     else if(k==j)
                     min=Math.min(min,a[i][k-1]);
                     else
                     min=Math.min(min,a[k+1][j]+a[i][k-1]);
                 }
               
                a[i][j]=sum+min;
                
            }
            
            
        }
        
        return a[0][n-1];
        
    }
	public static void main (String[] args) {
		
		int v[]={10,12,16,21};
		int f[]={4,2,6,3};
		System.out.println(minimumCost(v,f));
	}
}
