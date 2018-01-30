package strings;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().trim();
        int j = s.length() -1 ;
        int i = 0;
        while(i < j) {
            if(!Character.isAlphabetic(s.charAt(i))) {
                i++;
            }
            if(!Character.isAlphabetic(s.charAt(j))) {
                j--;
            }
            if(i == j) return true;

            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
         }
         return true;
    }
}
