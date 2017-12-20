package strings;

public class UniqueCharacters {
    public static void main(String[] args) {
        String s = "abcde";
        String d = "shubh";
        System.out.println(hasUniqueCharacters(s));
        System.out.println(hasUniqueCharacters(d));
    }

    private static boolean hasUniqueCharacters(String s) {
        if(s == null || s.isEmpty() || s.length() == 1) return true;

        boolean[] visited = new boolean[256];

        for(int i=0; i <s.length(); i++) {
            int hash = s.charAt(i) - 'a';
            if(visited[hash]) return false;
            visited[hash] = true;
        }
        return true;
    }
}
