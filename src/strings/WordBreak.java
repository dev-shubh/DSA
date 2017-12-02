package strings;

import java.util.ArrayList;

public class WordBreak {
    public static ArrayList<String> wordBreak(String word, ArrayList<String> dict) {
        int n = word.length();
        boolean[][] dp = new boolean[n+1][n+1];

        for(int i=0; i<=n; i++) {
            for(int j=i; j<=n; j++) {
                String subWord = word.substring(i,j);
                if(dict.contains(subWord)){
                    dp[i][j] = true;
                }
            }
        }

        ArrayList<String> solutions = new ArrayList<>();

        for (int j=0; j<=n; j++) {
            ArrayList<String> ansList = new ArrayList<>();
            String ansString = "";
            if(dp[0][j]){
                ansList.add(word.substring(0,j));
                if(jump(j+1, n, dp, ansList, word)){
                    for(String ans : ansList) {
                        ansString += ans + " ";
                    }
                    solutions.add(ansString);
                }

            }
        }
        return solutions;
    }

    private static boolean  jump(int startIndex, int n, boolean dp[][], ArrayList<String> ans, String word){
        if(startIndex > n) return false;
        for(int k=startIndex; k<=n; k++){
            if(dp[startIndex-1][k]) {
                ans.add(word.substring(startIndex-1, k));
                if(k == n) return true;
                return jump(k+1, n, dp, ans, word);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        final ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("cats");
        dictionary.add("and");
        dictionary.add("sand");
        dictionary.add("abbb");
        dictionary.add("a");
        dictionary.add("b");
        dictionary.add("aa");

        String word = "aabbbabaaabbbabaabaab";

        ArrayList<String> solutions = wordBreak(word, dictionary);

        solutions.forEach(solution -> {
            System.out.println(solution);
        });


    }
}
