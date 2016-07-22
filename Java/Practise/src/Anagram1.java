public class Anagram1 {
    static int[] chars = new int[26];

    public static void main(String[] args) {
        isAnagram(null);
        isAnagram("");
        isAnagram("abc");
        isAnagram("aabb");
        isAnagram("ababababa");
        isAnagram("abcdcbbs");
        isAnagram("abbccscsabcb");

    }

    private static void isAnagram(String str) {
        if (str == null || "".equals(str) || str.length() % 2 == 1) {
            System.out.println(str + " is invalid.");
        } else {
            for (int i = 0; i < 26; i++)
                chars[i] = 0;

            int len = str.length();
            for (int i = 0; i < len / 2; i++) {
                int ind = str.charAt(i);
                chars[ind-97]++;
            }

            for (int i = len / 2; i < len; i++) {
                int ind = str.charAt(i);
                chars[ind-97]--;
            }

            int sum = 0;
            for (int i = 0; i < 26; i++) {
                sum += Math.abs(chars[i]);
            }

            if (sum/2 > 0) {
                System.out.println(str + " is not anagram and differ by " + sum/2 + " letters.");
            } else {
                System.out.println(str + " is anagram.");
            }
        }
    }
}