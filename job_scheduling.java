import java.util.*;

public class job_scheduling
{
    public static int maximum(int[] arr){
        //to find no.of jobs can be scheduled
        int maxi=arr[0];
        for(int i=1;i<arr.length;i++){
            maxi=Math.max(maxi,arr[i]);
        }
        return maxi;
    }
	public static void job_seq(Integer[] profits,int[] deadlines){
	    //array to store job schedule
        int[] jobs=new int[maximum(deadlines)];
        
	    //multimap for storing profit by weight arrays indexes
	    HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
	    
	    for(int i=0;i<profits.length;i++){
	  
	        if(map.containsKey(profits[i])){
	            //creates refernce list 'b' to exisiting one
	            ArrayList<Integer> b;
	            b=map.get(profits[i]);
	            b.add(i);
	            map.put(profits[i],b);
	        }
	        else{
	            ArrayList<Integer> b=new ArrayList<>();
	            b.add(i);
	            map.put(profits[i],b);
	            b=null;
	        }
	        
	    }
	    //sorting profit array in descending order
        Arrays.sort(profits,Collections.reverseOrder());
        
        for(int i=0;i<profits.length;i++){
            ArrayList<Integer> list;
            //storing indexes for same profit in list
	        list=map.get(profits[i]);
	        
	        for(int k=0;k<list.size();k++){
	           
	           int index=deadlines[list.get(k)]-1;
	           
	           if(jobs[index] ==0){
	               jobs[index]=profits[i];
	           }
	           else{
	               
	               while(index>0 && jobs[index]!=0){
	                   index--;
	               }
	               //System.out.println("Idx is"+idx+" for index "+index);
	               if(jobs[index]==0){
	                   jobs[index]=profits[i];
	               }
	           }
	        }
        }
        int total_profit=0;
        for(int i=0;i<jobs.length;i++){
            total_profit+=jobs[i];
        }
        System.out.println(Arrays.toString(jobs));
        System.out.println("Maximum profit is: "+total_profit);
        
	}
    public static void main(String[] args) {
        //profit
	    Integer[] profits={100,19,27,25,15};                            
	    //deadlines 
	    int[] deadlines={2,1,2,1,3};
	    job_seq(profits,deadlines);
	   
    }
}


