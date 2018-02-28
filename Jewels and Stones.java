/*

*/

class Solution {
    public int numJewelsInStones(String J, String S) {
        int[] count = new int[64];
        for (char c : J.toCharArray()) {
            count[c - 'A']++;
        }
        int ans = 0;
        for (char c : S.toCharArray()) {
            if (count[c - 'A'] >= 1) ans ++;
        }
        return ans;
    }
}

或者

public int numJewelsInStones(String J, String S) {
        int res = 0;
        Set setJ = new HashSet();
        for (char j: J.toCharArray()) setJ.add(j);
        for (char s: S.toCharArray()) if (setJ.contains(s)) res++;
        return res;
    }
