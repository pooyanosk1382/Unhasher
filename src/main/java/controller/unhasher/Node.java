package controller.unhasher;

import java.lang.reflect.Array;

public class Node {

    boolean isEnd;
    Node[] edges;
    String key;

    public Node() {
        this.isEnd = false;
        this.edges = new Node[36];
    }

    public void trieInsert(Node node, String string, int index, String key) {
        if (index == string.length()) {
            node.isEnd = true;
            node.key = key;
            return;
        }
        char temp = string.charAt(index);
        int e = 0;
        if ((int)temp < 90) {
            e = (int)temp - (int)'1';
            e += 27;
        } else {
            e = (int)temp - (int)'a';
        }
        if (node.edges[e] == null) {
            Array[] array = new Array[36];
            Node node1 = new Node();
            node.edges[e] = node1;
        }
        trieInsert(node.edges[e], string, index+1, key);
    }

    public void trieSearch(Node node, String string, int index) throws NullPointerException {
        if (index == string.length()) {
            if (node == null) {
                System.out.println("Not found!");
                return;
            }
            if (node.isEnd) {
                System.out.println(node.key);
            } else {
                System.out.println("Not found!");
            }
            return;
        }
        char temp = string.charAt(index);
        int e = 0;
        if ((int)temp < 90) {
            e = (int)temp - (int)'1';
            e += 27;
        } else {
            e = (int)temp - (int)'a';
        }
        if (node.edges[e] == null) {
            System.out.println("Not found!");
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
        int e = 0;
        if ((int)temp < 90) {
            e = (int)temp - (int)'1';
            e += 27;
        } else {
            e = (int)temp - (int)'a';
        }
        if (node.edges[e] == null) {
            throw new Exception("Item not found");
        }
        trieDelete(node.edges[e], string, index+1);
    }

}