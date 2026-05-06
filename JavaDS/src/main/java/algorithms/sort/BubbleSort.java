package algorithms.sort;

/*compare first element to adjacent element, if first element is bigger swap
it with next element.*/
public class BubbleSort {
    public static void main(String args[]){
        int arr[]={5,4,3,2,1};
        System.out.print("Unsorted array:");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            int flag=0;
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=1;
                }
            }
            if(flag==0){
                break;
            }
        }

        System.out.print("Sorted array:");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
