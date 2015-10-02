package ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 10-2
 * Created by lipingxiong on 9/30/15.
 */
public class groupAnagram {
    void groupAnagram(String[] arr){
        HashMap<String, ArrayList<String> > map = new HashMap<>();
        //put anagrams to a list, sorted word as the key
        for(String s : arr){
            String key = sort_str(s);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        int i = 0;
        for(String key : map.keySet()){
            ArrayList<String> list = map.get(key);
            for(String str : list){
                arr[i++] = str;
            }
        }
    }
    // sort a string
    String sort_str(String s){
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
}
