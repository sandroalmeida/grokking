package dev.sandroalmeida.util;

public class ArrayUtil {

    public static void showIntArray(int[] arr){

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
            sb.append(" ");
            if(i < arr.length - 1) sb.append(",");
        }
        sb.append("}");

        System.out.println(sb.toString());
    }

}
