/* Pizza Is a dish of Italian origin, consisting of a flat round base of dough baked with some toppings.
It is basically Circular in shape. It comes in 3 sizes-
Small, Medium, and Large Pizza.

Abhinav is crazy for Pizzas.
Small Pizza has an area of 'S' units^2
Medium Pizza has an area of 'M' units^2
Large Pizza has an area of 'L' units^2

Cost of Small, medium and Large Pizza is 'CS' , 'CM', and 'CL' respectively.
Abhinav wants atleast 'X' units^2 of pizza .
What is the minimum amount of Rs. needed so that Abhinav can buy atleast X units square of Pizza?
If more than 1 arrangement is possibleChoose that one which requires Least Money. 

Two arrangements are said to be different if They have different quantities of Small , medium , or large pizzas!

Input:
First line contains the number of test cases-T
The next line contains 6 integers- X, S,M , L , CS, CM, CL

Output:
Output one integer the minimum amount of Rs. needed.

Constraints:
1<=T<=100
1<=X<=500
1<=S< M< L<=100
1<=CS< CM<=1000

Example:
Input:
1
16 3 6 9 50 150 300
Output:
300 */

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 { 
     
     static int print(int area[],int cost[],int k){
         
         
         int a[][]=new int[3][k+1];
         
         for(int i=1;i<=k;i++){
             
             if(i%area[0]==0)
             a[0][i]=(i/area[0])*cost[0];
             else
             a[0][i]=((i/area[0])+1)*cost[0];
             
             
         }
        
         for(int i=1;i<3;i++){
             
             for(int j=1;j<=k;j++){
                 
                 if(j<=area[i])
                     
                    a[i][j]=Math.min(a[i-1][j],cost[i]);
        
                 else{
                     
                     if(j%area[i]==0){
                         a[i][j]=Math.min(a[i-1][j],cost[i]+a[i][j-area[i]]);
                     }else{
                         a[i][j]=Math.min(Math.min(a[i-1][j],cost[i]+a[i][j-area[i]]),((j/area[i])+1)*cost[i]);
                     }
                 }
                 
             }
            
         }
         return a[2][k];
     }
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
            int k=s.nextInt();
            int area[]=new int[3];
            int cost[]=new int[3];
            
            for(int i=0;i<3;i++)
            area[i]=s.nextInt();
            
            for(int i=0;i<3;i++)
            cost[i]=s.nextInt();
            
            System.out.println(print(area,cost,k));
           
        
        }
	  
	  
	 }
}
