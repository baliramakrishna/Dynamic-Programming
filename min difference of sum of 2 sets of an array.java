/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    
 
    static int find(int i,int a[],int n,int total,int included,int sum, boolean visited[]){
        
       System.out.println(i+" "+total+" "+included+" "+sum);
        if(included==n/2){
            
           StringBuffer b1=new StringBuffer(""); 
            StringBuffer b2=new StringBuffer(""); 
            
            for(int k=0;k<n;k++){
                if(visited[k])
                b1.append(a[k]+" ");
                else
                b2.append(a[k]+" ");
            }
            
            System.out.println(b1+"     "+b2);
              return Math.abs(total-2*sum);
        }
      
        
        else  if(i==n)
        return 1000000;
       
          visited[i]=true;
         int x=find(i+1,a,n,total,included+1,sum+a[i],visited);
         visited[i]=false;
          int y= find(i+1,a,n,total,included,sum,visited);
          visited[i]=false;
         return Math.min(x,y);
        
        
    }
    
	public static void main (String[] args) {
             
    int a[] = {1,5,3,4};
     int total=0;
     
     for(int i=0;i<a.length;i++)
     total+=a[i];
   
    boolean visited[]=new boolean[a.length];  
     System.out.println(find(0,a,a.length,total,0,0,visited));                 
	}
}
