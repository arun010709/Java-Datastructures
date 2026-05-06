package problems.array;

public class FirstOccurence {



    public static void main(String args[]){
        String haystack="leetcode";
        String needle="leeto";
        System.out.print(findOccurence(haystack,needle));
    }
    public static int findOccurence(String haystack,String needle){
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;
    }
}
