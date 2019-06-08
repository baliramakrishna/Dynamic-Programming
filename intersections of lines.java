import java.lang.*;
import java.io.*;
import java.util.*;
class Points
 { 
     int x;
    int y;
    
    Points(int x,int y){
        this.x=x;
        this.y=y;
    }
 

    static boolean segment(Points p,Points q, Points r){
        
        if(q.x<=Math.max(p.x,r.x) && q.x>=Math.min(p.x,r.x) && q.y<=Math.max(p.y,r.y) &&  q.y>=Math.min(p.y,r.y))
        return true;
        
        return false;
        
    }
    static int orientation(Points p,Points q, Points r){
        
        int z=(p.x-q.x)*(p.y-r.y);
        int t=(p.y-q.y)*(p.x-r.x);
        int k=(z)-(t);
        
        if(k==0)
        return 0;
        
        return (k>0)?1:2;
        
    }
    
    static int line(Points p1,Points q1,Points p2,Points q2){
        
     int o1=orientation(p1,q1,p2);
     int o2=orientation(p1,q1,q2);
     int o3=orientation(p2,q2,p1);
     int o4=orientation(p2,q2,q1);
     
     if(o1!=o2 && o3!=o4)
     return 1;
     
     if(o1==0 && segment(p1,p2,q1))
     return 1;
     
     if(o2==0 && segment(p1,q2,q1))
     return 1;
     
     if(o3==0 && segment(p2,p1,q2))
     return 1;
     
     if(o4==0 && segment(p2,q1,q2))
     return 1;
     
     return 0;
     
        
        
        
    }
    
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
           int n=4;
           int a[]=new int[n];
           int b[]=new int[n];
           
           for(int i=0;i<n;i++)
           a[i]=s.nextInt();
           
            for(int i=0;i<n;i++)
           b[i]=s.nextInt();
           
            Points p1=new Points(a[0],a[1]);
	    Points q1=new Points(a[2],a[3]);
	    Points p2=new Points(b[0],b[1]);
	  Points q2=new Points(b[2],b[3]);
	     
	     System.out.println(line(p1,q1,p2,q2));
	  
        
        }
	  
	  
	 }
