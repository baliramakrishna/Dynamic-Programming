{
//initial code
import java.util.*;
import java.lang.*;
class InterLeaveString
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            String a =sc.next();
            String b = sc.next();
            String c = sc.next();
            GfG g=new GfG();
        
            System.out.println(g.isInterLeave(a,b,c)==true?1:0);
            t--;
        }
    }
}

}
/*This is a function problem.You only need to complete the function given below*/
/*you are required to complete this method */
class GfG{
	public boolean isInterLeave(String a,String b,String c)
	{
            int n=a.length();
            int m=b.length();
            int l=c.length();
            
            if(l<m+n)
            return false;
            
            boolean res[][]=new boolean[n+1][m+1];
            res[0][0]=true;
            
            for(int i=1;i<=m;i++){
                
                if(b.charAt(i-1)==c.charAt(i-1) && res[0][i-1])
                res[0][i]=true;
                
               
            }
            
            for(int i=1;i<=n;i++){
                
                if(a.charAt(i-1)==c.charAt(i-1) && res[i-1][0])
                res[i][0]=true;
            }
            
            for(int i=1;i<=n;i++){
                
               for(int j=1;j<=m;j++){
                   
                   int k=i+j-1;
                   
                   if(a.charAt(i-1)==c.charAt(k) && res[i-1][j])
                   res[i][j]=true;
                   
                   if(b.charAt(j-1) ==c.charAt(k) && res[i][j-1])
                   res[i][j]=true;
               } 
                
            }
            return res[n][m];
	}
}
