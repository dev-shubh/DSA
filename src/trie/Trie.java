package trie;

import java.util.HashMap;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode((char) 0);
    }

    public void insert(String word) {
        TrieNode trieNodeIterator = root;   // this is used to traverse the trie

        for (int lev = 0; lev < word.length(); lev++) {
            HashMap<Character, TrieNode> child = trieNodeIterator.getChildren();
            if(child.containsKey(word.charAt(lev))) {
                trieNodeIterator = child.get(word.charAt(lev));
            }
            else {
                TrieNode trieNode = new TrieNode(word.charAt(lev));
                child.put(word.charAt(lev), trieNode);
                trieNodeIterator = trieNode;
            }
        }
        trieNodeIterator.isEnding = true;

    }

    public boolean search(String input) {
        TrieNode trieNodeIterator = root;   // this is used to traverse the trie

        for (int i=0; i < input.length(); i++) {
            HashMap<Character, TrieNode> child = trieNodeIterator.getChildren();
            if(child.containsKey(input.charAt(i))) {
                trieNodeIterator = child.get(input.charAt(i));
            }
            else {
                return false;
            }
        }
        if (trieNodeIterator.isEnding) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getLongestMatchingPrefix(String input) {
        String result = null;
        String current = "";
        TrieNode trieNodeIterator = root;   // this is used to traverse the trie
        for (int i=0; i<input.length(); i++) {
            HashMap<Character, TrieNode> child = trieNodeIterator.getChildren();
            if(child.containsKey(input.charAt(i))) {
                trieNodeIterator = child.get(input.charAt(i));
                current += trieNodeIterator.getValue();
                if (trieNodeIterator.isEnding) {
                    result = current;
                }
            }
            else {
                break;
            }
        }
        return result;
    }
}
