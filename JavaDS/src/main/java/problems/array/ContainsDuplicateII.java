package problems.array;

import java.util.HashMap;
import java.util.Map;

//Time:O(n)
//Space:O(n)
public class ContainsDuplicateII {


    public static void main(String args[]){
        int nums[]={1,2,3,1};
        int k=3;

        System.out.print(containsNearbyDuplicate(nums,k));

    }
        public static boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }
            return false;
        }
}
