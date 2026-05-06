package problems.array;

public class LengthOfLastWord {

    public static void main(String args[]){
        String str = "luffy is still joyboy ";
        System.out.print(getLength(str));
    }

    public static int getLength(String str){
        String arr[]=str.split(" ");
        return arr[arr.length-1].length();
    }
}
