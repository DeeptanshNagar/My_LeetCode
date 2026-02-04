class Solution {
    private record Pair(int start, int end, boolean direction){}
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        
        List<Pair> l = new ArrayList<>();
        for(int st=0; st<n-1; ){
            if(nums[st] == nums[st+1]) {
                st++;
                continue;
            }

            int en=st+1; 
            boolean direction = nums[st] < nums[en]; // true > inc
            
            while(en<n && nums[en-1] != nums[en] && direction == (nums[en-1] < nums[en])) en++;
            l.add(new Pair(st, en-1, direction));
            st = en-1;
        }
        
        long ans = -(1L << 60);;
        for(int x=0, len=l.size()-2; x<len; x++){
            Pair f = l.get(x), s = l.get(x+1), t = l.get(x+2);
            if(!f.direction() || s.direction() || !t.direction()) continue;
            if(f.end() != s.start() || s.end() != t.start()) continue;

            long left = nums[f.end() - 1], middle = 0, right = nums[t.start() + 1];
            long tmpL = 0, tmpR = 0;
            
            for(int i=f.end()-1; i>=f.start(); i--) left = Math.max(left, tmpL += nums[i]);
            for(int i=s.start(); i<=s.end(); i++) middle += nums[i];
            for(int i=t.start()+1; i<=t.end(); i++) right = Math.max(right, tmpR += nums[i]);

            ans = Math.max(ans, left + middle + right);
        }
        return ans;
    }
}