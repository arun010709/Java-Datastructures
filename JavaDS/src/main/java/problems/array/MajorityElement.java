package problems.array;

//Time complexity - O(n)
//Space complexity-O(1)
public class MajorityElement {

    public static void main(String args[]){
        int[] arr={8,8,7,7,7};

        System.out.print(majorityElement(arr));
    }

    public static int majorityElement(int arr[]){
        int n=arr.length;
        int candidate=-1;
        int count=0;

        for(int num:arr){
            if(count==0){
                candidate=num;
                count++;
            }else if(num==candidate){
                count++;
            }else{
                count--;
            }
        }

        count=0;
        for(int num:arr){
            if(num==candidate){
                count++;
            }
        }

        if(count > n/2){
            return candidate;
        }else{
            return -1;
        }
    }
}
