package Strings;

/*
        * LEETCODE: 151. Reverse Words in a String

        * Problem Statement: Given an input string s, reverse the order of the words.

        A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

        Return a string of the words in reverse order concatenated by a single space.

        Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

        Example 1:

        Input: s = "the sky is blue"
        Output: "blue is sky the"
        Example 2:

        Input: s = "  hello world  "
        Output: "world hello"
        Explanation: Your reversed string should not contain leading or trailing spaces.
        Example 3:

        Input: s = "a good   example"
        Output: "example good a"
        Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

        Constraints:

        1 <= s.length <= 104
        s contains English letters (upper-case and lower-case), digits, and spaces ' '.
        There is at least one word in s.
 */

/*
       * take StringBuilder for ans String
       * start traversing from end of the string
       * now i will be at character other than space
       * now find the space, if not found then keep decrementing i
       * now we have got the space after some characters other than space
       * so we have a substring from i+1 to j+1 which has characters other than space
       * so we'll append substring to ans and for 1 space we'll append ' '
       * delete last character from ans because we're appending one space at last 
       * we can use .deleteCharAt() method of StringBuilder
       * or else we can use .trim() method of string which removes spaces from front and back of string
 */

public class ReverseWordsInString {
    public static String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            j = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            ans.append(s.substring(i + 1, j + 1)).append(' ');
        }
        // return ans.deleteCharAt(ans.length() - 1).toString();
        return ans.toString().trim();
    }

    // driver code
    public static void main(String[] args) {
        String s = "    sky   is blue        ";
        System.out.println(reverseWords(s)); // "blue is sky"
    }
}
