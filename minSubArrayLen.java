class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //采用滑动窗口的形式  left   i
        int left = 0;
        int length = nums.length;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < length; i++){
            sum += nums[i];
            
            while (sum >= s){
                ans = Math.min(ans, i-left+1);
                //有可能出现和大于s，但是删除left，之后会更小，或者相等
                //滑动窗口
                //前面的满足  后面的也有可能满足
                sum -= nums[left];
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}