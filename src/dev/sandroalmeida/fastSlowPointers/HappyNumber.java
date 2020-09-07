package dev.sandroalmeida.fastSlowPointers;

import java.util.ArrayList;
import java.util.List;

public class HappyNumber {

    public static boolean find(int num){

        List<Integer> results = new ArrayList<>();
        int result = 0;
        List<Integer> numbers = returnArr(num);

        while(result != 1){
            result = 0;
            for(int n : numbers){
                result += n * n;
            }
            if(results.contains(result)){
                return false;
            }
            numbers = returnArr(result);
            results.add(result);
        }

        return true;
    }

    private static List<Integer> returnArr(int num){
        List<Integer> numbers = new ArrayList<>();

        while(num >= 10){
            int mod = num % 10;
            num = num / 10;
            numbers.add(mod);
        }
        numbers.add(num);

        return numbers;
    }

    public static void main(String[] args) {
        System.out.println(find(23));
        System.out.println(find(12));
    }
}
