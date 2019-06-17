import java.lang.*;
import java.io.*;
class GFG
 {  
     
     static int max(int val[],int weight[],int c,int n){
         
         int a[][]=new int[n+1][c+1];
         
         for(int i=1;i<=n;i++){
             
             for(int j=1;j<=c;j++){
                 
                 //if weight is less than j
                 if(weight[i-1]>j)
                 a[i][j]=a[i-1][j];
                 // maximum of not considering currentweight ,considering current weight
                 else
                 a[i][j]=Math.max(a[i-1][j],a[i-1][j-weight[i-1]]+val[i-1]);
                 
             }
         }
         
         return a[n][c];
         
     }
	public static void main (String[] args) throws IOException
	 {
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	  int t = Integer.parseInt(br.readLine()); 
  
        while (t-- > 0) { 
            // n : size of array 
            int n = Integer.parseInt(br.readLine()); 
            int c= Integer.parseInt(br.readLine()); 
  
            // Declaring array 
            int val[] = new int[n]; 
             int weight[] = new int[n]; 
  
            // to read multiple integers line 
            String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
  
            // array elements input 
            for (int i = 0; i < n; i++) 
            val[i] = Integer.parseInt(strs[i]); 
            
             // to read multiple integers line 
            String x = br.readLine(); 
            String[] str= x.trim().split("\\s+"); 
  
            // array elements input 
            for (int i = 0; i < n; i++) 
            weight[i] = Integer.parseInt(str[i]); 
            
            //find out max val
            System.out.println(max(val,weight,c,n));
                
        
        }
	  
	  
	 }
}
