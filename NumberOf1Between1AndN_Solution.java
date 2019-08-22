public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++){
            sb.append(i);
        }
        int count = 0;
        int length = sb.length();
        for (int i = 0; i < length; i++){
            if (sb.charAt(i) == '1')
                count++;
        }
        return count;
    }
}