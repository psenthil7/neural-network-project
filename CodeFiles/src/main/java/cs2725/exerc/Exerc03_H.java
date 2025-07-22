/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 * 
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.exerc;

import cs2725.impl.LinkedNode;
import cs2725.util.Util;
import cs2725.viz.Graph;

public class Exerc03_H {

    /**
     * Reverse a linked list.
     * 
     * @param head The head of the list.
     * @return The head of the list after reversing.
     */
    private static LinkedNode<String> reverse(LinkedNode<String> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        LinkedNode<String> newHead = reverse(head.getNext());

        head.getNext().setNext(head);
        head.setNext(null);

        return newHead;
    }

    public static void main(String[] args) {
        LinkedNode<String> head = Util.makeList(5);

        Graph.i().setRef("head", head);

        head = reverse(head);

        Graph.i().setRef("head", head);
    }
    
}
