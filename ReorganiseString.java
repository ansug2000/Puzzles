/*Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.
Input S : "aab"
Output : "aba"

Input S: "aaab"
Output : "" */

class Solution {
    public String reorganizeString(String S) {
       int n = S.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int hf=0,i=0;
        while(i<n){
            map.put(S.charAt(i),map.getOrDefault(S.charAt(i),0)+1 );
            if(hf<map.get(S.charAt(i))) hf=map.get(S.charAt(i));
            i++; 
        }
        
        if((hf*2-1)>n)return "";
        
        char [] result = new char[n];
        int odd=0, even=1;
        for(Map.Entry<Character, Integer> pair : map.entrySet()){
            int count = pair.getValue();
            char letter=pair.getKey();
            
            while(count>0 && count < n/2+1 && even<n){
                result[even]=letter;
                count--;
                even+=2;
            }
            
            while(count>0){
                result[odd]=letter;
                count--;
                odd+=2;
            }
        }
        
        return new String(result);
    }
}
