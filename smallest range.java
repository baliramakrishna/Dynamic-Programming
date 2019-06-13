import java.util.*;
import java.io.*;
import java.lang.*;
public class DriverClass
{
	public static void main(String args[]) 
	{
	   Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   while(t-- >0)
	   {
	     int n = sc.nextInt();
	     int k = sc.nextInt();
	     int arr[][] = new int[k][n];
	       for(int i = 0; i < k; i++)
	       {
	        for(int j = 0; j < n; j++)
	               arr[i][j] = sc.nextInt();
	       }
	       new smallestRangeFromKLists().findSmallestRange(arr, n, k);
	       System.out.println();
	   }
	}
}

}
/*This is a function problem.You only need to complete the function given below*/

class smallestRangeFromKLists
{   
    static class Node{
        
         int data;
        int row;
        int nextElement;
       
        
        Node(int data,int row,int nextElement){
            
           this.data=data;
           this.nextElement=nextElement;
            this.row=row;
        }
        
    }
	static void findSmallestRange(int[][] a,int n,int k)
	{
	     
	     
	     PriorityQueue<Node> p=new PriorityQueue<>((t1,t2)->{
	         return t1.data-t2.data;
	     });
	     
	     int max=Integer.MIN_VALUE;
	     int min=0;
	     int range=Integer.MAX_VALUE;
	     int start=-1,end=-1;
	     
	     for(int i=0;i<k;i++){
	     p.add(new Node(a[i][0],i,1));
	     max=Math.max(a[i][0],max);
	     }
	     
	     while(true){
/	         
	         Node temp=p.poll();
	         min=temp.data;
	         
	         if(max-min+1<range){
	             
	             range=max-min+1;
	             start=min;
	             end=max;
	             
	         }
	         
	         if(temp.nextElement<n){
	             
	             p.add(new Node(a[temp.row][temp.nextElement],temp.row,temp.nextElement+1));
	             max=Math.max(max,a[temp.row][temp.nextElement]);
	         }else{
	             break;
	         }
	         
	     }
	     System.out.print(start+" "+end);
	}
}
