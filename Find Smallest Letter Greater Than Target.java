/*
Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
Note:
letters has a length in range [2, 10000].
letters consists of lowercase letters, and contains at least 2 unique letters.
target is a lowercase letter.
*/


class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        boolean[] f = new boolean[26];
        for(char c : letters)
            f[c - 'a'] = true;
        while(true){
            target++;
            if(target > 'z') target = 'a';
            if(f[target - 'a']) return target;
        }
    }
}


或者
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int index = findIndex(letters,target);
        if(index == 0){
            return letters[0];
        }
        if(index == letters.length){
            return letters[0];
        } 
        return letters[index];
    }
    public int findIndex(char[] letters,char target){
        int start = 0;
        int end = letters.length - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(letters[mid] <= target){
                start = mid;
            } else {
                end = mid;
            }
        }
        if(letters[start] > target){
            return start;
        }
        if(letters[end] > target){
            return end;
        }
        return letters.length;
    }
}
