import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {  
     static int sum(int a[],int from,int to){
         
         int sum=0;
         
         for(int i=from;i<=to;i++)
         sum+=a[i];
         
         return sum;
         
     }
     static int min(int arr[],int n,int k){
         
         int a[][]=new int[k][n];
         
         for(int i=0;i<n;i++)
         a[0][i]=sum(arr,0,i);
         
         for(int i=0;i<k;i++)
         a[i][0]=arr[0];
         
         for(int i=1;i<k;i++){
             
             for(int j=1;j<n;j++){
                 
                 int max=Integer.MAX_VALUE;
                 
                 for(int p=0;p<=j;p++)
                 max=Math.min(max,Math.max(a[i-1][p],sum(arr,p+1,j)));
                 
                 a[i][j]=max;
             }
         }
         
         
         return a[k-1][n-1];
     }
     
     
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
           
           int k=s.nextInt();
           int n=s.nextInt();
           int a[]=new int[n];
           
           for(int i=0;i<n;i++)
           a[i]=s.nextInt();
           System.out.println(min(a,n,k));
        
        }
	  
	  
	 }
}
