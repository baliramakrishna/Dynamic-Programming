import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {  
    
     static String sum(int a[],int n){
         
         int sum=0;
         for(int k:a)
        sum+=k;
        
        if(sum%2==1)
        return "NO";
        else{
            
            
            sum=sum/2;
            boolean t[][]=new boolean[n][sum+1];
            
            for(int i=0;i<n;i++)
            t[i][0]=true;
            
           
            
            for(int i=0;i<n;i++){
                
                for(int j=1;j<=sum;j++){
                    
                    if(a[i]>j){
                    if(i==0)
                    t[i][j]=false;
                    else
                    t[i][j]=t[i-1][j];
                    }
                    else{
                        if(i==0 && a[i]==j )
                        t[i][j]=true;
                        else if(i==0)
                        t[i][j]=false; 
                        else
                       t[i][j]=t[i-1][j] || t[i-1][j-a[i]];
                    }
                    
                }
            }
        
          if(t[n-1][sum]==true)
          return "YES";
          else
          return "NO";
        }
         
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
  
            // array elements input 
            for (int i = 0; i < n; i++) 
            arr[i] = Integer.parseInt(strs[i]); 
            
            System.out.println(sum(arr,n));    
        
        }
	  
	  
	 }
}
