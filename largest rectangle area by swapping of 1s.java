import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 { 
     static int histogram(int a[],int n){
         
         Stack<Integer> s=new Stack<>();
         int area=0,maxarea=0,i;
         
         for(i=0;i<n;){
             
             if(s.isEmpty() || a[s.peek()]<=a[i])
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
     static int maxArea(int a[][],int n,int m){
         
         int b[][]=new int [n][m];
         
         for(int i=0;i<n;i++){
             
             for(int j=0;j<m;j++){
                 
                 if(i==0)
                 b[i][j]=a[i][j];
                 else{
                     if(a[i][j]==0)
                     b[i][j]=0;
                     else
                     b[i][j]=b[i-1][j]+1;
                 }
             }
         }
         
         for(int i=0;i<n;i++)
         Arrays.sort(b[i]);
         
         int max=0;
         
         for(int i=0;i<n;i++)
         max=Math.max(histogram(b[i],m),max);
         
         return max;
         
     }
     
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
           int n=s.nextInt();
           int m=s.nextInt();
           int a[][]=new int[n][m];
           
           for(int i=0;i<n;i++)
           for(int j=0;j<m;j++)
           a[i][j]=s.nextInt();
           
           System.out.println(maxArea(a,n,m));
        
        }
	  
	  
	 }
}
