package problems.array;

//Time:O(n)
//Space:O(1)
public class RemoveDuplicateFromSortedArray {

    public static void main(String args[]){
        int[] arr={1,1,2,2,3};
        System.out.print(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] arr){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(i<arr.length-1 && arr[i]==arr[i+1]){
                continue;
            }else{
                arr[count]=arr[i];
                count++;
            }
        }
        return count;
    }
}
