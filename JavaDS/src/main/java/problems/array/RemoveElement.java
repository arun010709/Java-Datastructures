package problems.array;

//Time complexity - O(n)
//Space complexity-O(1)
public class RemoveElement {
    public static int removeElement(int arr[], int val) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[count] = arr[i];
                count++;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

        return count;
    }

    public static void main(String args[]) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(arr,val));
    }
}
