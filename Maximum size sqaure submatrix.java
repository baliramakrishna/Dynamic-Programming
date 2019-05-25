/*package whatever //do not write package name here */

import java.util.*;

class MaxArea{
    


   static int maxSize(int a[][]){
       
       int n1=a.length;
       int n2=a[0].length;
       
       int m[][]=new int[n1+1][n2+1];
       
       int max=-1;
       for(int i=1;i<=n1;i++){
           
           for(int j=1;j<=n2;j++){
               
               if(a[i-1][j-1]==0)
               m[i][j]=0;
               else
               m[i][j]=1+Math.min(Math.min(m[i-1][j],m[i-1][j-1]),m[i][j-1]);
               max=Math.max(m[i][j],max);
           }
           
       }
       
       return max;

   }

          
	public static void main (String[] args) {
		
		int a[][]={{1,0,0,1,1,1},{1,0,1,1,1,1},{0,1,1,1,1,1},{0,0,1,1,1,1}};
		System.out.println(maxSize(a));
		
	}
}
