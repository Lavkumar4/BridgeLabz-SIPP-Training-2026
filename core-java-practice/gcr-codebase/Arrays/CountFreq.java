import java.util.*;

public class CountFreq {
    public static void main(String [] args) {
        int arr[] ={3,5,6,8,7,6,4,3,4,5,9};
        Map<Integer,Integer> count= new HashMap<>();
        
        for(int i:arr){
			count.put(a,count.getOrDefault(a,defaultValue: 0)+1);
            // if(count.containsKey(i)){
            //     int ifreq = count.get(i);
            //     count.put(i,ifreq+1);
            // }
            // else{count.put(i,1);
            // }
        }
        for(int i:count.keySet()){
            System.out.println(i+"ki value hai "+ count.get(i));
        }
    }
}