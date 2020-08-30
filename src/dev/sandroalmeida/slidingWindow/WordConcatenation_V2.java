package dev.sandroalmeida.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordConcatenation_V2 {

    public static List<Integer> findWordConcatenation(String str, String[] words){

        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for(String word : words){
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        int wordsCount = words.length, wordLength = words[0].length();

        for(int i = 0; i <= str.length() - wordsCount * wordLength; i++){
            Map<String, Integer> wordsSeen = new HashMap<>();

            for(int j = 0; j < wordsCount; j++){
                int nextWordIndex = i + j * wordLength;
                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);
                if(!wordFrequencyMap.containsKey(word))
                    break;

                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);

                if(wordsSeen.get(word) > wordFrequencyMap.getOrDefault(word, 0))
                    break;

                if(j + 1 == wordsCount)
                    result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String[] arr = {"cat", "fox"};
        System.out.println(findWordConcatenation("catfoxcat", arr));
        System.out.println(findWordConcatenation("catcatfoxfox", arr));

    }
}
