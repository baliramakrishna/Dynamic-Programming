
*given infinite supply of coins,find out minimum no of coins required to form total*

/*package whatever //do not write package name here */

import java.util.*;

class   MinCoins{
    
    static HashMap<Integer,Integer> h=new HashMap<>();
    static int minCoins(int total,int coins[]){
        
        //if total=0 ,no of coins required =0
        if(total==0)
        return 0;
        
        // if total is present in hashtable return min coins in hashtable corresponding to total
        if(h.containsKey(total))
        return h.get(total);
        
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<coins.length;i++){
            
            //if coin value is greater than total move on
            if(coins[i]>total)
            continue;
            
            else
            min=Math.min(min,1+minCoins(total-coins[i],coins));
            
        }
        
        h.put(total,min);
        return min;
        
    }
	public static void main (String[] args) {
	  
	  int coins[]={1,2,3};
	  int total=5;
	  System.out.println("minimum no of coins "+ minCoins(total,coins));
	  
	}
}







//or


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 { 
     static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
     static long min(int v,int a[],int l, HashMap<Integer,Long> h,int n){
         
         if(v==0)
         return l;
         
        
         if(h.containsKey(v))
         return l+h.get(v);
         
          long temp=Integer.MAX_VALUE;
          
          for(int i=0;i<n;i++){
              
            if(a[i]>v)
            continue;
          temp=Math.min(temp,min(v-a[i],a,l+1,h,n));
          }
          
          h.put(v,temp-l);
          
          return temp;
         
         
     }
     
	public static void main (String[] args) throws IOException
	 {
	   
	   FastReader s=new FastReader();
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
           int v=s.nextInt();
           int n=s.nextInt();
           int a[]=new int[n];
           
           for(int i=0;i<n;i++)
           a[i]=s.nextInt();
           
           HashMap<Integer,Long> h=new HashMap<>();
           long p=min(v,a,0,h,n);
           
           if(p==Integer.MAX_VALUE)
          System.out.println(-1);
           else
           System.out.println(p);
        
        }
	  
	  
	 }
}

