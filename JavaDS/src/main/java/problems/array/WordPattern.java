package problems.array;

import java.util.HashMap;

public class WordPattern {
    public static void main(String args[]){
        String pattern="abba";
        String s="dog cat cat fish";

        System.out.print(wordPattern(pattern,s));
    }

    public static boolean wordPattern(String pattern,String s){
        String[] strArr=s.split(" ");
        if(pattern.toCharArray().length!=strArr.length){
            return false;
        }

        HashMap<Character,Integer> hm1 = new HashMap<>();
        HashMap<String,Integer> hm2 = new HashMap<>();


        for(int i=0;i<pattern.toCharArray().length;i++){
            if(!hm1.containsKey(pattern.charAt(i))){
                hm1.put(pattern.charAt(i),i);
            }

            if(!hm2.containsKey(strArr[i])){
                hm2.put(strArr[i],i);
            }

            if(!hm1.get(pattern.charAt(i)).equals(hm2.get(strArr[i]))){
                return false;
            }
        }
        return true;
    }
}
