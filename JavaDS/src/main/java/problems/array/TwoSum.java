package problems.array;

import java.util.HashMap;
import java.util.Map;


//Time:O(n)
//Space:O(n)

//Brute force
//O(n2)
//O(1)
public class TwoSum {
    public static void main(String args[]) {
        int target = 11;
        int[] nums = {2,3,5,7,9};
        int result[] = twoSumPointers(nums,target);
        if(result.length>0) {
            System.out.print(result[0] + " " + result[1]);
        }
        else{
            System.out.print("No match found");
        }
    }

    private static int[] twoSumHashMap(int target, int[] nums) {
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

    private static int[] twoSumBruteForce(int target,int[] nums){
        for (int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }

        }

        return new int[]{};
    }

    private static int[] twoSumPointers(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int currentSum = numbers[left] + numbers[right];

            if (currentSum == target) {
                return new int[]{numbers[left], numbers[right]}; // 1-indexed
            } else if (currentSum < target) {
                left++; // Need a larger sum
            } else {
                right--; // Need a smaller sum
            }
        }
        return new int[]{-1, -1};
    }

}
