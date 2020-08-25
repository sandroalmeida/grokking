package dev.sandroalmeida.slidingWindow;

public class CharacterReplacement {

    public static int findLength(String str, int k){

        int maxLength = 0, start = 0, replaces = k, firstIndex = 0;

        for(int end = 1; end < str.length(); end++){
            char leftChar = str.charAt(start);
            char rightChar = str.charAt(end);

            if(leftChar != rightChar){
                if(replaces > 0) {
                  if(replaces == k) firstIndex = end;
                  replaces--;
                } else {
                  maxLength = Math.max(maxLength, end - start);
                  replaces = k;
                  start = firstIndex;
                  end = start;
                }
            } else if(end == str.length() - 1){
                maxLength = Math.max(maxLength, end - start + 1);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String str1 = "aabccbb";
        String str2 = "abbcb";
        String str3 = "abccde";
        System.out.println(findLength(str1,2));
        System.out.println(findLength(str2,1));
        System.out.println(findLength(str3,1));
    }
}
