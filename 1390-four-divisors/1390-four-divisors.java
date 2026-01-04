class Solution {
    private int findDivisors(int num) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                divisors.add(i);
                if (i * i != num) divisors.add(num / i);
            }
            if (divisors.size() > 4) return 0;
        }
        if (divisors.size() != 4) return 0;
        int sum = 0;
        for (int n : divisors) sum += n;
        return sum;
    }
    
    int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int num : nums) ans+= findDivisors(num);
        return ans;
    }
}