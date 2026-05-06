package problems.array;

import java.util.HashMap;
import java.util.Map;


//Time:O(n)
//Space:O(n)
public class TwoSum {
    public static void main(String args[]){
        int target=6;
        int[] nums={3,4,2};
        int result[]=twoSum(target,nums);
        System.out.print(result[0]+" "+result[1]);
    }
    private static int[] twoSum(int target,int[] nums){
        Map<Integer,Integer> map=new HashMap<>();
        int [] result=new int[2];
        if(nums==null || nums.length<1) return result;
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                result[0]=map.get(target-nums[i]);
                result[1]=i;
                break;
            }
            map.put(nums[i],i);
        }
        return result;
    }

}
