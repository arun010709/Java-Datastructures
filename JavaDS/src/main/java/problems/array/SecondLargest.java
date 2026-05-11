package problems.array;
//Time-O(n) single loop
//Space-O(1) no extra constant used
public class SecondLargest {
    public static void main(String args[]){
        secondLargest(new int[]{3,7,5});
    }

    private static void secondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println("Invalid Input");
            return;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                secondLargest=largest;
                largest=arr[i];

            }else if(arr[i]>secondLargest && arr[i]!=largest){
                secondLargest=arr[i];
            }
        }

        System.out.println("Largest number is "+largest);
        System.out.println("Second largest number is "+secondLargest);
    }
}
