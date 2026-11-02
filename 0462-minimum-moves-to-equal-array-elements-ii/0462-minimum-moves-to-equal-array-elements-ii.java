class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        if(nums.length/2==0&&nums.length>=4){
            int target=nums[nums.length/2-1];
            int pAns=0;
            for(int val:nums){
                pAns+=Math.abs(target-val);
            }
            int nAns=0;
            target=nums[nums.length/2];
            for(int val:nums){
                nAns+=Math.abs(target-val);
            }
            ans=Math.min(pAns,nAns);
        }else{
            int target=nums[nums.length/2];
            for(int val:nums){
                ans+=Math.abs(val-target);
            }
        }
        return ans;
    }
}