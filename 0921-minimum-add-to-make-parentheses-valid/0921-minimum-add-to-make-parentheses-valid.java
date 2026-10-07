class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int count = 0;
        int ans = 0;
        for(char c : s.toCharArray()){
            if(c == '(')count++;
            else count--;

            if(count == -1){
                ans++;
                count = 0;
            }
        }
        ans += Math.abs(count);
        return ans;
    }
}