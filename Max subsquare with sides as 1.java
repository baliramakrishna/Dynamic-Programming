/*package whatever //do not write package name here */

import java.util.*;

class MaxArea{
    

  static class Dimensions{
      
      int height;
      int width;
      
      Dimensions(int  height,int width){
          
          this.height=height;
          this.width=width;
      }
  }
    static int maxSize(int a[][]){
        
        int n1=a.length;
        int n2=a[0].length;
        Dimensions d[][]=new Dimensions[n1+1][n2+1];
        
        for(int i=0;i<=n1;i++){
            
            for(int j=0;j<=n2;j++){
                
                if(i==0 || j==0)
                d[i][j]=new Dimensions(0,0);
                else if(a[i-1][j-1]!=0){
                d[i][j]=new Dimensions(d[i-1][j].height+1,d[i][j-1].width+1);
                
                }else
                d[i][j]=new Dimensions(0,0);
                
            }
            
        }
        
        int max=0;
        for(int i=n1;i>=1;i--){
            
            for(int j=n2;j>=1;j--){
                
                int min=Math.min(d[i][j].height,d[i][j].width);
                   
                if(min<=max)
                continue;
                else{
                    
                for(int k=min;k>max;k--){
                    
                    if (d[i-k+1][j].width>=k && d[i][j-k+1].height>=k){
                        max=k;
                        break;
                    }
                  }
                    
                }
                
            }
            
        }
        return max;
        
    }
       
      

          
	public static void main (String[] args) {
		
		int a[][]={{0,0,0,0,1},{1,0,1,1,1},{1,0,1,0,1},{1,1,1,1,1},{0,0,1,1,1}};
		System.out.println(maxSize(a));
		
	}
}
