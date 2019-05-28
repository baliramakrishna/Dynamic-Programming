/*package whatever //do not write package name here */

import java.io.*;

class MinimumPathCost{
    
    static int minimumCost(int a[][]){
        
        int n1=a.length;
        int n2=a[0].length;
        
        int p[][]=new int[n1][n2];
    
        
        for(int i=0;i<n1;i++){
            
            for(int j=0;j<n2;j++){
                
                if(i==0 && j==0)
                p[0][0]=a[0][0];
                
                else if(j==0)
                p[i][j]=p[i-1][j]+a[i][j];
                
                else if(i==0)
                p[i][j]=p[i][j-1]+a[i][j];
                
                else
                p[i][j]=a[i][j]+Math.min(p[i-1][j],p[i][j-1]);
                
            }
        }
      for(int b[]:p){
          
          for(int k:b){
              System.out.print(k+" ");
          }
          System.out.println();
      }
      return p[n1-1][n2-1]; 
        
        
    }
	public static void main (String[] args) {
		
		int cost[][] = {{1,3,5,8},{4,2,1,7},{4,3,2,3}};
		System.out.println(minimumCost(cost));
	}
}
