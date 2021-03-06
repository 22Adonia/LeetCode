/*
Given two strings s and t which consist of only lowercase letters.
String t is generated by random shuffling string s and then add one more letter at a random position.
Find the letter that was added in t.
Example:
Input:
s = "abcd"
t = "abcde"
Output:
e
Explanation:
'e' is the letter that was added.
*/

class Solution {
    public char findTheDifference(String s, String t) {
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        for(int i = 0; i < s.length(); i++){
            arr1[s.charAt(i)-'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            arr2[t.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(arr1[i] != arr2[i]){
                return (char)('a' + i);
            }
        }
        return 0;
    }
}

或者
 using bit manipulation
 class Solution {
    public char findTheDifference(String s, String t) {
        int n = t.length();
        char c = t.charAt(n-1);
        for(int i = 0; i < n - 1 ; i++){
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
}
