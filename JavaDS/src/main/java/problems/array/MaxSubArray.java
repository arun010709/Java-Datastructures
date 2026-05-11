package problems.array;

//Time-O(n)
//Space-O(1)
public class MaxSubArray {
    public static void main(String args[]){
        int[] arr={-10,4,-1,2,1};

        int currentMax=arr[0];
        int maxSoFar=arr[0];

        for(int i=1;i<arr.length;i++){
            currentMax = Math.max(arr[i],currentMax + arr[i]);
            maxSoFar=Math.max(maxSoFar,currentMax);
        }

        System.out.print(maxSoFar);

    }
}
