/*package whatever //do not write package name here */

import java.util.*;

class Permutations{
    
    static HashSet<String> h=new HashSet<>();
    
    static int permutations(String s){
        
      perm(s,"");
      return h.size();
    }
    
    static void perm(String s,String prefix){
        
        
        if(s.length()==0){
            
            if(!h.contains(prefix)){
                h.add(prefix);
                System.out.println(prefix);
            }
        }
        else{
            
            
            for(int i=0;i<s.length();i++){
                
                String rem=s.substring(0,i)+s.substring(i+1);
                
                perm(rem,prefix+s.charAt(i));
            }
        }
        
    }
	public static void main (String[] args) {
		
		String str="abcd";
		
		System.out.println(permutations(str));
	}
}
