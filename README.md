# Knuth–Morris–Pratt (KMP) String Matching Algorithm

---

## Introduction

The purpose of this project was to implement one classical string-searching algorithm from scratch in Java and analyze its performance. For this assignment, I chose the Knuth–Morris–Pratt (KMP) algorithm because it is one of the most efficient exact pattern-matching algorithms and improves significantly over the naive approach.

KMP searches for all occurrences of a pattern inside a larger text by avoiding unnecessary comparisons. It does this through a preprocessing phase that builds the LPS (Longest Prefix Suffix) table, which helps skip characters instead of checking them repeatedly.

The implementation was done fully in Java without using built-in search functions.

---

## Algorithm Overview

The KMP algorithm consists of two main parts:

- LPS Array Construction

The LPS array stores, for each position in the pattern, the length of the longest proper prefix that is also a suffix up to that position.

Example:
Pattern "ababd" → LPS array becomes [0, 0, 1, 2, 0].

This preprocessing step takes O(m) time, where m is the length of the pattern.

- Pattern Search Phase

Using the LPS table, the algorithm scans the text only once.
When characters mismatch, instead of restarting from the next text index, KMP uses the LPS array to return to the nearest valid prefix in the pattern.

This reduces the time complexity of searching to O(n), where n is the length of the text.

---

## Implementation Summary

The implementation consists of three parts:

### computeLPS()
- Builds the LPS array using two pointers
- Runs in linear time

### kmpSearch()
- Performs the actual KMP pattern matching
- Prints all starting indices of matches

### main() Test Cases
Three tests were used as required:

Short Test
- Text: "ababcabcabababd"
- Pattern: "ababd"
- Output: match at index 10

Medium Test
- Text: "abababababababababababababababababababababababab"
- Pattern: "ababab"
- Output: many overlapping matches (dense pattern)

Long Test
- Text: 50 repetitions of
"apai please give 100 for final lorem ipsum is simply dummy text of the printing and typesetting industry "
- Pattern: "ipsum is simply"
- Output: multiple matches found throughout the long string

These tests demonstrate the algorithm’s behavior on different input sizes and on highly repetitive text.

---

## Correctness and Behavior
The algorithm correctly identifies:
- single matches
- multiple non-overlapping matches
- multiple overlapping matches (e.g., "ababab" inside "ababababa")
- matches inside large repeated text

The results printed by the program were manually verified and aligned with expected behavior.

---

## Complexity Analysis
Let:
- n = length of text
- m = length of pattern

### Time Complexity
- LPS construction: O(m)
- Pattern search: O(n)

Overall time complexity: O(n+m)
​
This is significantly better than the naive algorithm’s worst-case O(n·m).

### Space Complexity
- LPS array stores m integers → O(m)
- No additional large data structures are used O(m)

---

## Conclusion
The KMP algorithm is an efficient and reliable way to perform string matching, especially in cases with repetitive patterns or long texts. Implementing it from scratch provided a clear understanding of prefix functions and how preprocessing helps eliminate redundant comparisons.
