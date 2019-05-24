/*package whatever //do not write package name here */

import java.util.*;

class MaxAreaHistogram{
    
    static int maxArea(int a[],int n){
        
        Stack<Integer> s=new Stack<>();
        
        int area=0,maxarea=-1,i;
        for( i=0;i<n;){
            
            if(s.empty())
            s.push(i++);
            else if(a[s.peek()]<=a[i])
             s.push(i++);
            else{
                
                int top=s.pop();
                
                if(s.isEmpty())
                area=a[top]*i;
                else
                area=a[top]*(i-s.peek()-1);
                
                if(area>maxarea)
                maxarea=area;
                
            }
        }
        
        while(!s.isEmpty()){
            
                int top=s.pop();
                
                if(s.isEmpty())
                area=a[top]*i;
                else
                area=a[top]*(i-s.peek()-1);
                
                if(area>maxarea)
                maxarea=area;
            
            
        }
        
        return maxarea;
        
    }
	public static void main (String[] args) {
	
	  int a[]={2,1,2,3,1};
	  int n=a.length;
	  System.out.println(maxArea(a,n));
	}
}
