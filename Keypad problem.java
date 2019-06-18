import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {  
     static int row[]={0,0,0,1,-1};
     static int coloumn[]={0,-1,1,0,0};
     static char ch[][]={{'1','2','3'},{'4','5','6'},{'7','8','9'},{'*','0','#'}};
     
    static long count(int n){
        
        if(n<=0)
        return 0;
        
        if(n==1)
        return 10;
        
        long a[][]=new long[10][n+1];
        
        for(int i=0;i<=9 ;i++){
            a[i][0]=0;
            a[i][1]=1;
        }
        for(int k=2;k<=n;k++){
            
            for(int i=0;i<=3;i++){
                
                for(int j=0;j<=2;j++){
                    
                    if(ch[i][j]!='*' && ch[i][j]!='#'){
                        
                        int num=ch[i][j]-'0';
                        
                        for(int v=0;v<5;v++){
                            
                            int r=i+row[v];
                            int c=j+coloumn[v];
                            
                            if(r>=0 && c>=0 && r<=3 && c<=2 && ch[r][c]!='*' && ch[r][c]!='#'){
                                int num1=ch[r][c]-'0';
                                a[num][k]+=a[num1][k-1];
                                
                            }
                        }
                        
                    }
                    
                }
            }
            
        }
        
        long tcount=0;
        
        for(int i=0;i<=9;i++)
        tcount+=a[i][n];
        
        return tcount;
        
    }
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
           int n=s.nextInt();
           
           System.out.println(count(n));
        
        }
	  
	  
	 }
}
