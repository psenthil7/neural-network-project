/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 * 
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.exerc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import cs2725.api.List;
import cs2725.api.SimpleMap;
import cs2725.impl.ArrayList;
import cs2725.impl.SimpleHashMap;
import cs2725.impl.SimpleUnsortedMap;

public class Exerc05_C {

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
        SimpleMap<String, Integer> wordMap = new SimpleUnsortedMap<>();
        for (String word : words) {
            if (!wordMap.containsKey(word)) {
                wordMap.put(word, 0);
            }
            wordMap.put(word, wordMap.get(word) + 1);
        }
        return wordMap;
    }

    /**
     * Counts the occurrences of each word in the given list.
     * 
     * @param words the list of words
     * @return a map containing the word counts
     */
    public static SimpleMap<String, Integer> wordCountFast(List<String> words) {
        SimpleMap<String, Integer> wordMap = new SimpleHashMap<>();
        for (String word : words) {
            if (!wordMap.containsKey(word)) {
                wordMap.put(word, 0);
            }
            wordMap.put(word, wordMap.get(word) + 1);
        }
        return wordMap;
    }

    /**
     * Reads the content of a file into a string.
     *
     * @param filePath the path to the file
     * @return the file content as a string
     * @throws IOException if an error occurs while reading the file
     */
    public static String loadTextFromFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static void main(String[] args) {
        try {
            String text = loadTextFromFile("resources/words.txt");

            List<String> words = stringToList(text);

            long startTime = 0, endTime = 0;

            startTime = System.nanoTime();
            SimpleMap<String, Integer> wordMapA = wordCount(words);
            endTime = System.nanoTime();
            System.out.printf("UnsortedMap based Duration: %.4fs\n", (endTime - startTime) / 1e9);

            // System.out.println("Word count:");
            // System.out.println(wordMapA);

            startTime = System.nanoTime();
            SimpleMap<String, Integer> wordMapB = wordCountFast(words);
            endTime = System.nanoTime();
            System.out.printf("HashMap based Duration: %.4fs\n", (endTime - startTime) / 1e9);

            // System.out.println("Word count:");
            // System.out.println(wordMapB);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

}
