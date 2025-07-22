/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 * 
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.exerc;

public class Exerc03_G {

    /**
     * Find a character in a sorted array. The function returns the index of some
     * occurrence of the character if it is found or -1 if it is not found.
     * 
     * @param arr The sorted array.
     * @param v   The character to find.
     * @param l   The left index of the search range.
     * @param r   The right index of the search range.
     * @return The index of the character.
     */
    static int frameCount = 0;

    private static int find(char[] arr, char v, int l, int r) {
        ++frameCount; // Stack frame count.
        System.out.printf("%sst:find(arr, %c, %d, %d): ?\n", "_____|".repeat(frameCount), v, l, r);

        if (l > r) {
            System.out.printf("%sed:find(arr, %c, %d, %d): %d\n", "_____|".repeat(frameCount), v, l, r, -1);
            --frameCount; // Stack frame count.

            return -1;
        }

        int m = l + (r - l) / 2;
        if (arr[m] == v) {
            System.out.printf("%sed:find(arr, %c, %d, %d): %d\n", "_____|".repeat(frameCount), v, l, r, m);
            --frameCount; // Stack frame count.

            return m;
        } else if (arr[m] < v) {
            int pos = find(arr, v, m + 1, r);

            System.out.printf("%sed:find(arr, %c, %d, %d): %d\n", "_____|".repeat(frameCount), v, l, r, pos);
            --frameCount; // Stack frame count.

            return pos;
        } else {
            int pos = find(arr, v, l, m - 1);

            System.out.printf("%sed:find(arr, %c, %d, %d): %d\n", "_____|".repeat(frameCount), v, l, r, pos);
            --frameCount; // Stack frame count.

            return pos;
        }
    }

    /**
     * Find a character in a sorted array. The function returns the index of some
     * occurrence of the character if it is found or -1 if it is not found.
     * 
     * @param arr The sorted array.
     * @param v   The character to find.
     * @return The index of the character.
     */
    private static int findItr(char[] arr, char v) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == v) {
                return m;
            } else if (arr[m] < v) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[] arr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' };
        char v = 'f';
        System.out.println(find(arr, v, 0, arr.length - 1));
        // System.out.println(findItr(arr, v));
    }

}
