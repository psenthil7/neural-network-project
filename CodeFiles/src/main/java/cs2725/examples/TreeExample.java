/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 * 
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.examples;

import cs2725.impl.BinaryTreeNode;
import cs2725.impl.NaryTreeNode;
import cs2725.viz.Graph;

public class TreeExample {

    public static <T> int height(BinaryTreeNode<T> root) {
        throw new UnsupportedOperationException();
    }

    private static NaryTreeNode<String> parentArrayToTree(int[] parentArray, String[] values) {
        throw new UnsupportedOperationException();
    }

    public static <T> int count(BinaryTreeNode<T> root) {
        throw new UnsupportedOperationException();
    }

    public static <T> void preOrder(BinaryTreeNode<T> root) {
    }

    public static <T> void inOrder(BinaryTreeNode<T> root) {
        throw new UnsupportedOperationException();
    }

    public static <T> void postOrder(BinaryTreeNode<T> root) {
        throw new UnsupportedOperationException();
    }

    private static BinaryTreeNode<String> makeExampleBinaryTree() {
        // Initialize binary tree nodes.
        BinaryTreeNode<String> a = new BinaryTreeNode<>("A");
        BinaryTreeNode<String> b = new BinaryTreeNode<>("B");
        BinaryTreeNode<String> c = new BinaryTreeNode<>("C");
        BinaryTreeNode<String> d = new BinaryTreeNode<>("D");
        BinaryTreeNode<String> e = new BinaryTreeNode<>("E");
        BinaryTreeNode<String> f = new BinaryTreeNode<>("F");
        BinaryTreeNode<String> g = new BinaryTreeNode<>("G");
        BinaryTreeNode<String> h = new BinaryTreeNode<>("H");
        BinaryTreeNode<String> i = new BinaryTreeNode<>("I");
        BinaryTreeNode<String> j = new BinaryTreeNode<>("J");
        BinaryTreeNode<String> k = new BinaryTreeNode<>("K");

        // Make a binary tree.
        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setRight(f);
        d.setLeft(g);
        d.setRight(h);
        e.setLeft(i);
        e.setRight(j);
        f.setLeft(k);

        return a;
    }

    private static NaryTreeNode<String> makeExampleNaryTree() {
        // Initialize n-ary tree nodes.
        NaryTreeNode<String> a1 = new NaryTreeNode<>("A");
        NaryTreeNode<String> b1 = new NaryTreeNode<>("B");
        NaryTreeNode<String> c1 = new NaryTreeNode<>("C");
        NaryTreeNode<String> d1 = new NaryTreeNode<>("D");
        NaryTreeNode<String> e1 = new NaryTreeNode<>("E");
        NaryTreeNode<String> f1 = new NaryTreeNode<>("F");
        NaryTreeNode<String> g1 = new NaryTreeNode<>("G");
        NaryTreeNode<String> h1 = new NaryTreeNode<>("H");
        NaryTreeNode<String> i1 = new NaryTreeNode<>("I");

        // Make an n-ary.
        a1.addChild(i1);
        a1.addChild(b1);
        a1.addChild(c1);
        b1.addChild(d1);
        b1.addChild(e1);
        c1.addChild(f1);
        c1.addChild(g1);
        c1.addChild(h1);

        return a1;
    }

    public static void main(String[] args) {
        BinaryTreeNode<String> a = makeExampleBinaryTree();
        // NaryTreeNode<String> root = makeExampleNaryTree();

        // Visualizations.
        Graph.enable();
        Graph.i().makeTopDown();
        Graph.i().setRef("a", a);
        // Graph.i().setRef("root", root);
    }

}
