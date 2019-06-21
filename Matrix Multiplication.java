import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {  
     
     
     static int min(int a[],int n){
         
         int temp[][]=new int[n][n];
         
         for(int l=3;l<=n;l++){
             
             for(int i=0;i<=n-l;i++){
                 
                 int j=i+l-1;
                 
                 int p=Integer.MAX_VALUE;
                 for(int k=i+1;k<j;k++)
                 p=Math.min(p,temp[i][k]+temp[k][j]+a[i]*a[k]*a[j]);
                 
                 temp[i][j]=p;
             }
         }
         return temp[0][n-1];
     }
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
           int n=s.nextInt();
           int a[]=new int[n];
           
           for(int i=0;i<n;i++)
           a[i]=s.nextInt();
         
         System.out.println(min(a,n));
        }
	  
	  
	 }
}
