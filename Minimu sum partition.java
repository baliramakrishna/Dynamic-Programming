import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {  static int d=Integer.MAX_VALUE;
 
  static int min(int total,int sum,int v[],int n){
     
      int a[][]=new int[n+1][sum+1];
      
      for(int i=1;i<=n;i++){
          
          for(int j=1;j<=sum;j++){
              
              if(j>=v[i-1])
              a[i][j]=Math.max(v[i-1]+a[i-1][j-v[i-1]],a[i-1][j]);
              else
              a[i][j]=a[i-1][j];
          }
      }
      return total-(2*a[n][sum]);
  }
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
            d=Integer.MAX_VALUE;
           int n=s.nextInt();
           int a[]=new int[n];
           int total=0;
           for(int i=0;i<n;i++){
           a[i]=s.nextInt();
           total+=a[i];
           }
           System.out.println(min(total,total/2,a,n));
          
           
        
        }
	  
	  
	 }
}
