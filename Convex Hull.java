import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {   
    static Points p[]; 
     
    static class Points{
        
        int x;
        int y;
        
        Points(int x,int y){
            this.x=x;
            this.y=y;
        }
    } 
    
    static int crossProduct(Points p1,Points p2,Points p3){
    
        return  (p1.x-p2.x)*(p1.y-p3.y)-(p1.x-p3.x)*(p1.y-p2.y);
        
    }
    
    static int distance(Points p1,Points p2,Points p3){
        
        int d1=(p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y);
        int d2=(p1.x-p3.x)*(p1.x-p3.x)+(p1.y-p3.y)*(p1.y-p3.y);
        
        if(d1<d2)
        return -1;
        else if(d1==d2)
        return 0;
        else
        return 1;
    }
    
    static void convexHull(Points p[],int n){
        
        Points start=p[0];
        
        for(int i=1;i<n;i++){
            
            if(p[i].x<start.x)
            start=p[i];
        }
        
    TreeSet<Points> h=new TreeSet<>((t1,t2)->{
        
        if(t1.x==t2.x)
        return t1.y-t2.y;
        else
        return t1.x-t2.x;
        });
        h.add(start);
        Points current=start;
        
        while(true){
            ArrayList<Points> l=new ArrayList<>();
            Points nextPoint=p[0];
            
            for(int i=1;i<n;i++){
                if(p[i]==current)
                continue;
                
                int d=crossProduct(current,nextPoint,p[i]);
                
                if(d>0){
                    
                    nextPoint=p[i];
                    l=new ArrayList<>();
                    
                }
                else if(d==0){
                    
                    int k=distance(current,nextPoint,p[i]);
                    
                    if(k<0){
                    l.add(nextPoint);
                    nextPoint=p[i];
                   }else
                   l.add(p[i]);
                    
                }
            }
            
            for(Points q:l)
            h.add(q);
            
            //if all are collinear it means no convex hull
            if(l.size()==n-1){
                System.out.println(-1);
                return;
            }
            
            if(start==nextPoint)
            break;
            
            h.add(nextPoint);
            current=nextPoint;
            
            
        }
        
        String str="";
        for(Points q:h)
        str=str+", "+q.x+" "+q.y;
        
        System.out.println(str.substring(2));
        
    }
    
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
           int n=s.nextInt();
           p=new Points[n];
           for(int i=0;i<n;i++){
              
              int x=s.nextInt();
             int y=s.nextInt();
             p[i]=new Points(x,y);
           }
           
           convexHull(p,n);
        
        }
	  
	  
	 }
}
