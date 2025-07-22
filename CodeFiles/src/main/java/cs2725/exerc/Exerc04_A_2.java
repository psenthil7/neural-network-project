/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 * 
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.exerc;

import cs2725.api.Stack;
import cs2725.impl.ArrayStack;
import cs2725.viz.Graph;

public class Exerc04_A_2 {

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and
     * ']', determine if the input string is valid.
     * An input string is valid if:
     * 1. Open brackets must be closed by the same type of brackets.
     * 2. Open brackets must be closed in the correct order.
     * 
     * @param str The input string.
     * @return True if the input string is valid, false otherwise.
     */
    public static boolean isWellFormed(String str) {
        Stack<Character> stack = new ArrayStack<>();

        Graph.i().setRef("stack", stack); // For visualization only.
        char[] chars = str.toCharArray(); // For visualization only.
        Graph.i().setRef("chars", chars); // For visualization only.

        int len = str.length();
        for (int i = 0; i < len; ++i) {
            Graph.i().setRef("i", chars, i); // For visualization only.

            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                stack.push(str.charAt(i));
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char lastOpen = stack.pop();
                if (lastOpen == '(' && str.charAt(i) != ')') {
                    return false;
                }
                if (lastOpen == '{' && str.charAt(i) != '}') {
                    return false;
                }
                if (lastOpen == '[' && str.charAt(i) != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Note: Make sure to copy paste your ArrayStack implementation from project 1
        // to the ArrayStack class to be able to run this code.

        // Setup for visualization.
        Graph.enable();
        Graph.i().makeLeftToRight();

        String str0 = "([{}])";
        boolean ans0 = isWellFormed(str0);

        String str1 = "{[]()([{}])}";
        boolean ans1 = isWellFormed(str1);

        String str2 = "([)]";
        boolean ans2 = isWellFormed(str2);

        String str3 = "(()";
        boolean ans3 = isWellFormed(str3);

        String str4 = "{}}";
        boolean ans4 = isWellFormed(str4);

        String str5 = "";
        boolean ans5 = isWellFormed(str5);
    }

}
