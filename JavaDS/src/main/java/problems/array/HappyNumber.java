package problems.array;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String args[]){
        System.out.print(isHappy(19));
    }
    public static boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();

        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = sum(n);
        }

        return n == 1;
    }

    public static int sum(int n) {
        int sum = 0;

        while (n > 0) {
            // To get the last digit of a number
            // find the remainder when it is divided by 10
            int LastDigit = n % 10;
            sum += LastDigit * LastDigit;
            n = n / 10;
        }

        return sum;
    }
}
