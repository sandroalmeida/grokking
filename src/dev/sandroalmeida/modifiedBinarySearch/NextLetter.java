package dev.sandroalmeida.modifiedBinarySearch;

public class NextLetter {

    public static char searchNextLetter(char[] letters, char key){

        if(key >= letters[letters.length - 1]) return letters[0];

        int start = 0, end = letters.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(key > letters[mid])
                start = mid + 1;
            else if(key < letters[mid])
                end = mid - 1;
            else{
                return letters[mid + 1];
            }
        }
        return letters[start];
    }

    public static void main(String[] args) {
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }
}
