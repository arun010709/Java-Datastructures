package problems.array;

//Time-O(n) single loop
//Space-O(1) no extra constant used
public class LargestSmallestUnsortedArray {

    public static void main(String args[]){
        int arr[]={3,2,1};
        findLargestAndSmallestElement(arr);


    }

    private static void findLargestAndSmallestElement(int[] arr) {
        if(arr==null || arr.length<2){
            return;
        }
        int max=arr[0];
        int min=arr[0];

        for(int i=1;i<arr.length;i++){
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Min number is "+min);
        System.out.println("Max number is "+max);
    }
}
