/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 * 
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.exerc;

import cs2725.api.List;
import cs2725.api.SimpleMap;
import cs2725.impl.ArrayList;
import cs2725.impl.SimpleHashMap;

public class Exerc05_B {

    /**
     * Converts a string of words into a list of words.
     * 
     * @param text the string of words
     * @return a list of words
     */
    public static List<String> stringToList(String text) {
        List<String> words = new ArrayList<>();
        String[] tokens = text.split("\\s+");

        for (String token : tokens) {
            words.insertItem(token);
        }

        return words;
    }

    /**
     * Counts the occurrences of each word in the given list.
     * 
     * @param words the list of words
     * @return a map containing the word counts
     */
    public static SimpleMap<String, Integer> wordCount(List<String> words) {
        SimpleMap<String, Integer> wordMap = new SimpleHashMap<>();
        for (String word : words) {
            if (!wordMap.containsKey(word)) {
                wordMap.put(word, 0);
            }
            wordMap.put(word, wordMap.get(word) + 1);
        }
        return wordMap;
    }

    public static void main(String[] args) {
        String text = "the dog played with the ball and the ball was big so the dog ran around the yard with the ball until the dog became tired";

        List<String> words = stringToList(text);
        SimpleMap<String, Integer> wordMap = wordCount(words);

        System.out.println("Word count:");
        System.out.println(wordMap);
    }

}
