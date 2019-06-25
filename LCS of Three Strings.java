import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 { 
     
     
     static int LCS(String str1,String str2,String str3,int n,int m,int o){
         
         
         int a[][][]=new int[n+1][m+1][o+1];
         
         for(int i=1;i<=n;i++){
             
             for(int j=1;j<=m;j++){
                 
                 for(int k=1;k<=o;k++){
                     
                     if(str1.charAt(i-1)==str2.charAt(j-1) && str1.charAt(i-1)==str3.charAt(k-1))
                     a[i][j][k]=a[i-1][j-1][k-1]+1;
                     else
                     a[i][j][k]=Math.max(Math.max(a[i-1][j][k],a[i][j-1][k]),a[i][j][k-1]);
                     
                 }
             }
         }
         return a[n][m][o];
     }
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
           int n=s.nextInt();
           int m=s.nextInt();
           int p=s.nextInt();
           String str1=s.next();
           String str2=s.next();
           String str3=s.next();
          System.out.println(LCS(str1,str2,str3,n,m,p));
        }
	  
	  
	 }
}
