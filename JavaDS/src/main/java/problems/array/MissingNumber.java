package problems.array;
//Time-O(n) single loop
//Space-O(1) no extra constant used
public class MissingNumber {
    public static void main(String args[]){
        findMissingNumber(new int[]{1,2,4,5},5);
    }

    private static void findMissingNumber(int[] arr, int n) {
        int expectedSum=n*(n+1) / 2;
        int actualSum=0;
        for(int i:arr){
            actualSum+=i;
        }

        System.out.print("Missing number "+(expectedSum-actualSum));
    }
}
