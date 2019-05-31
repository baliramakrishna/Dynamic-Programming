import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {   
     static int wordbreak(String str[],String s,int m){
         
         int n=s.length();
         
         boolean a[][]=new boolean[n][n];
         
         for(int l=1;l<=n;l++){
             
             
             for(int i=0;i<=n-l;i++){
                 
                 int j=i+l-1;
                 
                 if(l==1){
                 if(contains(str,s.substring(i,j+1)))
                 a[i][j]=true;
                 else
                 a[i][j]=false;
                 }
                 else{
                     
                     if(contains(str,s.substring(i,j+1)))
                      a[i][j]=true;
                      
                      else{
                          
                          for(int k=i;k<=j;k++){
                              
                              if(a[i][k]&& a[k+1][j]){
                                  a[i][j]=true;
                                  break;
                              }
                              
                          }
                          
                      }
                     
                       
                   }
                 
             }
            
         }
         
          if(a[0][n-1])
          return 1;
          else
          return 0;
         
     }
     
     static boolean contains(String str[],String s){
         
         for(String k:str){
             
             if(s.equals(k))
             return true;
         }
         return false;
     }
     
	public static void main (String[] args) throws IOException
	 {
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	  int t = Integer.parseInt(br.readLine()); 
  
        while (t-- > 0) { 
            // n : size of array 
            int n = Integer.parseInt(br.readLine()); 
  
            // Declaring array 
            int arr[] = new int[n]; 
  
            // to read multiple integers line 
            String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
  
           String k=br.readLine();
           
           System.out.println(wordbreak(strs,k,n));
       
        }
	  
	  
	 }
}
