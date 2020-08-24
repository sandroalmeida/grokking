package dev.sandroalmeida.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

    public static int findLength(char[] arr){
        int maxNumber = 0, start = 0;

        Map<Character, Integer> mapFruit = new HashMap<>();

        for(int end = 0; end < arr.length; end++){
            mapFruit.put(arr[end], mapFruit.getOrDefault(arr[end],0) + 1);
            while(mapFruit.size() > 2){
                mapFruit.put(arr[start], mapFruit.get(arr[start]) - 1);
                if(mapFruit.get(arr[start]) == 0){
                    mapFruit.remove(arr[start]);
                }
                start++;
            }
            maxNumber = Math.max(maxNumber, end - start + 1);
        }

        return maxNumber;
    }

    public static void main(String[] args) {
        char[] arr = {'A','B','C','A','C'};
        System.out.println(findLength(arr));
        char[] arr2 = {'A','B','C','B','B','C'};
        System.out.println(findLength(arr2));
    }
}
