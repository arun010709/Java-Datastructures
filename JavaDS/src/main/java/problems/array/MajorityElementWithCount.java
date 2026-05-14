package problems.array;

//Time-O(n)
//Space-O(1)
public class MajorityElementWithCount {

    public static void main(String args[]){
        int nums[]={7,7,9};
        int candidate=0;
        int count=0;

        for(int num:nums){
            if(count==0){
                candidate=num;
            }

            count+= (candidate==num)?1:-1;
        }

        //actual count
        int actualCount=0;
        for(int num:nums){
            if(candidate==num){
                actualCount++;
            }
        }

        System.out.println("The majority element is "+candidate);
        System.out.println("The occurence of the element is "+actualCount);
    }
}
