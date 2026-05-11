package problems.array;

import java.util.HashMap;
import java.util.Map;


//Time:O(n)
//Space:O(n)
public class TwoSum {
    public static void main(String args[]) {
        int target = 9;
        int[] nums = {3, 9, 6};
        int result[] = twoSum(target, nums);
        System.out.print(result[0] + " " + result[1]);
    }

    private static int[] twoSum(int target, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length ; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

}
