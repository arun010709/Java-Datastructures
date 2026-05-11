package problems.array;

import java.util.HashMap;
import java.util.Map;

//Time : O(m+n), number of characters in string s1 & s2
//Space: O(1), only 26 keys can be present in map at max.
public class ValidAnagram {

    public static void main(String args[]){

        String s1="anagram";
        String s2="nagaram";

        System.out.print(isAnagram(s1,s2));

    }

    public static boolean isAnagram(String s1,String s2){
        Map<Character,Integer> hm = new HashMap<>();

        for(Character ch:s1.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }

        for(Character ch:s2.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)-1);
        }

        for(Map.Entry<Character,Integer> entry:hm.entrySet()){
            if(entry.getValue()!=0){
                return false;
            }
        }
        return true;
    }
}
