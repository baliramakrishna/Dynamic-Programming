
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented
 * by array nums. You are asked to burst all the balloons. If the you burst balloon i you will
 * get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst,
 * the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Time complexity O(n^3)
 * Space complexity O(n^2)
 *
 * Reference
 * https://leetcode.com/problems/burst-balloons/
 */
 
 /*package whatever //do not write package name here */

import java.io.*;

class BurstBallons{
    
    static int maxCoins(int bal[],int length){
        
        int a[][]=new int[length][length];
        
        for(int l=1;l<=length;l++){
            
            for(int i=0;i<=length-l;i++){
                int j=i+l-1;
                
                for(int k=i;k<=j;k++){
                    
                    int left=1;
                    int right=1;
                    
                    if(i!=0)
                    left=bal[i-1];
                    
                    if(j!=length-1)
                    right=bal[j+1];
                    
                    int before=0;
                    int after=0;
                    
                    if(i!=k)
                    before=a[i][k-1];
                    if(j!=k)
                    after=a[k+1][j];
                    
                    a[i][j]=Math.max(before+after+bal[k]*left*right,a[i][j]);
                    
                }
                
            }
            
        }
        
        return a[0][length-1];
        
    }
	public static void main (String[] args) {
		
		int bal[]={3,1,5,8};
		System.out.println(maxCoins(bal,bal.length));
	}
}
