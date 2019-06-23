import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
          int n=s.nextInt();
          char ch[]=s.next().toCharArray();
          boolean b[][]=new boolean[n][n];
          
          int count=0;
          for(int i=0;i<n;i++)
          b[i][i]=true;
          
          for(int i=0;i<n-1;i++){
              
              if(ch[i]==ch[i+1]){
                  count++;
                  b[i][i+1]=true;
              }
          }
          
          for(int l=3;l<=n;l++){
              
              for(int i=0;i<=n-l;i++){
                  
                  int j=i+l-1;
                  if(ch[i]==ch[j] && b[i+1][j-1]){
                      count++;
                      b[i][j]=true;
                  }
              }
              
          }
          
          System.out.println(count);
        
        }
	  
	  
	 }
}
