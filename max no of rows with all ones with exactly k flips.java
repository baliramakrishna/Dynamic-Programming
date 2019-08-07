/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    
    static int maxRows(int a[][],int sum[],int n,int m,int k){
        
        
        int max=0;
        
        for(int i=k;i>=0;i=i-2){
            
            for(int j=0;j<n;j++){
                
                if(sum[j]+i==m){
                    
                    int val=getMax(a,sum,n,m,j);
                    
                    if(val>max)
                    max=val;
                }
            }
        }
        return max;
        
    }
    
    
    static int getMax(int a[][],int sum[],int n,int m,int row){
        
        int temp[]=new int[m];
        
        for(int i=0;i<m;i++){
            
            if(a[row][i]==0)
            temp[i]=1;
        }
        
        int count=0;
        
        for(int i=0;i<n;i++){
            
            int sum1=0;
            for(int j=0;j<m;j++){
                
                
                if(temp[j]==1){
                    
                    
                    if(a[i][j]==0)
                    sum1++;
                }
                else
                sum1+=a[i][j];
            }
            if(sum1==m)
            count++;
        }
        return count;
    }
	public static void main (String[] args) {
		
		int a[][]={
		    {1,0,0},
		    {1,0,1},
		    {1,0,0}
		};
		int m=a[0].length;
		int n=a.length;
		
		int sum[]=new int[n];
		
		for(int i=0;i<n;i++){
		    int sum1=0;
		    for(int j=0;j<m;j++)
		    sum1+=a[i][j];
		    
		    sum[i]=sum1;
		}
		
		System.out.println(maxRows(a,sum,n,m,4));
	}
}
