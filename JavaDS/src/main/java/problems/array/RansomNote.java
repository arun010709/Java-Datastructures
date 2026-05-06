package problems.array;

import java.util.HashMap;

public class RansomNote {

    public static void main(String args[]){
        String ransomNote="ab";
        String magazine="aab";

        System.out.print(isRansomNote(ransomNote,magazine));

    }

    public static boolean isRansomNote(String ransomNote,String magazine){
        HashMap<Character,Integer> hm = new HashMap<>();

        for(Character ch:magazine.toCharArray()){
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)+1);
            }else{
                hm.put(ch,1);
            }
        }

        for(Character ch:ransomNote.toCharArray()){
            if(hm.containsKey(ch)){
                if(hm.get(ch)>1){
                  hm.put(ch,hm.get(ch)-1);
                }else{
                    hm.remove(ch);
                }
            }else{
                return false;
            }
        }

        return true;
    }
}
