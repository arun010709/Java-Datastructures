package algorithms.sort;

/*assume first element as minimum element. Compare it with rest of elements
* if any smaller element is found, swap it's index with minimum and
* at the end of iteration swap first element with minimum element */
public class SelectionSort {
    public static void main(String args[]){
        int arr[]={5,4,3,2,1};
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }

        int min=0;
        for(int i=0;i<arr.length;i++){
            min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }

            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
    }
}
