package problems.array;

//Time:O(n)
//Space:O(1)
public class RemoveDuplicateElementFromSortedArray2 {

    public static void main(String args[]){
        int arr[]={1,1,1,2,2,2,3,3,};
        getUniqueElementCount(arr);
    }

    public static int getUniqueElementCount(int[] arr){
        int i=0;
        for(int n:arr){
            if(i<2 || n!=arr[i-2]) {
                arr[i++]=n;
            }
        }
        for(int n:arr){
            System.out.print(n);
        }
        return i;
    }


}
