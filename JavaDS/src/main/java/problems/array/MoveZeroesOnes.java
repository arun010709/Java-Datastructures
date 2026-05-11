package problems.array;

//Time-O(n)
//Space-O(1)
public class MoveZeroesOnes {
    public static void main(String args[]){
        int[] nums={0,1,0,1,1};
        int lastNonZeroAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap current element with the element at the write pointer
                int temp = nums[i];
                nums[i] = nums[lastNonZeroAt];
                nums[lastNonZeroAt] = temp;

                // Move the write pointer forward
                lastNonZeroAt++;
            }
        }
    }
}
