package trie;

public class TestTrie {
    public static void main(String[] args) {
        Trie dictionary = new Trie();

        dictionary.insert("shubham");
        dictionary.insert("nikita");
        dictionary.insert("are");
        dictionary.insert("area");
        dictionary.insert("base");
        dictionary.insert("cat");
        dictionary.insert("cater");
        dictionary.insert("children");
        dictionary.insert("child");
        dictionary.insert("basement");
        dictionary.insert("based");
        dictionary.insert("shubh");

        if(dictionary.search("caterer")) {
            System.out.println("string found");
        }
        else {
            System.out.println("string not found");
        }

        System.out.println(dictionary.getLongestMatchingPrefix("caterer"));
        System.out.println(dictionary.getLongestMatchingPrefix("basemexy"));
        System.out.println(dictionary.getLongestMatchingPrefix("child"));
        System.out.println(dictionary.getLongestMatchingPrefix("shubham"));

        System.out.println("Success");
    }
}
