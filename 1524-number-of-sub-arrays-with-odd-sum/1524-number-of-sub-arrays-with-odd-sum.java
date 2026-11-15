class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod=1000000007;
        int oddcnt=0,evencnt=1;
        int sum=0,res=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum%2==0){
                res=(res+oddcnt)%mod;
                evencnt++;
            }else{
                res=(res+evencnt)%mod;
                oddcnt++;
            }
        }
        return res;
    }
}