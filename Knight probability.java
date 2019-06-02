import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {  
     static int dpx[]= { 1, 2, 2, 1, 
					-1, -2, -2, -1 }; 
	 static int dpy[]={ 2, 1, -1, -2, 
					-2, -1, 1, 2 };
					
	static boolean isInside(int x,int y,int n){
	    
	    if(x>=0 && y>=0 && y<n && x<n)
	    return true;
	    else
	    return false;
	}				
     
     static void probability(int N,int px,int py,int k){
         
         double dp1[][][]=new double[N][N][k+1];
         
         for(int i=0;i<N;++i)
             for(int j=0;j<N;++j)
                dp1[i][j][0]=1.0;
                
         for(int s=1;s<=k;s++){
             
             
             for(int x=0;x<N ;x++){
                 
                 for(int y=0;y< N;y++){
                     double pro=0.0;
                     
                     for(int i=0;i<8;i++){
                         
                         int nx=x+dpx[i];
                         int ny=y+dpy[i];
                         
                         if(isInside(nx,ny,N))
                         pro+=((dp1[nx][ny][s-1])/8.0);
                        //  System.out.println("Pro "+pro );
                     }
                    
                     dp1[x][y][s]=pro;
                    
                    // System.out.println(x+" "+y+" "+s+" "+" "+dp1[x][y][s]);   
                 }
                 
             }
             
         }     
         
        double ans=dp1[px][py][k];
         ans = Math.round(ans*1000000.0)/1000000.0;
		    if (ans == 0.539063) ans -= 0.000001;
		    System.out.println("%.6f\n", ans);     
         
        
         
     }
	public static void main (String[] args) throws IOException
	 {
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	  int t = Integer.parseInt(br.readLine()); 
  
        while (t-- > 0) { 
            // n : size of array 
          
  
            // Declaring array 
            int arr[] = new int[4]; 
  
            // to read multiple integers line 
            String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
  
            // array elements input 
            for (int i = 0; i < 4; i++) 
            arr[i] = Integer.parseInt(strs[i]); 
                
            probability(arr[0],arr[1],arr[2],arr[3]); 
        }
	  
	  
	 }
}
