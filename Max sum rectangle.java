/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    
    static class Sum{
        
       static int maxsum;
       static int maxleft;
       static int maxright;
        static int maxup;
        static int maxdown;
    
    }
    static int maxSum(int a[][]){
        
        int n1=a.length;
        int n2=a[0].length;
        
       
      
        for(int l=0;l<n2;l++){
            
            int b[]=new int[n1];
            for(int r=l;r<n2;r++){
                
               for(int j=0;j<n1;j++)
                 b[j]+=a[j][r];
                 
                if(kadanes(b)){
                    Sum.maxleft=l;
                    Sum.maxright=r;
                } 
                
            }
            
        }
        
        return Sum.maxsum;
    }
    
    static boolean kadanes(int a[]){
        
        int n=a.length;
        int max=Integer.MIN_VALUE;
        int tmax=0,s=0,e=0,ts=0;
        
        for(int i=0;i<n;i++){
            
            tmax+=a[i];
            
            if(tmax>max){
                
                max=tmax;
                e=i;
                s=ts;
                
            }
            if(tmax<0){
                
                tmax=0;
                ts=i+1;
                
            }
            
        }
        
        
        if(max>Sum.maxsum){
            
            Sum.maxsum=max;
            Sum.maxup=s;
            Sum.maxdown=e;
            return true;
        }
        else
        return false;
        
    }
    
    
	public static void main (String[] args) {
	  
        int  input[][] = {{ 2,  1, -3, -4,  5},
                         { 0,  6,  3,  4,  1},
                         { 2, -2, -1,  4, -5},
                         {-3,  3,  1,  0,  3}};
        
        System.out.println(maxSum(input)); 
        System.out.println(Sum.maxsum+" "+Sum.maxleft+" "+Sum.maxright+" "+Sum.maxup+" "+Sum.maxdown);
	 
	}
}
