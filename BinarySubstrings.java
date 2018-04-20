/* Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.*/


class Solution {
    public int countBinarySubstrings(String s) {
        int ans =0, prev=0, curr=1;
        
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(i-1)){
                ans+=Math.min(prev, curr);
                prev=curr;
                curr=1;
            }else{
                curr++;
            }
        }
        return ans+Math.min(prev,curr);
    }
}
