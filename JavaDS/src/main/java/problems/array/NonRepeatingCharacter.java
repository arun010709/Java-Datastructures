package problems.array;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatingCharacter {
    //Input: SWISS
    //Output : W
    public static void main(String args[]){
        String str1="AABBC";

        HashMap<Character,Integer> digitCountMap = new HashMap<>();
        int count=0;
        for(Character ch: str1.toCharArray()){
            if(digitCountMap.containsKey(ch)){
                digitCountMap.put(ch,digitCountMap.get(ch)+1);
            }
            else{
                digitCountMap.put(ch,count);
            }
        }

        boolean flag=false;
        for(Map.Entry<Character,Integer> entry:digitCountMap.entrySet()){
            if(entry.getValue()==0){
                System.out.print("First non repeating character is "+entry.getKey());
                flag=true;
                break;
            }
        }

        if(!flag){
            System.out.print("No repeating character found");
        }
    }

}
