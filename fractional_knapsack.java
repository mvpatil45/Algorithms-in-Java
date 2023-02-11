import java.util.*;

public class fractional_knapsack
{
	public static float knapsack(float[] p,float[] w,float weight){
        // length of array
	    int n=p.length;
	    //multimap for storing profit by weight arrays indexes
	    HashMap<Float, ArrayList<Integer>> map=new HashMap<>();
	    //profit by weight array
	    ArrayList<Float> pw=new ArrayList<>();
	    for(int i=0;i<n;i++){
	        float value=p[i]/w[i];
	        pw.add(value);
	        if(map.containsKey(value)){
	            //creates refernce list 'b' to exisiting one
	            ArrayList<Integer> b;
	            b=map.get(value);
	            b.add(i);
	            map.put(value,b);
	        }
	        else{
	            ArrayList<Integer> b=new ArrayList<>();
	            b.add(i);
	            map.put(value,b);
	            b=null;
	        }
	        
	    }
	    //sorting profit by weight array in descending order
        Collections.sort(pw,Collections.reverseOrder());
        //array for storing fractions of objects
        float[] frac=new float[n];
        int k=0;
        while(weight>0){
            ArrayList<Integer> array;
            //storing list in array
	        array=map.get(pw.get(k));
	        for(int i=0;i<array.size();i++){
	            float diff=weight-w[array.get(i)];
                if(diff<0){
                    frac[array.get(i)]=weight/w[array.get(i)];
                    weight=0;
                }
                else{
                    weight=weight-w[array.get(i)];
                    frac[array.get(i)]=1;
                    
                }
	        }
            // to avoid same map keys
            k+=array.size();
        }
        float profit=0;
	  	for(int i=0;i<n;i++){
	        profit+=frac[i]*p[i];
	    }
	    return profit;
	    
	}
    public static void main(String[] args) {
        //maximum weight
        float weight=50;
        //profit
	    float[] p={60,100,120};
	    //weight
	    float[] w={10,20,30};
	    System.out.println("Maximize Profit is: "+knapsack(p,w,weight));
    }
}


