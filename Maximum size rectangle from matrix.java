/*package whatever //do not write package name here */

import java.util.*;

class MaxArea{
    
    static int maxHistogramArea(int a[]){
        
        int n=a.length;
        int area=0,maxarea=-1,i;
        
        Stack<Integer> s=new Stack<>();
        for(i=0;i<n;){
            
            if(s.isEmpty())
            s.push(i++);
            else if(a[s.peek()]<=a[i])
            s.push(i++);
            else{
                
                int top=s.pop();
                
                if(s.isEmpty())
                area=a[top]*i;
                else
                area=a[top]*(i-s.peek()-1);
                
                maxarea=Math.max(area,maxarea);
                
                
            }
        
    }
    
    while(!s.isEmpty()){
        
        int top=s.pop();
        if(s.isEmpty())
        area=a[top]*i;
        else
        area=a[top]*(i-s.peek()-1);
                
         maxarea=Math.max(area,maxarea);
        
        
    }
    
    return maxarea;
    
}

 static int maxArea(int a[][]){
     
     int n1=a.length;
     int n2=a[0].length;
     int area=0,maxarea=-1;
     
     int m[]=new int[n2];
     for(int i=0;i<n1;i++){
         
         for(int j=0;j<n2;j++){
             
            if(i==0) 
            m[j]=a[i][j];
            else{
                
                if(a[i][j]==0)
                m[j]=0;
                else
                m[j]+=1;
            }
            
         }
         
         area=maxHistogramArea(m);
         
         maxarea=Math.max(area,maxarea);
         
     }
     
     return maxarea;
     
 }
	public static void main (String[] args) {
		
		int a[][]={{1,0,0,1,1,1},{1,0,1,1,0,1},{0,1,1,1,1,1},{0,0,1,1,1,1}};
		System.out.println(maxArea(a));
		
	}
}
