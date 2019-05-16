/*package whatever //do not write package name here */

import java.util.*;

class Box implements Comparable<Box>{
    
    int l,w,h,area;
    
    Box(int l,int w,int h){
        this.l=l;
        this.w=w;
        this.h=h;
    }
    
    @Override
    public int compareTo(Box b){
        
       return b.area-this.area; 
    }
    
    static int maxHeight(Box a[],int n){
        
       Box[] box=new Box[3*n];
       
       for(int i=0;i<n;i++){
           Box temp=a[i];
           box[3*i]=new Box(Math.max(temp.l,temp.w),Math.min(temp.l,temp.w),temp.h);
           box[3*i+1]=new Box(Math.max(temp.l,temp.h),Math.min(temp.l,temp.h),temp.w);
           box[3*i+2]=new Box(Math.max(temp.h,temp.w),Math.min(temp.h,temp.w),temp.l);
       }
       
       for(int i=0;i<box.length;i++)
       box[i].area=box[i].l*box[i].w;
       
       Arrays.sort(box);
       
       int mhv[]=new int[box.length];
       int result[]=new int[box.length];
       for(int i=0;i<box.length;i++){
           mhv[i]=box[i].h;
           result[i]=i;
       }
       
       for(int i=1;i<box.length;i++){
            Box first=box[i];
           for(int j=0;j<box.length;j++ ){
               Box sec=box[j];
               
               if(sec.l>first.l && sec.w>first.w){
                   
                   mhv[i]=Math.max(mhv[i],mhv[j]+box[i].h);
                   result[i]=j;
               }
           }
       }
       
       int max=-1;
       for(int k:mhv){
           if(k>max)
           max=k;
       }
       return max;
    }
	public static void main (String[] args) {
		
		Box[] a=new Box[2];
		a[0]=new Box(3,2,5);
		a[1]=new Box(1,2,4);
		System.out.println("Max Height "+maxHeight(a,a.length));
	}
}
