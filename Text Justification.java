/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    
    static void sumOfSquares(String str[],int n,int k){
        
        int a[][]=new int[n][n];
        
        for(int i=0;i<n;i++){
            int p=0;
            for(int j=i;j<n;j++){
                
                p+=str[j].length();
                if(p<=k)
                a[i][j]=(int)Math.pow(k-p,2);
                
                else
                a[i][j]=Integer.MAX_VALUE;
                
                p++;
               
            }
            
        }
        
        
        int b[]=new int[n];
        int c[]=new int[n];
        
        for(int i=n-1;i>=0;i--){
            
            if(a[i][n-1]!=Integer.MAX_VALUE)
                {
                    b[i]=a[i][n-1];
                    c[i]=n;
                }
                else{
                    int min=Integer.MAX_VALUE;
                    int t=0;
                    for(int j=n-1;j>i;j--){
                        
                        if(a[i][j-1]!=Integer.MAX_VALUE && min>a[i][j-1]+b[j]){
                            min=a[i][j-1]+b[j];
                            t=j;
                        }
                        
                    }
                    b[i]=min;
                    c[i]=t;
                }
                
               
                }
                
             int m=0;
             for(int p:c){
                 
                 for(int i=m;i<p;i++)
                 System.out.print(str[i]+" ");
                 m=p;
                 System.out.println();
             }  
            
    }
    
	public static void main (String[] args) {
		
		String str[]={"tushor","roy","likes","to","code"};
		sumOfSquares(str,str.length,10);
	}
}
