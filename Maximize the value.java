/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    
    static class Values{
        
        int first;
        int second;
        
        Values(int first,int second){
            
            this.first=first;
            this.second=second;
        }
    }
    
    static Values maximize(int a[]){
        
        int n=a.length;
        Values b[][]=new Values[n][n];
        
        for(int l=1;l<=n;l++){
            
            for(int i=0;i<=n-l;i++){
                
                int j=i+l-1;
                
                if(i==j){
                b[i][j]=new Values(a[i],0);
                continue;
                }
                else{
                    
                    
                    int k=a[i]+b[i+1][j].second;
                    int p=a[j]+b[i][j-1].second;
                    
                    if(k>p)
                    b[i][j]=new Values(k,b[i+1][j].first);
                    else
                    b[i][j]=new Values(p,b[i][j-1].first);
                    
                    
                }
                
                
                
            }
            
        }
        
        return b[0][n-1];
    }
	public static void main (String[] args) {
		
		int a[]={3,9,1,2};
		
		Values v=maximize(a);
		System.out.println(v.first+" "+v.second);
	}
}
