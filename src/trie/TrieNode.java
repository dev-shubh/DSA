package trie;

import java.util.HashMap;

public class TrieNode {
    private char value;
    private HashMap<Character, TrieNode> children;
    boolean isEnding;

    public TrieNode(char ch) {
        this.value = ch;
        this.children = new HashMap<Character, TrieNode>();
        this.isEnding = false;
    }

    public void setEnding(boolean ending) {
        isEnding = ending;
    }

    public char getValue() {

        return value;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isEnding() {
        return isEnding;
    }
}
