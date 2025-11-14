package Bonus;

// KMP Algorithm Implementation
// Time Complexity: O(n + m)
// Space Complexity: O(m)
// Suitable for pattern matching in large texts


public class KMP {
    // Compute LPS array (prefix table)
    public static int[] computeLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0;   // length of previous longest prefix-suffix
        int i = 1;
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; 
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    // KMP Search
    public static void kmpSearch(String text, String pat) {
        int n = text.length();
        int m = pat.length();
        int[] lps = computeLPS(pat);
        int i = 0; // text index
        int j = 0; // pattern index
        while (i < n) {
            if (text.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                // If whole pattern matched
                if (j == m) {
                    System.out.println("Pattern found at index: " + (i - j));
                    j = lps[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }
    // 3 test examples
    public static void main(String[] args) {
        // SHORT example
        System.out.println("SHORT TEST:");
        kmpSearch("ababcabcabababd", "ababd");
        // MEDIUM example
        System.out.println("\nMEDIUM TEST:");
        kmpSearch("abababababababababababababababababababababababab", "ababab");
        // LONG example
        System.out.println("\nLONG TEST:");
        String longText = "apai please give 100 for final lorem ipsum is simply dummy text of the printing and typesetting industry ";
        longText = longText.repeat(50);   // long string
        kmpSearch(longText, "ipsum is simply");
    }
}
