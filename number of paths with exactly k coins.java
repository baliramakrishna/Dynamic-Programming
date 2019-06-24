import java.util.Arrays;
import java.util.Scanner;


public class noOFPaths {	

	public static void main(String args[]) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0){
			int k=in.nextInt();
			int n=in.nextInt();
			int arr[][]=new int[n][n];
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					arr[i][j]=in.nextInt();
				}
			}
			System.out.println(sol(arr, n, n, k));
		}
	}
	static long sol(int mat[][],int n,int m,int k){
		long dp[][][]=new long[n][m][k+1];
		if(mat[0][0]>k){
		    return 0;
		}
		dp[0][0][mat[0][0]]=1;
		
		int sum=0;
		for(int i=0;i<n;i++){
			sum+=mat[i][0];
			if(sum<=k)
			   dp[i][0][sum]=1;
		}
		sum=0;
		for(int i=0;i<m;i++){
			sum+=mat[0][i];
			if(sum<=k)
			   dp[0][i][sum]=1;
		}

		for(int i=1;i<n;i++){
			for(int j=1;j<m;j++){
				for(int l=0;l<=k;l++){
					if(l-mat[i][j]>=0)
					    dp[i][j][l]=dp[i-1][j][l-mat[i][j]] + dp[i][j-1][l-mat[i][j]];
				}
			}
		}
		return dp[n-1][m-1][k];
	}

	
}
