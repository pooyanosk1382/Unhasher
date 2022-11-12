package controller.unhasher;

import java.lang.reflect.Array;

public class Node {

    boolean isEnd;
    Node[] edges;

    public Node() {
        this.isEnd = false;
        this.edges = new Node[26];
    }

    public void trieInsert(Node node, String string, int index) {
        if (index == string.length()) {
            node.isEnd = true;
            return;
        }
        char temp = string.charAt(index);
        int e = (int)temp - (int)'a';
        if (node.edges[e] == null) {
            Array[] array = new Array[26];
            Node node1 = new Node();
            node.edges[e] = node1;
        }
        trieInsert(node.edges[e], string, index+1);
    }

    public void trieSearch(Node node, String string, int index) throws NullPointerException {
        if (index == string.length()) {
            if (node == null) {
                System.out.println(false);
                return;
            }
            System.out.println(node.isEnd);
            return;
        }
        char temp = string.charAt(index);
        int e = (int)temp - (int)'a';
        if (node.edges[e] == null) {
            System.out.println(false);
            return;
        }
        trieSearch(node.edges[e], string, index+1);
    }

    public void trieDelete(Node node, String string, int index) throws Exception {
        if (index == string.length()) {
            if (!node.isEnd) {
                throw new Exception("Item not found");
            } else {
                node.isEnd = false;
            }
            return;
        }
        char temp = string.charAt(index);
        int e = (int)temp - (int)'a';
        if (node.edges[e] == null) {
            throw new Exception("Item not found");
        }
        trieDelete(node.edges[e], string, index+1);
    }

}